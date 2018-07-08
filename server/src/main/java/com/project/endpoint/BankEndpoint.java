package com.project.endpoint;

import com.project.service.FakturaService;
import com.project.ws.FakturaXML;
import com.project.ws.ImportFakturaRequest;
import com.project.ws.ImportFakturaResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.List;

/**
 * Created by Ivan V. on 08-Jul-18
 */
@Endpoint
public class BankEndpoint {

    @Autowired
    private FakturaService fakturaService;

    @PayloadRoot(namespace = "http://poslovna.com/soap-example", localPart = "importFakturaRequest")
    @ResponsePayload
    public ImportFakturaResponse importFakturaRequest(@RequestPayload ImportFakturaRequest importFakturaRequest){
        List<FakturaXML> faktura = importFakturaRequest.getFaktura();
        System.out.println("USOOO");
        ImportFakturaResponse resp = new ImportFakturaResponse();
        return resp;
    }
}
