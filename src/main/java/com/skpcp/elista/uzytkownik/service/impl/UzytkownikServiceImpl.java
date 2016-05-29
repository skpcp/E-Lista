package com.skpcp.elista.uzytkownik.service.impl;

import com.skpcp.elista.dziennikplanow.ob.DziennikPlanowOB;
import com.skpcp.elista.dziennikplanow.repository.IDziennikPlanowRepository;
import com.skpcp.elista.grupa.dto.GrupaDTO;
import com.skpcp.elista.grupa.ob.GrupaOB;
import com.skpcp.elista.grupa.repository.IGrupaRepository;
import com.skpcp.elista.rola.dto.RolaDTO;
import com.skpcp.elista.rola.ob.RolaOB;
import com.skpcp.elista.rola.respository.IRolaRepository;
import com.skpcp.elista.utils.converters.GrupaConverter;
import com.skpcp.elista.utils.converters.RolaConverter;
import com.skpcp.elista.utils.converters.UzytkownikConverter;
import com.skpcp.elista.utils.exceptions.MyServerException;
import com.skpcp.elista.uzytkownik.EStan;
import com.skpcp.elista.uzytkownik.dto.*;
import com.skpcp.elista.uzytkownik.ob.UzytkownikOB;
import com.skpcp.elista.uzytkownik.repository.IUzytkownikRepository;
import com.skpcp.elista.uzytkownik.service.IUzytkownikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.print.DocFlavor;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Tomek on 2016-03-20.
 */
@Service
@Transactional
public class UzytkownikServiceImpl implements IUzytkownikService {

    @Autowired
    IUzytkownikRepository iUzytkownikRepository;

    @Autowired
    IDziennikPlanowRepository iDziennikPlanowRepository;

    @Autowired
    IRolaRepository iRolaRepository;

    @Autowired
    IGrupaRepository iGrupaRepository;
    /* Mała rozkmina
     * Obiekt DTO - data transfer object pośredniczy
     * w wywołaniach, jest to tak jakby kontener? Nie działam
     * bezpośrednio w bazie danych
     *
     * Założenie serwisu
     * Pobieram dzięki intefejsowi IUżytkownikRepository instancje obiektów OB, która za pomocą auto
     * magi JPA zbiera mi z bazy danych za pomocą gotowych kwerend ( nie wiem co tam siedzi)
     * tworzy w magiczny sposób instancje obiektówOB które później
     * za pomocą serwius konwertuje je do DTO a potem mogę z nimi robić co mi się
     * żywnie podoba.
     * */

    @Override
    public UzytkownikDTOBezHasla znajdzUzytkownikaPoEmailu(String aEmail) throws MyServerException {
        UzytkownikOB pUzytkownikOB = iUzytkownikRepository.znajdzPoEmailu(aEmail);//znajdź po ID, i zwróc instancje obiektu UzytkownikOB
        if(pUzytkownikOB == null) throw new MyServerException("Nie ma takiego uzytkownika",HttpStatus.NOT_FOUND,new HttpHeaders()); //jeżeli nic nie znajdziesz, to oznacza null (wartość domyślną) to zwróc tego nulla
        return UzytkownikConverter.uzytkownikOBDoUzytkownikaDTOBezHasla(pUzytkownikOB);//muszę przekształcić dany typ obiektu OB na DTO by potem móc go wyświetlić albo robić z nim cokolwiek innego
    }

    @Override
    public UzytkownikDTOBezHasla znajdzUzytkownikaPoId(Long aId) throws MyServerException {
        UzytkownikOB pUzytkownikOB = iUzytkownikRepository.findOne(aId);//znajdź po ID, i zwróc instancje obiektu UzytkownikOB
        if(pUzytkownikOB == null) throw new MyServerException("Nie ma takiego uzytkownika", HttpStatus.NOT_FOUND,new HttpHeaders()); //jeżeli nic nie znajdziesz, to oznacza null (wartość domyślną) to zwróc tego nulla
        return UzytkownikConverter.uzytkownikOBDoUzytkownikaDTOBezHasla(pUzytkownikOB);//muszę przekształcić dany typ obiektu OB na DTO by potem móc go wyświetlić albo robić z nim cokolwiek innego
    }

