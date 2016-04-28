package com.skpcp.elista.czaspracy.service.impl;


import com.skpcp.elista.czaspracy.dto.CzasPracyDTO;
import com.skpcp.elista.czaspracy.ob.CzasPracyOB;
import com.skpcp.elista.czaspracy.repository.ICzasPracyRepository;
import com.skpcp.elista.czaspracy.service.ICzasPracyService;
import com.skpcp.elista.dziennikplanow.ob.DziennikPlanowOB;
import com.skpcp.elista.dziennikplanow.repository.IDziennikPlanowRepository;
import com.skpcp.elista.nieobecnosci.ob.NieobecnoscOB;
import com.skpcp.elista.nieobecnosci.repository.INieobecnoscRepository;
import com.skpcp.elista.utils.converters.CzasPracyConverter;
import com.skpcp.elista.utils.exceptions.MyServerException;
import com.skpcp.elista.utils.converters.UzytkownikConverter;
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
 * Created by Achilles on 2016-03-22.
 */
@Service
@Transactional(noRollbackFor = MyServerException.class)
public class CzasPracyServiceImpl implements ICzasPracyService {

    @Autowired
    ICzasPracyRepository iCzasPracyRepository;

    @Autowired
    INieobecnoscRepository iNieobecnoscRepository;

    @Autowired
    IUzytkownikRepository iUzytkownikRepository;

    @Autowired
    IDziennikPlanowRepository iDziennikPlanowRepository;

    @Override
    public List<CzasPracyDTO> wyswietlCzasyPracyPoUzytkowniku(Long aIdUzytkownika)  {
        List<CzasPracyDTO> pListCzasyPracyDTO = new ArrayList<>();
        List<CzasPracyOB> pListCzasyPracyOB = iCzasPracyRepository.znajdzCzasPracyPoUzytkowniku(aIdUzytkownika);
        for (CzasPracyOB czasPracy : pListCzasyPracyOB) {
            pListCzasyPracyDTO.add(CzasPracyConverter.czprOBdoCzprDTO(czasPracy));
        }
        return pListCzasyPracyDTO;
    }

    @Override
    public CzasPracyDTO zapiszCzasPracyWedlugPlanu(CzasPracyDTO aCzasPracyDTO) throws MyServerException {
        if (aCzasPracyDTO == null) throw new MyServerException("Puste pole czas pracy",HttpStatus.NOT_FOUND,new HttpHeaders());
        UzytkownikDTO pUzytkownikDTO = aCzasPracyDTO.getUzytkownik() == null ? null : aCzasPracyDTO.getUzytkownik();
        if (pUzytkownikDTO == null) throw new MyServerException("Puste pole uzytkownik",HttpStatus.NOT_FOUND,new HttpHeaders());
        //skoro nie jest nullem przystępujemy do pracy
        UzytkownikOB pUztkownikOB = pUzytkownikDTO.getId() == null ? null : iUzytkownikRepository.findOne(pUzytkownikDTO.getId());
        if (pUztkownikOB == null) {
            throw new MyServerException("Nie znaleziono uzytkownika",HttpStatus.NOT_FOUND,new HttpHeaders());
        }



        //tutaj sprawdzam czy jest nieobecnosc dla danego uzytkownika w konkretnym dniu !
        NieobecnoscOB pNieobecnoscOB = iNieobecnoscRepository.znajdzNieobecnoscPoDacieIUzytkowniku(aCzasPracyDTO.getDzien(),pUzytkownikDTO.getId());
        if(pNieobecnoscOB != null){
           throw new MyServerException("Nie mozna zapisac czasu, pracy jezeli jest zapisana nieboecnosc",HttpStatus.METHOD_NOT_ALLOWED,new HttpHeaders()); //nie ma oszukiwania !
        }
        Boolean flaga = false;
        CzasPracyOB pCzasPracyOBDzien = aCzasPracyDTO.getDzien() == null ? null : iCzasPracyRepository.znajdzCzasPracyPoDacie(pUzytkownikDTO.getId(),aCzasPracyDTO.getDzien());
        if(pCzasPracyOBDzien != null ){
            flaga = true;
        }
        Date dDzisiajJest = aCzasPracyDTO.getDzien(); //wiem jaki dzisiaj dzień!
        String napis = String.format("%1$tA", dDzisiajJest);//dzien tygodnia
        DziennikPlanowOB pDziennikPlanowOB = iDziennikPlanowRepository.znajdzPoDniuTygodnia(
                napis
                , pUztkownikOB);
        if (pDziennikPlanowOB == null) {
           throw new MyServerException("Nie istnieje dziennik planow",HttpStatus.NOT_FOUND,new HttpHeaders()); //coś poszło nie tak!!! //a konkretnie nie ten dzień!!! nie można pracować w weekend no chyba, że się chce !
        }
        //pobieram moje czasy pracy
        Date dRozpoczecie = pDziennikPlanowOB.getPlanOd() == null ? null : pDziennikPlanowOB.getPlanOd();
        Date dZakonczenie = pDziennikPlanowOB.getPlanOd() == null ? null : pDziennikPlanowOB.getPlanDo();

        //teraz już wiem jakiego szukam użytkownika oraz do jakiego dziennika planów mam zaglądać poraz zobaczyć czy jest taki czas pracy
        CzasPracyOB pCzasPracyOB = aCzasPracyDTO.getId() == null ? null : iCzasPracyRepository.findOne(aCzasPracyDTO.getId());
        if (pCzasPracyOB == null) {
            //nie istnieje to zapisuje
            //aCzasPracyDTO.setDzien(dDzisiajJest);
            if(flaga) throw new MyServerException("Istnieje juz zapisany ten dzien pracy dla danego uzytkownika",HttpStatus.METHOD_NOT_ALLOWED, new HttpHeaders());
            aCzasPracyDTO.setUzytkownik(UzytkownikConverter.uzytOBdoUzytkDTO(pUztkownikOB));
            aCzasPracyDTO.setRozpoczecie(dRozpoczecie);
            aCzasPracyDTO.setZakonczenie(dZakonczenie);
            return CzasPracyConverter.czprOBdoCzprDTO(iCzasPracyRepository.save(CzasPracyConverter.czprDTOdoCzprOB(aCzasPracyDTO)));
        }
        //edytuje istniejący
        pCzasPracyOB.setUzytkownik(pUztkownikOB);
        pCzasPracyOB.setDzien(aCzasPracyDTO.getDzien());
        pCzasPracyOB.setRozpoczecie(dRozpoczecie);
        pCzasPracyOB.setZakonczenie(dZakonczenie);
        pCzasPracyOB.setZakresPracy(aCzasPracyDTO.getZakresPracy());
        return CzasPracyConverter.czprOBdoCzprDTO(iCzasPracyRepository.save(pCzasPracyOB));
    }

