package com.skpcp.elista.czaspracy.repository;


import com.skpcp.elista.czaspracy.ob.CzasPracyOB;
import com.skpcp.elista.uzytkownik.ob.UzytkownikOB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Created by Achilles on 2016-03-22.
 */
@Repository
public interface ICzasPracyRepository extends JpaRepository<CzasPracyOB, Long> {

    @Query("SELECT c FROM CzasPracyOB AS c  WHERE c.uzytkownik.id=?1 ")
    List<CzasPracyOB> znajdzCzasPracyPoUzytkowniku(Long aIdUzytkownika);

    @Query("SELECT c FROM CzasPracyOB  AS c WHERE c.uzytkownik.id =?1 AND c.dzien=?2")
    CzasPracyOB znajdzCzasPracyPoDacieOrazUzytkowniku(Long aIdUzytkownika,Date aDzien);

    @Query("SELECT c FROM CzasPracyOB  AS c WHERE c.uzytkownik.id=?1 AND c.dzien=?2")
    CzasPracyOB znajdzCzasPracyPoDacie(Long aIdUzytkownika,Date aDzien);
}
