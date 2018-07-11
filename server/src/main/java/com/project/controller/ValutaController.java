package com.project.controller;

import com.project.domain.Valuta;
import com.project.service.ValutaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/valuta")
public class ValutaController {

    @Autowired
    private ValutaService valutaService;

    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Valuta>> getAll(){
        List<Valuta> valute = valutaService.findAll();
        return new ResponseEntity<>(valute, HttpStatus.OK);
    }

    @RequestMapping(
            value  = "/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Valuta> getOne(@PathVariable Long id){
        Valuta valuta = valutaService.findOne(id);
        return new ResponseEntity<>(valuta, HttpStatus.OK);
    }

    @RequestMapping(
            value  = "/{id}",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Valuta> delete(@PathVariable Long id){
        Valuta valuta = valutaService.findOne(id);
        valutaService.delete(valuta);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Valuta> save(@RequestBody Valuta valuta){
        Valuta novaValuta = valutaService.save(valuta);
        return new ResponseEntity<>(novaValuta, HttpStatus.OK);
    }

}
