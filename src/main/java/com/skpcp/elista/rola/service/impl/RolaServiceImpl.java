package com.skpcp.elista.rola.service.impl;

import com.skpcp.elista.rola.dto.RolaDTO;
import com.skpcp.elista.rola.dto.RolaDTOBezUprawnien;
import com.skpcp.elista.rola.dto.RolaDTOZmiana;
import com.skpcp.elista.rola.ob.RolaOB;
import com.skpcp.elista.rola.respository.IRolaRepository;
import com.skpcp.elista.rola.service.IRolaService;
import com.skpcp.elista.utils.converters.RolaConverter;
import com.skpcp.elista.utils.exceptions.MyServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
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
    public RolaDTO znajdzRolePoNazwie(String aNazwa) throws MyServerException
    {
        RolaOB pRolaOB = iRolaRepository.znajdzPoNazwieRoli(aNazwa);
        if (pRolaOB == null)
            throw new MyServerException("Nie znaleziono takiej roli", HttpStatus.NOT_FOUND,new HttpHeaders());
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
    public RolaDTO edytujNazweRoli(RolaDTOZmiana aRolaDTO) throws MyServerException {
        RolaOB pRolaOB = aRolaDTO.getRola() == null ? null : iRolaRepository.znajdzPoNazwieRoli(aRolaDTO.getRola());
        if(pRolaOB == null) throw new MyServerException("Nie ma takiej roli",HttpStatus.NOT_FOUND,new HttpHeaders());
        RolaOB pRolaOBZmiana = aRolaDTO.getRolaDoZmiany() == null ? null : iRolaRepository.znajdzPoNazwieRoli(aRolaDTO.getRolaDoZmiany());
        if(pRolaOBZmiana != null) throw  new MyServerException("Nie istnieje juz rola o podanej nazwie",HttpStatus.METHOD_NOT_ALLOWED,new HttpHeaders());
        pRolaOB.setNazwa(aRolaDTO.getRolaDoZmiany());
        return  RolaConverter.rolaOBdoRolaDTO(iRolaRepository.save(pRolaOB));
    }

    @Override
    public void usunRole(Long aId) {
        iRolaRepository.delete(aId);
    }
}