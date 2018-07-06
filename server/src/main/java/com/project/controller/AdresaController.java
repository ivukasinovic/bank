package com.project.controller;

import com.project.domain.Adresa;
import com.project.service.AdresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Dejan Stojkic (Smek) on 7/6/2018.
 */

@RestController
@RequestMapping(value = "/adresa")
public class AdresaController {

    @Autowired
    private AdresaService adresaService;

    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<Adresa>> getAdreses () {
        List<Adresa> adresa = adresaService.findAll() ; //findOne(user);
        return new ResponseEntity<List<Adresa>>(adresa, HttpStatus.OK);     // "200 OK"
    }


    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Adresa> getAdres (@PathVariable("id") Long id) {
        Adresa listaAdminaFanZone = adresaService.findOne(id) ; //findOne(user);
        return new ResponseEntity<>(listaAdminaFanZone, HttpStatus.OK);     // "200 OK"
    }

    // ===
    @RequestMapping(
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Adresa> createAdres (@RequestBody Adresa country) {
        Adresa userNew = adresaService.save(country);
        return new ResponseEntity(userNew, HttpStatus.OK);
    }


    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Adresa> apdejtujAdresu (@PathVariable("id") Long id) {
        Adresa adresa = adresaService.findOne(id);
        return new ResponseEntity(adresa, HttpStatus.OK);     // "200 OK"
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.DELETE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Adresa> izbrisi(@PathVariable("id") Long id){
        adresaService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
