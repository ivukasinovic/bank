package com.project.service;

import com.project.domain.PoslovnaGodina;
import com.project.domain.Preduzece;

import java.util.List;

/**
 * Created by Ivan V. on 08-Jul-18
 */
public interface PoslovnaGodinaService {
    
    List<PoslovnaGodina> findAll();

    PoslovnaGodina findOne(Long id);

    PoslovnaGodina findByGodinaAndPreduzece(Integer godina, Preduzece preduzece);

    void delete(PoslovnaGodina poslovnaGodina);

    PoslovnaGodina save(PoslovnaGodina poslovnaGodina);
    
}
