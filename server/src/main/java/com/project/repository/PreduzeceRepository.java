package com.project.repository;

import com.project.domain.Preduzece;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Dejan Stojkic (Smek) on 7/6/2018.
 */
public interface PreduzeceRepository extends JpaRepository<Preduzece,Long> {

    Preduzece findByEmailAndLozinka(String email, String lozinka);

    Preduzece findOne(Long id);

    Preduzece findByNaziv(String naziv);

    Preduzece findByBrojRacuna(String brojRacuna);



}
