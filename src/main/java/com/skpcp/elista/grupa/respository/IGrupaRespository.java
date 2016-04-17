package com.skpcp.elista.grupa.respository;

import com.skpcp.elista.grupa.ob.GrupaOB;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by padyyajs on 22.03.2016.
 */
@Repository
public interface IGrupaRespository extends JpaRepository <GrupaOB, Long>
{
    @Query("SELECT u FROM GrupaOB u WHERE u.nazwa LIKE ?1")
    GrupaOB znajdzPoNazwieRoli(String aNazwa);
//    @Query("SELECT u FROM GrupaOB.uzytkownicy u WHERE u.id=?1")
//    GrupaOB znajdzGrupeUzytkownika(Long aIdUzytkownika);
//    @Query("SELECT u FROM GrupaOB u WHERE u.id =?1 AND u.nazwa =?2")
//    List<GrupaOB> findAll (String aNazwa);

}
