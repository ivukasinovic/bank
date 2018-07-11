package com.project.controller;

import com.project.domain.PoslovnaGodina;
import com.project.service.PoslovnaGodinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/poslovnaGodina")
public class PoslovnaGodinaController {

    @Autowired
    private PoslovnaGodinaService poslovnaGodinaService;

    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PoslovnaGodina>> getAll(){
        List<PoslovnaGodina> poslovneGodine = poslovnaGodinaService.findAll();
        return new ResponseEntity<>(poslovneGodine, HttpStatus.OK);
    }

    @RequestMapping(
            value  = "/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PoslovnaGodina> getOne(@PathVariable Long id){
        PoslovnaGodina poslovnaGodina = poslovnaGodinaService.findOne(id);
        return new ResponseEntity<>(poslovnaGodina, HttpStatus.OK);
    }

    @RequestMapping(
            value  = "/{id}",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PoslovnaGodina> delete(@PathVariable Long id){
        PoslovnaGodina poslovnaGodina = poslovnaGodinaService.findOne(id);
        poslovnaGodinaService.delete(poslovnaGodina);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PoslovnaGodina> save(@RequestBody PoslovnaGodina poslovnaGodina){
        PoslovnaGodina novaPoslovnaGodina = poslovnaGodinaService.save(poslovnaGodina);
        return new ResponseEntity<>(novaPoslovnaGodina, HttpStatus.OK);
    }

}
