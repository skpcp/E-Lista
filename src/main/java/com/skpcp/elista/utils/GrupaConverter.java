package com.skpcp.elista.utils;

import com.skpcp.elista.grupy.dto.GrupaDTO;
import com.skpcp.elista.grupy.ob.GrupaOB;

/**
 * Created by padyyajs on 22.03.2016.
 */
public class GrupaConverter
{
    public static GrupaOB grupyDTOdogrupyOB(GrupaDTO aGrupaDTO) {
        if (aGrupaDTO == null)
            return null;
        return new GrupaOB(aGrupaDTO.getNazwa(),UprawnienieConverter.uprawnienieListDTOdoUprwnienOB(aGrupaDTO.getUprawnienia()));
    }

    public static GrupaDTO grupyOBdogrupyDTO(GrupaOB aGrupaOB) {
        if (aGrupaOB == null)
            return null;
        return new GrupaDTO(aGrupaOB.getId(), aGrupaOB.getTechDate(),aGrupaOB.getNazwa(),UprawnienieConverter.uprawnienieListOBdoUprawnienDTO(aGrupaOB.getUprawnienia()));
    }
}

