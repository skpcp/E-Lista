package com.skpcp.elista.role.service;


import com.skpcp.elista.role.dto.RolaDTO;

import java.util.List;

/**
 * Created by padyyajs on 22.03.2016.
 */
public interface IRoleService
{
    RolaDTO znajdzRolePoNazwie(String aNazwa);
    List<RolaDTO> znajdzWszystkieRole();
    void usunRole(Long aId);


}