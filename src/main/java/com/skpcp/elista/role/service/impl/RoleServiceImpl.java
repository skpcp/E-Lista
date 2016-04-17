package com.skpcp.elista.role.service.impl;

import com.skpcp.elista.role.dto.RolaDTO;
import com.skpcp.elista.role.ob.RolaOB;
import com.skpcp.elista.role.respository.IRolaRespository;
import com.skpcp.elista.role.service.IRoleService;
import com.skpcp.elista.utils.RolaConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by padyyajs on 22.03.2016.
 */
@Service
@Transactional
public class RoleServiceImpl implements IRoleService {
    @Autowired
    IRolaRespository iRolaRespository;

    @Override
    public RolaDTO znajdzRolePoNazwie(String aNazwa)
    {
        RolaOB pRolaOB = iRolaRespository.znajdzPoNazwieRoli(aNazwa);
        if (pRolaOB == null)
            return null;
        return RolaConverter.rolaOBdoRoliDTO(pRolaOB);
    }

//    @Override
//    public RolaDTO znajdzGrupeUzytkownika(Long aIdUzytkownika)
//    {
//        RolaOB pGrupaOB = iGrupyRespository.znajdzGrupeUzytkownika(aIdUzytkownika);
//        if(pGrupaOB == null) return null;
//        return RolaConverter.rolaOBdoRoliDTO(pGrupaOB);
//    }

    @Override
    public List<RolaDTO> znajdzWszystkieRole()
    {
        List<RolaDTO> listaWynikowaRolaDTO = new ArrayList<>();
        List<RolaOB> listaRolaOB = iRolaRespository.findAll();
        for (RolaOB rola : listaRolaOB) listaWynikowaRolaDTO.add(RolaConverter.rolaOBdoRoliDTO(rola));
        return listaWynikowaRolaDTO;
    }
//
//    @Override
//    public RolaDTO zapiszRole(RolaDTO aRolaDTO)
//    {
//        if (aRolaDTO == null) {
//            return null;
//        }
//        RolaOB pGrupyOB = aRolaDTO.getId() == null ? null : iRolaRespository.findOne(aRolaDTO.getId());
//
//        if (pGrupyOB == null) {
//            return RolaConverter.rolaOBdoRoliDTO(iRolaRespository.save(RolaConverter.rolaDTOdoRoliOB(aRolaDTO)));
//        }
//        pGrupyOB.setNazwa(aRolaDTO.getNazwa());
//        return RolaConverter.rolaOBdoRoliDTO(iRolaRespository.save(pGrupyOB));
//    }

    @Override
    public void usunRole(Long aId) {
        iRolaRespository.delete(aId);
    }
}