    @Override
    public CzasPracyDTO zapiszCzasPracy(CzasPracyDTO aCzasPracyDTO) throws MyServerException {
        if (aCzasPracyDTO == null) throw new MyServerException("Puste pole czas pracy",HttpStatus.NOT_FOUND,new HttpHeaders());
        if (aCzasPracyDTO.getUzytkownik() == null) throw new MyServerException("Puste pole uzytkownik",HttpStatus.NOT_FOUND,new HttpHeaders());
        UzytkownikDTO pUzytkownikDTO = aCzasPracyDTO.getUzytkownik();
        UzytkownikOB pUzytkownikOB = pUzytkownikDTO.getId() == null ? null : iUzytkownikRepository.znajdzPoIdIEmailu(pUzytkownikDTO.getId(),pUzytkownikDTO.getEmail());
        if (pUzytkownikOB == null) {
            throw new MyServerException("Nie znaleziono uzytkownika",HttpStatus.NOT_FOUND,new HttpHeaders());
        }

        //w tym momencie użytkownik na pewno istnieje
        //sprawdzam swój czas pracy
        NieobecnoscOB pNieobecnoscOB = iNieobecnoscRepository.znajdzNieobecnoscPoDacieIUzytkowniku(aCzasPracyDTO.getDzien(),pUzytkownikDTO.getId());
        if(pNieobecnoscOB != null){
            throw new MyServerException("Nie mozna zapisac czasu, pracy jezeli jest zapisana nieboecnosc",HttpStatus.METHOD_NOT_ALLOWED,new HttpHeaders()); //nie ma oszukiwania !
        }
        //sprawdzam czy taki czas pracy już nie istnieje
        Boolean flaga = false;
        CzasPracyOB pCzasPracyOBDzien = aCzasPracyDTO.getDzien() == null ? null : iCzasPracyRepository.znajdzCzasPracyPoDacie(pUzytkownikDTO.getId(),aCzasPracyDTO.getDzien());
        if(pCzasPracyOBDzien != null ){
            flaga = true;
        }
        CzasPracyOB pCzasPracyOB = aCzasPracyDTO.getId() == null ? null : iCzasPracyRepository.findOne(aCzasPracyDTO.getId());
        if (pCzasPracyOB == null) {
            if(flaga)  throw new MyServerException("Istnieje juz zapisany ten dzien pracy dla danego uzytkownika",HttpStatus.METHOD_NOT_ALLOWED, new HttpHeaders()); //czas pracy zapisujemy tylko raz, jednego konkretnego dnia dla jednego konkretnego uzytkownika
            //jeżeli takiego nie ma to zapisujemy
            aCzasPracyDTO.setUzytkownik(UzytkownikConverter.uzytOBdoUzytkDTO(pUzytkownikOB));
            return CzasPracyConverter.czprOBdoCzprDTO(iCzasPracyRepository.save(CzasPracyConverter.czprDTOdoCzprOB(aCzasPracyDTO)));
        }
        pCzasPracyOB.setUzytkownik(pUzytkownikOB);
        pCzasPracyOB.setDzien(aCzasPracyDTO.getDzien());
        pCzasPracyOB.setRozpoczecie(aCzasPracyDTO.getRozpoczecie());
        pCzasPracyOB.setZakonczenie(aCzasPracyDTO.getZakonczenie());

        //teraz edytuje istniejący

        pCzasPracyOB.setZakresPracy(aCzasPracyDTO.getZakresPracy());
        return CzasPracyConverter.czprOBdoCzprDTO(iCzasPracyRepository.save(pCzasPracyOB));
    }

    @Override
    public void usunCzasPracy(Long aId) {
        iCzasPracyRepository.delete(aId);
    }

    @Override
    public CzasPracyDTO znajdzCzasPracyPoId(Long aId) throws MyServerException {
        CzasPracyOB pCzasPracyOB = iCzasPracyRepository.findOne(aId);
        if (pCzasPracyOB == null) {
            throw new MyServerException("Nie znaleziono uzytkownika",HttpStatus.NOT_FOUND,new HttpHeaders());
        }
        return CzasPracyConverter.czprOBdoCzprDTO(pCzasPracyOB);
    }
}
