package com.project.service.impl;

import com.project.domain.StopaPDV;
import com.project.repository.StopaPDVRepository;
import com.project.service.StopaPDVService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StopaPDVServiceImpl implements StopaPDVService {

    @Autowired
    private StopaPDVRepository stopaPDVRepository;

    @Override
    public List<StopaPDV> findAll() { return stopaPDVRepository.findAll(); }

    @Override
    public StopaPDV findOne(Long id) { return stopaPDVRepository.findOne(id); }

    @Override
    public void delete(StopaPDV stopaPDV) { stopaPDVRepository.delete(stopaPDV); }

    @Override
    public StopaPDV save(StopaPDV stopaPDV) { return stopaPDVRepository.save(stopaPDV); }

}
