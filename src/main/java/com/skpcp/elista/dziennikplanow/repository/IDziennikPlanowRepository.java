package com.skpcp.elista.dziennikplanow.repository;

import com.skpcp.elista.dziennikplanow.ob.DziennikPlanowOB;
import com.skpcp.elista.uzytkownik.ob.UzytkownikOB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * Created by bidzis on 2016-03-22.
 */
@Repository
public interface IDziennikPlanowRepository extends JpaRepository<DziennikPlanowOB,Long> {

    @Query("SELECT d FROM DziennikPlanowOB d WHERE d.uzytkownik.id=?1")
    List<DziennikPlanowOB> znajdzDziennikiPlanowPoUzytkowniku(Long aId);
    @Query("SELECT d FROM DziennikPlanowOB d WHERE d.dzienTygodnia=?1 AND d.uzytkownik=?2")
    DziennikPlanowOB znajdzPoDniuTygodnia(String aDzienTygodnia, UzytkownikOB aUzytkownikOB);



}
