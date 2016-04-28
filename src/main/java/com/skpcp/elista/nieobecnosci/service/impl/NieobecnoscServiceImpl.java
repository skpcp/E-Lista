package com.skpcp.elista.nieobecnosci.service.impl;


import com.skpcp.elista.czaspracy.ob.CzasPracyOB;
import com.skpcp.elista.czaspracy.repository.ICzasPracyRepository;
import com.skpcp.elista.nieobecnosci.dto.NieobecnoscDTO;
import com.skpcp.elista.nieobecnosci.ob.NieobecnoscOB;
import com.skpcp.elista.nieobecnosci.repository.INieobecnoscRepository;
import com.skpcp.elista.nieobecnosci.service.INieobecnoscService;

import com.skpcp.elista.utils.converters.NieobecnoscConverter;
import com.skpcp.elista.utils.converters.UzytkownikConverter;
import com.skpcp.elista.utils.exceptions.MyServerException;
import com.skpcp.elista.uzytkownik.dto.UzytkownikDTO;
import com.skpcp.elista.uzytkownik.ob.UzytkownikOB;
import com.skpcp.elista.uzytkownik.repository.IUzytkownikRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by IGOR on 2016-03-22.
 */
@Service
@Transactional
public class NieobecnoscServiceImpl implements INieobecnoscService {
    @Autowired
    INieobecnoscRepository iNieobecnosciRepository;

    @Autowired
    IUzytkownikRepository iUzytkownikRepository;

    @Autowired
    ICzasPracyRepository iCzasPracyRepository;

    @Override
    public NieobecnoscDTO znajdzNieobecnoscPoId(Long aId) throws MyServerException{
        NieobecnoscOB pNieobecnosciOB = iNieobecnosciRepository.findOne(aId);
        if(pNieobecnosciOB == null) throw new MyServerException("Nie ma takiej nieobecnosci", HttpStatus.NOT_FOUND,new HttpHeaders());
        return NieobecnoscConverter.nieoOBdonieoDTO(pNieobecnosciOB);
    }

    @Override
    public List<NieobecnoscDTO> znajdzWszystkieNieobecnosci(){
        List<NieobecnoscDTO> listaWynikowaNieobecnosciDTO = new ArrayList<>();
        List<NieobecnoscOB> listaNieobecnosciOB = iNieobecnosciRepository.findAll();
        for(NieobecnoscOB nieobecnosci : listaNieobecnosciOB) listaWynikowaNieobecnosciDTO.add(NieobecnoscConverter.nieoOBdonieoDTO(nieobecnosci));

        return listaWynikowaNieobecnosciDTO;
    }
    @Override
    public List<NieobecnoscDTO> znajdzNieobecnoscPoIdUzytkownika(Long aIdUzytkownika){
        List<NieobecnoscDTO> listaWynikowaNieobecnosciDTO = new ArrayList<>();
        List<NieobecnoscOB> listaNieobecnosciOB = iNieobecnosciRepository.znajdzNieobecnosciPoUzytkowniku(aIdUzytkownika);
        for(NieobecnoscOB nieobecnoscOB : listaNieobecnosciOB)
        listaWynikowaNieobecnosciDTO.add(NieobecnoscConverter.nieoOBdonieoDTO(nieobecnoscOB));
        return listaWynikowaNieobecnosciDTO;
    }
    @Override
    public NieobecnoscDTO znajdzNieobecnoscPoDacieIUzytkowniku(Date aData, Long aIdUzytkownika) throws MyServerException{
        NieobecnoscOB pNieobecnoscOB = iNieobecnosciRepository.znajdzNieobecnoscPoDacieIUzytkowniku(aData,aIdUzytkownika);//zwróc mi wszystkie nieobecności
        if(pNieobecnoscOB == null)  throw new MyServerException("Nie ma takiej nieobecnosci", HttpStatus.NOT_FOUND,new HttpHeaders());
        return NieobecnoscConverter.nieoOBdonieoDTO(pNieobecnoscOB);

    }
    @Override
    public List<NieobecnoscDTO> znajdzNieobecnosciPoTypie(String aTyp){
        List<NieobecnoscDTO> listaWynikowaNieobecnosciDTO = new ArrayList<>();//utworzenie pojemnika
        List<NieobecnoscOB> listaNieobecnosciOB = iNieobecnosciRepository.znajdzNieboecnosciPoTypie(aTyp);//zwróc mi wszystkie nieobecności
        //przepisanie moich nieobecnosci
        for(NieobecnoscOB nieobecnosc : listaNieobecnosciOB) listaWynikowaNieobecnosciDTO.add(NieobecnoscConverter.nieoOBdonieoDTO(nieobecnosc)); //zmień każdą instancję NieobecnosciOB do instancji DTO

        return listaWynikowaNieobecnosciDTO;//zwróć DTO

    }

