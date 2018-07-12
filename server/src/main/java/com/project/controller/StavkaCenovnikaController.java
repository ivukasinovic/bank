package com.project.controller;

import com.project.domain.Cenovnik;
import com.project.domain.StavkaCenovnika;
import com.project.service.CenovnikService;
import com.project.service.ProizvodService;
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

    @Autowired
    private CenovnikService cenovnikService;

    @Autowired
    private ProizvodService proizvodService;

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
            value = "/{idCenovnika}/{idProizvoda}",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StavkaCenovnika> save(@RequestBody StavkaCenovnika stavkaCenovnika,@PathVariable("idCenovnika")Long idCenovnika,
                                                @PathVariable("idProizvoda")Long idProizvoda){

        Cenovnik cenovnik = cenovnikService.findOne(idCenovnika);
        stavkaCenovnika.setCenovnik(cenovnik);
        stavkaCenovnika.setProizvod(proizvodService.findOne(idProizvoda));

        StavkaCenovnika novaStavkaCenovnika = stavkaCenovnikaService.save(stavkaCenovnika);

        return new ResponseEntity<>(novaStavkaCenovnika, HttpStatus.OK);
    }



}
