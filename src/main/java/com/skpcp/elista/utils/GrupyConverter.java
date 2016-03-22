package com.skpcp.elista.utils;

import com.skpcp.elista.grupy.dto.GrupyDTO;
import com.skpcp.elista.grupy.ob.GrupyOB;
import com.skpcp.elista.uzytkownik.dto.UzytkownikDTO;
import com.skpcp.elista.uzytkownik.ob.UzytkownikOB;

/**
 * Created by padyyajs on 22.03.2016.
 */
public class GrupyConverter
{
    public static GrupyOB grupyDTOdogrupyOB (GrupyDTO aGrupyDTO)
    {
        if(aGrupyDTO == null)
            return null;
        return new GrupyOB(aGrupyDTO.getNazwaGrupy(),aGrupyDTO.getIdUzytkownika());
    }
    public static GrupyDTO grupyOBdogrupyDTO (GrupyOB aGrupyOB)
    {
        if(aGrupyOB == null )
            return null;
        return new GrupyDTO(aGrupyOB.getNazwaGrupy(), aGrupyOB.getIdUzytkownika());
    }
}










