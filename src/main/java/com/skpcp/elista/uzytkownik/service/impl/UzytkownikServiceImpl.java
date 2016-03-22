package com.skpcp.elista.uzytkownik.service.impl;

import com.skpcp.elista.utils.UzytkownikConverter;
import com.skpcp.elista.uzytkownik.EStan;
import com.skpcp.elista.uzytkownik.dto.UzytkownikDTO;
import com.skpcp.elista.uzytkownik.ob.UzytkownikOB;
import com.skpcp.elista.uzytkownik.repository.IUzytkownikRepository;
import com.skpcp.elista.uzytkownik.service.IUzytkownikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tomek on 2016-03-20.
 */
@Service
@Transactional
public class UzytkownikServiceImpl implements IUzytkownikService {

    @Autowired
    IUzytkownikRepository iUzytkownikRepository;

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
    public UzytkownikDTO znajdzUzytkownikaPoId(Long aId) {
        UzytkownikOB pUzytkownikOB = iUzytkownikRepository.findOne(aId);//znajdź po ID, i zwróc instancje obiektu UzytkownikOB
        if(pUzytkownikOB == null) return null; //jeżeli nic nie znajdziesz, to oznacza null (wartość domyślną) to zwróc tego nulla
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
    public UzytkownikDTO zapiszUzytkownika(UzytkownikDTO aUzytkownikDTO) {
        if(aUzytkownikDTO == null){
            return null;
        }
        //sprawdzam czy dany rekord z OB już istnieje
        UzytkownikOB pUzytkownikOB = aUzytkownikDTO.getId() == null ? null : iUzytkownikRepository.findOne(aUzytkownikDTO.getId());

        if(pUzytkownikOB == null){//gdy nie ma takiego to zapisz
            return UzytkownikConverter.uzytOBdoUzytkDTO(iUzytkownikRepository.save(UzytkownikConverter.uzytDTOdoUzytkOB(aUzytkownikDTO)));
        }
        //tutaj odwołując się do obiektu pUzytkownikOB mogę zrobić walidację danych po stronie serwera (na OB)
        //edytuj istniejącego
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
        iUzytkownikRepository.delete(aId);
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
    public UzytkownikDTO zmienAktywnoscUzytkownikaPoId(Long aId, EStan aAktywnosc) {
        UzytkownikOB pUzytkownikOB = iUzytkownikRepository.findOne(aId);
        if(pUzytkownikOB == null){
            return null;
        }
        pUzytkownikOB.setAktywnosc(aAktywnosc);
        UzytkownikDTO pUzytkownikDTO = UzytkownikConverter.uzytOBdoUzytkDTO(pUzytkownikOB);
        return pUzytkownikDTO;
    }


    @Override
    public UzytkownikDTO zmienDaneOsobowePoId(Long aId, String aImie, String aNazwisko, String aTelefon) {
        UzytkownikOB pUzytkownikOB = iUzytkownikRepository.findOne(aId);
        if(pUzytkownikOB == null){
            return null;
        }
        pUzytkownikOB.setImie(aImie);
        pUzytkownikOB.setNazwisko(aNazwisko);
        pUzytkownikOB.setTelefon(aTelefon);
        UzytkownikDTO pUzytkownikDTO = UzytkownikConverter.uzytOBdoUzytkDTO(pUzytkownikOB);

        return pUzytkownikDTO;
    }

    @Override
    public UzytkownikDTO zmienDaneDostepuPoId(Long aId, String aEmail, String aHaslo) {
        UzytkownikOB pUzytkownikOB = iUzytkownikRepository.findOne(aId);
        if(pUzytkownikOB == null){
            return null;
        }
        pUzytkownikOB.setEmail(aEmail);
        pUzytkownikOB.setHaslo(aHaslo);
        UzytkownikDTO pUzytkownikDTO = UzytkownikConverter.uzytOBdoUzytkDTO(pUzytkownikOB);

        return pUzytkownikDTO;
    }
}

