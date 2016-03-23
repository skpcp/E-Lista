package com.skpcp.elista.czaspracy.service;

import com.skpcp.elista.czaspracy.dto.CzasPracyDTO;

import java.util.Date;

/**
 * Created by Achilles on 2016-03-22.
 */
public interface ICzasPracyService {
    CzasPracyDTO wyswietlCzasPracyPoIdUzytkownika(Long aIdUzytkownika);

    CzasPracyDTO wprowadzGodzineRozpoczeciaPoIdUzytkownika(Long aIdUzytkownika, Date aRozpoczecie);

    CzasPracyDTO wprowadzGodzineZakonczeniaPoIdUzytkownika(Long aIdUzytkownika, Date aZakonczenie);

    CzasPracyDTO wprowadzZakresPracyPoIdUzytkownika(Long aIdUzytkownika, String aZakresPracy);

    CzasPracyDTO wyswietlGodzineRozpoczeciaPoIdUzytkownika(Long aIdUzytkownika);

    CzasPracyDTO wyswietlGodzineZakonczeniaPoIdUzytkownika(Long aIdUzytkownika);

    CzasPracyDTO wyswietlZakresPracyPoIdUzytkownika(Long aIdUzytkownika);
}