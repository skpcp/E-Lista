package com.skpcp.elista.grupy.service.impl;

import com.skpcp.elista.grupy.dto.GrupyDTO;
import com.skpcp.elista.grupy.ob.GrupyOB;
import com.skpcp.elista.grupy.respository.IGrupyRespository;
import com.skpcp.elista.utils.GrupyConverter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by padyyajs on 22.03.2016.
 */
public class GrupyServiceImpl {
    @Override
    public GrupyDTO znajdzGrupePoNazwie(String anazwaGrupy)
    {
        GrupyOB pGrupyOB = iGrupyRespository.findOne(anazwaGrupy);
        if (pGrupyOB == null)
            return null;
        return GrupyConverter.grupyOBdogrupyDTO(pGrupyOB);
    }

    @Override
    public GrupyDTO znajdzUzytkownikaPoGrupie(long aId, String anazwaGrupy)
    {
        List<GrupyDTO> listaWynikowaGrupyDTO = new ArrayList<>();
        List<GrupyOB> listaGrupyOB = iGrupyRespository.findUserBynazwagrupy(aId, anazwaGrupy);
        for (GrupyOB grupa : listaGrupyOB) listaWynikowaGrupyDTO.add(GrupyConverter.grupyOBdogrupyDTO(grupa));
        return listaWynikowaGrupyDTO;
    }

    @Override
    public GrupyDTO znajdzWszystkieGrupy(String anazwaGrupy)
    {
        List<GrupyDTO> listaWynikowaGrupyDTO = new ArrayList<>();
        List<GrupyDTO> listaGrupyOB = iGrupyRespository.finAll();
        for (GrupyOB grupa : listaGrupyOB) listaWynikowaGrupyDTO.add(GrupyConverter.grupyOBdogrupyDTO(grupa));
        return listaWynikowaGrupyDTO;
    }

    @Override
    public GrupyDTO zapiszGrupe(GrupyDTO anazwaGrupyDTO)
    {
        if (anazwaGrupyDTO == null) {
            return null;
        }
        GrupyOB pGrupyOB = anazwaGrupyDTO.getnazwaGrupy() == null ? null : iGrupyRespository.findOne(anazwaGrupyDTO.getNazwaGrupy()));

        if (pGrupyOB == null) {
            return GrupyConverter.grupyOBdogrupyDTO(iGrupyRespository.save(GrupyConverter.grupyDTOdogrupyOB(anazwaGrupyDTO)));
        }
        pGrupyOB.setNazwaGrupy(anazwaGrupyDTO.getNazwaGrupy());
        return GrupyConverter.grupyOBdogrupyDTO(IGrupyRespository.save(pGrupyOB));
    }

    @Override
    public void usunGrupe(String anazwaGrupy) {
        iGrupyRespository.delete(anazwaGrupy);
    }
}