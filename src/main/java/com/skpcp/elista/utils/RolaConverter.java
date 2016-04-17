package com.skpcp.elista.utils;

import com.skpcp.elista.role.dto.RolaDTO;
import com.skpcp.elista.role.ob.RolaOB;

/**
 * Created by padyyajs on 22.03.2016.
 */
public class RolaConverter
{
    public static RolaOB rolaDTOdoRoliOB(RolaDTO aRolaDTO) {
        if (aRolaDTO == null)
            return null;
        return new RolaOB(aRolaDTO.getNazwa(),UprawnienieConverter.uprawnienieListDTOdoUprwnienOB(aRolaDTO.getUprawnienia()));
    }

    public static RolaDTO rolaOBdoRoliDTO(RolaOB aRolaOB) {
        if (aRolaOB == null)
            return null;
        return new RolaDTO(aRolaOB.getId(), aRolaOB.getTechDate(), aRolaOB.getNazwa(),UprawnienieConverter.uprawnienieListOBdoUprawnienDTO(aRolaOB.getUprawnienia()));
    }
}

