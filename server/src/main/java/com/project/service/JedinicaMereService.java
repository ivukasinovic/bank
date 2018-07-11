package com.project.service;

import com.project.domain.JedinicaMere;
import java.util.List;

public interface JedinicaMereService {

    List<JedinicaMere> findAll();

    JedinicaMere findOne(Long id);

    void delete(JedinicaMere jedinicaMere);

    JedinicaMere save(JedinicaMere jedinicaMere);

}
