package com.skpcp.elista.utils.converters;

import com.skpcp.elista.uprawnienia.dto.UprawnienieDTO;
import com.skpcp.elista.uprawnienia.ob.UprawnienieOB;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tomasz Komoszeski on 2016-04-16.
 */
public class UprawnienieConverter {
    public static UprawnienieOB uprawnienieDTOdoUprawnienOB(UprawnienieDTO aUprawnienieDTO){
        UprawnienieOB pUprawnienieOB = new UprawnienieOB(aUprawnienieDTO.getId(),aUprawnienieDTO.getTechDate(),aUprawnienieDTO.getNazwa());

        return pUprawnienieOB;
    }
    public static UprawnienieDTO uprawnienieOBdoUprawnienieDTO(UprawnienieOB aUprawnienieOB){
        return new UprawnienieDTO(aUprawnienieOB.getId(),aUprawnienieOB.getTechDate(),aUprawnienieOB.getNazwa());
    }

    public static List<UprawnienieOB> uprawnienieListDTOdoUprwnienOB(List<UprawnienieDTO> aListaUprawnienDTO){
        List<UprawnienieOB> pListaUprawnienOB = new ArrayList<>();
        for(UprawnienieDTO uprawnienie :aListaUprawnienDTO){
            pListaUprawnienOB.add(uprawnienieDTOdoUprawnienOB(uprawnienie));
        }
        return pListaUprawnienOB;
    }
    public static List<UprawnienieDTO> uprawnienieListOBdoUprawnienDTO(List<UprawnienieOB> aListaUprawnienOB){
        List<UprawnienieDTO> pListaUprawnienDTO = new ArrayList<>();
        for(UprawnienieOB uprawnienie : aListaUprawnienOB){
            pListaUprawnienDTO.add(uprawnienieOBdoUprawnienieDTO(uprawnienie));
        }
        return pListaUprawnienDTO;
    }


}
