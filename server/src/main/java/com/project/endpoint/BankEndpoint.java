package com.project.endpoint;

import com.project.domain.Faktura;
import com.project.domain.FakturaStatus;
import com.project.domain.NalogZaPlacanje;
import com.project.domain.Preduzece;
import com.project.service.FakturaService;
import com.project.service.NalogZaPlacanjeService;
import com.project.service.PreduzeceService;
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



    @PayloadRoot(namespace = "http://poslovna.com/soap-example", localPart = "importFakturaRequest")
    @ResponsePayload
    public ImportFakturaResponse importFakturaRequest(@RequestPayload ImportFakturaRequest importFakturaRequest){
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
            faktura.setDuznik(preduzeceService.findOne(fakturaXML.getKupac().getId()));
            faktura.setPrimalac(preduzeceService.findOne(fakturaXML.getProdavac().getId()));
            //poslovna godina
            faktura.setDatum(new Date());
            faktura.setDatumValute(new Date());
        }
        System.out.println("USOOO");
        ImportFakturaResponse resp = new ImportFakturaResponse();
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
        return response;
    }



}
