package com.project.service;

import com.project.domain.Faktura;

import java.util.List;

/**
 * Created by Ivan V. on 07-Jul-18
 */
public interface FakturaService {

    List<Faktura> findAll();

    Faktura findOne(Long id);

    void delete(Faktura faktura);

    Faktura save(Faktura faktura);
}
