package com.skpcp.elista.nieobecnosci.repository;

import com.skpcp.elista.nieobecnosci.EJednostka;
import com.skpcp.elista.nieobecnosci.ob.NieobecnosciOB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * Created by IGOR on 2016-03-22.
 */
@Repository
public interface INieobecnosciRepository extends JpaRepository<NieobecnosciOB,Long>{
    List<NieobecnosciOB> findByIdUzytkownikaStartsWith(Long aID);
    List<NieobecnosciOB> findByDateStartsWith(Date aID);
    @Query("SELECT u FROM NieobecnosciOB u WHERE u.idUzytkownika =?1 AND u.data =?2")
    List<NieobecnosciOB> findByIdUzytkownikaIDate(Long aidUzytkownika, Date date);
    @Query("SELECT u FROM NieobecnosciOB u WHERE u.typ=?1")
    List<NieobecnosciOB> findByTypStartsWith(EJednostka aID);

}
