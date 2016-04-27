package com.skpcp.elista.grupa.service;

import com.skpcp.elista.grupa.dto.GrupaDTO;
import com.skpcp.elista.grupa.dto.GrupaUzytkownikDTO;
import com.skpcp.elista.uzytkownik.dto.UzytkownikDTO;


/**
 * Created by Tomasz Komoszeski on 2016-04-27.
 */
public interface IGrupaService {

    GrupaDTO zapiszGrupe(GrupaDTO aGrupa);
    GrupaDTO znajdzGrupePoId(Long aId);
    GrupaDTO dodajUzytkownikDoGrupy(GrupaUzytkownikDTO aGrupaDTO);
    GrupaDTO znajdzGrupePoNazwie(String aNazwa);
    GrupaDTO znajdzGrupePoLiderzeId(Long aIdLidera);
    void usunGrupePoId(Long aId);
}
