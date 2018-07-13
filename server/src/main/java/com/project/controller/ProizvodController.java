package com.project.controller;

import com.project.domain.GrupaProizvoda;
import com.project.domain.JedinicaMere;
import com.project.domain.Preduzece;
import com.project.domain.Proizvod;
import com.project.service.GrupaProizvodaService;
import com.project.service.JedinicaMereService;
import com.project.service.PreduzeceService;
import com.project.service.ProizvodService;
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
@RequestMapping(value = "proizvod")
public class ProizvodController {

    @Autowired
    private ProizvodService proizvodService;

    @Autowired
    private PreduzeceService preduzeceService;

    @Autowired
    private GrupaProizvodaService grupaProizvodaService;

    @Autowired
    private JedinicaMereService jedinicaMereService;

    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Proizvod>> getAll(){

        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpSession session = attr.getRequest().getSession(true);
        Preduzece preduzece = (Preduzece) session.getAttribute("preduzece");

        List<Proizvod> proizvodList = proizvodService.findByPreduzece(preduzece);
        return new ResponseEntity<>(proizvodList, HttpStatus.OK);
    }

    @RequestMapping(
            value  = "/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Proizvod> getOne(@PathVariable Long id){
        Proizvod cenovnici = proizvodService.findOne(id);
        return new ResponseEntity<>(cenovnici, HttpStatus.OK);
    }

    @RequestMapping(
            value  = "/{id}",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Proizvod> delete(@PathVariable Long id){
        try {
            Proizvod proizvod = proizvodService.findOne(id);
            proizvodService.delete(proizvod);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return  new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @RequestMapping(
            value = "/{idGrupe}/{idJedinice}",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Proizvod> delete(@RequestBody Proizvod proizvod, @PathVariable("idGrupe")Long idGrupe,
                                           @PathVariable("idJedinice")Long idJedinice){
        try {


            ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
            HttpSession session = attr.getRequest().getSession(true);
            Preduzece preduzece = (Preduzece) session.getAttribute("preduzece");
            proizvod.setPreduzece(preduzece);

            GrupaProizvoda grupaProizvoda = grupaProizvodaService.findOne(idGrupe);
            proizvod.setGrupaProizvoda(grupaProizvoda);

            JedinicaMere jedinicaMere = jedinicaMereService.findOne(idJedinice);
            proizvod.setJedinicaMere(jedinicaMere);

            Proizvod noviProizvod = proizvodService.save(proizvod);

            return new ResponseEntity<>(noviProizvod, HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
