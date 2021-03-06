package com.project.service;

import com.project.domain.Preduzece;

import java.util.List;

/**
 * Created by Dejan Stojkic (Smek) on 7/6/2018.
 */
public interface PreduzeceService {

    Preduzece findByEmailAndLozinka(String email, String lozinka);

    Preduzece findByNaziv(String naziv);

    void confirmEmailAdress(Long id);

    Preduzece findByBrojRacuna(String brojRacuna);

    Preduzece findOne(Long id);

    Preduzece save(Preduzece user);

    void delete(Long id);

    List<Preduzece> findAll();

}
