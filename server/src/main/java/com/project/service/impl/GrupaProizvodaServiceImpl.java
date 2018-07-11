package com.project.service.impl;

import com.project.domain.GrupaProizvoda;
import com.project.repository.GrupaProizvodaRepository;
import com.project.service.GrupaProizvodaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GrupaProizvodaServiceImpl implements GrupaProizvodaService {

    @Autowired
    private GrupaProizvodaRepository grupaProizvodaRepository;

    @Override
    public List<GrupaProizvoda> findAll() { return grupaProizvodaRepository.findAll(); }

    @Override
    public GrupaProizvoda findOne(Long id) { return grupaProizvodaRepository.findOne(id); }

    @Override
    public void delete(GrupaProizvoda grupaProizvoda) { grupaProizvodaRepository.delete(grupaProizvoda); }

    @Override
    public GrupaProizvoda save(GrupaProizvoda grupaProizvoda) { return grupaProizvodaRepository.save(grupaProizvoda); }

}
