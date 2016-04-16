package com.skpcp.elista.grupy.respository;

import com.skpcp.elista.grupy.dto.GrupaDTO;
import com.skpcp.elista.grupy.ob.GrupaOB;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * Created by padyyajs on 22.03.2016.
 */
@Repository
public interface IGrupyRespository extends JpaRepository <GrupaOB, Long>
{
    @Query("SELECT u FROM GrupaOB u WHERE u.nazwa LIKE ?1")
    GrupaOB znajdzPoNazwieGrupy(String aNazwa);
//    @Query("SELECT u FROM GrupaOB.uzytkownicy u WHERE u.id=?1")
//    GrupaOB znajdzGrupeUzytkownika(Long aIdUzytkownika);
//    @Query("SELECT u FROM GrupaOB u WHERE u.id =?1 AND u.nazwa =?2")
//    List<GrupaOB> findAll (String aNazwa);

}
