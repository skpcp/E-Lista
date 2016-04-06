package com.skpcp.elista.czaspracy.service.impl;


import com.skpcp.elista.czaspracy.dto.CzasPracyDTO;
import com.skpcp.elista.czaspracy.ob.CzasPracyOB;
import com.skpcp.elista.czaspracy.repository.ICzasPracyRepository;
import com.skpcp.elista.czaspracy.service.ICzasPracyService;
import com.skpcp.elista.utils.CzasPracyConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created by Achilles on 2016-03-22.
 */
@Service
@Transactional
public class CzasPracyServiceImpl implements ICzasPracyService {

    @Autowired
    ICzasPracyRepository iCzasPracyRepository;

    @Override
    public CzasPracyDTO wyswietlCzasPracyPoIdUzytkownika(Long aIdUzytkownika) {
        CzasPracyOB pCzasPracyOB = iCzasPracyRepository.findOne(aIdUzytkownika);
        if (pCzasPracyOB == null) return null;
        return CzasPracyConverter.czprOBdoCzprDTO(pCzasPracyOB);
    }

    @Override
    public CzasPracyDTO wprowadzGodzineRozpoczeciaPoIdUzytkownika(Long aIdUzytkownika, Date aRozpoczecie) {
        CzasPracyOB pCzasPracyOB = iCzasPracyRepository.findOne(aIdUzytkownika);
        if (pCzasPracyOB == null) {
            return null;
        }
        pCzasPracyOB.setRozpoczecie(aRozpoczecie);
        CzasPracyDTO pCzasPracyDTO = CzasPracyConverter.czprOBdoCzprDTO(pCzasPracyOB);
        return pCzasPracyDTO;
    }

    @Override
    public CzasPracyDTO wprowadzGodzineZakonczeniaPoIdUzytkownika(Long aIdUzytkownika, Date aZakonczenie) {
        CzasPracyOB pCzasPracyOB = iCzasPracyRepository.findOne(aIdUzytkownika);
        if (pCzasPracyOB == null) {
            return null;
        }
        pCzasPracyOB.setZakonczenie(aZakonczenie);
        CzasPracyDTO pCzasPracyDTO = CzasPracyConverter.czprOBdoCzprDTO(pCzasPracyOB);
        return pCzasPracyDTO;
    }

    @Override
    public CzasPracyDTO wprowadzZakresPracyPoIdUzytkownika(Long aIdUzytkownika, String aZakresPracy) {
        CzasPracyOB pCzasPracyOB = iCzasPracyRepository.findOne(aIdUzytkownika);
        if (pCzasPracyOB == null) {
            return null;
        }
        pCzasPracyOB.setZakresPracy(aZakresPracy);
        CzasPracyDTO pCzasPracyDTO = CzasPracyConverter.czprOBdoCzprDTO(pCzasPracyOB);
        return pCzasPracyDTO;
    }

    @Override
    public CzasPracyDTO wyswietlGodzineRozpoczeciaPoIdUzytkownika(Long aIdUzytkownika) {
        CzasPracyOB pCzasPracyOB = iCzasPracyRepository.findOne(aIdUzytkownika);
        if (pCzasPracyOB == null) {
            return null;
        }
        pCzasPracyOB.getRozpoczecie();
        CzasPracyDTO pCzasPracyDTO = CzasPracyConverter.czprOBdoCzprDTO(pCzasPracyOB);
        return pCzasPracyDTO;
    }

    @Override
    public CzasPracyDTO wyswietlGodzineZakonczeniaPoIdUzytkownika(Long aIdUzytkownika) {
        CzasPracyOB pCzasPracyOB = iCzasPracyRepository.findOne(aIdUzytkownika);
        if (pCzasPracyOB == null) {
            return null;
        }
        pCzasPracyOB.getZakonczenie();
        CzasPracyDTO pCzasPracyDTO = CzasPracyConverter.czprOBdoCzprDTO(pCzasPracyOB);
        return pCzasPracyDTO;
    }

    @Override
    public CzasPracyDTO wyswietlZakresPracyPoIdUzytkownika(Long aIdUzytkownika) {
        CzasPracyOB pCzasPracyOB = iCzasPracyRepository.findOne(aIdUzytkownika);
        if (pCzasPracyOB == null) {
            return null;
        }
        pCzasPracyOB.getZakresPracy();
        CzasPracyDTO pCzasPracyDTO = CzasPracyConverter.czprOBdoCzprDTO(pCzasPracyOB);
        return pCzasPracyDTO;
    }
}
