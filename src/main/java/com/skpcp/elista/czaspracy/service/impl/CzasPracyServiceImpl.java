package com.skpcp.elista.czaspracy.service.impl;


import com.skpcp.elista.czaspracy.dto.CzasPracyDTO;
import com.skpcp.elista.czaspracy.ob.CzasPracyOB;
import com.skpcp.elista.czaspracy.repository.ICzasPracyRepository;
import com.skpcp.elista.czaspracy.service.ICzasPracyService;
import com.skpcp.elista.dziennikplanow.api.DziennikPlanowController;
import com.skpcp.elista.dziennikplanow.ob.DziennikPlanowOB;
import com.skpcp.elista.dziennikplanow.repository.IDziennikPlanowRepository;
import com.skpcp.elista.nieobecnosci.ob.NieobecnoscOB;
import com.skpcp.elista.nieobecnosci.repository.INieobecnoscRepository;
import com.skpcp.elista.utils.CzasPracyConverter;
import com.skpcp.elista.utils.DziennikPlanowConverter;
import com.skpcp.elista.utils.UzytkownikConverter;
import com.skpcp.elista.uzytkownik.dto.UzytkownikDTO;
import com.skpcp.elista.uzytkownik.ob.UzytkownikOB;
import com.skpcp.elista.uzytkownik.repository.IUzytkownikRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMessage;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.HttpStatusCodeException;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.InternalServerErrorException;
import javax.xml.ws.http.HTTPException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Achilles on 2016-03-22.
 */
@Service
@Transactional(noRollbackFor = HttpServerErrorException.class)
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
    public List<CzasPracyDTO> wyswietlCzasyPracyPoUzytkowniku(Long aIdUzytkownika) {
        List<CzasPracyDTO> pListCzasyPracyDTO = new ArrayList<>();
        List<CzasPracyOB> pListCzasyPracyOB = iCzasPracyRepository.znajdzCzasPracyPoUzytkowniku(aIdUzytkownika);
        for (CzasPracyOB czasPracy : pListCzasyPracyOB) {
            pListCzasyPracyDTO.add(CzasPracyConverter.czprOBdoCzprDTO(czasPracy));
        }
        return pListCzasyPracyDTO;
    }

    @Override
    public CzasPracyDTO zapiszCzasPracyWedlugPlanu(CzasPracyDTO aCzasPracyDTO) throws HttpServerErrorException {
        if (aCzasPracyDTO == null) return  null;
        UzytkownikDTO pUzytkownikDTO = aCzasPracyDTO.getUzytkownik() == null ? null : aCzasPracyDTO.getUzytkownik();
        if (pUzytkownikDTO == null) return null;// coś poszło nie tak
        //skoro nie jest nullem przystępujemy do pracy
        UzytkownikOB pUztkownikOB = pUzytkownikDTO.getId() == null ? null : iUzytkownikRepository.findOne(pUzytkownikDTO.getId());
        if (pUztkownikOB == null) {
            throw new HttpServerErrorException(HttpStatus.NO_CONTENT,"Nie znaleziono uzytkownika");
        }


        //tutaj sprawdzam czy jest nieobecnosc dla danego uzytkownika w konkretnym dniu !
        NieobecnoscOB pNieobecnoscOB = iNieobecnoscRepository.znajdzNieobecnoscPoDacieIUzytkowniku(aCzasPracyDTO.getDzien(),pUzytkownikDTO.getId());
        if(pNieobecnoscOB != null){
            return  null; //nie ma oszukiwania !
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
            return null; //coś poszło nie tak!!! //a konkretnie nie ten dzień!!! nie można pracować w weekend no chyba, że się chce !
        }
        //pobieram moje czasy pracy
        Date dRozpoczecie = pDziennikPlanowOB.getPlanOd() == null ? null : pDziennikPlanowOB.getPlanOd();
        Date dZakonczenie = pDziennikPlanowOB.getPlanOd() == null ? null : pDziennikPlanowOB.getPlanDo();

        //teraz już wiem jakiego szukam użytkownika oraz do jakiego dziennika planów mam zaglądać poraz zobaczyć czy jest taki czas pracy
        CzasPracyOB pCzasPracyOB = aCzasPracyDTO.getId() == null ? null : iCzasPracyRepository.findOne(aCzasPracyDTO.getId());
        if (pCzasPracyOB == null) {
            //nie istnieje to zapisuje
            //aCzasPracyDTO.setDzien(dDzisiajJest);
            if(flaga) return null;
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
    public CzasPracyDTO zapiszCzasPracy(CzasPracyDTO aCzasPracyDTO) {
        if (aCzasPracyDTO == null) return null;
        if (aCzasPracyDTO.getUzytkownik() == null) return null;
        UzytkownikDTO pUzytkownikDTO = aCzasPracyDTO.getUzytkownik();
        UzytkownikOB pUzytkownikOB = pUzytkownikDTO.getId() == null ? null : iUzytkownikRepository.znajdzPoIdIEmailu(pUzytkownikDTO.getId(),pUzytkownikDTO.getEmail());
        if (pUzytkownikOB == null) {
            return null;
        }

        //w tym momencie użytkownik na pewno istnieje
        //sprawdzam swój czas pracy
        NieobecnoscOB pNieobecnoscOB = iNieobecnoscRepository.znajdzNieobecnoscPoDacieIUzytkowniku(aCzasPracyDTO.getDzien(),pUzytkownikDTO.getId());
        if(pNieobecnoscOB != null){
            return  null; //nie ma oszukiwania !
        }
        //sprawdzam czy taki czas pracy już nie istnieje
        Boolean flaga = false;
        CzasPracyOB pCzasPracyOBDzien = aCzasPracyDTO.getDzien() == null ? null : iCzasPracyRepository.znajdzCzasPracyPoDacie(pUzytkownikDTO.getId(),aCzasPracyDTO.getDzien());
        if(pCzasPracyOBDzien != null ){
            flaga = true;
        }
        CzasPracyOB pCzasPracyOB = aCzasPracyDTO.getId() == null ? null : iCzasPracyRepository.findOne(aCzasPracyDTO.getId());
        if (pCzasPracyOB == null) {
            if(flaga) return  null; //czas pracy zapisujemy tylko raz, jednego konkretnego dnia dla jednego konkretnego uzytkownika
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
    public CzasPracyDTO znajdzCzasPracyPoId(Long aId) {
        CzasPracyOB pCzasPracyOB = iCzasPracyRepository.findOne(aId);
        if (pCzasPracyOB == null) {
            return null;
        }
        return CzasPracyConverter.czprOBdoCzprDTO(pCzasPracyOB);
    }
}
