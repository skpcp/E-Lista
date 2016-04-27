package com.skpcp.elista.grupa.repository;

import com.skpcp.elista.grupa.ob.GrupaOB;
import com.skpcp.elista.uzytkownik.ob.UzytkownikOB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Tomasz Komoszeski on 2016-04-27.
 */
@Repository
public interface IGrupaRepository extends JpaRepository<GrupaOB, Long> {
    @Query("SELECT g FROM GrupaOB g WHERE g.nazwa = ?1")
    GrupaOB znajdzGrupePoNazwie(String aNazwa);
    @Query("SELECT g FROM GrupaOB g WHERE g.lider.id =?1")
    GrupaOB znajdzGrupePoIdLidera(Long aId);
    @Query("SELECT g FROM GrupaOB g WHERE g.id = ?1 AND g.nazwa = ?2")
    GrupaOB znajdzGrupePoIdOrazNazwie(Long aId,String nazwa);
//    @Query("UPDATE GrupaOB g SET g. WHERE g.id = ?2")
//    GrupaOB dodajUzytkownikaDoGrupy(List<UzytkownikOB> aUzytkownicy, Long aId);
}
