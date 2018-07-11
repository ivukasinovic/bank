package com.project.service.impl;

import com.project.domain.Valuta;
import com.project.repository.ValutaRepository;
import com.project.service.ValutaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ValutaServiceImpl implements ValutaService {

    @Autowired
    private ValutaRepository valutaRepository;

    @Override
    public List<Valuta> findAll() { return valutaRepository.findAll(); }

    @Override
    public Valuta findOne(Long id) { return valutaRepository.findOne(id); }

    @Override
    public void delete(Valuta valuta) { valutaRepository.delete(valuta); }

    @Override
    public Valuta save(Valuta valuta) { return valutaRepository.save(valuta); }

}
