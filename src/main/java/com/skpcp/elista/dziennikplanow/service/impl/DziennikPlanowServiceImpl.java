package com.skpcp.elista.dziennikplanow.service.impl;

import com.skpcp.elista.dziennikplanow.dto.DziennikPlanowDTOBezTechDate;
import com.skpcp.elista.dziennikplanow.dto.DziennikPlanowDTOBezUzytkownika;
import com.skpcp.elista.dziennikplanow.dto.DziennikPlanowDTOUzytkownik;
import com.skpcp.elista.dziennikplanow.ob.DziennikPlanowOB;
import com.skpcp.elista.dziennikplanow.repository.IDziennikPlanowRepository;
import com.skpcp.elista.dziennikplanow.service.IDziennikPlanowService;
import com.skpcp.elista.utils.converters.DziennikPlanowConverter;
import com.skpcp.elista.utils.exceptions.MyServerException;
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
    public DziennikPlanowDTOUzytkownik znajdzDziennikPlanowPoId(Long aId) throws MyServerException{
        DziennikPlanowOB pDziennikPlanowOB = iDziennikPlanowRepository.findOne(aId);//znajdź po ID, i zwróc instancje obiektu UzytkownikOB
        if(pDziennikPlanowOB == null) throw new MyServerException("Nie znaleziono dziennika planow", HttpStatus.NOT_FOUND,new HttpHeaders()); //jeżeli nic nie znajdziesz, to oznacza null (wartość domyślną) to zwróc tego nulla
        return DziennikPlanowConverter.dziennikPlanowOBDoDziennikPlanowDTOUzytkownik(pDziennikPlanowOB);
    }
    @Override
    public List<DziennikPlanowDTOUzytkownik> znajdzWszystkieDziennikiPlanow(){
        List<DziennikPlanowDTOUzytkownik> listaWynikowaDziennikowPlanowDTO = new ArrayList<>();//utworzenie pojemnika
        List<DziennikPlanowOB> listaDziennikowPlanowOB = iDziennikPlanowRepository.findAll();
        for(DziennikPlanowOB dziennik : listaDziennikowPlanowOB) listaWynikowaDziennikowPlanowDTO .add(DziennikPlanowConverter.dziennikPlanowOBDoDziennikPlanowDTOUzytkownik(dziennik));
        return listaWynikowaDziennikowPlanowDTO ;//działa

    }
    @Override
    public List<DziennikPlanowDTOBezUzytkownika> znajdzDziennikiPlanowPoUzytkowniku(Long aIdUzytkownika){//READ po
        List<DziennikPlanowOB> listaDziennikowPlanowOB = iDziennikPlanowRepository.znajdzDziennikiPlanowPoUzytkowniku(aIdUzytkownika);
        List<DziennikPlanowDTOBezUzytkownika> listaWynikowaDziennikowPlanowDTO = new ArrayList<>();
        for(DziennikPlanowOB dziennik : listaDziennikowPlanowOB) listaWynikowaDziennikowPlanowDTO .add(DziennikPlanowConverter.dziennikPlanowOBDodziennikPlanowDTOBezUzytkownika(dziennik));
        return listaWynikowaDziennikowPlanowDTO ;

    }


    @Override
    public DziennikPlanowDTOUzytkownik zapiszDziennikPlanow(DziennikPlanowDTOBezTechDate aDziennikPlanowDTO) throws MyServerException {//CREATE and EDIT

        UzytkownikOB pUzytkownikOB = aDziennikPlanowDTO.getUzytkownikId() == null ? null : iUzytkownikRepository.findOne(aDziennikPlanowDTO.getUzytkownikId());
        if(pUzytkownikOB == null)  throw new MyServerException("Nie znaleziono uzytkownika",HttpStatus.NOT_FOUND,new HttpHeaders()); //gdy nie istnieje użytkownik nie ma sensu przechodzić dalej!

        DziennikPlanowOB pDziennikPlanowOB = aDziennikPlanowDTO.getId() == null ? null :
                iDziennikPlanowRepository.findOne(aDziennikPlanowDTO.getId());
        if(pDziennikPlanowOB == null) {//gdy nie ma takiego dziennika planów
            throw new MyServerException("Nie znaleziono dziennika planow", HttpStatus.NOT_FOUND, new HttpHeaders());
        }
        pDziennikPlanowOB.setPlanOd(aDziennikPlanowDTO.getPlanOd()); //zmieniam dane!
        pDziennikPlanowOB.setPlanDo(aDziennikPlanowDTO.getPlanDo());//zmieniam dane!
        return DziennikPlanowConverter.dziennikPlanowOBDoDziennikPlanowDTOUzytkownik(iDziennikPlanowRepository.save(pDziennikPlanowOB));
    }

    @Override
    public void usunDziennikPlanow(Long aId){
        iDziennikPlanowRepository.delete(aId);
    }//DELETE



}
