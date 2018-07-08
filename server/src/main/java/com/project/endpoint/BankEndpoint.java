package com.project.endpoint;

import com.project.domain.*;
import com.project.service.*;
import com.project.ws.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

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

            //KRITICNO
            faktura.setDuznik(preduzeceService.findByNaziv(fakturaXML.getKupac().getNaziv()));
            faktura.setPrimalac(preduzeceService.findByNaziv(fakturaXML.getProdavac().getNaziv()));
            //poslovna godina
            faktura.setPoslovnaGodina(poslovnaGodinaService.findByGodinaAndPreduzece(fakturaXML.getPoslovnaGodina(), faktura.getDuznik()));
            faktura.setDatum(new Date());
            faktura.setDatumValute(new Date());
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
        Preduzece preduzece = new Preduzece();
        //Id iz stringa uzimam id preduzeca  od kojeg uzimam naloge za placanje
        Long idDuznika= Long.valueOf(exportNalogaRequest.getNalog());
        List<NalogZaPlacanje> nalozi = nalogZaPlacanjeService.findByDuznik(idDuznika);
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

            //set jos 5 atributa


            //  nalogZaPlacanjeXML.setDatumNaloga(nalogZaPlacanje.getDatumNaloga());


            //response.getNalozi().add(nalogZaPlacanje);

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
        for(StavkaDnevnogIzvodaXML stavka: dnevniIzvodXML.getStavkaDnevnogIzvodaList().getStavkaDnevnogIzvoda()){
            StavkaIzvoda stavkaIzvoda = new StavkaIzvoda();
            //datumNaloga
            //datum valute
            stavkaIzvoda.setIznos(stavka.getIznos());
            stavkaIzvoda.setKupac(preduzeceService.findByNaziv(stavka.getKupac()));
            stavkaIzvoda.setProdavac(preduzeceService.findByNaziv(stavka.getProdavac()));
            stavkaIzvoda.setSvrha(stavka.getSvrhaPlacanja());
            stavkaIzvoda.setIznos(stavka.getIznos());
            stavkaIzvodaService.save(stavkaIzvoda);
        }
        DnevnoStanje novoDnevno = dnevnoStanjeService.save(dnevnoStanje);
        if(novoDnevno == null){
            response.setIzvodStatus("Doslo je do greske!");
        }
        response.setIzvodStatus("Uspesno!");
        return response;
    }



}
