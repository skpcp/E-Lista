package com.skpcp.elista.dziennikplanow.service.impl;

import com.skpcp.elista.dziennikplanow.dto.DziennikPlanowDTO;
import com.skpcp.elista.dziennikplanow.ob.DziennikPlanowOB;
import com.skpcp.elista.dziennikplanow.repository.IDziennikPlanowRepository;
import com.skpcp.elista.dziennikplanow.service.IDziennikPlanowService;
import com.skpcp.elista.utils.converters.DziennikPlanowConverter;
import com.skpcp.elista.utils.exceptions.MyServerException;
import com.skpcp.elista.uzytkownik.dto.UzytkownikDTO;
import com.skpcp.elista.uzytkownik.ob.UzytkownikOB;
import com.skpcp.elista.uzytkownik.repository.IUzytkownikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Autowired
    IUzytkownikRepository iUzytkownikRepository;


    @Override
    public DziennikPlanowDTO znajdzDziennikPlanowPoId(Long aId) throws MyServerException{
        DziennikPlanowOB pDziennikPlanowOB = iDziennikPlanowRepository.findOne(aId);//znajdź po ID, i zwróc instancje obiektu UzytkownikOB
        if(pDziennikPlanowOB == null) throw new MyServerException("Nie znaleziono dziennika planow", HttpStatus.NOT_FOUND,new HttpHeaders()); //jeżeli nic nie znajdziesz, to oznacza null (wartość domyślną) to zwróc tego nulla
        return DziennikPlanowConverter.dziennikplanowOBdoDziennikPlanowowDTO(pDziennikPlanowOB);
    }
    @Override
    public List<DziennikPlanowDTO> znajdzWszystkieDziennikiPlanow(){
        List<DziennikPlanowDTO> listaWynikowaDziennikowPlanowDTO = new ArrayList<>();//utworzenie pojemnika
        List<DziennikPlanowOB> listaDziennikowPlanowOB = iDziennikPlanowRepository.findAll();

        for(DziennikPlanowOB dziennik : listaDziennikowPlanowOB) listaWynikowaDziennikowPlanowDTO .add(DziennikPlanowConverter.dziennikplanowOBdoDziennikPlanowowDTO(dziennik));

        return listaWynikowaDziennikowPlanowDTO ;//działa

    }
    @Override
    public List<DziennikPlanowDTO> znajdzDziennikiPlanowPoUzytkowniku(Long aIdUzytkownika){//READ po
        List<DziennikPlanowOB> listaDziennikowPlanowOB = iDziennikPlanowRepository.znajdzDziennikiPlanowPoUzytkowniku(aIdUzytkownika);
        List<DziennikPlanowDTO> listaWynikowaDziennikowPlanowDTO = new ArrayList<>();
        //if(listaDziennikowPlanowOB == null) return null;
        for(DziennikPlanowOB dziennik : listaDziennikowPlanowOB) listaWynikowaDziennikowPlanowDTO .add(DziennikPlanowConverter.dziennikplanowOBdoDziennikPlanowowDTO(dziennik)); //zmień każdą instancję UzytkownikOB do instancji DTO

        return listaWynikowaDziennikowPlanowDTO ;

    }


    @Override
    public DziennikPlanowDTO zapiszDziennikPlanow(DziennikPlanowDTO aDziennikPlanowDTO) throws MyServerException {//CREATE and EDIT
        UzytkownikDTO pUzytkownikDTO = aDziennikPlanowDTO.getUzytkownik();
        if (pUzytkownikDTO == null)  throw new MyServerException("Nie znaleziono pola uzytkownika",HttpStatus.NOT_FOUND,new HttpHeaders());
        UzytkownikOB pUzytkownikOB = pUzytkownikDTO.getId() == null ? null :
                iUzytkownikRepository.findOne(pUzytkownikDTO.getId());
        if(pUzytkownikOB == null)  throw new MyServerException("Nie znaleziono uzytkownika",HttpStatus.NOT_FOUND,new HttpHeaders()); //gdy nie istnieje użytkownik nie ma sensu przechodzić dalej!

        DziennikPlanowOB pDziennikPlanowOB = aDziennikPlanowDTO.getId() == null ? null :
                iDziennikPlanowRepository.findOne(aDziennikPlanowDTO.getId());
        if(pDziennikPlanowOB == null) {//gdy nie ma takiego dziennika planów
            throw new MyServerException("Nie znaleziono dziennika planow",HttpStatus.NOT_FOUND,new HttpHeaders());
        }
        pDziennikPlanowOB.setTechDate(aDziennikPlanowDTO.getTechDate()); //to akurat wiadomo, że muszę zapisać kiedy to się stało
        pDziennikPlanowOB.setPlanOd(aDziennikPlanowDTO.getPlanOd()); //zmieniam dane!
        pDziennikPlanowOB.setPlanDo(aDziennikPlanowDTO.getPlanDo());//zmieniam dane!
        return DziennikPlanowConverter.dziennikplanowOBdoDziennikPlanowowDTO(iDziennikPlanowRepository.save(pDziennikPlanowOB));
    }

    @Override
    public void usunDziennikPlanow(Long aId){
        iDziennikPlanowRepository.delete(aId);
    }//DELETE

//    @Override
//    public DziennikPlanowDTO dopiszUzytkownikaDoDziennikaPlanow(Long aId, UzytkownikDTO aUzytkownik) {
//        DziennikPlanowOB pDziennikPlanowOB = iDziennikPlanowRepository.findOne(aId);
//        if(pDziennikPlanowOB == null){
//            return null;
//        }
//
//        //nie obchodzi mnie co w nim jest, chce go dodać do dziennika
//        pDziennikPlanowOB.setUzytkownik(UzytkownikConverter.uzytDTOdoUzytkOB(aUzytkownik));//wpisanie użytkownika do bazy danych
//        return DziennikPlanowConverter.dziennikplanowOBdoDziennikPlanowowDTO(pDziennikPlanowOB);//mam zwrócić DTO dziennikPlanów już zmodyfikowany
//    }

}
