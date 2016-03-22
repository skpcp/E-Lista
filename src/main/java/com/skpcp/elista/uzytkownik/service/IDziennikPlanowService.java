package com.skpcp.elista.uzytkownik.service;

import com.skpcp.elista.dziennikplanow.EDniTygodnia;
import com.skpcp.elista.dziennikplanow.dto.DziennikPlanowDTO;
import com.skpcp.elista.dziennikplanow.ob.DziennikPlanowOB;
import com.skpcp.elista.uzytkownik.EStan;
import com.skpcp.elista.uzytkownik.dto.UzytkownikDTO;

import java.util.Date;
import java.util.List;

/**
 * Created by bidzis on 2016-03-22.
 */
public interface IDziennikPlanowService {
    DziennikPlanowDTO znajdzDziennikPlanowPoId(Long aId);
    List<DziennikPlanowDTO> znajdzWszystkieDziennikiPlanow();
    List<DziennikPlanowDTO> znajdzDziennikPlanowPoIdUzytkownika(Long aIdUzytkownika);
    List<DziennikPlanowDTO> znajdzDziennikPoDniuTygodnia(EDniTygodnia aDzienTygodnia);
    DziennikPlanowDTO zapiszUzytkownika(UzytkownikDTO aUzytkownikDTO);
    void usunDziennikPlanow(Long aId);
    List<DziennikPlanowDTO> znajdzUzytkownikowPoAktywnosci(EStan aAktywnosc);
    DziennikPlanowDTO zmienDziennikPlanuPoIdUzytkownika(Long aIdUzytkownika, EDniTygodnia aDniTygodnia, Date aPlanOd, Date aPlanDo);
    
}
