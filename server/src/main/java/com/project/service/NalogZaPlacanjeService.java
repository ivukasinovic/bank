package com.project.service;

import com.project.domain.NalogZaPlacanje;

import java.util.List;

/**
 * Created by Ivan V. on 07-Jul-18
 */
public interface NalogZaPlacanjeService {
    List<NalogZaPlacanje> findAll();

    NalogZaPlacanje findOne(Long id);

    void delete(NalogZaPlacanje nalogZaPlacanje);

    NalogZaPlacanje save(NalogZaPlacanje nalogZaPlacanje);

    void generisiNalog(Long idFakture, Double iznos);

    List<NalogZaPlacanje> findByDuznik(Long id);
}
