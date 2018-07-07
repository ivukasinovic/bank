package com.project.service.impl;

import com.project.domain.Partnerstvo;
import com.project.repository.PartnerstvoRepository;
import com.project.service.PartnerstvoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Ivan V. on 07-Jul-18
 */
@Service
public class PartnerstvoServiceImpl implements PartnerstvoService {

    @Autowired
    private PartnerstvoRepository partnerstvoRepository;

    @Override
    public List<Partnerstvo> findAll() {
        return partnerstvoRepository.findAll();
    }

    @Override
    public Partnerstvo findOne(Long id) {
        return partnerstvoRepository.findOne(id);
    }

    @Override
    public void delete(Partnerstvo partnerstvo) {
        partnerstvoRepository.delete(partnerstvo);
    }

    @Override
    public Partnerstvo save(Partnerstvo partnerstvo) {
        return partnerstvoRepository.save(partnerstvo);
    }
}
