package com.project.service.impl;

import com.project.domain.NalogZaPlacanje;
import com.project.repository.NalogZaPlacanjeRepository;
import com.project.service.NalogZaPlacanjeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Ivan V. on 07-Jul-18
 */
@Service
public class NalogZaPlacanjeServiceImpl implements NalogZaPlacanjeService {

    @Autowired
    private NalogZaPlacanjeRepository nalogZaPlacanjeRepository;

    @Override
    public List<NalogZaPlacanje> findAll() {
        return nalogZaPlacanjeRepository.findAll();
    }

    @Override
    public NalogZaPlacanje findOne(Long id) {
        return nalogZaPlacanjeRepository.findOne(id);
    }

    @Override
    public void delete(NalogZaPlacanje nalogZaPlacanje) {
        nalogZaPlacanjeRepository.delete(nalogZaPlacanje);
    }

    @Override
    public NalogZaPlacanje save(NalogZaPlacanje nalogZaPlacanje) {
        return nalogZaPlacanjeRepository.save(nalogZaPlacanje);
    }
}
