package com.project.controller;

import com.project.domain.Cenovnik;
import com.project.service.CenovnikService;
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
@RequestMapping(value = "/cenovnik")
public class CenovnikController {

    @Autowired
    private CenovnikService cenovnikService;

    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Cenovnik>> getAll(){
        List<Cenovnik> cenovnici = cenovnikService.findAll();
        return new ResponseEntity<>(cenovnici, HttpStatus.OK);
    }

    @RequestMapping(
            value  = "/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cenovnik> getOne(@PathVariable Long id){
        Cenovnik cenovnici = cenovnikService.findOne(id);
        return new ResponseEntity<>(cenovnici, HttpStatus.OK);
    }

    @RequestMapping(
            value  = "/{id}",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cenovnik> delete(@PathVariable Long id){
        Cenovnik cenovnik = cenovnikService.findOne(id);
        cenovnikService.delete(cenovnik);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cenovnik> delete(@RequestBody Cenovnik cenovnik){
        Cenovnik noviCenovnik = cenovnikService.save(cenovnik);
        return new ResponseEntity<>(noviCenovnik, HttpStatus.OK);
    }




}