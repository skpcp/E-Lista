package com.skpcp.elista.nieobecnosci.service.impl;


import com.skpcp.elista.czaspracy.ob.CzasPracyOB;
import com.skpcp.elista.czaspracy.repository.ICzasPracyRepository;
import com.skpcp.elista.nieobecnosci.dto.NieobecnoscDTOBezTechDate;
import com.skpcp.elista.nieobecnosci.dto.NieobecnoscDTOBezUzytkownika;
import com.skpcp.elista.nieobecnosci.dto.NieobecnoscDTOUzytkownik;
import com.skpcp.elista.nieobecnosci.ob.NieobecnoscOB;
import com.skpcp.elista.nieobecnosci.repository.INieobecnoscRepository;
import com.skpcp.elista.nieobecnosci.service.INieobecnoscService;

import com.skpcp.elista.utils.converters.NieobecnoscConverter;
import com.skpcp.elista.utils.exceptions.MyServerException;
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
    public NieobecnoscDTOUzytkownik znajdzNieobecnoscPoId(Long aId) throws MyServerException{
        NieobecnoscOB pNieobecnosciOB = iNieobecnosciRepository.findOne(aId);
        if(pNieobecnosciOB == null) throw new MyServerException("Nie ma takiej nieobecnosci", HttpStatus.NOT_FOUND,new HttpHeaders());
        return NieobecnoscConverter.nieobecnoscOBDoNieobecnoscDTOUzytkownik(pNieobecnosciOB);
    }

    @Override
    public List<NieobecnoscDTOUzytkownik> znajdzWszystkieNieobecnosci(){
        List<NieobecnoscDTOUzytkownik> listaWynikowaNieobecnosciDTO = new ArrayList<>();
        List<NieobecnoscOB> listaNieobecnosciOB = iNieobecnosciRepository.findAll();
        for(NieobecnoscOB nieobecnosci : listaNieobecnosciOB) listaWynikowaNieobecnosciDTO.add(NieobecnoscConverter.nieobecnoscOBDoNieobecnoscDTOUzytkownik(nieobecnosci));

        return listaWynikowaNieobecnosciDTO;
    }
    @Override
    public List<NieobecnoscDTOUzytkownik> znajdzNieobecnoscPoIdUzytkownika(Long aIdUzytkownika){
        List<NieobecnoscDTOUzytkownik> listaWynikowaNieobecnosciDTO = new ArrayList<>();
        List<NieobecnoscOB> listaNieobecnosciOB = iNieobecnosciRepository.znajdzNieobecnosciPoUzytkowniku(aIdUzytkownika);
        for(NieobecnoscOB nieobecnoscOB : listaNieobecnosciOB)
        listaWynikowaNieobecnosciDTO.add(NieobecnoscConverter.nieobecnoscOBDoNieobecnoscDTOUzytkownik(nieobecnoscOB));
        return listaWynikowaNieobecnosciDTO;
    }

    @Override
    public NieobecnoscDTOBezUzytkownika znajdzNieobecnoscPoDacieIUzytkowniku(Date aData, Long aIdUzytkownika) throws MyServerException{
        NieobecnoscOB pNieobecnoscOB = iNieobecnosciRepository.znajdzNieobecnoscPoDacieIUzytkowniku(aData,aIdUzytkownika);//zwróc mi wszystkie nieobecności
        if(pNieobecnoscOB == null)  throw new MyServerException("Nie ma takiej nieobecnosci", HttpStatus.NOT_FOUND,new HttpHeaders());
        return NieobecnoscConverter.nieobecnoscOBDoNieobecnoscDTOBezUzytkownika(pNieobecnoscOB);

    }
    @Override
    public List<NieobecnoscDTOUzytkownik> znajdzNieobecnosciPoTypie(String aTyp){
        List<NieobecnoscDTOUzytkownik> listaWynikowaNieobecnosciDTO = new ArrayList<>();//utworzenie pojemnika
        List<NieobecnoscOB> listaNieobecnosciOB = iNieobecnosciRepository.znajdzNieboecnosciPoTypie(aTyp);//zwróc mi wszystkie nieobecności
        //przepisanie moich nieobecnosci
        for(NieobecnoscOB nieobecnosc : listaNieobecnosciOB) listaWynikowaNieobecnosciDTO.add(NieobecnoscConverter.nieobecnoscOBDoNieobecnoscDTOUzytkownik(nieobecnosc)); //zmień każdą instancję NieobecnosciOB do instancji DTO
        return listaWynikowaNieobecnosciDTO;//zwróć DTO

    }

    @Override
    public List<NieobecnoscDTOBezUzytkownika> znajdzNieobecnosciPoTypieIUzytkowniku(String aTyp, Long aIdUzytkownika) {
        List<NieobecnoscDTOBezUzytkownika> listaWynikowaNieobecnosciDTO = new ArrayList<>();//utworzenie pojemnika
        List<NieobecnoscOB> listaNieobecnosciOB = iNieobecnosciRepository.znajdzPoTypieNieobecnosciIUzytkowniku(aTyp,aIdUzytkownika);//zwróc mi wszystkie nieobecności
        //przepisanie moich nieobecnosci
        for(NieobecnoscOB nieobecnosc : listaNieobecnosciOB) listaWynikowaNieobecnosciDTO.add(NieobecnoscConverter.nieobecnoscOBDoNieobecnoscDTOBezUzytkownika(nieobecnosc));
        return listaWynikowaNieobecnosciDTO;//zwróć DTO
    }
    @Override
    public NieobecnoscDTOUzytkownik zapiszNieobecnosc(NieobecnoscDTOBezTechDate aNieobecnosciDTO) throws MyServerException{
        if(aNieobecnosciDTO == null){
            throw new MyServerException("Brak pola nieobecnosc",HttpStatus.NOT_FOUND,new HttpHeaders());
        }


        UzytkownikOB pUztkownikOB = aNieobecnosciDTO.getUzytkownikId() == null ? null : iUzytkownikRepository.findOne(aNieobecnosciDTO.getUzytkownikId());
        if(pUztkownikOB == null){
            throw new MyServerException("Nie ma takiego użytkownika", HttpStatus.NOT_FOUND,new HttpHeaders()); //coś poszło nie tak
        }

        CzasPracyOB pCzasPracyOB = iCzasPracyRepository.znajdzCzasPracyPoDacieOrazUzytkowniku(pUztkownikOB.getId(),aNieobecnosciDTO.getData());
        if(pCzasPracyOB != null){
            throw new MyServerException("Nie mozna zapisac nieobecnosci, gdyz istnieje juz zapisany na ten dzien czas pracy",HttpStatus.METHOD_NOT_ALLOWED,new HttpHeaders());
        }
        //sprawdzam czy dany rekord z OB już istnieje

        Boolean flaga=false;
        NieobecnoscOB pNieobecnosciOBDzien = aNieobecnosciDTO.getData() == null ? null : iNieobecnosciRepository.znajdzNieobecnoscPoDacieIUzytkowniku(aNieobecnosciDTO.getData(),pUztkownikOB.getId());
        if(pNieobecnosciOBDzien != null){
            flaga = true; //nie można dodać więcej niż jedną nieobecność
        }
        NieobecnoscOB pNieobecnosciOB = aNieobecnosciDTO.getId() == null ? null : iNieobecnosciRepository.findOne(aNieobecnosciDTO.getId());

        if(pNieobecnosciOB == null){//gdy nie ma takiego to zapisz
            if(flaga) throw new MyServerException("Nie mozna zapisac nieobecnosci, gdyz istnieje juz zapisana nieobecnosc na ten dzien, dla danego uzytkownika",HttpStatus.METHOD_NOT_ALLOWED,new HttpHeaders()); //nieuprawnione dodanie tego samego dnia kolejnej nieobecnosci do tego samego uzytkownika , ej!
            pNieobecnosciOB = new NieobecnoscOB(pUztkownikOB,aNieobecnosciDTO.getData(),aNieobecnosciDTO.getIlosc(),aNieobecnosciDTO.getTyp());
            return NieobecnoscConverter.nieobecnoscOBDoNieobecnoscDTOUzytkownik(iNieobecnosciRepository.save(pNieobecnosciOB));
        }

        //edytuj istniejącego
        pNieobecnosciOB.setUzytkownik(pUztkownikOB);
        pNieobecnosciOB.setData(aNieobecnosciDTO.getData());
        pNieobecnosciOB.setIloscGodzin(aNieobecnosciDTO.getIlosc());
        pNieobecnosciOB.setTyp(aNieobecnosciDTO.getTyp());
        return NieobecnoscConverter.nieobecnoscOBDoNieobecnoscDTOUzytkownik(iNieobecnosciRepository.save(pNieobecnosciOB));

    }
    @Override
    public void usunNieobecnosci(Long aId) throws MyServerException {

        NieobecnoscOB pNieobecnosciOB = iNieobecnosciRepository.findOne(aId);
        if(pNieobecnosciOB == null) throw new MyServerException("Nieobecnosc nie istnieje",HttpStatus.NOT_FOUND,new HttpHeaders());
        iNieobecnosciRepository.delete(aId);
    }



    

}
