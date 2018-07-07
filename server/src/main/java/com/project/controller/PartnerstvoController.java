package com.project.controller;

import com.project.domain.Partnerstvo;
import com.project.service.PartnerstvoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Ivan V. on 07-Jul-18
 */
@RestController
@RequestMapping(value = "partnerstvo")
public class PartnerstvoController {

    @Autowired
    private PartnerstvoService partnerstvoService;

    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Partnerstvo>> getAll(){
        List<Partnerstvo> cenovnici = partnerstvoService.findAll();
        return new ResponseEntity<>(cenovnici, HttpStatus.OK);
    }

    @RequestMapping(
            value  = "/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Partnerstvo> getOne(@PathVariable Long id){
        Partnerstvo cenovnici = partnerstvoService.findOne(id);
        return new ResponseEntity<>(cenovnici, HttpStatus.OK);
    }

    @RequestMapping(
            value  = "/{id}",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Partnerstvo> delete(@PathVariable Long id){
        Partnerstvo partnerstvo = partnerstvoService.findOne(id);
        partnerstvoService.delete(partnerstvo);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Partnerstvo> delete(@RequestBody Partnerstvo partnerstvo){
        Partnerstvo noviPartnerstvo = partnerstvoService.save(partnerstvo);
        return new ResponseEntity<>(noviPartnerstvo, HttpStatus.OK);
    }
    
}
