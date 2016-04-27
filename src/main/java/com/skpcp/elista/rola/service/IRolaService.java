package com.skpcp.elista.rola.service;


import com.skpcp.elista.rola.dto.RolaDTO;

import java.util.List;

/**
 * Created by padyyajs on 22.03.2016.
 */
public interface IRolaService
{
    RolaDTO znajdzRolePoNazwie(String aNazwa);
    List<RolaDTO> znajdzWszystkieRole();
    void usunRole(Long aId);


}