package com.skpcp.elista.rola.respository;

import com.skpcp.elista.rola.ob.RolaOB;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by padyyajs on 22.03.2016.
 */
@Repository
public interface IRolaRepository extends JpaRepository <RolaOB, Long>
{
    @Query("SELECT u FROM RolaOB u WHERE u.nazwa LIKE ?1")
    RolaOB znajdzPoNazwieGrupy(String aNazwa);

}
