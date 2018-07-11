package com.project.service.impl;

import com.project.domain.JedinicaMere;
import com.project.repository.AdresaRepository;
import com.project.repository.JedinicaMereRepository;
import com.project.service.JedinicaMereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JedinicaMereServiceImpl implements JedinicaMereService {

    @Autowired
    private JedinicaMereRepository jedinicaMereRepository;

    @Override
    public List<JedinicaMere> findAll() { return jedinicaMereRepository.findAll(); }

    @Override
    public JedinicaMere findOne(Long id) { return jedinicaMereRepository.findOne(id); }

    @Override
    public void delete(JedinicaMere jedinicaMere) { jedinicaMereRepository.delete(jedinicaMere); }

    @Override
    public JedinicaMere save(JedinicaMere jedinicaMere) { return jedinicaMereRepository.save(jedinicaMere); }

}
