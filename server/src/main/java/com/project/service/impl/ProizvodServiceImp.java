package com.project.service.impl;

import com.project.domain.Preduzece;
import com.project.domain.Proizvod;
import com.project.repository.ProizvodRepository;
import com.project.service.ProizvodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Ivan V. on 07-Jul-18
 */
@Service
public class ProizvodServiceImp implements ProizvodService {
    @Autowired
    private ProizvodRepository proizvodRepository;

    @Override
    public List<Proizvod> findAll() {
        return proizvodRepository.findAll();
    }

    @Override
    public List<Proizvod> findByPreduzece(Preduzece preduzece) {
        return proizvodRepository.findByPreduzece(preduzece);
    }

    @Override
    public Proizvod findOne(Long id) {
        return proizvodRepository.findOne(id);
    }

    @Override
    public void delete(Proizvod proizvod) {
        proizvodRepository.delete(proizvod);
    }

    @Override
    public Proizvod save(Proizvod proizvod) {
        return proizvodRepository.save(proizvod);
    }
    
}
