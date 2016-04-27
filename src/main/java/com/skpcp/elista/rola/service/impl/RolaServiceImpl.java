package com.skpcp.elista.rola.service.impl;

import com.skpcp.elista.rola.dto.RolaDTO;
import com.skpcp.elista.rola.ob.RolaOB;
import com.skpcp.elista.rola.respository.IRolaRepository;
import com.skpcp.elista.rola.service.IRolaService;
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
public class RolaServiceImpl implements IRolaService {
    @Autowired
    IRolaRepository iRolaRepository;

    @Override
    public RolaDTO znajdzRolePoNazwie(String aNazwa)
    {
        RolaOB pRolaOB = iRolaRepository.znajdzPoNazwieGrupy(aNazwa);
        if (pRolaOB == null)
            return null;
        return RolaConverter.rolaOBdoRolaDTO(pRolaOB);
    }


    @Override
    public List<RolaDTO> znajdzWszystkieRole()
    {
        List<RolaDTO> wynik = new ArrayList<>();
        List<RolaOB> listaRolaOB = iRolaRepository.findAll();
        for (RolaOB rola : listaRolaOB) wynik.add(RolaConverter.rolaOBdoRolaDTO(rola));
        return wynik;
    }


    @Override
    public void usunRole(Long aId) {
        iRolaRepository.delete(aId);
    }
}