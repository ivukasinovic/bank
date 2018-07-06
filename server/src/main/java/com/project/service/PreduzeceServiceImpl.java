package com.project.service;

import com.project.domain.Preduzece;
import com.project.repository.PreduzeceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public void confirmEmailAdress(Long id) {
        Preduzece kor = preduzeceRepository.findOne(id);
      //  kor.setActivated(true);       // Dodati atribut !!!
        preduzeceRepository.save(kor);
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


}
