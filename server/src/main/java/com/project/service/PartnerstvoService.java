package com.project.service;

import com.project.domain.Partnerstvo;

import java.util.List;

/**
 * Created by Ivan V. on 07-Jul-18
 */
public interface PartnerstvoService  {
    List<Partnerstvo> findAll();

    Partnerstvo findOne(Long id);

    void delete(Partnerstvo partnerstvo);

    Partnerstvo save(Partnerstvo partnerstvo);
}
