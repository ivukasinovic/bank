package com.project.controller;

import com.project.domain.StavkaCenovnika;
import com.project.service.StavkaCenovnikaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/stavkaCenovnika")
public class StavkaCenovnikaController {

    @Autowired
    private StavkaCenovnikaService stavkaCenovnikaService;

    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StavkaCenovnika>> getAll(){
        List<StavkaCenovnika> stavkeCenovnika = stavkaCenovnikaService.findAll();
        return new ResponseEntity<>(stavkeCenovnika, HttpStatus.OK);
    }

    @RequestMapping(
            value  = "/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StavkaCenovnika> getOne(@PathVariable Long id){
        StavkaCenovnika stavkaCenovnika = stavkaCenovnikaService.findOne(id);
        return new ResponseEntity<>(stavkaCenovnika, HttpStatus.OK);
    }

    @RequestMapping(
            value  = "/{id}",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StavkaCenovnika> delete(@PathVariable Long id){
        StavkaCenovnika stavkaCenovnika = stavkaCenovnikaService.findOne(id);
        stavkaCenovnikaService.delete(stavkaCenovnika);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StavkaCenovnika> save(@RequestBody StavkaCenovnika stavkaCenovnika){
        StavkaCenovnika novaStavkaCenovnika = stavkaCenovnikaService.save(stavkaCenovnika);
        return new ResponseEntity<>(novaStavkaCenovnika, HttpStatus.OK);
    }

}
