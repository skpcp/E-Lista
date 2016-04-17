package com.skpcp.elista.uzytkownik.service.impl;

import com.skpcp.elista.dziennikplanow.ob.DziennikPlanowOB;
import com.skpcp.elista.dziennikplanow.repository.IDziennikPlanowRepository;
import com.skpcp.elista.grupa.dto.GrupaDTO;
import com.skpcp.elista.grupa.respository.IGrupaRespository;
import com.skpcp.elista.utils.DziennikPlanowConverter;
import com.skpcp.elista.utils.UzytkownikConverter;
import com.skpcp.elista.uzytkownik.EStan;
import com.skpcp.elista.uzytkownik.dto.UzytkownikDTO;
import com.skpcp.elista.uzytkownik.ob.UzytkownikOB;
import com.skpcp.elista.uzytkownik.repository.IUzytkownikRepository;
import com.skpcp.elista.uzytkownik.service.IUzytkownikService;
import org.springframework.beans.factory.annotation.Autowired;
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
    IGrupaRespository iGrupaRespository;
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
        GrupaDTO pGrupaDTO = aUzytkownikDTO.getGrupa();
        if(pGrupaDTO == null) {
            return null;
        }
        //sprawdzam czy dany rekord z OB już istnieje
        UzytkownikOB pUzytkownikOB = aUzytkownikDTO.getId() == null ? null : iUzytkownikRepository.findOne(aUzytkownikDTO.getId());
        if(pUzytkownikOB == null){//gdy nie ma takiego to zapisz
            aUzytkownikDTO = UzytkownikConverter.uzytOBdoUzytkDTO(iUzytkownikRepository.save(UzytkownikConverter.uzytDTOdoUzytkOB(aUzytkownikDTO)));//zapisuje
            pUzytkownikOB = UzytkownikConverter.uzytDTOdoUzytkOB(aUzytkownikDTO);//stwórz instancje do przypisania do dziennika
            //przepisz wiadomo

            //tworzenia pięciu standardowych dzienników planów

            SimpleDateFormat pMojFormat = new SimpleDateFormat("hh:mm");
            String nGodzinaOd = "8:00";
            String nGodzinaDo = "15:00";
            Date dPoczatekPracy;
            Date dKoniecPracy;

            try {
                dPoczatekPracy = DziennikPlanowConverter.fCzas.parse(nGodzinaOd);
                dKoniecPracy = DziennikPlanowConverter.fCzas.parse(nGodzinaDo);
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
        //TO DO dopisać usuwanie dzienników
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

