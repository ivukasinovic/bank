package com.project.service;

import com.project.domain.Faktura;
import com.project.domain.Preduzece;

import java.util.List;

/**
 * Created by Ivan V. on 07-Jul-18
 */
public interface FakturaService {

    List<Faktura> findAll();

    Faktura findOne(Long id);

    Faktura findByBroj(Long broj);

    void delete(Faktura faktura);

    Faktura save(Faktura faktura);

    List<Faktura> getNeplacene(Preduzece preduzece);

    List<Faktura> findByDuznik(Preduzece duznik);

    List<Faktura> findByPrimalac(Preduzece primalac);

}
