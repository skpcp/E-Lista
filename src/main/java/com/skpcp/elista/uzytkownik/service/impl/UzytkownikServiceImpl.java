package com.skpcp.elista.uzytkownik.service.impl;

import com.skpcp.elista.dziennikplanow.ob.DziennikPlanowOB;
import com.skpcp.elista.dziennikplanow.repository.IDziennikPlanowRepository;
import com.skpcp.elista.rola.dto.RolaDTO;
import com.skpcp.elista.rola.ob.RolaOB;
import com.skpcp.elista.rola.respository.IRolaRepository;
import com.skpcp.elista.utils.converters.RolaConverter;
import com.skpcp.elista.utils.converters.UzytkownikConverter;
import com.skpcp.elista.utils.exceptions.MyServerException;
import com.skpcp.elista.uzytkownik.EStan;
import com.skpcp.elista.uzytkownik.dto.UzytkownikDTO;
import com.skpcp.elista.uzytkownik.ob.UzytkownikOB;
import com.skpcp.elista.uzytkownik.repository.IUzytkownikRepository;
import com.skpcp.elista.uzytkownik.service.IUzytkownikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMessage;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public UzytkownikDTO znajdzUzytkownikaPoId(Long aId) throws MyServerException {
        UzytkownikOB pUzytkownikOB = iUzytkownikRepository.findOne(aId);//znajdź po ID, i zwróc instancje obiektu UzytkownikOB
        if(pUzytkownikOB == null) throw new MyServerException("Nie ma takiego uzytkownika", HttpStatus.NOT_FOUND,new HttpHeaders()); //jeżeli nic nie znajdziesz, to oznacza null (wartość domyślną) to zwróc tego nulla
        return UzytkownikConverter.uzytOBdoUzytkDTO(pUzytkownikOB);//muszę przekształcić dany typ obiektu OB na DTO by potem móc go wyświetlić albo robić z nim cokolwiek innego
    }

    @Override
    public List<UzytkownikDTO> znajdzWszystkichUzytkownikow() {
        List<UzytkownikDTO> listaWynikowaUzytkownikowDTO = new ArrayList<>();//utworzenie pojemnika
        List<UzytkownikOB> listaUzytkownikowOB = iUzytkownikRepository.findAll();//zwróc mi wszystkich użytkowników
        //przepisanie moich użytkowników
        for(UzytkownikOB uzytkownik : listaUzytkownikowOB) listaWynikowaUzytkownikowDTO.add(UzytkownikConverter.uzytOBdoUzytkDTO(uzytkownik)); //zmień każdą instancję UzytkownikOB do instancji DTO

        return listaWynikowaUzytkownikowDTO;//działa
    }

    @Override
    public List<UzytkownikDTO> znajdzUzytkownikowPoImieniu(String aImie) {
        List<UzytkownikDTO> listaWynikowaUzytkownikowDTO = new ArrayList<>();//utworzenie pojemnika
        List<UzytkownikOB> listaUzytkownikowOB = iUzytkownikRepository.findByImieStartsWith(aImie);//zwróc mi wszystkich użytkowników
        //przepisanie moich użytkowników
        for(UzytkownikOB uzytkownik : listaUzytkownikowOB) listaWynikowaUzytkownikowDTO.add(UzytkownikConverter.uzytOBdoUzytkDTO(uzytkownik)); //zmień każdą instancję UzytkownikOB do instancji DTO

        return listaWynikowaUzytkownikowDTO;//zwróć DTO
    }

    @Override
    public List<UzytkownikDTO> znajdzUzytkownikowPoNazwisku(String aNazwisko) {
        List<UzytkownikDTO> listaWynikowaUzytkownikowDTO = new ArrayList<>();//utworzenie pojemnika
        List<UzytkownikOB> listaUzytkownikowOB = iUzytkownikRepository.findByNazwiskoStartsWith(aNazwisko);//zwróc mi wszystkich użytkowników
        //przepisanie moich użytkowników
        for(UzytkownikOB uzytkownik : listaUzytkownikowOB) listaWynikowaUzytkownikowDTO.add(UzytkownikConverter.uzytOBdoUzytkDTO(uzytkownik)); //zmień każdą instancję UzytkownikOB do instancji DTO

        return listaWynikowaUzytkownikowDTO;//zwróć DTO
    }

    @Override
    public List<UzytkownikDTO> znajdzUzytkownikowPoImieniuINazwisku(String aImie, String aNazwisko) {
        List<UzytkownikDTO> listaWynikowaUzytkownikowDTO = new ArrayList<>();//utworzenie pojemnika
        List<UzytkownikOB> listaUzytkownikowOB = iUzytkownikRepository.findByFullImie(aImie,aNazwisko);
        //przepisanie moich użytkowników
        for(UzytkownikOB uzytkownik : listaUzytkownikowOB) listaWynikowaUzytkownikowDTO.add(UzytkownikConverter.uzytOBdoUzytkDTO(uzytkownik)); //zmień każdą instancję UzytkownikOB do instancji DTO

        return listaWynikowaUzytkownikowDTO;//zwróć DTO
    }

    @Override
    public UzytkownikDTO zapiszUzytkownika(UzytkownikDTO aUzytkownikDTO) throws MyServerException {
        if(aUzytkownikDTO == null){
            throw new MyServerException("Brak pola uzytkownik",HttpStatus.NOT_FOUND,new HttpHeaders());
        }
        RolaDTO pGrupaDTO = aUzytkownikDTO.getRola();
        if(pGrupaDTO == null) {
            throw new MyServerException("Brak pola rola",HttpStatus.NOT_FOUND,new HttpHeaders());
        }

        //sprawdzam czy dany rekord z OB już istnieje

        UzytkownikOB pUzytkownikOB = aUzytkownikDTO.getId() == null ? null : iUzytkownikRepository.findOne(aUzytkownikDTO.getId());
        if(pUzytkownikOB == null){//gdy nie ma takiego to zapisz
            UzytkownikOB pUzytkonikOBEmailVeryfication = aUzytkownikDTO.getEmail() == null ? null : iUzytkownikRepository.znajdzPoEmailu(aUzytkownikDTO.getEmail());
            if(pUzytkonikOBEmailVeryfication != null) throw new MyServerException("Juz jest taki mail",HttpStatus.METHOD_NOT_ALLOWED,new HttpHeaders()); //nie można stworzyć ponieważ już jest taki eamil;
            RolaOB pRolaOB = iRolaRepository.znajdzPoNazwieGrupy("Pracownik");//domyslna rola
            aUzytkownikDTO.setRola(RolaConverter.rolaOBdoRolaDTO(pRolaOB));
            aUzytkownikDTO = UzytkownikConverter.uzytOBdoUzytkDTO(iUzytkownikRepository.save(UzytkownikConverter.uzytDTOdoUzytkOB(aUzytkownikDTO)));//zapisuje
            pUzytkownikOB = UzytkownikConverter.uzytDTOdoUzytkOB(aUzytkownikDTO);//stwórz instancje do przypisania do dziennika
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
            iDziennikPlanowRepository.save(listaDziennikow);//zapisuje listę
            return aUzytkownikDTO;
        }
        //edytuj istniejącego
        RolaOB rolaOB = pGrupaDTO.getId() == null ? null : iRolaRepository.znajdzPoNazwieGrupy(pGrupaDTO.getNazwa());
        if(rolaOB == null ) throw new MyServerException("Nie ma takiej roli!",HttpStatus.NOT_FOUND,new HttpHeaders()); //nie znalazło no to null! xD
        pUzytkownikOB.setRola(rolaOB);
        pUzytkownikOB.setImie(aUzytkownikDTO.getImie());
        pUzytkownikOB.setNazwisko(aUzytkownikDTO.getNazwisko());
        pUzytkownikOB.setEmail(aUzytkownikDTO.getEmail());
        pUzytkownikOB.setHaslo(aUzytkownikDTO.getHaslo());
        pUzytkownikOB.setTelefon(aUzytkownikDTO.getTelefon());
        pUzytkownikOB.setAktywnosc(aUzytkownikDTO.getAktywnosc());
        return UzytkownikConverter.uzytOBdoUzytkDTO(iUzytkownikRepository.save(pUzytkownikOB));
    }

    @Override
    public void usunUzytkownika(Long aId) {
        UzytkownikOB pUzytkownikOB = iUzytkownikRepository.findOne(aId);
        pUzytkownikOB.setAktywnosc(EStan.NIEAKTYWNY);
        iUzytkownikRepository.save(pUzytkownikOB);
    }

    @Override
    public List<UzytkownikDTO> znajdzUzytkownikowPoAktywnosci(EStan aAktywnosc) {
        List<UzytkownikDTO> listaWynikowaUzytkownikowDTO = new ArrayList<>();//utworzenie pojemnika
        List<UzytkownikOB> listaUzytkownikowOB = iUzytkownikRepository.znajdzPoAktywnosci(aAktywnosc);
        //przepisanie moich użytkowników
        for(UzytkownikOB uzytkownik : listaUzytkownikowOB) listaWynikowaUzytkownikowDTO.add(UzytkownikConverter.uzytOBdoUzytkDTO(uzytkownik)); //zmień każdą instancję UzytkownikOB do instancji DTO

        return listaWynikowaUzytkownikowDTO;//zwróć DTO
    }

    @Override
    public List<UzytkownikDTO> znajdzUzytkownikowPoNazwieRoli(String aNazwa) {
        List<UzytkownikOB> listaUzytkownikOB = new ArrayList<>();
        listaUzytkownikOB = iUzytkownikRepository.znajdzPoRoli(aNazwa);
        return UzytkownikConverter.listUzytkOBdoUzytkDTO(listaUzytkownikOB);
    }
}

