package com.project.service.impl;

import com.project.domain.DnevnoStanje;
import com.project.repository.DnevnoStanjeRepository;
import com.project.service.DnevnoStanjeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DnevnoStanjeServiceImpl implements DnevnoStanjeService {

    @Autowired
    private DnevnoStanjeRepository dnevnoStanjeRepository;

    @Override
    public List<DnevnoStanje> findAll() {
        return dnevnoStanjeRepository.findAll();
    }

    @Override
    public DnevnoStanje findOne(Long id) {
        return dnevnoStanjeRepository.findOne(id);
    }

    @Override
    public void delete(DnevnoStanje dnevnoStanje) {
        dnevnoStanjeRepository.delete(dnevnoStanje);
    }

    @Override
    public DnevnoStanje save(DnevnoStanje dnevnoStanje) {
        return dnevnoStanjeRepository.save(dnevnoStanje);
    }
}
