package com.skpcp.elista.czaspracy.repository;


import com.skpcp.elista.czaspracy.ob.CzasPracyOB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Achilles on 2016-03-22.
 */
@Repository
public interface ICzasPracyRepository extends JpaRepository<CzasPracyOB, Long> {
    @Query("SELECT u FROM CzasPracyOB u WHERE u.idUzytkownika=?1")
    List<CzasPracyOB> findByIdUzytkownika(Long aIdUzytkownika);
}
