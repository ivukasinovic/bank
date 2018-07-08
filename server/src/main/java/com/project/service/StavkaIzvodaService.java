package com.project.service;

import com.project.domain.StavkaIzvoda;

import java.util.List;

/**
 * Created by Ivan V. on 08-Jul-18
 */
public interface StavkaIzvodaService {

    List<StavkaIzvoda> findAll();

    StavkaIzvoda findOne(Long id);

    void delete(StavkaIzvoda stavkaIzvoda);

    StavkaIzvoda save(StavkaIzvoda stavkaIzvoda);

}
