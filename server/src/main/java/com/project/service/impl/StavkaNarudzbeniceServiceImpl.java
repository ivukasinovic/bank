package com.project.service.impl;

import com.project.domain.StavkaNarudzbenice;
import com.project.repository.StavkaNarudzbeniceRepository;
import com.project.service.StavkaNarudzbeniceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Ivan V. on 07-Jul-18
 */
@Service
public class StavkaNarudzbeniceServiceImpl implements StavkaNarudzbeniceService {

    @Autowired
    private StavkaNarudzbeniceRepository stavkaNarudzbeniceRepository;

    @Override
    public List<StavkaNarudzbenice> findAll() {
        return stavkaNarudzbeniceRepository.findAll();
    }

    @Override
    public StavkaNarudzbenice findOne(Long id) {
        return stavkaNarudzbeniceRepository.findOne(id);
    }

    @Override
    public void delete(StavkaNarudzbenice stavkaNarudzbenice) {
        stavkaNarudzbeniceRepository.delete(stavkaNarudzbenice);
    }

    @Override
    public StavkaNarudzbenice save(StavkaNarudzbenice stavkaNarudzbenice) {
        return stavkaNarudzbeniceRepository.save(stavkaNarudzbenice);
    }
}
