package com.skpcp.elista.grupy.respository;

import com.skpcp.elista.grupy.dto.GrupyDTO;
import com.skpcp.elista.grupy.ob.GrupyOB;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by padyyajs on 22.03.2016.
 */
@Respository
public interface IGrupyRespository extends JpaRespository <GrupyDTO, Long>
{
    List<GrupyOB> findBynazwaGrupy (String anazwaGrupy);
    @Query("SELECT u FROM GrupyOB u WHERE u.nazwagrupy=?1")
    List<GrupyOB> findUserBynazwaGrupy (Long aId, String anazwaGrupy);
    @Query("SELECT u FROM GrupyOB u WHERE u.id =?1 AND u.nazwagrupy =?2")
    List<GrupyOB> findAll (String anazwaGrupy);

}
