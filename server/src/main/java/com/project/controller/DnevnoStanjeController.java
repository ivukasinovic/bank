package com.project.controller;

import com.project.domain.DnevnoStanje;
import com.project.service.DnevnoStanjeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/dnevnoStanje")
public class DnevnoStanjeController {

    @Autowired
    private DnevnoStanjeService dnevnoStanjeService;

    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<DnevnoStanje>> getAll(){
        List<DnevnoStanje> listaDnevnoStanje = dnevnoStanjeService.findAll();
        return new ResponseEntity<>(listaDnevnoStanje, HttpStatus.OK);
    }

    @RequestMapping(
            value  = "/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DnevnoStanje> getOne(@PathVariable Long id){
        DnevnoStanje dnevnoStanje = dnevnoStanjeService.findOne(id);
        return new ResponseEntity<>(dnevnoStanje, HttpStatus.OK);
    }

    @RequestMapping(
            value  = "/{id}",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DnevnoStanje> delete(@PathVariable Long id){
        DnevnoStanje dnevnoStanje = dnevnoStanjeService.findOne(id);
        dnevnoStanjeService.delete(dnevnoStanje);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DnevnoStanje> delete(@RequestBody DnevnoStanje dnevnoStanje){
        DnevnoStanje novoDnevnoStanje = dnevnoStanjeService.save(dnevnoStanje);
        return new ResponseEntity<>(novoDnevnoStanje, HttpStatus.OK);
    }

}
