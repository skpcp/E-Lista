package com.skpcp.elista.nieobecnosci.repository;


import com.skpcp.elista.nieobecnosci.ob.NieobecnoscOB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Created by IGOR on 2016-03-22.
 */
@Repository
public interface INieobecnoscRepository extends JpaRepository<NieobecnoscOB,Long>{


      @Query("SELECT u FROM NieobecnoscOB u WHERE u.uzytkownik.id=?1")
      List<NieobecnoscOB> znajdzNieobecnosciPoUzytkowniku(Long aIdUzytkownika);
      @Query("SELECT u FROM NieobecnoscOB u WHERE u.data=?1")
      List<NieobecnoscOB> znajdzNieobecnosciPoDacie(Date aData);
      @Query("SELECT u FROM NieobecnoscOB u WHERE u.data=?1 AND u.uzytkownik.id=?2")
      NieobecnoscOB znajdzNieobecnoscPoDacieIUzytkowniku(Date date,Long aIdUzytkownika);
      @Query("SELECT u FROM NieobecnoscOB  u WHERE u.typ LIKE ?1")
      List<NieobecnoscOB> znajdzNieboecnosciPoTypie(String aTyp);
      @Query("SELECT u FROM NieobecnoscOB u WHERE u.typ LIKE ?1 AND u.uzytkownik.id=?2")
      List<NieobecnoscOB> znajdzPoTypieNieobecnosciIUzytkowniku(String aTyp,Long aIdUzytkownika);

}