    @Override
    public List<NieobecnoscDTO> znajdzNieobecnosciPoTypieIUzytkowniku(String aTyp, Long aIdUzytkownika) {
        List<NieobecnoscDTO> listaWynikowaNieobecnosciDTO = new ArrayList<>();//utworzenie pojemnika
        List<NieobecnoscOB> listaNieobecnosciOB = iNieobecnosciRepository.znajdzPoTypieNieobecnosciIUzytkowniku(aTyp,aIdUzytkownika);//zwróc mi wszystkie nieobecności
        //przepisanie moich nieobecnosci
        for(NieobecnoscOB nieobecnosc : listaNieobecnosciOB) listaWynikowaNieobecnosciDTO.add(NieobecnoscConverter.nieoOBdonieoDTO(nieobecnosc)); //zmień każdą instancję NieobecnosciOB do instancji DTO

        return listaWynikowaNieobecnosciDTO;//zwróć DTO
    }
    @Override
    public NieobecnoscDTO zapiszNieobecnosc(NieobecnoscDTO aNieobecnosciDTO) throws MyServerException{
        if(aNieobecnosciDTO == null){
            throw new MyServerException("Brak pola nieobecnosc",HttpStatus.NOT_FOUND,new HttpHeaders());
        }

        UzytkownikDTO pUzytkownikDTO = aNieobecnosciDTO.getUzytkownik() == null ? null : aNieobecnosciDTO.getUzytkownik();
        if(pUzytkownikDTO == null) throw new MyServerException("Nie ma takiego użytkownika", HttpStatus.NOT_FOUND,new HttpHeaders());// coś poszło nie tak
        //skoro nie jest nullem przystępujemy do pracy
        UzytkownikOB pUztkownikOB = pUzytkownikDTO.getId() == null ? null : iUzytkownikRepository.findOne(pUzytkownikDTO.getId());
        if(pUztkownikOB == null){
            throw new MyServerException("Nie ma takiej nieobecnosci", HttpStatus.NOT_FOUND,new HttpHeaders()); //coś poszło nie tak
        }

        CzasPracyOB pCzasPracyOB = iCzasPracyRepository.znajdzCzasPracyPoDacieOrazUzytkowniku(pUzytkownikDTO.getId(),aNieobecnosciDTO.getData());
        if(pCzasPracyOB != null){
            throw new MyServerException("Nie mozna zapisac nieobecnosci, gdyz istnieje juz zapisany na ten dzien czas pracy",HttpStatus.METHOD_NOT_ALLOWED,new HttpHeaders());
        }
        //sprawdzam czy dany rekord z OB już istnieje

        Boolean flaga=false;
        NieobecnoscOB pNieobecnosciOBDzien = aNieobecnosciDTO.getData() == null ? null : iNieobecnosciRepository.znajdzNieobecnoscPoDacieIUzytkowniku(aNieobecnosciDTO.getData(),pUzytkownikDTO.getId());
        if(pNieobecnosciOBDzien != null){
            flaga = true; //nie można dodać więcej niż jedną nieobecność
        }
        NieobecnoscOB pNieobecnosciOB = aNieobecnosciDTO.getId() == null ? null : iNieobecnosciRepository.findOne(aNieobecnosciDTO.getId());

        if(pNieobecnosciOB == null){//gdy nie ma takiego to zapisz
            if(flaga) throw new MyServerException("Nie mozna zapisac nieobecnosci, gdyz istnieje juz zapisana nieobecnosc na ten dzien, dla danego uzytkownika",HttpStatus.METHOD_NOT_ALLOWED,new HttpHeaders()); //nieuprawnione dodanie tego samego dnia kolejnej nieobecnosci do tego samego uzytkownika , ej!
            aNieobecnosciDTO.setUzytkownik(UzytkownikConverter.uzytOBdoUzytkDTO(pUztkownikOB));
            return NieobecnoscConverter.nieoOBdonieoDTO(iNieobecnosciRepository.save(NieobecnoscConverter.nieoDTOdoNieoOB(aNieobecnosciDTO)));
        }

        //edytuj istniejącego
        pNieobecnosciOB.setUzytkownik(UzytkownikConverter.uzytDTOdoUzytkOB(aNieobecnosciDTO.getUzytkownik()));
        pNieobecnosciOB.setData(aNieobecnosciDTO.getData());
        pNieobecnosciOB.setIloscGodzin(aNieobecnosciDTO.getIlosc());
        pNieobecnosciOB.setTyp(aNieobecnosciDTO.getTyp());
        return NieobecnoscConverter.nieoOBdonieoDTO(iNieobecnosciRepository.save(pNieobecnosciOB));

    }
    @Override
    public void usunNieobecnosci(Long aId) {
        iNieobecnosciRepository.delete(aId);
    }



    

}
