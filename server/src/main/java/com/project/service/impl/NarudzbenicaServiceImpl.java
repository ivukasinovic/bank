package com.project.service.impl;

import com.project.domain.Narudzbenica;
import com.project.repository.NarudzbenicaRepository;
import com.project.service.NarudzbenicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Ivan V. on 07-Jul-18
 */
@Service
public class NarudzbenicaServiceImpl implements NarudzbenicaService {

    @Autowired
    private NarudzbenicaRepository narudzbenicaRepository;

    @Override
    public List<Narudzbenica> findAll() {
        return narudzbenicaRepository.findAll();
    }

    @Override
    public Narudzbenica findOne(Long id) {
        return narudzbenicaRepository.findOne(id);
    }

    @Override
    public void delete(Narudzbenica narudzbenica) {
        narudzbenicaRepository.delete(narudzbenica);
    }

    @Override
    public Narudzbenica save(Narudzbenica narudzbenica) {
        return narudzbenicaRepository.save(narudzbenica);
    }
}