    @Override
    public List<UzytkownikDTOBezHasla> znajdzWszystkichUzytkownikow() {
        List<UzytkownikDTOBezHasla> listaWynikowaUzytkownikowDTO = new ArrayList<>();//utworzenie pojemnika
        List<UzytkownikOB> listaUzytkownikowOB = iUzytkownikRepository.findAll();//zwróc mi wszystkich użytkowników
        //przepisanie moich użytkowników
        for(UzytkownikOB uzytkownik : listaUzytkownikowOB) listaWynikowaUzytkownikowDTO.add(UzytkownikConverter.uzytkownikOBDoUzytkownikaDTOBezHasla(uzytkownik)); //zmień każdą instancję UzytkownikOB do instancji DTO

        return listaWynikowaUzytkownikowDTO;//działa
    }

    @Override
    public List<UzytkownikDTOBezHasla> znajdzUzytkownikowPoImieniu(String aImie) {
        List<UzytkownikDTOBezHasla> listaWynikowaUzytkownikowDTO = new ArrayList<>();//utworzenie pojemnika
        List<UzytkownikOB> listaUzytkownikowOB = iUzytkownikRepository.findByImieStartsWith(aImie);//zwróc mi wszystkich użytkowników
        //przepisanie moich użytkowników
        for(UzytkownikOB uzytkownik : listaUzytkownikowOB) listaWynikowaUzytkownikowDTO.add(UzytkownikConverter.uzytkownikOBDoUzytkownikaDTOBezHasla(uzytkownik)); //zmień każdą instancję UzytkownikOB do instancji DTO

        return listaWynikowaUzytkownikowDTO;//zwróć DTO
    }

    @Override
    public List<UzytkownikDTOBezHasla> znajdzUzytkownikowPoNazwisku(String aNazwisko) {
        List<UzytkownikDTOBezHasla> listaWynikowaUzytkownikowDTO = new ArrayList<>();//utworzenie pojemnika
        List<UzytkownikOB> listaUzytkownikowOB = iUzytkownikRepository.findByNazwiskoStartsWith(aNazwisko);//zwróc mi wszystkich użytkowników
        //przepisanie moich użytkowników
        for(UzytkownikOB uzytkownik : listaUzytkownikowOB) listaWynikowaUzytkownikowDTO.add(UzytkownikConverter.uzytkownikOBDoUzytkownikaDTOBezHasla(uzytkownik)); //zmień każdą instancję UzytkownikOB do instancji DTO

        return listaWynikowaUzytkownikowDTO;//zwróć DTO
    }

    @Override
    public List<UzytkownikDTOBezHasla> znajdzUzytkownikowPoImieniuINazwisku(String aImie, String aNazwisko) {
        List<UzytkownikDTOBezHasla> listaWynikowaUzytkownikowDTO = new ArrayList<>();//utworzenie pojemnika
        List<UzytkownikOB> listaUzytkownikowOB = iUzytkownikRepository.findByFullImie(aImie,aNazwisko);
        //przepisanie moich użytkowników
        for(UzytkownikOB uzytkownik : listaUzytkownikowOB) listaWynikowaUzytkownikowDTO.add(UzytkownikConverter.uzytkownikOBDoUzytkownikaDTOBezHasla(uzytkownik)); //zmień każdą instancję UzytkownikOB do instancji DTO

        return listaWynikowaUzytkownikowDTO;//zwróć DTO
    }


