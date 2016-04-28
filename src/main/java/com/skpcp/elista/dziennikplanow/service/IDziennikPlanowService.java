package com.skpcp.elista.dziennikplanow.service;

import com.skpcp.elista.dziennikplanow.dto.DziennikPlanowDTO;
import com.skpcp.elista.utils.exceptions.MyServerException;


import java.util.List;

/**
 * Created by bidzis on 2016-03-22.
 */
public interface IDziennikPlanowService {
    DziennikPlanowDTO znajdzDziennikPlanowPoId(Long aId) throws MyServerException;
    List<DziennikPlanowDTO> znajdzWszystkieDziennikiPlanow();
    List<DziennikPlanowDTO> znajdzDziennikiPlanowPoUzytkowniku(Long aIdUzytkownika);
  //  List<DziennikPlanowDTO> znajdzDziennikPoDniuTygodnia(EDniTygodnia aDzienTygodnia);//to się później zrobi ! ;)
    DziennikPlanowDTO zapiszDziennikPlanow(DziennikPlanowDTO aDziennikPlanowDTO) throws MyServerException;
    void usunDziennikPlanow(Long aId);
    //DziennikPlanowDTO zmienDziennikPlanuPoId(Long aId, EDniTygodnia aDzienTygodnia, Date aPlanOd, Date aPlanDo);
     //DziennikPlanowDTO dopiszUzytkownikaDoDziennikaPlanow(Long aId, UzytkownikDTO aUzytkownikDTO);
}
