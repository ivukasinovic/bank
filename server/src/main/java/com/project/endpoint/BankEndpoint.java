package com.project.endpoint;

import com.project.domain.Faktura;
import com.project.domain.FakturaStatus;
import com.project.service.FakturaService;
import com.project.service.PreduzeceService;
import com.project.ws.FakturaXML;
import com.project.ws.ImportFakturaRequest;
import com.project.ws.ImportFakturaResponse;
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
}
