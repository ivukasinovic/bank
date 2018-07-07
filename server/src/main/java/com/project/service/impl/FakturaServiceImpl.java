package com.project.service.impl;

import com.project.domain.Faktura;
import com.project.repository.FakturaRepository;
import com.project.service.FakturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Ivan V. on 07-Jul-18
 */
@Service
public class FakturaServiceImpl implements FakturaService {
    @Autowired
    private FakturaRepository fakturaRepository;

    @Override
    public List<Faktura> findAll() {
        return fakturaRepository.findAll();
    }

    @Override
    public Faktura findOne(Long id) {
        return fakturaRepository.findOne(id);
    }

    @Override
    public void delete(Faktura faktura) {
        fakturaRepository.delete(faktura);
    }

    @Override
    public Faktura save(Faktura faktura) {
        return fakturaRepository.save(faktura);
    }
}
