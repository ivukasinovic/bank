package com.project.service.impl;

import com.project.domain.Cenovnik;
import com.project.domain.Preduzece;
import com.project.repository.CenovnikRepository;
import com.project.service.CenovnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Ivan V. on 07-Jul-18
 */
@Service
public class CenovnikServiceImpl implements CenovnikService {

    @Autowired
    private CenovnikRepository cenovnikRepository;

    @Override
    public List<Cenovnik> findAll() {
        return cenovnikRepository.findAll();
    }

    @Override
    public Cenovnik findOne(Long id) {
        return cenovnikRepository.findOne(id);
    }

    @Override
    public void delete(Cenovnik cenovnik) {
        cenovnikRepository.delete(cenovnik);
    }

    @Override
    public Cenovnik save(Cenovnik cenovnik) {
        return cenovnikRepository.save(cenovnik);
    }

    @Override
    public List<Cenovnik> findByPreduzece(Preduzece preduzece) {
        return cenovnikRepository.findByPreduzece(preduzece);
    }
}
