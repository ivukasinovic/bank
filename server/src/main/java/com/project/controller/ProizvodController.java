package com.project.controller;

import com.project.domain.Proizvod;
import com.project.service.ProizvodService;
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
@RequestMapping(value = "proizvod")
public class ProizvodController {

    @Autowired
    private ProizvodService proizvodService;

    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Proizvod>> getAll(){
        List<Proizvod> cenovnici = proizvodService.findAll();
        return new ResponseEntity<>(cenovnici, HttpStatus.OK);
    }

    @RequestMapping(
            value  = "/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Proizvod> getOne(@PathVariable Long id){
        Proizvod cenovnici = proizvodService.findOne(id);
        return new ResponseEntity<>(cenovnici, HttpStatus.OK);
    }

    @RequestMapping(
            value  = "/{id}",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Proizvod> delete(@PathVariable Long id){
        Proizvod proizvod = proizvodService.findOne(id);
        proizvodService.delete(proizvod);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Proizvod> delete(@RequestBody Proizvod proizvod){
        Proizvod noviProizvod = proizvodService.save(proizvod);
        return new ResponseEntity<>(noviProizvod, HttpStatus.OK);
    }
}
