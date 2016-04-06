package com.skpcp.elista.grupy.service;

import com.skpcp.elista.grupy.dto.GrupyDTO;
import com.sun.xml.internal.ws.api.message.saaj.SAAJFactory;

import java.util.List;

/**
 * Created by padyyajs on 22.03.2016.
 */
public interface IGrupyService
{
    GrupyDTO znajdzGrupePoNazwie (String anazwaGrupy);
    GrupyDTO znajdzUzytkownikaPoGrupie (Long aId, String anazwaGrupy);
    List<GrupyDTO> znajdzWszystkieGrupy();
    void usunGrupe (String anazwaGrupy);
    GrupyDTO zapiszGrupe (GrupyDTO aGrupyDTO);

}