package com.skpcp.elista.dziennikplanow.repository;

import com.skpcp.elista.dziennikplanow.EDniTygodnia;
import com.skpcp.elista.dziennikplanow.ob.DziennikPlanowOB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * Created by bidzis on 2016-03-22.
 */
@Repository
public interface IDziennikPlanowRepository extends JpaRepository<DziennikPlanowOB,Long> {

    @Query("select u from DziennikPlanowOB u where u.idUzytkownika=?1")
    List<DziennikPlanowOB> findByIdUzytkownikaStartsWith(Long aIdUzytkownika);
    List<DziennikPlanowOB> znajdzPoDniuTygodnia(EDniTygodnia aDzienTygodnia);


}
