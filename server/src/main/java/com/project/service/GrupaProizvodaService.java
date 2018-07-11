package com.project.service;

import com.project.domain.GrupaProizvoda;
import java.util.List;

public interface GrupaProizvodaService {

    List<GrupaProizvoda> findAll();

    GrupaProizvoda findOne(Long id);

    void delete(GrupaProizvoda grupaProizvoda);

    GrupaProizvoda save(GrupaProizvoda grupaProizvoda);

}
