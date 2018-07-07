package com.project.service;

import com.project.domain.Proizvod;

import java.util.List;

/**
 * Created by Ivan V. on 07-Jul-18
 */
public interface ProizvodService {
    List<Proizvod> findAll();

    Proizvod findOne(Long id);

    void delete(Proizvod proizvod);

    Proizvod save(Proizvod proizvod);
}
