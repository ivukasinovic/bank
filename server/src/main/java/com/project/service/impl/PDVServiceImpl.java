package com.project.service.impl;

import com.project.domain.PDV;
import com.project.repository.PDVRepository;
import com.project.service.PDVService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PDVServiceImpl implements PDVService {

    @Autowired
    private PDVRepository PDVRepository;

    @Override
    public List<PDV> findAll() { return PDVRepository.findAll(); }

    @Override
    public PDV findOne(Long id) { return PDVRepository.findOne(id); }

    @Override
    public void delete(PDV pdv) { PDVRepository.delete(pdv); }

    @Override
    public PDV save(PDV pdv) { return PDVRepository.save(pdv); }

}
