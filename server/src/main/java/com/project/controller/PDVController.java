package com.project.controller;

import com.project.domain.PDV;
import com.project.service.PDVService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/pdv")
public class PDVController {
// ubaciti servis grupe i proveriti u kontroleru prilikom brisanja da li pripada grupi ako pripada onda ga ne brisati
    @Autowired
    private PDVService pdvService;

    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PDV>> getAll(){
        List<PDV> listaPDV = pdvService.findAll();
        return new ResponseEntity<>(listaPDV, HttpStatus.OK);
    }

    @RequestMapping(
            value  = "/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PDV> getOne(@PathVariable Long id){
        PDV pdv = pdvService.findOne(id);
        return new ResponseEntity<>(pdv, HttpStatus.OK);
    }


    @RequestMapping(
            value  = "/{id}",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PDV> delete(@PathVariable Long id){
        PDV pdv = pdvService.findOne(id);
        pdvService.delete(pdv);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PDV> save(@RequestBody PDV pdv){
        //pdv.setStopaPDVList(null);
        System.out.println("\nId:" + pdv.getId());

        PDV p = pdvService.findOne(pdv.getId());
        p.setNaziv(pdv.getNaziv());

        PDV noviPdv = null;
        if(p != null)
            noviPdv = pdvService.save(p);
        return new ResponseEntity<>(noviPdv, HttpStatus.OK);
    }

    @RequestMapping(
            value  = "/dodavanje",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PDV> dodavanje(@RequestBody PDV pdv){
        //pdv.setStopaPDVList(null);

        PDV noviPdv = null;
        if(pdv != null)
            noviPdv = pdvService.save(pdv);
        return new ResponseEntity<>(noviPdv, HttpStatus.OK);
    }

}
