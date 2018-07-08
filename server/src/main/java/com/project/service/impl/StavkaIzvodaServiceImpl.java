package com.project.service.impl;

import com.project.domain.StavkaIzvoda;
import com.project.repository.StavkaIzvodaRepository;
import com.project.service.StavkaIzvodaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Ivan V. on 08-Jul-18
 */
@Service
public class StavkaIzvodaServiceImpl implements StavkaIzvodaService {
    @Autowired
    private StavkaIzvodaRepository stavkaIzvodaRepository;

    @Override
    public List<StavkaIzvoda> findAll() {
        return stavkaIzvodaRepository.findAll();
    }

    @Override
    public StavkaIzvoda findOne(Long id) {
        return stavkaIzvodaRepository.findOne(id);
    }

    @Override
    public void delete(StavkaIzvoda stavkaIzvoda) {
        stavkaIzvodaRepository.delete(stavkaIzvoda);
    }

    @Override
    public StavkaIzvoda save(StavkaIzvoda stavkaIzvoda) {
        return stavkaIzvodaRepository.save(stavkaIzvoda);
    }

}
