package com.skpcp.elista.uzytkownik.repository;


import com.skpcp.elista.uzytkownik.EStan;
import com.skpcp.elista.uzytkownik.ob.UzytkownikOB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Tomek on 2016-03-20.
 */
@Repository
public interface IUzytkownikRepository extends JpaRepository<UzytkownikOB,Long> {

    List<UzytkownikOB> findByImieStartsWith(String aImie);
    List<UzytkownikOB> findByNazwiskoStartsWith(String aNazwisko);
    @Query("SELECT u FROM UzytkownikOB u WHERE u.imie =?1 AND u.nazwisko=?2")
    List<UzytkownikOB> findByFullImie(String aImie,String aNazwisko);
    @Query("SELECT u FROM UzytkownikOB u WHERE u.aktywnosc=?1")
    List<UzytkownikOB> znajdzPoAktywnosci(EStan aAktywnosc);
}
