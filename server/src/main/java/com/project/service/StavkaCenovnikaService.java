package com.project.service;

import com.project.domain.StavkaCenovnika;
import java.util.List;

public interface StavkaCenovnikaService {

    List<StavkaCenovnika> findAll();

    StavkaCenovnika findOne(Long id);

    void delete(StavkaCenovnika stavkaCenovnika);

    StavkaCenovnika save(StavkaCenovnika stavkaCenovnika);

}
