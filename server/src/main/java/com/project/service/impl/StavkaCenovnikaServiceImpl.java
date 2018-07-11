package com.project.service.impl;

import com.project.domain.StavkaCenovnika;
import com.project.repository.StavkaCenovnikaRepository;
import com.project.service.StavkaCenovnikaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StavkaCenovnikaServiceImpl implements StavkaCenovnikaService {

    @Autowired
    private StavkaCenovnikaRepository stavkaCenovnikaRepository;

    @Override
    public List<StavkaCenovnika> findAll() { return stavkaCenovnikaRepository.findAll(); }

    @Override
    public StavkaCenovnika findOne(Long id) { return stavkaCenovnikaRepository.findOne(id); }

    @Override
    public void delete(StavkaCenovnika stavkaCenovnika) { stavkaCenovnikaRepository.delete(stavkaCenovnika); }

    @Override
    public StavkaCenovnika save(StavkaCenovnika stavkaCenovnika) { return stavkaCenovnikaRepository.save(stavkaCenovnika); }

}
