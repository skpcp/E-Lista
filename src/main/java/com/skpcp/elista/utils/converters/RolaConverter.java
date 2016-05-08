package com.skpcp.elista.utils.converters;

import com.skpcp.elista.rola.dto.RolaDTO;
import com.skpcp.elista.rola.dto.RolaDTOBezIdTechDate;
import com.skpcp.elista.rola.dto.RolaDTOBezUprawnien;
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

    public static RolaDTOBezUprawnien rolaOBDoRolaDTOBezUprawnien(RolaOB aRolaOB){
        if(aRolaOB == null) return null;
        return new RolaDTOBezUprawnien(aRolaOB.getNazwa());
    }

    public static RolaDTO rolaDTOBezIDTechDateDoRoliDTO(RolaDTOBezIdTechDate aRolaDTO){
        if(aRolaDTO == null) return null;
        return new RolaDTO(aRolaDTO.getNazwa(),aRolaDTO.getUprawnienia());
    }

    public static RolaDTO rolaDTOBezUprawnienDoRoliDTO(RolaDTOBezUprawnien aRolaDTO){
        if(aRolaDTO == null) return null;
        return new RolaDTO(aRolaDTO.getNazwa(),null);
    }

    public static RolaDTOBezUprawnien rolaDTOdoRolaDTOBezUprawnien(RolaDTO aRolaDTO){
        if(aRolaDTO == null) return null;
        return new RolaDTOBezUprawnien(aRolaDTO.getNazwa());
    }
}

