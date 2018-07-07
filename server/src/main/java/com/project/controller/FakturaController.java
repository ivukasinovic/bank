package com.project.controller;

import com.project.domain.Faktura;
import com.project.service.FakturaService;
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
@RequestMapping(value = "faktura")
public class FakturaController {

    @Autowired
    private FakturaService fakturaService;

    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Faktura>> getAll(){
        List<Faktura> cenovnici = fakturaService.findAll();
        return new ResponseEntity<>(cenovnici, HttpStatus.OK);
    }

    @RequestMapping(
            value  = "/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Faktura> getOne(@PathVariable Long id){
        Faktura cenovnici = fakturaService.findOne(id);
        return new ResponseEntity<>(cenovnici, HttpStatus.OK);
    }

    @RequestMapping(
            value  = "/{id}",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Faktura> delete(@PathVariable Long id){
        Faktura faktura = fakturaService.findOne(id);
        fakturaService.delete(faktura);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Faktura> delete(@RequestBody Faktura faktura){
        Faktura noviFaktura = fakturaService.save(faktura);
        return new ResponseEntity<>(noviFaktura, HttpStatus.OK);
    }
}
