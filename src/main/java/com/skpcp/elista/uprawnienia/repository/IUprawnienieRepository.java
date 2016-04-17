package com.skpcp.elista.uprawnienia.repository;

import com.skpcp.elista.uprawnienia.ob.UprawnienieOB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Tomasz Komoszeski on 2016-04-17.
 */
@Repository
public interface IUprawnienieRepository extends JpaRepository<UprawnienieOB,Long> {

}
