package com.skpcp.elista.grupa.service.impl;

import com.skpcp.elista.grupa.dto.GrupaDTO;
import com.skpcp.elista.grupa.ob.GrupaOB;
import com.skpcp.elista.grupa.respository.IGrupaRespository;
import com.skpcp.elista.grupa.service.IGrupaService;
import com.skpcp.elista.utils.GrupaConverter;
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
public class GrupaServiceImpl implements IGrupaService {
    @Autowired
    IGrupaRespository iGrupaRespository;

    @Override
    public GrupaDTO znajdzGrupaPoNazwie(String aNazwa)
    {
        GrupaOB pGrupaOB = iGrupaRespository.znajdzPoNazwieGrupy(aNazwa);
        if (pGrupaOB == null)
            return null;
        return GrupaConverter.grupaOBdoGrupaDTO(pGrupaOB);
    }

//    @Override
//    public GrupaDTO znajdzGrupeUzytkownika(Long aIdUzytkownika)
//    {
//        GrupaOB pGrupaOB = iGrupyRespository.znajdzGrupeUzytkownika(aIdUzytkownika);
//        if(pGrupaOB == null) return null;
//        return GrupaConverter.grupaOBdoGrupaDTO(pGrupaOB);
//    }

    @Override
    public List<GrupaDTO> znajdzWszystkieGrupa()
    {
        List<GrupaDTO> listaWynikowaGrupaDTO = new ArrayList<>();
        List<GrupaOB> listaGrupaOB = iGrupaRespository.findAll();
        for (GrupaOB rola : listaGrupaOB) listaWynikowaGrupaDTO.add(GrupaConverter.grupaOBdoGrupaDTO(rola));
        return listaWynikowaGrupaDTO;
    }
//
//    @Override
//    public GrupaDTO zapiszRole(GrupaDTO aRolaDTO)
//    {
//        if (aRolaDTO == null) {
//            return null;
//        }
//        GrupaOB pGrupyOB = aRolaDTO.getId() == null ? null : iRolaRespository.findOne(aRolaDTO.getId());
//
//        if (pGrupyOB == null) {
//            return GrupaConverter.grupaOBdoGrupaDTO(iRolaRespository.save(GrupaConverter.grupaDTOdoGrupaOB(aRolaDTO)));
//        }
//        pGrupyOB.setNazwa(aRolaDTO.getNazwa());
//        return GrupaConverter.grupaOBdoGrupaDTO(iRolaRespository.save(pGrupyOB));
//    }

    @Override
    public void usunRole(Long aId) {
        iGrupaRespository.delete(aId);
    }
}