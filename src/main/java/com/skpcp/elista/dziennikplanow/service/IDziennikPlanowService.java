package com.skpcp.elista.dziennikplanow.service;

import com.skpcp.elista.dziennikplanow.EDniTygodnia;
import com.skpcp.elista.dziennikplanow.dto.DziennikPlanowDTO;


import java.util.Date;
import java.util.List;

/**
 * Created by bidzis on 2016-03-22.
 */
public interface IDziennikPlanowService {
    DziennikPlanowDTO znajdzDziennikPlanowPoId(Long aId);
    List<DziennikPlanowDTO> znajdzWszystkieDziennikiPlanow();
    DziennikPlanowDTO znajdzDziennikPlanowPoIdUzytkownika(Long aIdUzytkownika);
   // List<DziennikPlanowDTO> znajdzDziennikPoDniuTygodnia(EDniTygodnia aDzienTygodnia);
    DziennikPlanowDTO zapiszDziennikPlanow(DziennikPlanowDTO aDziennikPlanowDTO);
    void usunDziennikPlanow(Long aId);
    DziennikPlanowDTO zmienDziennikPlanuPoIdUzytkownika(Long aIdUzytkownika, EDniTygodnia aDniTygodnia, Date aPlanOd, Date aPlanDo);
    DziennikPlanowDTO zmienDziennikPlanuPoId(Long aId, EDniTygodnia aDniTygodnia, Date aPlanOd, Date aPlanDo);
}
