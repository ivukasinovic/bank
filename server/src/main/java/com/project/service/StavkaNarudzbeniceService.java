package com.project.service;

import com.project.domain.StavkaNarudzbenice;

import java.util.List;

/**
 * Created by Ivan V. on 07-Jul-18
 */
public interface StavkaNarudzbeniceService {
    List<StavkaNarudzbenice> findAll();

    StavkaNarudzbenice findOne(Long id);

    void delete(StavkaNarudzbenice stavkaNarudzbenice);

    StavkaNarudzbenice save(StavkaNarudzbenice stavkaNarudzbenice);
}