    //Dla Administratora
    @Override
    public UzytkownikDTOBezHasla zapiszUzytkownika(UzytkownikDTOBezIdTechDate aUzytkownikDTO) throws MyServerException {
        if(aUzytkownikDTO == null){
            throw new MyServerException("Brak pola uzytkownik",HttpStatus.NOT_FOUND,new HttpHeaders());
        }
        if(aUzytkownikDTO.getGrupa()==null)
        {
            throw new MyServerException("Brak grupy",HttpStatus.NOT_FOUND,new HttpHeaders());
        }

        if(aUzytkownikDTO.getRola() == null){
            throw new MyServerException("Brak roli",HttpStatus.NOT_FOUND,new HttpHeaders());
        }
        UzytkownikOB pUzytkownikOB = aUzytkownikDTO.getEmail() == null ? null : iUzytkownikRepository.znajdzPoEmailu(aUzytkownikDTO.getEmail());
        if(pUzytkownikOB == null){//gdy nie ma takiego to zapisz
            RolaOB pRolaOB = iRolaRepository.znajdzPoNazwieRoli("Pracownik");//domyslna rola
            aUzytkownikDTO.setAktywnosc(EStan.AKTYWNY);
            GrupaOB pGrupaOB = iGrupaRepository.znajdzGrupePoNazwie("Pracownicy Firmy");
            pUzytkownikOB = new UzytkownikOB(aUzytkownikDTO.getImie(),aUzytkownikDTO.getNazwisko(),aUzytkownikDTO.getEmail(),aUzytkownikDTO.getHaslo(),aUzytkownikDTO.getTelefon(),aUzytkownikDTO.getAktywnosc());
            pUzytkownikOB.setGrupa(pGrupaOB);
            pUzytkownikOB.setRola(pRolaOB);

            //przepisz wiadomo

            //tworzenia pięciu standardowych dzienników planów

            SimpleDateFormat pMojFormat = new SimpleDateFormat("hh:mm");
            String nGodzinaOd = "8:00";
            String nGodzinaDo = "16:00";
            Date dPoczatekPracy;
            Date dKoniecPracy;

            try {
                dPoczatekPracy = pMojFormat.parse(nGodzinaOd);
                dKoniecPracy = pMojFormat.parse(nGodzinaDo);
            }catch (ParseException e){
                return null;
            }

            String[] pDniTygodnia = {"poniedziałek","wtorek","środa","czwartek","piątek"};
            List<DziennikPlanowOB> listaDziennikow = new ArrayList<>();
            for(String dzienTygodnia : pDniTygodnia) {
                DziennikPlanowOB pDziennikPlanowOB = new DziennikPlanowOB(pUzytkownikOB,dzienTygodnia,dPoczatekPracy,dKoniecPracy);
                listaDziennikow.add(pDziennikPlanowOB);
            }
            iUzytkownikRepository.save(pUzytkownikOB);//zapisuje użytkownika
            iDziennikPlanowRepository.save(listaDziennikow);//zapisuje listę
            return UzytkownikConverter.uzytkownikOBDoUzytkownikaDTOBezHasla(pUzytkownikOB);
        }
        //edytuj istniejącego imie nazwisko telefon
        RolaOB rolaOB = aUzytkownikDTO.getRola() == null ? null : iRolaRepository.znajdzPoNazwieRoli(aUzytkownikDTO.getRola());
        if(rolaOB == null ) throw new MyServerException("Nie ma takiej roli!",HttpStatus.NOT_FOUND,new HttpHeaders()); //nie znalazło no to null! xD
        pUzytkownikOB.setRola(rolaOB);
        GrupaOB grupaOB = aUzytkownikDTO.getGrupa() == null ? null : iGrupaRepository.znajdzGrupePoNazwie(aUzytkownikDTO.getGrupa());
        if(grupaOB == null) throw new MyServerException("Nie ma takiej grupy",HttpStatus.NOT_FOUND,new HttpHeaders());
        UzytkownikOB lider = grupaOB.getLider();
        if(lider.getId() == pUzytkownikOB.getId()) throw new MyServerException("Nie możesz dołączyc do grupy w której jestes liderem",HttpStatus.METHOD_NOT_ALLOWED,new HttpHeaders());
        pUzytkownikOB.setGrupa(grupaOB);
        pUzytkownikOB.setImie(aUzytkownikDTO.getImie());
        pUzytkownikOB.setNazwisko(aUzytkownikDTO.getNazwisko());
        pUzytkownikOB.setTelefon(aUzytkownikDTO.getTelefon());
        return UzytkownikConverter.uzytkownikOBDoUzytkownikaDTOBezHasla(iUzytkownikRepository.save(pUzytkownikOB));
    }


