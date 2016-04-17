package com.skpcp.elista.role.respository;

import com.skpcp.elista.role.ob.RolaOB;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by padyyajs on 22.03.2016.
 */
@Repository
public interface IRolaRespository extends JpaRepository <RolaOB, Long>
{
    @Query("SELECT u FROM RolaOB u WHERE u.nazwa LIKE ?1")
    RolaOB znajdzPoNazwieRoli(String aNazwa);
//    @Query("SELECT u FROM RolaOB.uzytkownicy u WHERE u.id=?1")
//    RolaOB znajdzGrupeUzytkownika(Long aIdUzytkownika);
//    @Query("SELECT u FROM RolaOB u WHERE u.id =?1 AND u.nazwa =?2")
//    List<RolaOB> findAll (String aNazwa);

}
