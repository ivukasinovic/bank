package com.project.controller;

import com.project.domain.Faktura;
import com.project.domain.Preduzece;
import com.project.repository.PreduzeceRepository;
import com.project.service.FakturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;
import javax.xml.ws.Response;
import java.util.List;

@RestController
@RequestMapping(value = "/faktura")
public class FakturaController {

    @Autowired
    private FakturaService fakturaService;

    @Autowired
    private PreduzeceRepository preduzeceRepository;

    @GetMapping(value = "/neplacene", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Faktura>> getNeplacene(){
//todo: kada povezem na front uzeti ulogovano preduzece
//        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
//        HttpSession session= attr.getRequest().getSession(true);
//        Preduzece preduzece = (Preduzece)session.getAttribute("preduzece");
        Preduzece preduzece = preduzeceRepository.findOne(1l);
        List<Faktura> fakture = fakturaService.getNeplaceneFakture(preduzece);

        return  new ResponseEntity<>(fakture, HttpStatus.OK);
    }
}
