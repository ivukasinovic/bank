package com.project.controller;

import com.project.domain.StavkaIzvoda;
import com.project.service.StavkaIzvodaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/stavkaIzvoda")
public class StavkaIzvodaController {

    @Autowired
    private StavkaIzvodaService stavkaIzvodaService;

    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StavkaIzvoda>> getAll(){
        List<StavkaIzvoda> stavkeIzvoda = stavkaIzvodaService.findAll();
        return new ResponseEntity<>(stavkeIzvoda, HttpStatus.OK);
    }

    @RequestMapping(
            value  = "/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StavkaIzvoda> getOne(@PathVariable Long id){
        StavkaIzvoda stavkaIzvoda = stavkaIzvodaService.findOne(id);
        return new ResponseEntity<>(stavkaIzvoda, HttpStatus.OK);
    }

    @RequestMapping(
            value  = "/{id}",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StavkaIzvoda> delete(@PathVariable Long id){
        StavkaIzvoda stavkaIzvoda = stavkaIzvodaService.findOne(id);
        stavkaIzvodaService.delete(stavkaIzvoda);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StavkaIzvoda> save(@RequestBody StavkaIzvoda stavkaIzvoda){
        StavkaIzvoda novaStavkaIzvoda = stavkaIzvodaService.save(stavkaIzvoda);
        return new ResponseEntity<>(novaStavkaIzvoda, HttpStatus.OK);
    }

}
