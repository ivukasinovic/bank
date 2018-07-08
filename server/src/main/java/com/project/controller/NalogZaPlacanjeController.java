package com.project.controller;

import com.project.domain.Faktura;
import com.project.domain.NalogZaPlacanje;
import com.project.service.NalogZaPlacanjeService;
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
@RequestMapping(value = "nalog-za-placanje")
public class NalogZaPlacanjeController {

    @Autowired
    private NalogZaPlacanjeService nalogZaPlacanjeService;

    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<NalogZaPlacanje>> getAll(){
        List<NalogZaPlacanje> cenovnici = nalogZaPlacanjeService.findAll();
        return new ResponseEntity<>(cenovnici, HttpStatus.OK);
    }

    @RequestMapping(
            value  = "/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<NalogZaPlacanje> getOne(@PathVariable Long id){
        NalogZaPlacanje cenovnici = nalogZaPlacanjeService.findOne(id);
        return new ResponseEntity<>(cenovnici, HttpStatus.OK);
    }

    @RequestMapping(
            value  = "/{id}",
            method = RequestMethod.DELETE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<NalogZaPlacanje> delete(@PathVariable Long id){
        NalogZaPlacanje nalogZaPlacanje = nalogZaPlacanjeService.findOne(id);
        nalogZaPlacanjeService.delete(nalogZaPlacanje);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<NalogZaPlacanje> delete(@RequestBody NalogZaPlacanje nalogZaPlacanje){
        NalogZaPlacanje noviNalogZaPlacanje = nalogZaPlacanjeService.save(nalogZaPlacanje);
        return new ResponseEntity<>(noviNalogZaPlacanje, HttpStatus.OK);
    }

    @RequestMapping(
            value = "/generisi/{idFakture}/{iznos}",
            method = RequestMethod.GET)
    public ResponseEntity generisiIzPrijedloga(@PathVariable("idFakture") Long idFakture, @PathVariable("iznos") Double iznos) {

        nalogZaPlacanjeService.generisiNalog(idFakture, iznos);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
