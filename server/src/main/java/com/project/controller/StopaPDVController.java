package com.project.controller;

import com.project.domain.PDV;
import com.project.domain.StopaPDV;
import com.project.service.PDVService;
import com.project.service.StopaPDVService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/stopaPDV")
public class StopaPDVController {

    @Autowired
    private StopaPDVService stopaPDVService;

    @Autowired
    private PDVService pdvService;

    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StopaPDV>> getAll(){
        List<StopaPDV> stopePDV = stopaPDVService.findAll();
        return new ResponseEntity<>(stopePDV, HttpStatus.OK);
    }

    @RequestMapping(
            value  = "/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StopaPDV> getOne(@PathVariable Long id){
        StopaPDV stopaPDV = stopaPDVService.findOne(id);
        return new ResponseEntity<>(stopaPDV, HttpStatus.OK);
    }

    @RequestMapping(
            value  = "/{id}",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StopaPDV> delete(@PathVariable Long id){
        StopaPDV stopaPDV = stopaPDVService.findOne(id);
        stopaPDVService.delete(stopaPDV);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StopaPDV> save(@RequestBody StopaPDV stopaPDV){
        StopaPDV novaStopaPDV = stopaPDVService.save(stopaPDV);
        return new ResponseEntity<>(novaStopaPDV, HttpStatus.OK);
    }

    @RequestMapping(
            value  = "/{id}",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StopaPDV> save(@RequestBody StopaPDV stopaPDV, @PathVariable Long id){
        StopaPDV novaStopaPDV = new StopaPDV();

        PDV pdv  = new PDV();
        pdv = pdvService.findOne(id);
        stopaPDV.setPdv(pdv);
        stopaPDV.setId(null);
        novaStopaPDV = stopaPDVService.save(stopaPDV);
        return new ResponseEntity<>(novaStopaPDV, HttpStatus.OK);
    }
    @RequestMapping(
            value  = "/izmena/{id}",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StopaPDV> izmena(@RequestBody StopaPDV stopaPDV, @PathVariable Long id){
        StopaPDV novaStopaPDV = new StopaPDV();

        PDV pdv  = new PDV();
        pdv = pdvService.findOne(id);
        stopaPDV.setPdv(pdv);

        novaStopaPDV = stopaPDVService.save(stopaPDV);
        return new ResponseEntity<>(novaStopaPDV, HttpStatus.OK);
    }

}
