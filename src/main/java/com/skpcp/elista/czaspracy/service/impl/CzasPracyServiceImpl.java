package com.skpcp.elista.czaspracy.service.impl;


import com.skpcp.elista.czaspracy.dto.CzasPracyDTO;
import com.skpcp.elista.czaspracy.ob.CzasPracyOB;
import com.skpcp.elista.czaspracy.repository.ICzasPracyRepository;
import com.skpcp.elista.czaspracy.service.ICzasPracyService;
import com.skpcp.elista.dziennikplanow.api.DziennikPlanowController;
import com.skpcp.elista.dziennikplanow.ob.DziennikPlanowOB;
import com.skpcp.elista.dziennikplanow.repository.IDziennikPlanowRepository;
import com.skpcp.elista.utils.CzasPracyConverter;
import com.skpcp.elista.utils.DziennikPlanowConverter;
import com.skpcp.elista.utils.UzytkownikConverter;
import com.skpcp.elista.uzytkownik.dto.UzytkownikDTO;
import com.skpcp.elista.uzytkownik.ob.UzytkownikOB;
import com.skpcp.elista.uzytkownik.repository.IUzytkownikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Achilles on 2016-03-22.
 */
@Service
@Transactional
public class CzasPracyServiceImpl implements ICzasPracyService {

    @Autowired
    ICzasPracyRepository iCzasPracyRepository;

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
    public CzasPracyDTO zapiszCzasPracyWedlugPlanu(CzasPracyDTO aCzasPracyDTO) {
        if (aCzasPracyDTO == null) return null;
        UzytkownikDTO pUzytkownikDTO = aCzasPracyDTO.getUzytkownik() == null ? null : aCzasPracyDTO.getUzytkownik();
        if (pUzytkownikDTO == null) return null;// coś poszło nie tak
        //skoro nie jest nullem przystępujemy do pracy
        UzytkownikOB pUztkownikOB = pUzytkownikDTO.getId() == null ? null : iUzytkownikRepository.findOne(pUzytkownikDTO.getId());
        if (pUztkownikOB == null) {
            return null; //coś poszło nie tak
        }
        Date dDzisiajJest = new Date(); //wiem jaki dzisiaj dzień!
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

            aCzasPracyDTO.setRozpoczecie(dRozpoczecie);
            aCzasPracyDTO.setZakonczenie(dZakonczenie);
            return CzasPracyConverter.czprOBdoCzprDTO(iCzasPracyRepository.save(CzasPracyConverter.czprDTOdoCzprOB(aCzasPracyDTO)));
        }
        //edytuje istniejący
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
        UzytkownikOB pUzytkownikOB = pUzytkownikDTO.getId() == null ? null :
                iUzytkownikRepository.findOne(pUzytkownikDTO.getId());
        if (pUzytkownikOB == null) {
            //coś poszło nie tak przecież użytkownik powinien być!
            return null;
        }
        //w tym momencie użytkownik na pewno istnieje
        //sprawdzam swój czas pracy
        CzasPracyOB pCzasPracyOB = aCzasPracyDTO.getId() == null ? null : iCzasPracyRepository.findOne(aCzasPracyDTO.getId());
        if (pCzasPracyOB == null) {
            //jeżeli takiego nie ma to zapisujemy
            return CzasPracyConverter.czprOBdoCzprDTO(iCzasPracyRepository.save(CzasPracyConverter.czprDTOdoCzprOB(aCzasPracyDTO)));
        }
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
