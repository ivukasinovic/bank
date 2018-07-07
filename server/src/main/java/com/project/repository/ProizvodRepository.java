package com.project.repository;

import com.project.domain.Proizvod;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Ivan V. on 07-Jul-18
 */
public interface ProizvodRepository extends JpaRepository<Proizvod, Long> {
}
