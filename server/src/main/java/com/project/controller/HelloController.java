package com.project.controller;

import com.project.domain.Role;
import com.project.domain.User;
import com.project.service.MessageService;
import com.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import sun.security.krb5.Credentials;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping(value = "user")
public class HelloController {

    @Autowired
    private UserService userService;

    @Autowired
    private MessageService messageService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<String> getMessage(){
        return new ResponseEntity<>("Hello", HttpStatus.OK);
    }

    @RequestMapping(
            value = "/logIn",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> login(@RequestBody com.project.DTO.Credentials credentials){


      User user = userService.findByEmailAndPassword(credentials.getEmail(),credentials.getPassword());

        if(user == null)
            return new ResponseEntity<User> (user, HttpStatus.UNAUTHORIZED);

        if(user.getRole().equals("USER"))
        {
            User regPos = (User) user;
            if(!regPos.isActivated())
            {
                user =  null;
                return new ResponseEntity<User>(user,HttpStatus.UNAUTHORIZED);
            }
        }

        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpSession session= attr.getRequest().getSession(true);
        session.setAttribute("user", user);

        return  new ResponseEntity<User>( user, HttpStatus.OK);
    }

    @RequestMapping(
            value = "/register",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createRegisteredUser(@Validated @RequestBody User newUser, Errors errors ) {
        // newUser.setEmail(newUser.getEmail());
        newUser.setRole("USER"); // Samo za obicne korisnike


        if(errors.hasErrors())
        {
            return  new ResponseEntity<String>(errors.getAllErrors().toString(), HttpStatus.BAD_REQUEST);
        }

//        newUser.setBodovi(0L);
//        newUser.setTipskale(TipSkala.OSNOVNI);
    //    newUser.setRole("USER"); //
        newUser.setRole("USER");
        User savedRegisteredUser = userService.save(newUser);
        //regPosetilacService.sendEmai(savedRegisteredUser);
        String poruka = "http://localhost:8080/user/potvrdaMaila/"+savedRegisteredUser.getId();
        messageService.sendEmai( savedRegisteredUser.getEmail(), poruka);

        return new ResponseEntity<>(savedRegisteredUser, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/potvrdaMaila/{id}",method = RequestMethod.GET)
    public void potvrdaEmailAdrese(@PathVariable("id") String idKorisnika){
        Long id = Long.parseLong(idKorisnika);
        userService.confirmEmailAdress(id);
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
