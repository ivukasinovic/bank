package com.project.controller;

import com.project.domain.Partnerstvo;
import com.project.domain.Preduzece;
import com.project.service.PartnerstvoService;
import com.project.service.PreduzeceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Dejan Stojkic (Smek) on 7/10/2018.
 */

@RestController
@RequestMapping(value = "preduzece")
public class PreduzeceController {

    @Autowired
    private PreduzeceService preduzeceService;


    @RequestMapping(
            value  = "/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Preduzece> getOne(@PathVariable Long id){
        Preduzece cenovnici = preduzeceService.findOne(id);
        return new ResponseEntity<>(cenovnici, HttpStatus.OK);
    }

    @RequestMapping(
            value  = "/{id}",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Preduzece> delete(@PathVariable Long id){
        Preduzece partnerstvo = preduzeceService.findOne(id);
        preduzeceService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Preduzece> delete(@RequestBody Preduzece preduzece){
        Preduzece noviPartnerstvo = preduzeceService.save(preduzece);
        return new ResponseEntity<>(noviPartnerstvo, HttpStatus.OK);
    }


}

