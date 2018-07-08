package com.project.service.impl;

import com.project.domain.PoslovnaGodina;
import com.project.domain.Preduzece;
import com.project.repository.PoslovnaGodinaRepository;
import com.project.service.PoslovnaGodinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Ivan V. on 08-Jul-18
 */
@Service
public class PoslovnaGodinaServiceImpl implements PoslovnaGodinaService {

    @Autowired
    private PoslovnaGodinaRepository poslovnaGodinaRepository;

    @Override
    public List<PoslovnaGodina> findAll() {
        return poslovnaGodinaRepository.findAll();
    }

    @Override
    public PoslovnaGodina findOne(Long id) {
        return poslovnaGodinaRepository.findOne(id);
    }

    @Override
    public PoslovnaGodina findByGodinaAndPreduzece(Integer godina, Preduzece preduzece) {
        return poslovnaGodinaRepository.findByGodinaAndPreduzece(godina, preduzece);
    }

    @Override
    public void delete(PoslovnaGodina poslovnaGodina) {
        poslovnaGodinaRepository.delete(poslovnaGodina);
    }

    @Override
    public PoslovnaGodina save(PoslovnaGodina poslovnaGodina) {
        return poslovnaGodinaRepository.save(poslovnaGodina);
    }
}
