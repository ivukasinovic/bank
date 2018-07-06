package com.project.service;

import com.project.domain.Faktura;
import com.project.domain.Preduzece;

import java.util.List;

public interface FakturaService {

    List<Faktura> getNeplaceneFakture(Preduzece preduzece);
}
