package com.project.controller;

import com.project.domain.Adresa;
import com.project.domain.Preduzece;
import com.project.service.AdresaService;
import com.project.service.MessageService;
import com.project.service.PreduzeceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping(value = "user")
public class HelloController {


    @Autowired
    private MessageService messageService;

    @Autowired
    private PreduzeceService preduzeceService;

    @Autowired
    private AdresaService adresaService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<String> getMessage(){
        return new ResponseEntity<>("Hello", HttpStatus.OK);
    }

    @RequestMapping(
            value = "/logIn",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Preduzece> login(@RequestBody com.project.DTO.Credentials credentials){

        Preduzece preduzece = preduzeceService.findByEmailAndLozinka(credentials.getEmail(),credentials.getLozinka());
        if(preduzece == null)
            return new ResponseEntity<Preduzece> (preduzece, HttpStatus.UNAUTHORIZED);

        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpSession session= attr.getRequest().getSession(true);
        session.setAttribute("preduzece", preduzece);

        return  new ResponseEntity<>( preduzece, HttpStatus.OK);
    }

    @RequestMapping(
            value = "/register/{id}",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createRegisteredUser(@PathVariable("id") Long id,@Validated @RequestBody Preduzece newUser, Errors errors ) {

        if(errors.hasErrors())
        {
            return  new ResponseEntity<String>(errors.getAllErrors().toString(), HttpStatus.BAD_REQUEST);
        }

        Adresa adres =  adresaService.findOne(id);      // ako se bira vec postojece adrese !!!
        newUser.setAdresa(adres);


        Preduzece savedRegisteredUser = preduzeceService.save(newUser);

        String poruka = "http://localhost:8080/user/potvrdaMaila/"+savedRegisteredUser.getId();
        messageService.sendEmai( savedRegisteredUser.getEmail(), poruka);

        return new ResponseEntity<>(savedRegisteredUser, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/potvrdaMaila/{id}",method = RequestMethod.GET)
    public void potvrdaEmailAdrese(@PathVariable("id") String idKorisnika){
        Long id = Long.parseLong(idKorisnika);
    }


    @RequestMapping(value = "/logOut",
            method = RequestMethod.GET)
    public ResponseEntity logOut(){
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpSession session= attr.getRequest().getSession(true);
        session.invalidate();
        return new ResponseEntity(HttpStatus.OK);
    }

}
