package com.project.service.impl;

import com.project.domain.StavkaFakture;
import com.project.repository.StavkaFaktureRepository;
import com.project.service.StavkaFaktureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Ivan V. on 07-Jul-18
 */
@Service
public class StavkaFaktureServiceImpl implements StavkaFaktureService {
    @Autowired
    private StavkaFaktureRepository stavkaFaktureRepository;

    @Override
    public List<StavkaFakture> findAll() {
        return stavkaFaktureRepository.findAll();
    }

    @Override
    public StavkaFakture findOne(Long id) {
        return stavkaFaktureRepository.findOne(id);
    }

    @Override
    public void delete(StavkaFakture stavkaFakture) {
        stavkaFaktureRepository.delete(stavkaFakture);
    }

    @Override
    public StavkaFakture save(StavkaFakture stavkaFakture) {
        return stavkaFaktureRepository.save(stavkaFakture);
    }
}
