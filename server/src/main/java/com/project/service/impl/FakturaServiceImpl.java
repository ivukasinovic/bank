package com.project.service.impl;

import com.project.domain.Faktura;
import com.project.domain.Preduzece;
import com.project.repository.FakturaRepository;
import com.project.service.FakturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FakturaServiceImpl implements FakturaService {

    @Autowired
    private FakturaRepository fakturaRepository;

    @Override
    public List<Faktura> getNeplaceneFakture(Preduzece preduzece) {

        return fakturaRepository.findByPreduzeceAndTipIgnoreCaseAndPreostaliIznosGreaterThan(preduzece,"ulazna",0.0);
    }
}
