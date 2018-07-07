package com.project.service.impl;

import com.project.domain.Adresa;
import com.project.repository.AdresaRepository;
import com.project.service.AdresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Dejan Stojkic (Smek) on 7/6/2018.
 */
@Service
public class AdresaServiceImpl implements AdresaService {

    @Autowired
    private AdresaRepository adresaRepository;

    @Override
    public List<Adresa> findAll() {
        return adresaRepository.findAll();
    }

    @Override
    public Adresa findOne(Long id) {
        return adresaRepository.findOne(id);
    }

    @Override
    public Adresa save(Adresa user) {
        return adresaRepository.save(user);
    }

    @Override
    public void delete(Long id) {
        adresaRepository.delete(id);
    }

}
