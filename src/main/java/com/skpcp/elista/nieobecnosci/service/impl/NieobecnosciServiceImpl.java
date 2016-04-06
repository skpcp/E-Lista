package com.skpcp.elista.nieobecnosci.service.impl;

import com.skpcp.elista.nieobecnosci.EJednostka;
import com.skpcp.elista.nieobecnosci.dto.NieobecnosciDTO;
import com.skpcp.elista.nieobecnosci.ob.NieobecnosciOB;
import com.skpcp.elista.nieobecnosci.repository.INieobecnosciRepository;
import com.skpcp.elista.nieobecnosci.service.INieobecnosciService;
import com.skpcp.elista.utils.NieobecnosciConverter;
import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created by IGOR on 2016-03-22.
 */
@Service
@Transactional
public class NieobecnosciServiceImpl implements INieobecnosciService {
    @Autowired
    INieobecnosciRepository iNieobecnosciRepository;

    @Override
    public NieobecnosciDTO znajdzNieobecnoscPoId(Long aID){
        NieobecnosciOB pNieobecnosciOB = iNieobecnosciRepository.findOne(aId);
        if(pNieobecnosciOB == null) return null;
        return NieobecnosciConverter.nieoOBdonieoDTO(pNieobecnosciOB);
    }
    @Override
    public List<NieobecnosciDTO> znajdzWszystkieNieobecnosci(){
        List<NieobecnosciDTO> listaWynikowaNieobecnosciDTO = new ArrayList<>();
        List<NieobecnosciOB> listaNieobecnosciOB = iNieobecnosciRepository.findAll();
        for(NieobecnosciOB nieobecnosci : listaNieobecnosciOB) listaWynikowaNieobecnosciDTO.add(NieobecnosciConverter.nieoOBdonieoDTO(nieobecnosci));

        return listaWynikowaNieobecnosciDTO;
    }
    @Override
    public List<NieobecnosciDTO> znajdzNieobecnoscPoIdUzytkownika(Long aID){
        List<NieobecnosciDTO> listaWynikowaNieobecnosciDTO = new ArrayList<>();
        List<NieobecnosciOB> listaNieobecnosciOB = iNieobecnosciRepository.findByIdUzytkownikaStartsWith(aID);

        return listaWynikowaNieobecnosciDTO;
    }
    @Override
    public List<NieobecnosciDTO> znajdzNieobecnoscPoDacie(Date aID){
        List<NieobecnosciDTO> listaWynikowaNieobecnosciDTO = new ArrayList<>();//utworzenie pojemnika
        List<NieobecnosciOB> listaNieobecnosciOB = iNieobecnosciRepository.findByDateStartsWith(aID);//zwróc mi wszystkie nieobecności
        //przepisanie moich nieobecnosci
        for(NieobecnosciOB nieobecnosc : listaNieobecnosciOB) listaWynikowaNieobecnosciDTO.add(NieobecnosciConverter.nieoOBdonieoDTO(nieobecnosc)); //zmień każdą instancję NieobecnosciOB do instancji DTO

        return listaWynikowaNieobecnosciDTO;//zwróć DTO

    }
    @Override
    public List<NieobecnosciDTO> znajdzNieobecnoscPoTypie(EJednostka aID){
        List<NieobecnosciDTO> listaWynikowaNieobecnosciDTO = new ArrayList<>();//utworzenie pojemnika
        List<NieobecnosciOB> listaNieobecnosciOB = iNieobecnosciRepository.findByTypStartsWith(aID);//zwróc mi wszystkie nieobecności
        //przepisanie moich nieobecnosci
        for(NieobecnosciOB nieobecnosc : listaNieobecnosciOB) listaWynikowaNieobecnosciDTO.add(NieobecnosciConverter.nieoOBdonieoDTO(nieobecnosc)); //zmień każdą instancję NieobecnosciOB do instancji DTO

        return listaWynikowaNieobecnosciDTO;//zwróć DTO

    }
    @Override
    public NieobecnosciDTO zapiszNieobecnosci(NieobecnosciDTO aNieobecnosci){
        if(aNieobecnosciDTO == null){
            return null;
        }
        //sprawdzam czy dany rekord z OB już istnieje
        NieobecnosciOB pNieobecnosciOB = aNieobecnosciDTO.getId() == null ? null : iNieobecnosciRepository.findOne(aNieobecnosciDTO.getId());

        if(pNieobecnosciOB == null){//gdy nie ma takiego to zapisz
            return NieobecnosciConverter.nieoOBdonieoDTO(iNieobecnosciRepository.save(NieobecnosciConverter.nieoDTOdoNieoOB(aNieobecnosciDTO)));
        }
        //tutaj odwołując się do obiektu pNieobecnosciOB mogę zrobić walidację danych po stronie serwera (na OB)
        //edytuj istniejącego
        pNieobecnosciOB.setIdUzytkownika(aNieobecnosciDTO.getIdUzytkownika());
        pNieobecnosciOB.setData(aNieobecnosciDTO.getData());
        pNieobecnosciOB.setIlosc(aNieobecnosciDTO.getIlosc());
        pNieobecnosciOB.setTyp(aNieobecnosciDTO.getTyp());
        return NieobecnosciConverter.nieoOBdonieoDTO(iNieobecnosciRepository.save(pNieobecnosciOB));

    }
    @Override
    public void usunNieobecnosci(Long aId) {
        iNieobecnosciRepository.delete(aId);
    }
    @Override
    public NieobecnosciDTO zmienTypNiebecnosciPoId(EJednostka aID){
        NieobecnosciOB pNieobecnosciOB = iNieobecnosciRepository.findOne(aId);
        if(pNieobecnosciOB == null){
            return null;
        }
        pNieobecnosciOB.setTyp(aTyp);
        NieobecnosciDTO pNieobecnosciDTO = NieobecnosciConverter.nieoOBdonieoDTO(pNieobecnosciOB);
        return pNieobecnosciDTO;

    }
    @Override
    public NieobecnosciDTO zmienIloscNieobecnosciPoId(Integer aID){
        NieobecnosciOB pNieobecnosciOB = iNieobecnosciRepository.findOne(aID);
        if(pNieobecnosciOB == null){
            return null;
        }
        pNieobecnosciOB.setIlosc(aID);
        NieobecnosciDTO pNieobecnosciDTO = NieobecnosciConverter.nieoOBdonieoDTO(pNieobecnosciOB);
        return pNieobecnosciDTO;

    }
    @Override
    public NieobecnosciDTO zmienDateNieobecnosciPoId(Date aID){
        NieobecnosciOB pNieobecnosciOB = iNieobecnosciRepository.findOne(aId);
        if(pNieobecnosciOB == null){
            return null;
        }
        pNieobecnosciOB.setData(aID);
        NieobecnosciDTO pNieobecnosciDTO = NieobecnosciConverter.nieoOBdonieoDTO(pNieobecnosciOB);
        return pNieobecnosciDTO;

    }



    

}
