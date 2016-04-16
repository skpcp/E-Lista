package com.skpcp.elista.dziennikplanow.service;

import com.skpcp.elista.dziennikplanow.EDniTygodnia;
import com.skpcp.elista.dziennikplanow.dto.DziennikPlanowDTO;
import com.skpcp.elista.uzytkownik.dto.UzytkownikDTO;
import com.skpcp.elista.uzytkownik.ob.UzytkownikOB;


import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

/**
 * Created by bidzis on 2016-03-22.
 */
public interface IDziennikPlanowService {
    DziennikPlanowDTO znajdzDziennikPlanowPoId(Long aId);
    List<DziennikPlanowDTO> znajdzWszystkieDziennikiPlanow();
    List<DziennikPlanowDTO> znajdzDziennikiPlanowPoUzytkowniku(Long aIdUzytkownika);
  //  List<DziennikPlanowDTO> znajdzDziennikPoDniuTygodnia(EDniTygodnia aDzienTygodnia);//to się później zrobi ! ;)
    DziennikPlanowDTO zapiszDziennikPlanow(DziennikPlanowDTO aDziennikPlanowDTO);
    void usunDziennikPlanow(Long aId);
    //DziennikPlanowDTO zmienDziennikPlanuPoId(Long aId, EDniTygodnia aDzienTygodnia, Date aPlanOd, Date aPlanDo);
     //DziennikPlanowDTO dopiszUzytkownikaDoDziennikaPlanow(Long aId, UzytkownikDTO aUzytkownikDTO);
}
