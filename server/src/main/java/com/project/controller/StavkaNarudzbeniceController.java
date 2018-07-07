package com.project.controller;

import com.project.domain.StavkaNarudzbenice;
import com.project.service.StavkaNarudzbeniceService;
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
@RequestMapping(value = "stavka-narudzbenice")
public class StavkaNarudzbeniceController {

    @Autowired
    private StavkaNarudzbeniceService stavkaNarudzbeniceService;

    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StavkaNarudzbenice>> getAll(){
        List<StavkaNarudzbenice> cenovnici = stavkaNarudzbeniceService.findAll();
        return new ResponseEntity<>(cenovnici, HttpStatus.OK);
    }

    @RequestMapping(
            value  = "/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StavkaNarudzbenice> getOne(@PathVariable Long id){
        StavkaNarudzbenice cenovnici = stavkaNarudzbeniceService.findOne(id);
        return new ResponseEntity<>(cenovnici, HttpStatus.OK);
    }

    @RequestMapping(
            value  = "/{id}",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StavkaNarudzbenice> delete(@PathVariable Long id){
        StavkaNarudzbenice stavkaNarudzbenice = stavkaNarudzbeniceService.findOne(id);
        stavkaNarudzbeniceService.delete(stavkaNarudzbenice);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StavkaNarudzbenice> delete(@RequestBody StavkaNarudzbenice stavkaNarudzbenice){
        StavkaNarudzbenice noviStavkaNarudzbenice = stavkaNarudzbeniceService.save(stavkaNarudzbenice);
        return new ResponseEntity<>(noviStavkaNarudzbenice, HttpStatus.OK);
    }
}
