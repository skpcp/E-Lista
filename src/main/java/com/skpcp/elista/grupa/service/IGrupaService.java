package com.skpcp.elista.grupa.service;


import com.skpcp.elista.grupa.dto.GrupaDTO;

import java.util.List;

/**
 * Created by padyyajs on 22.03.2016.
 */
public interface IGrupaService
{
    GrupaDTO znajdzGrupaPoNazwie(String aNazwa);
    List<GrupaDTO> znajdzWszystkieGrupa();
    void usunRole(Long aId);


}