package com.project.service;

import com.project.domain.PDV;
import java.util.List;

public interface PDVService {

    List<PDV> findAll();

    PDV findOne(Long id);

    void delete(PDV pdv);

    PDV save(PDV pdv);

}
