package com.project.service.impl;

import com.project.domain.Faktura;
import com.project.domain.Preduzece;
import com.project.repository.FakturaRepository;
import com.project.service.FakturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Ivan V. on 07-Jul-18
 */
@Service
public class FakturaServiceImpl implements FakturaService {
    @Autowired
    private FakturaRepository fakturaRepository;

    @Override
    public List<Faktura> findAll() {
        return fakturaRepository.findAll();
    }

    @Override
    public Faktura findOne(Long id) {
        return fakturaRepository.findOne(id);
    }

    @Override
    public Faktura findByBroj(Long broj) {
        return fakturaRepository.findByBroj(broj);
    }

    @Override
    public void delete(Faktura faktura) {
        fakturaRepository.delete(faktura);
    }

    @Override
    public Faktura save(Faktura faktura) {
        return fakturaRepository.save(faktura);
    }

    @Override
    public List<Faktura> getNeplacene(Preduzece preduzece) {
        return fakturaRepository.findByDuznikAndPreostaliIznosGreaterThan(preduzece,0.0);

    }

    @Override
    public List<Faktura> findByDuznik(Preduzece duznik) {
        return fakturaRepository.findByDuznik(duznik);
    }

    @Override
    public List<Faktura> findByPrimalac(Preduzece primalac) {
        return fakturaRepository.findByPrimalac(primalac);
    }
}
