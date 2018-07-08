package com.project.service;

import com.project.domain.DnevnoStanje;

import java.util.List;

public interface DnevnoStanjeService {

    List<DnevnoStanje> findAll();

    DnevnoStanje findOne(Long id);

    void delete(DnevnoStanje dnevnoStanje);

    DnevnoStanje save(DnevnoStanje dnevnoStanje);

}
