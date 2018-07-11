package com.project.controller;

import com.project.domain.GrupaProizvoda;
import com.project.service.GrupaProizvodaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/grupaProizvoda")
public class GrupaProizvodaController {

    @Autowired
    private GrupaProizvodaService grupaProizvodaService;

    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<GrupaProizvoda>> getAll(){
        List<GrupaProizvoda> grupeProizvoda = grupaProizvodaService.findAll();
        return new ResponseEntity<>(grupeProizvoda, HttpStatus.OK);
    }

    @RequestMapping(
            value  = "/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GrupaProizvoda> getOne(@PathVariable Long id){
        GrupaProizvoda grupaProizvoda = grupaProizvodaService.findOne(id);
        return new ResponseEntity<>(grupaProizvoda, HttpStatus.OK);
    }

    @RequestMapping(
            value  = "/{id}",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GrupaProizvoda> delete(@PathVariable Long id){
        GrupaProizvoda grupaProizvoda = grupaProizvodaService.findOne(id);
        grupaProizvodaService.delete(grupaProizvoda);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GrupaProizvoda> save(@RequestBody GrupaProizvoda grupaProizvoda){
        GrupaProizvoda novaGrupaProizvoda = grupaProizvodaService.save(grupaProizvoda);
        return new ResponseEntity<>(novaGrupaProizvoda, HttpStatus.OK);
    }

}
