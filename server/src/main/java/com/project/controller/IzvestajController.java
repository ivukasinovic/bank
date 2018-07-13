package com.project.controller;

import com.project.clientWs.BankService;
import com.project.clientWs.BankServicePort;
import com.project.ws.ExportNalogaRequest;
import com.project.ws.ExportNalogaResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Ivan V. on 13-Jul-18
 */
@RestController
@RequestMapping("/xml")
public class IzvestajController {

    @RequestMapping(method = RequestMethod.GET,
                    produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> exportNaloga() {
        BankService objMethod = new BankService();
        BankServicePort objPort = objMethod.getBankServicePortSoap11();
        ExportNalogaRequest request = new ExportNalogaRequest();
        request.setNalog(String.valueOf(2));
        ExportNalogaResponse response = objPort.exportNaloga(request);
        return new ResponseEntity<>(response.getNalozi(), HttpStatus.OK);
    }
}
