package com.skpcp.elista.grupy.service.impl;

import com.skpcp.elista.grupy.dto.GrupaDTO;
import com.skpcp.elista.grupy.ob.GrupaOB;
import com.skpcp.elista.grupy.respository.IGrupyRespository;
import com.skpcp.elista.grupy.service.IGrupyService;
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
public class GrupyServiceImpl implements IGrupyService {
    @Autowired
    IGrupyRespository iGrupyRespository;

    @Override
    public GrupaDTO znajdzGrupePoNazwie(String aNazwa)
    {
        GrupaOB pGrupyOB = iGrupyRespository.znajdzPoNazwieGrupy(aNazwa);
        if (pGrupyOB == null)
            return null;
        return GrupaConverter.grupyOBdogrupyDTO(pGrupyOB);
    }

//    @Override
//    public GrupaDTO znajdzGrupeUzytkownika(Long aIdUzytkownika)
//    {
//        GrupaOB pGrupaOB = iGrupyRespository.znajdzGrupeUzytkownika(aIdUzytkownika);
//        if(pGrupaOB == null) return null;
//        return GrupaConverter.grupyOBdogrupyDTO(pGrupaOB);
//    }

    @Override
    public List<GrupaDTO> znajdzWszystkieGrupy()
    {
        List<GrupaDTO> listaWynikowaGrupyDTO = new ArrayList<>();
        List<GrupaOB> listaGrupyOB = iGrupyRespository.findAll();
        for (GrupaOB grupa : listaGrupyOB) listaWynikowaGrupyDTO.add(GrupaConverter.grupyOBdogrupyDTO(grupa));
        return listaWynikowaGrupyDTO;
    }
//
    @Override
    public GrupaDTO zapiszGrupe(GrupaDTO aGrupaDTO)
    {
        if (aGrupaDTO == null) {
            return null;
        }
        GrupaOB pGrupyOB = aGrupaDTO.getId() == null ? null : iGrupyRespository.findOne(aGrupaDTO.getId());

        if (pGrupyOB == null) {
            return GrupaConverter.grupyOBdogrupyDTO(iGrupyRespository.save(GrupaConverter.grupyDTOdogrupyOB(aGrupaDTO)));
        }
        pGrupyOB.setNazwa(aGrupaDTO.getNazwa());
        return GrupaConverter.grupyOBdogrupyDTO(iGrupyRespository.save(pGrupyOB));
    }

    @Override
    public void usunGrupe(Long aId) {
        iGrupyRespository.delete(aId);
    }
}