    //DlaWszystkich
    //Prawdopodobnie potrzeba będzie nowe DTO:
    @Override
    public UzytkownikDTOBezRoliGrupy rejestracjaUzytkownika(UzytkownikDTOBezRoliGrupyZHaslem aUzytkownikDTO) throws MyServerException {
        UzytkownikOB pUzytkownikOB = aUzytkownikDTO.getEmail() == null ? null : iUzytkownikRepository.znajdzPoEmailu(aUzytkownikDTO.getEmail());
        if(pUzytkownikOB != null) throw new MyServerException("Istnieje uzytkownik o podanym mailu",HttpStatus.METHOD_NOT_ALLOWED,new HttpHeaders());
        return  UzytkownikConverter.uzytkownikOBdoUzytkownikDTOBezRoliGrupy(iUzytkownikRepository.save(UzytkownikConverter.uzytkownikDTOBezRoliGrupyZHaslemDoUzytkownikaOB(aUzytkownikDTO)));
    }

    @Override
    public void dezaktywujUzytkownika(Long aId) {
        UzytkownikOB pUzytkownikOB = iUzytkownikRepository.findOne(aId);
        pUzytkownikOB.setAktywnosc(EStan.NIEAKTYWNY);
        iUzytkownikRepository.save(pUzytkownikOB);
    }

    //dla adminów albo i lidera tutaj trzeba będzie prawdopodbnie podać całe DTO
    //nie możemy aktywować jeżeli nie był on w naszej grupie
    @Override
    public void aktywujUzytkownika(Long aId) throws MyServerException {
        UzytkownikOB pUzytkownikOB = iUzytkownikRepository.findOne(aId);
        if(pUzytkownikOB == null) throw  new MyServerException("Nie ma takiego uzytkownka",HttpStatus.NOT_FOUND,new HttpHeaders());
        if(pUzytkownikOB.getAktywnosc() == EStan.AKTYWNY) throw new MyServerException("Uzytkownik juz aktywny",HttpStatus.METHOD_NOT_ALLOWED,new HttpHeaders());
        if(pUzytkownikOB.getAktywnosc() == EStan.OCZEKUJACY){
            //stwórzy dzienniki planów dodaj role
            RolaOB pRolaOB = iRolaRepository.znajdzPoNazwieRoli("Pracownik");//domyslna rola
            pUzytkownikOB.setRola(pRolaOB);
            GrupaOB pGrupaOB = iGrupaRepository.znajdzGrupePoNazwie("Pracownicy Firmy");
            pUzytkownikOB.setGrupa(pGrupaOB);
            SimpleDateFormat pMojFormat = new SimpleDateFormat("hh:mm");
            String nGodzinaOd = "8:00";
            String nGodzinaDo = "16:00";
            Date dPoczatekPracy;
            Date dKoniecPracy;

            try {
                dPoczatekPracy = pMojFormat.parse(nGodzinaOd);
                dKoniecPracy = pMojFormat.parse(nGodzinaDo);
            }catch (ParseException e){
                throw new MyServerException("Bład parsowania",HttpStatus.METHOD_NOT_ALLOWED,new HttpHeaders());
            }

            String[] pDniTygodnia = {"poniedziałek","wtorek","środa","czwartek","piątek"};
            List<DziennikPlanowOB> listaDziennikow = new ArrayList<>();
            for(String dzienTygodnia : pDniTygodnia) {
                DziennikPlanowOB pDziennikPlanowOB = new DziennikPlanowOB(pUzytkownikOB,dzienTygodnia,dPoczatekPracy,dKoniecPracy);
                listaDziennikow.add(pDziennikPlanowOB);
            }
            iDziennikPlanowRepository.save(listaDziennikow);//zapisuje listę
        }
        pUzytkownikOB.setAktywnosc(EStan.AKTYWNY);
        iUzytkownikRepository.save(pUzytkownikOB);
    }

