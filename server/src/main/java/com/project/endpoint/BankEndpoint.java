package com.project.endpoint;

import com.project.domain.Faktura;
import com.project.domain.FakturaStatus;
import com.project.service.FakturaService;
import com.project.service.PoslovnaGodinaService;
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
    private PoslovnaGodinaService poslovnaGodinaService;

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

        ExportNalogaResponse response = new ExportNalogaResponse();
        return  response;
    }

    @PayloadRoot(namespace = "http://poslovna.com/soap-example", localPart = "importIzvodRequest")
    @ResponsePayload
    public ImportIzvodResponse importIzvodRequest(@RequestPayload ImportIzvodRequest importIzvodRequest) {

        ImportIzvodResponse response = new ImportIzvodResponse();
        return response;
    }



}
