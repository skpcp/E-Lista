package com.skpcp.elista.grupa.service;

import com.skpcp.elista.grupa.dto.GrupaBezUDTO;
import com.skpcp.elista.grupa.dto.GrupaDTO;

/**
 * Created by Tomasz Komoszeski on 2016-04-27.
 */
public interface IGrupaService {

    GrupaDTO zapiszGrupe(GrupaBezUDTO aGrupa);
    GrupaDTO znajdzGrupePoId(Long aId);
    GrupaDTO dodajUzytkownikDoGrupy(Long aIdGrupy,Long aIdUzytkownika);
    GrupaDTO znajdzGrupePoNazwie(String aNazwa);
    GrupaDTO znajdzGrupePoLiderzeId(Long aIdLidera);
    void usunGrupePoId(Long aId);
}
