package com.project.service;

import com.project.domain.Adresa;
import com.project.domain.Preduzece;

import java.util.List;

/**
 * Created by Dejan Stojkic (Smek) on 7/6/2018.
 */
public interface AdresaService {

    List<Adresa> findAll();

    Adresa findOne(Long id);

    Adresa save(Adresa user);

    void delete(Long id);
}