    @Override
    public List<UzytkownikDTOBezHasla> znajdzUzytkownikowPoAktywnosci(EStan aAktywnosc) {
        List<UzytkownikDTOBezHasla> listaWynikowaUzytkownikowDTO = new ArrayList<>();//utworzenie pojemnika
        List<UzytkownikOB> listaUzytkownikowOB = iUzytkownikRepository.znajdzPoAktywnosci(aAktywnosc);
        //przepisanie moich użytkowników
        for(UzytkownikOB uzytkownik : listaUzytkownikowOB) listaWynikowaUzytkownikowDTO.add(UzytkownikConverter.uzytkownikOBDoUzytkownikaDTOBezHasla(uzytkownik)); //zmień każdą instancję UzytkownikOB do instancji DTO

        return listaWynikowaUzytkownikowDTO;//zwróć DTO
    }


    @Override
    public List<UzytkownikDTOBezHasla> znajdzUzytkownikowPoNazwieRoli(String aNazwa)  {
        List<UzytkownikOB> listaUzytkownikOB = new ArrayList<>();
        listaUzytkownikOB = iUzytkownikRepository.znajdzPoRoli(aNazwa,EStan.AKTYWNY);
        return UzytkownikConverter.listaUzytkowOBDOListaUzytkownikowDTOBezHasla(listaUzytkownikOB);
    }

    @Override
    public UzytkownikDTOBezHasla zmienAdresEmailUzytkownika(Long aIdUzytkownika, String aEmail) throws MyServerException {
        UzytkownikOB pUzytkownikOB = iUzytkownikRepository.findOne(aIdUzytkownika);
        if(pUzytkownikOB == null) throw new MyServerException("Nie ma takiego uzytkownika",HttpStatus.NOT_FOUND,new HttpHeaders());
        UzytkownikOB pUzytkownikOBEmail = iUzytkownikRepository.znajdzPoEmailu(aEmail);
        if(pUzytkownikOBEmail != null) throw new MyServerException("Uzytkownik z takim emailem juz istnieje",HttpStatus.METHOD_NOT_ALLOWED,new HttpHeaders());
        //wszystko w porządku już mogę ustawić email;
        pUzytkownikOB.setEmail(aEmail);
        return UzytkownikConverter.uzytkownikOBDoUzytkownikaDTOBezHasla(iUzytkownikRepository.save(pUzytkownikOB));
    }


    @Override
    public void zmienHasloUzytkownika(UzytkownikDTOZmianaHasla aUzytkownikDTO) throws MyServerException {
        UzytkownikOB pUzytkownikOB = aUzytkownikDTO.getEmail() == null ? null : iUzytkownikRepository.znajdzPoEmailu(aUzytkownikDTO.getEmail());
        if(pUzytkownikOB == null) throw new MyServerException("Nie ma takiego uzytkownika",HttpStatus.NOT_FOUND,new HttpHeaders());
        String hasloZBazy = pUzytkownikOB.getHaslo();
        String hasloPodane = aUzytkownikDTO.getHaslo();
        if(hasloPodane == null || hasloZBazy == null || aUzytkownikDTO.getNoweHaslo() == null) throw new MyServerException("Nie znaleziono hasla",HttpStatus.NOT_FOUND,new HttpHeaders());
        if (hasloZBazy.hashCode() != hasloPodane.hashCode()) throw new MyServerException("Złe hasło",HttpStatus.METHOD_NOT_ALLOWED,new HttpHeaders());
        pUzytkownikOB.setHaslo(aUzytkownikDTO.getNoweHaslo());
        iUzytkownikRepository.save(pUzytkownikOB);
    }

    @Override
    public List<UzytkownikDTOBezHasla> znajdzUzytkownikowPoNazwieGrupy(String aNazwaGrupy) {
        List<UzytkownikOB> pUzytkownicy = iUzytkownikRepository.znajdzPoNazwieGrupy(aNazwaGrupy,EStan.AKTYWNY);
        return UzytkownikConverter.listaUzytkowOBDOListaUzytkownikowDTOBezHasla(pUzytkownicy);
    }

