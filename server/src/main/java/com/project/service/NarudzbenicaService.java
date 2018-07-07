package com.project.service;

import com.project.domain.Narudzbenica;

import java.util.List;

/**
 * Created by Ivan V. on 07-Jul-18
 */
public interface NarudzbenicaService {

    List<Narudzbenica> findAll();

    Narudzbenica findOne(Long id);

    void delete(Narudzbenica narudzbenica);

    Narudzbenica save(Narudzbenica narudzbenica);
}
