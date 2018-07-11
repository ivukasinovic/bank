package com.project.controller;

import com.project.domain.JedinicaMere;
import com.project.service.JedinicaMereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/jedinicaMere")
public class JedinicaMereController {

    @Autowired
    private JedinicaMereService jedinicaMereService;

    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<JedinicaMere>> getAll(){
        List<JedinicaMere> jediniceMere = jedinicaMereService.findAll();
        return new ResponseEntity<>(jediniceMere, HttpStatus.OK);
    }

    @RequestMapping(
            value  = "/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<JedinicaMere> getOne(@PathVariable Long id){
        JedinicaMere jedinicaMere = jedinicaMereService.findOne(id);
        return new ResponseEntity<>(jedinicaMere, HttpStatus.OK);
    }

    @RequestMapping(
            value  = "/{id}",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<JedinicaMere> delete(@PathVariable Long id){
        JedinicaMere jedinicaMere = jedinicaMereService.findOne(id);
        jedinicaMereService.delete(jedinicaMere);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<JedinicaMere> save(@RequestBody JedinicaMere jedinicaMere){
        JedinicaMere novaJedinicaMere = jedinicaMereService.save(jedinicaMere);
        return new ResponseEntity<>(novaJedinicaMere, HttpStatus.OK);
    }

}