    @Override
    public List<UzytkownikDTOBezHasla> znajdzUzytkownikowPoIdGrupy(Long aIdGrupy) {
        List<UzytkownikOB> pUzytkownicy = iUzytkownikRepository.znajdzPoIdGrupy(aIdGrupy,EStan.AKTYWNY);
        return UzytkownikConverter.listaUzytkowOBDOListaUzytkownikowDTOBezHasla(pUzytkownicy);
    }

    @Override
    public List<UzytkownikDTOBezHasla> znajdzUzytkownikowWGrupiePoAktywnosci(String aNazwaGrupy, EStan aktywnosc) {
        List<UzytkownikOB> pUzytkownicy = iUzytkownikRepository.znajdzPoNazwieGrupy(aNazwaGrupy,aktywnosc);
        return UzytkownikConverter.listaUzytkowOBDOListaUzytkownikowDTOBezHasla(pUzytkownicy);
    }

    //tylko i wyłącznie dla Admina
    @Override
    public UzytkownikDTOBezHasla ustawGrupeDlaUzytkownika(Long aIdUzytkownika,String aNazwaGrupy) throws MyServerException {
        UzytkownikOB pUzytkownikOB = iUzytkownikRepository.findOne(aIdUzytkownika);
        if(pUzytkownikOB == null) throw  new MyServerException("Nie ma takiego uzytkownka",HttpStatus.NOT_FOUND,new HttpHeaders());
        GrupaOB pGrupaOB = iGrupaRepository.znajdzGrupePoNazwie(aNazwaGrupy);
        if(pGrupaOB == null) throw new MyServerException("Nie ma takiej grupy",HttpStatus.NOT_FOUND,new HttpHeaders());
        //istnieje tak grupa!
        pUzytkownikOB.setGrupa(pGrupaOB);
        return UzytkownikConverter.uzytkownikOBDoUzytkownikaDTOBezHasla(iUzytkownikRepository.save(pUzytkownikOB));
    }

    @Override
    public UzytkownikDTOBezHasla ustawRoleDlaUzytkownika(Long aIdUzytkownika, String aNazwaRoli) throws MyServerException {
        UzytkownikOB pUzytkownikOB = iUzytkownikRepository.findOne(aIdUzytkownika);
        if(pUzytkownikOB == null) throw  new MyServerException("Nie ma takiego uzytkownka",HttpStatus.NOT_FOUND,new HttpHeaders());
        RolaOB pRolaOB = iRolaRepository.znajdzPoNazwieRoli(aNazwaRoli);
        if(pRolaOB == null) throw new MyServerException("Nie ma takiej roli",HttpStatus.NOT_FOUND,new HttpHeaders());
        pUzytkownikOB.setRola(pRolaOB);
        return UzytkownikConverter.uzytkownikOBDoUzytkownikaDTOBezHasla(iUzytkownikRepository.save(pUzytkownikOB));
    }

    @Override
    public UzytkownikDTOLog zalogujMnie(UzytkownikDTOZaloguj aUzytkownikDTO) throws MyServerException {
        UzytkownikOB pUzytkownikOB = aUzytkownikDTO.getEmail() == null ? null : iUzytkownikRepository.znajdzPoEmailu(aUzytkownikDTO.getEmail());
        if (pUzytkownikOB == null) throw new MyServerException("Nie ma takiego uzytkownka",HttpStatus.NOT_FOUND,new HttpHeaders());
        String hasloZBazy = pUzytkownikOB.getHaslo();
        String hasloPodane = aUzytkownikDTO.getHaslo();
        if(hasloPodane == null || hasloZBazy == null) throw new MyServerException("Nie znaleziono hasla",HttpStatus.NOT_FOUND,new HttpHeaders());
        if (hasloZBazy.hashCode() != hasloPodane.hashCode()) throw new MyServerException("Złe hasło",HttpStatus.METHOD_NOT_ALLOWED,new HttpHeaders());
        return UzytkownikConverter.uzytkownikOBdoUzytkownikDTOLog(pUzytkownikOB);
    }
}

