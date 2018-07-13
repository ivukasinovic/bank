package com.project.controller;

import com.project.domain.Cenovnik;
import com.project.domain.Preduzece;
import com.project.domain.Valuta;
import com.project.service.CenovnikService;
import com.project.service.ValutaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Ivan V. on 07-Jul-18
 */
@RestController
@RequestMapping(value = "/cenovnik")
public class CenovnikController {

    @Autowired
    private CenovnikService cenovnikService;
    @Autowired
    private ValutaService valutaService;

        @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Cenovnik>> getAll(){

        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpSession session = attr.getRequest().getSession(true);
        Preduzece preduzece = (Preduzece) session.getAttribute("preduzece");

        List<Cenovnik> cenovnici = cenovnikService.findByPreduzece(preduzece);
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
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity update(@RequestBody Cenovnik cenovnik) {

        cenovnikService.save(cenovnik);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(
            value = "/{idValute}",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cenovnik> delete(@RequestBody Cenovnik cenovnik, @PathVariable("idValute")Long idValute){
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpSession session = attr.getRequest().getSession(true);
        Preduzece preduzece = (Preduzece) session.getAttribute("preduzece");
        cenovnik.setPreduzece(preduzece);

        Valuta valuta = valutaService.findOne(idValute);
        cenovnik.setValuta(valuta);

        Cenovnik noviCenovnik = cenovnikService.save(cenovnik);
        return new ResponseEntity<>(noviCenovnik, HttpStatus.OK);
    }




}
