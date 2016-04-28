package com.skpcp.elista.utils.converters;

import com.skpcp.elista.rola.dto.RolaDTO;
import com.skpcp.elista.rola.ob.RolaOB;

/**
 * Created by padyyajs on 22.03.2016.
 */
public class RolaConverter
{
    public static RolaOB rolaDTOdoRolaOB(RolaDTO aGrupaDTO) {
        if (aGrupaDTO == null)
            return null;
        RolaOB pRolaOB = new RolaOB(aGrupaDTO.getNazwa(),UprawnienieConverter.uprawnienieListDTOdoUprwnienOB(aGrupaDTO.getUprawnienia()));
        pRolaOB.setId(aGrupaDTO.getId());
        pRolaOB.setTechDate(aGrupaDTO.getTechDate());
        return pRolaOB;
    }

    public static RolaDTO rolaOBdoRolaDTO(RolaOB aRolaOB) {
        if (aRolaOB == null)
            return null;
        return new RolaDTO(aRolaOB.getId(), aRolaOB.getTechDate(), aRolaOB.getNazwa(),UprawnienieConverter.uprawnienieListOBdoUprawnienDTO(aRolaOB.getUprawnienia()));
    }
}

