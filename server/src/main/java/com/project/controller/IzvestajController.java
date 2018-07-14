package com.project.controller;

import com.project.clientWs.BankService;
import com.project.clientWs.BankServicePort;
import com.project.domain.NalogZaPlacanje;
import com.project.service.NalogZaPlacanjeService;
import com.project.ws.ExportNalogaRequest;
import com.project.ws.ExportNalogaResponse;
import com.project.ws.NalogZaPlacanjeXML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.List;

/**
 * Created by Ivan V. on 13-Jul-18
 */
@RestController
@RequestMapping("/xml")
public class IzvestajController {

    @Autowired
    private NalogZaPlacanjeService nalogZaPlacanjeService;


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



        @RequestMapping(value = "/export/{id}",
                method = RequestMethod.GET)
        public ResponseEntity<?> export(@PathVariable Long id) {
            NalogZaPlacanje nalog = nalogZaPlacanjeService.findOne(id);
          //  NalogZaPlacanjeXML nalogXML = otpremnicaConverter.convert(nalog);


            BankService objMethod = new BankService();
            BankServicePort objPort = objMethod.getBankServicePortSoap11();
            ExportNalogaRequest request = new ExportNalogaRequest();
            request.setNalog(String.valueOf(id));
            ExportNalogaResponse response = objPort.exportNaloga(request);
            List<NalogZaPlacanjeXML> nalozi = response.getNalozi();
            String desktop = System.getProperty("user.home") + "/Desktop/xmlExportNalog"+id+".xml";
            File file = new File(desktop);
            JAXBContext jaxbContext;
            try {
                jaxbContext = JAXBContext.newInstance(ExportNalogaResponse.class);
                Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

                // output pretty printed
                jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

                jaxbMarshaller.marshal(response, file);
            } catch (JAXBException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return new ResponseEntity<>( HttpStatus.OK);
        }
    }


