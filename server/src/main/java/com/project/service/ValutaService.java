package com.project.service;

import com.project.domain.Valuta;
import java.util.List;

public interface ValutaService {

    List<Valuta> findAll();

    Valuta findOne(Long id);

    void delete(Valuta valuta);

    Valuta save(Valuta valuta);

}
