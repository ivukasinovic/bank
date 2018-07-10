package com.project.service;

import com.project.domain.Partnerstvo;
import com.project.domain.Preduzece;

import java.util.List;

/**
 * Created by Ivan V. on 07-Jul-18
 */
public interface PartnerstvoService  {
    List<Partnerstvo> findAll();

    List<Partnerstvo> findByPreduzece1_id(Long id);

    List<Partnerstvo> findByPreduzece1(Preduzece preduzece);

    Partnerstvo findOne(Long id);

    void delete(Partnerstvo partnerstvo);

    Partnerstvo save(Partnerstvo partnerstvo);
}
