package com.skpcp.elista.grupa.service.impl;

import com.skpcp.elista.grupa.dto.GrupaDTO;
import com.skpcp.elista.grupa.dto.GrupaUzytkownikDTO;
import com.skpcp.elista.grupa.ob.GrupaOB;
import com.skpcp.elista.grupa.repository.IGrupaRepository;
import com.skpcp.elista.grupa.service.IGrupaService;
import com.skpcp.elista.utils.GrupaConverter;
import com.skpcp.elista.utils.UzytkownikConverter;
import com.skpcp.elista.uzytkownik.dto.UzytkownikDTO;
import com.skpcp.elista.uzytkownik.ob.UzytkownikOB;
import com.skpcp.elista.uzytkownik.repository.IUzytkownikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tomasz Komoszeski on 2016-04-27.
 */
@Service
@Transactional
public class GrupaServiceImpl implements IGrupaService {

    @Autowired
    IGrupaRepository grupaRepository;

    @Autowired
    IUzytkownikRepository uzytkownikRepository;

    @Override
    public GrupaDTO dodajUzytkownikDoGrupy(GrupaUzytkownikDTO aGrupaDTO) {
        GrupaOB pGrupaOB = aGrupaDTO.getId() == null ? null : grupaRepository.findOne(aGrupaDTO.getId());
        if(pGrupaOB == null)
            return null;//nie ma takiej grupy;

        UzytkownikOB pUzytkownikOB = aGrupaDTO.getUzytkownik().getId() == null ? null : uzytkownikRepository.findOne(aGrupaDTO.getUzytkownik().getId());
        if(pUzytkownikOB == null) return null;//nie ma takiego użytkownika
        List<UzytkownikOB> uzytkownicy = pGrupaOB.getUzytkownicy();
        if(pGrupaOB == null) return null; //nie ma takiej grupy
        if(!uzytkownicy.isEmpty()) for(UzytkownikOB uzytkownikOB : uzytkownicy){ //jeżeli nie jest pusta
            if(uzytkownikOB.getId() == pUzytkownikOB.getId()) return null;//dany użytkownik istnieje już w grupie
        }
        //znajdz użytkownika

        if(pUzytkownikOB == null) return null; //nie istnieje taki użytkownik
        //istnieje więc go dodaj
        pGrupaOB.getUzytkownicy().add(pUzytkownikOB);


        return GrupaConverter.grupaOBdoGrupyDTO(grupaRepository.save(pGrupaOB));

    }

    @Override
    public GrupaDTO zapiszGrupe(GrupaDTO aGrupaDTO) {
        if(aGrupaDTO == null) return null;

        UzytkownikOB pUzytkownikOB = aGrupaDTO.getLider().getId() == null ? null : uzytkownikRepository.findOne(aGrupaDTO.getLider().getId());
        if(pUzytkownikOB == null) return  null; //nie ma użytkownika który by mógł założyć grupe

        GrupaOB pGrupaOB = (aGrupaDTO.getId() == null && aGrupaDTO.getNazwa() == null) ? null : grupaRepository.znajdzGrupePoIdOrazNazwie(aGrupaDTO.getId(),aGrupaDTO.getNazwa());
        if(pGrupaOB == null){
            //zapisz grupę nową grupe
            List<UzytkownikOB> uzytkownicyOB = new ArrayList<>();
            uzytkownicyOB.add(pUzytkownikOB);
            aGrupaDTO.setUzytkownicy(UzytkownikConverter.listUzytkOBdoUzytkDTO(uzytkownicyOB));
            return GrupaConverter.grupaOBdoGrupyDTO(grupaRepository.save(GrupaConverter.grupaDTOdoGrupyOB(aGrupaDTO)));
        }
        //jeżeli istniała to edytuj
        pGrupaOB.setLider(pUzytkownikOB); //zmieniam lidera

        return GrupaConverter.grupaOBdoGrupyDTO(grupaRepository.save(pGrupaOB));
    }

    @Override
    public GrupaDTO znajdzGrupePoId(Long aId) {
        GrupaOB pGrupaOB = grupaRepository.findOne(aId);
        if(pGrupaOB == null) return null;
        return GrupaConverter.grupaOBdoGrupyDTO(pGrupaOB);
    }

    @Override
    public GrupaDTO znajdzGrupePoNazwie(String aNazwa) {
        GrupaOB pGrupaOB = grupaRepository.znajdzGrupePoNazwie(aNazwa);
        if(pGrupaOB == null) return null;
        return GrupaConverter.grupaOBdoGrupyDTO(pGrupaOB);
    }

    @Override
    public GrupaDTO znajdzGrupePoLiderzeId(Long aIdLidera) {
        GrupaOB pGrupaOB = grupaRepository.znajdzGrupePoIdLidera(aIdLidera);
        if(pGrupaOB == null) return  null;
        return GrupaConverter.grupaOBdoGrupyDTO(pGrupaOB);
    }

    @Override
    public void usunGrupePoId(Long aId) {
        grupaRepository.delete(aId);
    }
}
