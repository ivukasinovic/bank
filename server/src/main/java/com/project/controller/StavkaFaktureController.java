package com.project.controller;

import com.project.domain.StavkaFakture;
import com.project.service.StavkaFaktureService;
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
@RequestMapping(value = "stavka-fakture")
public class StavkaFaktureController {

    @Autowired
    private StavkaFaktureService stavkaFaktureService;

    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StavkaFakture>> getAll(){
        List<StavkaFakture> cenovnici = stavkaFaktureService.findAll();
        return new ResponseEntity<>(cenovnici, HttpStatus.OK);
    }

    @RequestMapping(
            value  = "/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StavkaFakture> getOne(@PathVariable Long id){
        StavkaFakture cenovnici = stavkaFaktureService.findOne(id);
        return new ResponseEntity<>(cenovnici, HttpStatus.OK);
    }

    @RequestMapping(
            value  = "/{id}",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StavkaFakture> delete(@PathVariable Long id){
        StavkaFakture stavkaFakture = stavkaFaktureService.findOne(id);
        stavkaFaktureService.delete(stavkaFakture);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StavkaFakture> delete(@RequestBody StavkaFakture stavkaFakture){
        StavkaFakture noviStavkaFakture = stavkaFaktureService.save(stavkaFakture);
        return new ResponseEntity<>(noviStavkaFakture, HttpStatus.OK);
    }
}
