package com.project.service;

import com.project.domain.StopaPDV;
import java.util.List;

public interface StopaPDVService {

    List<StopaPDV> findAll();

    StopaPDV findOne(Long id);

    void delete(StopaPDV stopaPDV);

    StopaPDV save(StopaPDV stopaPDV);

}
