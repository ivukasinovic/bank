package com.project.service;

import com.project.domain.StavkaFakture;

import java.util.List;

/**
 * Created by Ivan V. on 07-Jul-18
 */
public interface StavkaFaktureService  {


    List<StavkaFakture> findAll();

    StavkaFakture findOne(Long id);

    void delete(StavkaFakture faktura);

    StavkaFakture save(StavkaFakture faktura);
}
