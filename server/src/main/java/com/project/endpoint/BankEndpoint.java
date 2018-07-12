package com.project.endpoint;

import com.project.config.Converter;
import com.project.domain.*;
import com.project.service.*;
import com.project.ws.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.XMLGregorianCalendar;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Ivan V. on 08-Jul-18
 */
@Endpoint
public class BankEndpoint {

    @Autowired
    private FakturaService fakturaService;

    @Autowired
    private PreduzeceService preduzeceService;

    @Autowired
    private NalogZaPlacanjeService nalogZaPlacanjeService;
  
    @Autowired
    private PoslovnaGodinaService poslovnaGodinaService;

    @Autowired
    private StavkaIzvodaService stavkaIzvodaService;

    @Autowired
    private DnevnoStanjeService dnevnoStanjeService;

    @Autowired
    private ValutaService valutaService;

    @PayloadRoot(namespace = "http://poslovna.com/soap-example", localPart = "importFakturaRequest")
    @ResponsePayload
    public ImportFakturaResponse importFakturaRequest(@RequestPayload ImportFakturaRequest importFakturaRequest){
        ImportFakturaResponse resp = new ImportFakturaResponse();
        List<FakturaXML> fakture = importFakturaRequest.getFaktura();
        for(FakturaXML fakturaXML: fakture) {
            Faktura faktura = new Faktura();
            faktura.setBezPDV(fakturaXML.getBezPDV());
            faktura.setBroj(fakturaXML.getBroj());
            faktura.setPreostaliIznos(fakturaXML.getPreostaliIznos());
            faktura.setStatus(FakturaStatus.POSLATA);
            faktura.setUkupanPDV(fakturaXML.getUkupanPDV());
            faktura.setUkupanRabat(fakturaXML.getUkupanRabat());
            faktura.setUkupnoZaPlacanje(fakturaXML.getUkupnoZaPlacanje());
            DateFormat df = new SimpleDateFormat("dd-mm-yyyy");
            try {
                Date d = df.parse(fakturaXML.getDatum());
                Date dv = df.parse(fakturaXML.getDatumValute());
                faktura.setDatum(d);
                faktura.setDatumValute(dv);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            //KRITICNO
            faktura.setDuznik(preduzeceService.findByNaziv(fakturaXML.getKupac().getNaziv()));
            faktura.setPrimalac(preduzeceService.findByNaziv(fakturaXML.getProdavac().getNaziv()));
            faktura.setPoslovnaGodina(poslovnaGodinaService.findByGodinaAndPreduzece(fakturaXML.getPoslovnaGodina(), faktura.getDuznik()));
            faktura.setValuta(valutaService.findOne(1L));
            Faktura novaFaktura = fakturaService.save(faktura);
            if(novaFaktura == null){
                resp.setFakturaStatus("Doslo je do greske, neke fakture mozda nisu importovane. ");
                return resp;
            }
        }
        resp.setFakturaStatus("Uspesno ste importovali fakture!");
        return resp;
    }

    @PayloadRoot(namespace = "http://poslovna.com/soap-example", localPart = "exportNalogaRequest")
    @ResponsePayload
    public ExportNalogaResponse exportNalogaRequest(@RequestPayload ExportNalogaRequest exportNalogaRequest){
        //prosledju je mi id duznika
        ExportNalogaResponse response = new ExportNalogaResponse();
        System.out.println("\nU servisu .. " + exportNalogaRequest.getNalog());
        //Id iz stringa uzimam id preduzeca  od kojeg uzimam naloge za placanje
        Long idDuznika= Long.valueOf(exportNalogaRequest.getNalog());
        System.out.println("\n Broj .. " + idDuznika);
        //  NalogZaPlacanje nalozi = nalogZaPlacanjeService.findOne(5L);
        List<NalogZaPlacanje> nalozi = nalogZaPlacanjeService.findByDuznik_Id(idDuznika);
        //setujem respons za sve naloge za placanje
        for(NalogZaPlacanje nalogZaPlacanje: nalozi) {

            NalogZaPlacanjeXML nalogZaPlacanjeXML = new NalogZaPlacanjeXML();

            nalogZaPlacanjeXML.setHitno(nalogZaPlacanje.getHitno());
            nalogZaPlacanjeXML.setId(nalogZaPlacanje.getId());
            nalogZaPlacanjeXML.setSvrha(nalogZaPlacanje.getSvrha());
            nalogZaPlacanjeXML.setModelOdobrenja(nalogZaPlacanje.getModelOdobrenja());
            nalogZaPlacanjeXML.setModelZaduzenja(nalogZaPlacanje.getModelZaduzenja());
            nalogZaPlacanjeXML.setOznakaValute(nalogZaPlacanje.getOznakaValute());
            nalogZaPlacanjeXML.setPozivNaBrojOdobrenja(nalogZaPlacanje.getPozivNaBrojOdobrenja());
            nalogZaPlacanjeXML.setPozivNaBrojZaduzenja(nalogZaPlacanje.getPozivNaBrojZaduzenja());
            nalogZaPlacanjeXML.setIznos(nalogZaPlacanje.getIznos());

            AdresaXML adresaProdavacXML = new AdresaXML();
            adresaProdavacXML.setBroj(nalogZaPlacanje.getPrimalac().getAdresa().getBroj());
            adresaProdavacXML.setDrzava(nalogZaPlacanje.getPrimalac().getAdresa().getDrzava());
            adresaProdavacXML.setGrad(nalogZaPlacanje.getPrimalac().getAdresa().getGrad());
            adresaProdavacXML.setId(nalogZaPlacanje.getPrimalac().getAdresa().getId());
            adresaProdavacXML.setPostanskiBroj(nalogZaPlacanje.getPrimalac().getAdresa().getPostanskiBroj());
            adresaProdavacXML.setUlica(nalogZaPlacanje.getPrimalac().getAdresa().getUlica());

            PreduzeceXML preduzeceProdavacXML = new PreduzeceXML();

            preduzeceProdavacXML.setId(nalogZaPlacanje.getPrimalac().getId());
            preduzeceProdavacXML.setBrojRacuna(nalogZaPlacanje.getPrimalac().getBrojRacuna());
            preduzeceProdavacXML.setNaziv(nalogZaPlacanje.getPrimalac().getNaziv());
            preduzeceProdavacXML.setPib(nalogZaPlacanje.getPrimalac().getPib());
            preduzeceProdavacXML.setAdresa(adresaProdavacXML);

            nalogZaPlacanjeXML.setProdavac(preduzeceProdavacXML);// PRODAVAC = PRIMALAC A DUZNIK = KUPAC
            //kraj prodavac
            AdresaXML adresaKupacXML = new AdresaXML();
            adresaKupacXML.setBroj(nalogZaPlacanje.getDuznik().getAdresa().getBroj());
            adresaKupacXML.setDrzava(nalogZaPlacanje.getDuznik().getAdresa().getDrzava());
            adresaKupacXML.setGrad(nalogZaPlacanje.getDuznik().getAdresa().getGrad());
            adresaKupacXML.setId(nalogZaPlacanje.getDuznik().getAdresa().getId());
            adresaKupacXML.setPostanskiBroj(nalogZaPlacanje.getDuznik().getAdresa().getPostanskiBroj());
            adresaKupacXML.setUlica(nalogZaPlacanje.getDuznik().getAdresa().getUlica());

            PreduzeceXML preduzeceKupacXML = new PreduzeceXML();

            preduzeceKupacXML.setId(nalogZaPlacanje.getDuznik().getId());
            preduzeceKupacXML.setBrojRacuna(nalogZaPlacanje.getDuznik().getBrojRacuna());
            preduzeceKupacXML.setNaziv(nalogZaPlacanje.getDuznik().getNaziv());
            preduzeceKupacXML.setPib(nalogZaPlacanje.getDuznik().getPib());
            preduzeceKupacXML.setAdresa(adresaKupacXML);

            nalogZaPlacanjeXML.setKupac(preduzeceKupacXML);// PRODAVAC = PRIMALAC A DUZNIK = KUPAC
            //kraj kupac

            XMLGregorianCalendar datumNalog = null;
            try {
                datumNalog = Converter.vracaXmlDate(nalogZaPlacanje.getDatumNaloga());
            } catch (DatatypeConfigurationException e) {
                e.printStackTrace();
            }
            nalogZaPlacanjeXML.setDatumNaloga(datumNalog);
            XMLGregorianCalendar datumValute = null;
            try {
                datumValute = Converter.vracaXmlDate(nalogZaPlacanje.getDatumValute());
            } catch (DatatypeConfigurationException e) {
                e.printStackTrace();
            }
            nalogZaPlacanjeXML.setDatumNaloga(datumValute);
            //messageRes.setDateSent(datumDati);

            //  nalogZaPlacanjeXML.setDatumNaloga(nalogZaPlacanje.getDatumNaloga());


            response.getNalozi().add(nalogZaPlacanjeXML);

        }



        return  response;
    }

    @PayloadRoot(namespace = "http://poslovna.com/soap-example", localPart = "importIzvodRequest")
    @ResponsePayload
    public ImportIzvodResponse importIzvodRequest(@RequestPayload ImportIzvodRequest importIzvodRequest) {
        ImportIzvodResponse response = new ImportIzvodResponse();
        DnevniIzvodXML dnevniIzvodXML = importIzvodRequest.getIzvod();
        DnevnoStanje dnevnoStanje = new DnevnoStanje();
        dnevnoStanje.setNovoStanje(dnevniIzvodXML.getNovoStanje());
        dnevnoStanje.setPrethodnoStanje(dnevniIzvodXML.getPrethodnoStanje());
        preduzeceService.findByBrojRacuna(dnevniIzvodXML.getBrojRacuna());
        dnevnoStanje.setPreduzece(preduzeceService.findByBrojRacuna(dnevniIzvodXML.getBrojRacuna()));
        dnevnoStanje.setRezervisano(0.00);
        dnevnoStanje.setPrometKorist(dnevniIzvodXML.getUkupnoUKorist());
        dnevnoStanje.setPrometTeret(dnevniIzvodXML.getUkupnoNaTeret());
        DateFormat df = new SimpleDateFormat("dd-mm-yyyy");
        try {
            dnevnoStanje.setDatum(df.parse(dnevniIzvodXML.getDatumNaloga()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        DnevnoStanje novoDnevno = dnevnoStanjeService.save(dnevnoStanje);
        for(StavkaDnevnogIzvodaXML stavka: dnevniIzvodXML.getStavkaDnevnogIzvodaList().getStavkaDnevnogIzvoda()){
            StavkaIzvoda stavkaIzvoda = new StavkaIzvoda();
            DateFormat d = new SimpleDateFormat("dd-mm-yyyy");
            try {
                stavkaIzvoda.setDatumNaloga(d.parse(stavka.getDatumNaloga()));
                stavkaIzvoda.setDatumValute(d.parse(stavka.getDatumValute()));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            //datum valute
            stavkaIzvoda.setIznos(stavka.getIznos());
            stavkaIzvoda.setKupac(preduzeceService.findByNaziv(stavka.getKupac()));
            stavkaIzvoda.setProdavac(preduzeceService.findByNaziv(stavka.getProdavac()));
            stavkaIzvoda.setSvrha(stavka.getSvrhaPlacanja());
            stavkaIzvoda.setIznos(stavka.getIznos());
            stavkaIzvoda.setPozivNaBroj(Integer.parseInt(stavka.getPozivNaBroj()));
            stavkaIzvoda.setModel(stavka.getModel());
            stavkaIzvoda.setDnevnoStanje(dnevnoStanje);
            stavkaIzvodaService.save(stavkaIzvoda);
        }
        if(novoDnevno == null){
            response.setIzvodStatus("Doslo je do greske!");
        }
        response.setIzvodStatus("Uspesno!");
        return response;
    }



}
