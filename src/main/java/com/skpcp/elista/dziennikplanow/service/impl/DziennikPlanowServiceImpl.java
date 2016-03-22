package com.skpcp.elista.dziennikplanow.service.impl;

import com.skpcp.elista.dziennikplanow.EDniTygodnia;
import com.skpcp.elista.dziennikplanow.dto.DziennikPlanowDTO;
import com.skpcp.elista.dziennikplanow.ob.DziennikPlanowOB;
import com.skpcp.elista.dziennikplanow.repository.IDziennikPlanowRepository;
import com.skpcp.elista.dziennikplanow.service.IDziennikPlanowService;
import com.skpcp.elista.utils.DziennikPlanowConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;


/**
 * Created by bidzis on 2016-03-22.
 */
@Service
@Transactional
public class DziennikPlanowServiceImpl implements IDziennikPlanowService{
    @Autowired
    IDziennikPlanowRepository iDziennikPlanowRepository;

    @Override
    public DziennikPlanowDTO znajdzDziennikPlanowPoId(Long aId){
        DziennikPlanowOB pDziennikPlanowOB = iDziennikPlanowRepository.findOne(aId);//znajdź po ID, i zwróc instancje obiektu UzytkownikOB
        if(pDziennikPlanowOB == null) return null; //jeżeli nic nie znajdziesz, to oznacza null (wartość domyślną) to zwróc tego nulla
        return DziennikPlanowConverter.dziennikplanowOBdoDziennikPlanowowDTO(pDziennikPlanowOB);
    }
    @Override
    public List<DziennikPlanowDTO> znajdzWszystkieDziennikiPlanow(){
        List<DziennikPlanowDTO> listaWynikowaDziennikowPlanowDTO = new ArrayList<>();//utworzenie pojemnika
        List<DziennikPlanowOB> listaDziennikowPlanowOB = iDziennikPlanowRepository.findAll();//zwróc mi wszystkich użytkowników
        //przepisanie moich użytkowników
        for(DziennikPlanowOB dziennik : listaDziennikowPlanowOB) listaWynikowaDziennikowPlanowDTO .add(DziennikPlanowConverter.dziennikplanowOBdoDziennikPlanowowDTO(dziennik)); //zmień każdą instancję UzytkownikOB do instancji DTO

        return listaWynikowaDziennikowPlanowDTO ;//działa

    }
    public DziennikPlanowDTO znajdzDziennikPlanowPoIdUzytkownika(Long aIdUzytkownika){
        DziennikPlanowOB pDziennikPlanowOB = iDziennikPlanowRepository.findOne(aIdUzytkownika);//znajdź po ID, i zwróc instancje obiektu UzytkownikOB
        if(pDziennikPlanowOB == null) return null; //jeżeli nic nie znajdziesz, to oznacza null (wartość domyślną) to zwróc tego nulla
        return DziennikPlanowConverter.dziennikplanowOBdoDziennikPlanowowDTO(pDziennikPlanowOB);

    }
    @Override
    public List<DziennikPlanowDTO> znajdzDziennikPoDniuTygodnia(EDniTygodnia aDzienTygodnia){
        List<DziennikPlanowDTO> listaWynikowaDziennikowPlanowDTO = new ArrayList<>();//utworzenie pojemnika
        List<DziennikPlanowOB> listaDziennikowPlanowOB = iDziennikPlanowRepository.znajdzPoDniuTygodnia(aDzienTygodnia);
        //przepisanie moich użytkowników
        for(DziennikPlanowOB dziennik : listaDziennikowPlanowOB) listaWynikowaDziennikowPlanowDTO .add(DziennikPlanowConverter.dziennikplanowOBdoDziennikPlanowowDTO(dziennik));

        return listaWynikowaDziennikowPlanowDTO;//zwróć DTO
    }
    @Override
    public DziennikPlanowDTO zapiszDziennikPlanow(DziennikPlanowDTO aDziennikPlanowDTO){
        if(aDziennikPlanowDTO == null){
            return null;
        }
        //sprawdzam czy dany rekord z OB już istnieje
        DziennikPlanowOB pDziennikPlanowOB = aDziennikPlanowDTO.getId() == null ? null : iDziennikPlanowRepository.findOne(aDziennikPlanowDTO.getId());

        if(pDziennikPlanowOB == null){//gdy nie ma takiego to zapisz
            return DziennikPlanowConverter.dziennikplanowOBdoDziennikPlanowowDTO(iDziennikPlanowRepository.save(DziennikPlanowConverter.dziennikplanowDTOdoDziennikPlanowowOB(aDziennikPlanowDTO)));
        }
        //tutaj odwołując się do obiektu pDziennikPlanowOB mogę zrobić walidację danych po stronie serwera (na OB)
        //edytuj istniejącego
        pDziennikPlanowOB.setIdUzytkownika(aDziennikPlanowDTO.getIdUzytkownika());
        pDziennikPlanowOB.setDzienTygodnia(aDziennikPlanowDTO.getDzienTygodnia());
        pDziennikPlanowOB.setPlanOd(aDziennikPlanowDTO.getPlanOd());
        pDziennikPlanowOB.setPlanDo(aDziennikPlanowDTO.getPlanDo());
        return DziennikPlanowConverter.dziennikplanowOBdoDziennikPlanowowDTO(iDziennikPlanowRepository.save(pDziennikPlanowOB));
    }
    @Override
    public void usunDziennikPlanow(Long aId){
        iDziennikPlanowRepository.delete(aId);
    }
    @Override
    public DziennikPlanowDTO zmienDziennikPlanuPoIdUzytkownika(Long aIdUzytkownika, EDniTygodnia aDzienTygodnia, Date aPlanOd, Date aPlanDo){
        DziennikPlanowOB pDzienikPlanowOB = iDziennikPlanowRepository.findOne(aIdUzytkownika);
        if(pDzienikPlanowOB == null){
            return null;
        }
        pDzienikPlanowOB.setDzienTygodnia(aDzienTygodnia);
        pDzienikPlanowOB.setPlanOd(aPlanOd);
        pDzienikPlanowOB.setPlanDo(aPlanDo);
        DziennikPlanowDTO pDziennikPlanowDTO = DziennikPlanowConverter.dziennikplanowOBdoDziennikPlanowowDTO(pDzienikPlanowOB);

        return pDziennikPlanowDTO;

    }
    @Override
    public DziennikPlanowDTO zmienDziennikPlanuPoId(Long aId, EDniTygodnia aDzienTygodnia, Date aPlanOd, Date aPlanDo){
        DziennikPlanowOB pDzienikPlanowOB = iDziennikPlanowRepository.findOne(aId);
        if(pDzienikPlanowOB == null){
            return null;
        }
        pDzienikPlanowOB.setDzienTygodnia(aDzienTygodnia);
        pDzienikPlanowOB.setPlanOd(aPlanOd);
        pDzienikPlanowOB.setPlanDo(aPlanDo);
        DziennikPlanowDTO pDziennikPlanowDTO = DziennikPlanowConverter.dziennikplanowOBdoDziennikPlanowowDTO(pDzienikPlanowOB);

        return pDziennikPlanowDTO;

    }

}
