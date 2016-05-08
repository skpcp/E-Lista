package com.skpcp.elista.uzytkownik.api;

import com.skpcp.elista.utils.exceptions.MyServerException;
import com.skpcp.elista.uzytkownik.EStan;
import com.skpcp.elista.uzytkownik.dto.*;
import com.skpcp.elista.uzytkownik.service.IUzytkownikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Created by Tomek on 2016-03-20.
 */
@RestController
@RequestMapping(value = "/elista/uzytkownicy")
public class UzytkownikController {
    @Autowired
    IUzytkownikService serwisUzytkownika;



    @RequestMapping(value = "pobierzPoId/{id}",method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<UzytkownikDTOBezHasla> znajdzUzytkownikaPoId(@PathVariable("id") Long aId){
        try{
        return new ResponseEntity<>(serwisUzytkownika.znajdzUzytkownikaPoId(aId), HttpStatus.OK);
        }catch (MyServerException e){
            return new ResponseEntity<>(e.getHeaders(),e.getStatus());
        }
    }


    @RequestMapping(value = "/pobierzWszystkich",method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<UzytkownikDTOBezHasla>> znajdzWszystkich(){
        return new ResponseEntity<>(serwisUzytkownika.znajdzWszystkichUzytkownikow(),HttpStatus.OK);
    }

    @RequestMapping(value ="/pobierzPoImieniu/{imie}",method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<UzytkownikDTOBezHasla>> znajdzPoImieniu(@PathVariable("imie")String aImie ){
        return new ResponseEntity<>(serwisUzytkownika.znajdzUzytkownikowPoImieniu(aImie),HttpStatus.OK);
    }

    @RequestMapping(value ="/pobierzPoNazwisku/{nazwisko}",method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<UzytkownikDTOBezHasla>> znajdzPoNazwisku(@PathVariable("nazwisko")String aNazwisko){
        return new ResponseEntity<>(serwisUzytkownika.znajdzUzytkownikowPoNazwisku(aNazwisko),HttpStatus.OK);
    }

    @RequestMapping(value = "pobierzPoImieniuINazwisku/{imie},{nazwisko}",method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<UzytkownikDTOBezHasla>> znajdzPoImieniuINazwisku(@PathVariable("imie")String aImie,@PathVariable("nazwisko") String aNazwisko){
        return new ResponseEntity<>(serwisUzytkownika.znajdzUzytkownikowPoImieniuINazwisku(aImie,aNazwisko),HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/zapiszUzytkownika",method = RequestMethod.POST,consumes = "application/json",produces = "application/json")
    @ResponseBody
    public ResponseEntity<UzytkownikDTOBezHasla> zapiszUzytkownika(@RequestBody UzytkownikDTOBezIdTechDate aUzytkownikDTO){
        try {
            return new ResponseEntity<>(serwisUzytkownika.zapiszUzytkownika(aUzytkownikDTO), HttpStatus.CREATED);
        }catch (MyServerException e) {
            return new ResponseEntity<>(e.getHeaders(),e.getStatus());
        }
    }


    @RequestMapping(value = "/zarejestrujUzytkownika",method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<UzytkownikDTOBezRoliGrupy> zarejestrujUzytkownika(@RequestBody UzytkownikDTOBezRoliGrupyZHaslem aUzytkownikDTO)
    {
        try{
            return new ResponseEntity<>(serwisUzytkownika.rejestracjaUzytkownika(aUzytkownikDTO),HttpStatus.CREATED);
        } catch (MyServerException e){
            return new ResponseEntity<>(e.getHeaders(),e.getStatus());
        }
    }

    @RequestMapping(value = "dezaktywujPoId/{id}", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Void> dezaktywujPoId(@PathVariable("id")Long aId){
        serwisUzytkownika.dezaktywujUzytkownika(aId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @RequestMapping(value = "aktywujPoId/{id}", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Void> aktywujUzytkownika(@PathVariable("id")Long aId) {
        try{
            serwisUzytkownika.aktywujUzytkownika(aId);
            return new ResponseEntity<Void>(HttpStatus.CREATED);
        }catch (MyServerException e){
            return new ResponseEntity<Void>(e.getHeaders(),e.getStatus());
        }

    }

    @RequestMapping(value = "pobierzPoAktywnosci/{aktywnosc}",method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<UzytkownikDTOBezHasla>> znajdzWszystkichPoAktywnosci(@PathVariable("aktywnosc")EStan aAktywnosc){
        return new ResponseEntity<>(serwisUzytkownika.znajdzUzytkownikowPoAktywnosci(aAktywnosc),HttpStatus.OK);
    }

    @RequestMapping(value = "pobierzPoNazwieRoli/{rola.nazwa}",method = RequestMethod.GET)
    public ResponseEntity<List<UzytkownikDTOBezHasla>> znajdzWszystkichUzytkownikowPoNazwieRoli(@PathVariable("rola.nazwa")String aNazwa){
        return new ResponseEntity<>(serwisUzytkownika.znajdzUzytkownikowPoNazwieRoli(aNazwa),HttpStatus.OK);
    }

    @RequestMapping(value = "pobierzPoEmailuId/{email}",method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<UzytkownikDTOBezHasla> znajdzUzytkownikaPoEmailu(@PathVariable("email") String aEmail){
        try{
            return new ResponseEntity<>(serwisUzytkownika.znajdzUzytkownikaPoEmailu(aEmail), HttpStatus.OK);
        }catch (MyServerException e){
            return new ResponseEntity<>(e.getHeaders(),e.getStatus());
        }

    }

    @RequestMapping(value = "zmienAdresEmail/{id},{email}",method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<UzytkownikDTOBezHasla> zmienAdresEmailUzytkownika(@PathVariable("id") Long aIdUzytkownika,@PathVariable("email") String aEmial){
        try{
            return new ResponseEntity<>(serwisUzytkownika.zmienAdresEmailUzytkownika(aIdUzytkownika,aEmial),HttpStatus.OK);
        }catch (MyServerException e){
            return new ResponseEntity<>(e.getHeaders(),e.getStatus());
        }
    }


    @RequestMapping(value = "zmienHaslo/{id},{haslo}",method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Void> zmienHasloUzytkownika(@PathVariable("id") Long aIdUzytkownika,@PathVariable("haslo") String aHaslo){
       try{
           serwisUzytkownika.zmienHasloUzytkownika(aIdUzytkownika, aHaslo);
           return new ResponseEntity<>(HttpStatus.OK);
       }catch (MyServerException e){
           return new ResponseEntity<>(e.getHeaders(),e.getStatus());
       }
    }


    @RequestMapping(value = "pobierzPoUzytkownikowPoNazwieGrupy/{grupa.nazwa}",method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<UzytkownikDTOBezHasla>> znajdzUzytkownikowPoNazwieGrupy(@PathVariable("grupa.nazwa") String aNazwaGrupy){
        return new ResponseEntity<>(serwisUzytkownika.znajdzUzytkownikowPoNazwieGrupy(aNazwaGrupy),HttpStatus.OK);
    }


    @RequestMapping(value = "pobierzPoUzytkownikowPoIdGrupy/{grupa.id}",method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<UzytkownikDTOBezHasla>> znajdzUzytkownikowPoIdGrupy(@PathVariable("grupa.id") Long aIdGrupy){
        return new ResponseEntity<>(serwisUzytkownika.znajdzUzytkownikowPoIdGrupy(aIdGrupy),HttpStatus.OK);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN,LIDER')")
    @RequestMapping(value = "pobierzUzytkownikowPoGrupieIPoAktywnosci/{grupa.nazwa},{aktywnosc}",method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<UzytkownikDTOBezHasla>> znajdzUzytkownikowPoNazwieGrupyOrazPoAktywnosci(@PathVariable("grupa")String aGrupaNazwa,@PathVariable("aktywnosc") EStan aAktywnosc){
            return new ResponseEntity<>(serwisUzytkownika.znajdzUzytkownikowWGrupiePoAktywnosci(aGrupaNazwa,aAktywnosc),HttpStatus.OK);
        }

    @RequestMapping(value = "/zmienGrupeUzytkownika/{id},{grupa.nazwa}",method = RequestMethod.POST,consumes = "application/json",produces = "application/json")
    @ResponseBody
    public ResponseEntity<UzytkownikDTOBezHasla> zmienGrupeUzytkownika(@PathVariable("id") Long aIdUzytkownika, @PathVariable("grupa.nazwa") String aNazwaGrupy){
        try{
            return new ResponseEntity<>(serwisUzytkownika.ustawGrupeDlaUzytkownika(aIdUzytkownika,aNazwaGrupy),HttpStatus.OK);
        }catch (MyServerException e){
            return new ResponseEntity<>(e.getHeaders(),e.getStatus());
        }
    }

}
