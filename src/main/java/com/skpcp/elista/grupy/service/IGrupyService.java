package com.skpcp.elista.grupy.service;


import com.skpcp.elista.grupy.dto.GrupaDTO;
import com.skpcp.elista.grupy.ob.GrupaOB;
import com.skpcp.elista.uzytkownik.dto.UzytkownikDTO;

import java.util.List;

/**
 * Created by padyyajs on 22.03.2016.
 */
public interface IGrupyService
{
    GrupaDTO znajdzGrupePoNazwie (String aNazwa);
   // GrupaDTO znajdzGrupeUzytkownika(Long aIdUzytkownika);
    List<GrupaDTO> znajdzWszystkieGrupy();
    void usunGrupe (Long aId);
    GrupaDTO zapiszGrupe (GrupaDTO aGrupaDTO);

}