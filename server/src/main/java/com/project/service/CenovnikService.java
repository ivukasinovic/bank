package com.project.service;

import com.project.domain.Cenovnik;
import com.project.domain.Preduzece;

import java.util.List;

/**
 * Created by Ivan V. on 07-Jul-18
 */
public interface CenovnikService {

    List<Cenovnik> findAll();

    Cenovnik findOne(Long id);

    void delete(Cenovnik cenovnik);

    Cenovnik save(Cenovnik cenovnik);

    List<Cenovnik> findByPreduzece(Preduzece preduzece);
}
