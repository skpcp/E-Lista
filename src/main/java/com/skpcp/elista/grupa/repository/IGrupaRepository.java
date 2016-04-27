package com.skpcp.elista.grupa.repository;

import com.skpcp.elista.grupa.ob.GrupaOB;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Tomasz Komoszeski on 2016-04-27.
 */
public interface IGrupaRepository extends JpaRepository<GrupaOB, Long> {
}
