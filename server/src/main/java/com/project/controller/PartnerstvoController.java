package com.project.controller;

import com.project.domain.Partnerstvo;
import com.project.domain.Preduzece;
import com.project.service.PartnerstvoService;
import com.project.service.PreduzeceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Ivan V. on 07-Jul-18
 */
@RestController
@RequestMapping(value = "partnerstvo")
public class PartnerstvoController {

    @Autowired
    private PartnerstvoService partnerstvoService;

    @Autowired
    private PreduzeceService preduzeceService;

    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Partnerstvo>> getAll(){
        List<Partnerstvo> cenovnici = partnerstvoService.findAll();
        return new ResponseEntity<>(cenovnici, HttpStatus.OK);
    }

    @RequestMapping(
            value = "samo-nasi/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Partnerstvo>> getMojePartnere(@PathVariable Long id){
        List<Partnerstvo> cenovnici = partnerstvoService.findByPreduzece1_id(id);
        return new ResponseEntity<>(cenovnici, HttpStatus.OK);
    }

    @RequestMapping(
            value = "/ostali/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Preduzece>> getOstali(@PathVariable("id") Long id){

        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpSession session= attr.getRequest().getSession(true);
        Preduzece preduzeceF = (Preduzece)session.getAttribute("preduzece");

        List<Preduzece> svii = preduzeceService.findAll();
        List<Partnerstvo> cenovnici = partnerstvoService.findByPreduzece1_id(id);

        List<Preduzece> preduzeca = new ArrayList<>();

        for (int i=0;i < cenovnici.size();i++) {
               preduzeca.add(cenovnici.get(i).getPreduzece2());
        }
        preduzeca.add(preduzeceF);

        svii.removeAll(preduzeca);


        return new ResponseEntity<>(svii, HttpStatus.OK);
    }


    @RequestMapping(
            value  = "/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Partnerstvo> getOne(@PathVariable Long id){
        Partnerstvo cenovnici = partnerstvoService.findOne(id);
        return new ResponseEntity<>(cenovnici, HttpStatus.OK);
    }

    @RequestMapping(
            value  = "/{id}",
            method = RequestMethod.DELETE)
    public ResponseEntity<Partnerstvo> delete(@PathVariable Long id){
        //Partnerstvo partnerstvo = partnerstvoService.findOne(id);
        partnerstvoService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(
            value = "/dodaj/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Partnerstvo> kreiraj(@PathVariable String id){

        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpSession session= attr.getRequest().getSession(true);
        Preduzece preduzeceF = (Preduzece)session.getAttribute("preduzece");

        Partnerstvo partnerstvo = new Partnerstvo();
        partnerstvo.setDatum(new Date());
        partnerstvo.setPreduzece1(preduzeceF);
        partnerstvo.setPreduzece2(preduzeceService.findOne(Long.valueOf(id)));

        Partnerstvo noviPartnerstvo = partnerstvoService.save(partnerstvo);
        return new ResponseEntity<>(noviPartnerstvo, HttpStatus.OK);
    }
    
}
