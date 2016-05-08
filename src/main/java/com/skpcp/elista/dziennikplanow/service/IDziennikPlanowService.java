package com.skpcp.elista.dziennikplanow.service;

import com.skpcp.elista.dziennikplanow.dto.DziennikPlanowDTO;
import com.skpcp.elista.dziennikplanow.dto.DziennikPlanowDTOBezTechDate;
import com.skpcp.elista.dziennikplanow.dto.DziennikPlanowDTOBezUzytkownika;
import com.skpcp.elista.dziennikplanow.dto.DziennikPlanowDTOUzytkownik;
import com.skpcp.elista.utils.exceptions.MyServerException;


import java.util.List;

/**
 * Created by bidzis on 2016-03-22.
 */
public interface IDziennikPlanowService {
    DziennikPlanowDTOUzytkownik znajdzDziennikPlanowPoId(Long aId) throws MyServerException;
    List<DziennikPlanowDTOUzytkownik> znajdzWszystkieDziennikiPlanow();
    List<DziennikPlanowDTOBezUzytkownika> znajdzDziennikiPlanowPoUzytkowniku(Long aIdUzytkownika);
  //  List<DziennikPlanowDTO> znajdzDziennikPoDniuTygodnia(EDniTygodnia aDzienTygodnia);//to się później zrobi ! ;)
    DziennikPlanowDTOUzytkownik zapiszDziennikPlanow(DziennikPlanowDTOBezTechDate aDziennikPlanowDTO) throws MyServerException;
    void usunDziennikPlanow(Long aId);
    //DziennikPlanowDTO zmienDziennikPlanuPoId(Long aId, EDniTygodnia aDzienTygodnia, Date aPlanOd, Date aPlanDo);
     //DziennikPlanowDTO dopiszUzytkownikaDoDziennikaPlanow(Long aId, UzytkownikDTO aUzytkownikDTO);
}
