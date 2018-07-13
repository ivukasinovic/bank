package com.project.controller;

import com.project.domain.Narudzbenica;
import com.project.service.NarudzbenicaService;
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
@RequestMapping(value = "narudzbenica")
public class    NarudzbenicaController {


    @Autowired
    private NarudzbenicaService narudzbenicaService;

    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Narudzbenica>> getAll(){
        List<Narudzbenica> cenovnici = narudzbenicaService.findAll();
        return new ResponseEntity<>(cenovnici, HttpStatus.OK);
    }

    @RequestMapping(
            value  = "/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Narudzbenica> getOne(@PathVariable Long id){
        Narudzbenica cenovnici = narudzbenicaService.findOne(id);
        return new ResponseEntity<>(cenovnici, HttpStatus.OK);
    }

    @RequestMapping(
            value  = "/{id}",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Narudzbenica> delete(@PathVariable Long id){
        Narudzbenica narudzbenica = narudzbenicaService.findOne(id);
        narudzbenicaService.delete(narudzbenica);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Narudzbenica> delete(@RequestBody Narudzbenica narudzbenica){
        Narudzbenica noviNarudzbenica = narudzbenicaService.save(narudzbenica);
        return new ResponseEntity<>(noviNarudzbenica, HttpStatus.OK);
    }
    
}
