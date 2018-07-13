package com.project.service.impl;

import com.project.domain.Preduzece;
import com.project.repository.PreduzeceRepository;
import com.project.service.PreduzeceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Dejan Stojkic (Smek) on 7/6/2018.
 */
@Service
public class PreduzeceServiceImpl implements PreduzeceService {

    @Autowired
    private PreduzeceRepository preduzeceRepository;

    @Override
    public Preduzece findByEmailAndLozinka(String email, String lozinka) {
        return preduzeceRepository.findByEmailAndLozinka(email,lozinka);
    }

    @Override
    public Preduzece findByNaziv(String naziv) {
        return preduzeceRepository.findByNaziv(naziv);
    }

    @Override
    public void confirmEmailAdress(Long id) {
        Preduzece kor = preduzeceRepository.findOne(id);
      //  kor.setActivated(true);       // Dodati atribut !!!
        preduzeceRepository.save(kor);
    }

    @Override
    public Preduzece findByBrojRacuna(String brojRacuna) {
        return preduzeceRepository.findByBrojRacuna(brojRacuna);
    }

    @Override
    public Preduzece findOne(Long id) {
        return preduzeceRepository.findOne(id);
    }



    @Override
    public Preduzece save(Preduzece user) {
        return preduzeceRepository.save(user);
    }

    @Override
    public void delete(Long id) {
        preduzeceRepository.delete(id);
    }

    @Override
    public List<Preduzece> findAll() {
        return preduzeceRepository.findAll();
    }


}
