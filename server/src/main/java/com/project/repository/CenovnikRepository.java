package com.project.repository;

import com.project.domain.Cenovnik;
import com.project.domain.Preduzece;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Ivan V. on 07-Jul-18
 */
public interface CenovnikRepository extends JpaRepository<Cenovnik, Long> {

    List<Cenovnik> findByPreduzece(Preduzece preduzece);
}

