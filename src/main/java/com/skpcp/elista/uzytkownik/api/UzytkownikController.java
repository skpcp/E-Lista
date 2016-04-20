package com.skpcp.elista.uzytkownik.api;

import com.skpcp.elista.dziennikplanow.dto.DziennikPlanowDTO;
import com.skpcp.elista.uzytkownik.EStan;
import com.skpcp.elista.uzytkownik.dto.UzytkownikDTO;
import com.skpcp.elista.uzytkownik.service.IUzytkownikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


import java.util.List;

/**
 * Created by Tomek on 2016-03-20.
 */
@RestController
@RequestMapping(value = "elista/uzytkownicy")
public class UzytkownikController {
    @Autowired
    IUzytkownikService serwisUzytkownika;

    @RequestMapping(value = "pobierzPoId/{id}",method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<UzytkownikDTO> znajdzUzytkownikaPoId(@PathVariable("id") Long aId){
        return new ResponseEntity<>(serwisUzytkownika.znajdzUzytkownikaPoId(aId), HttpStatus.OK);
    }

    @RequestMapping(value = "/pobierzWszystkich",method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<UzytkownikDTO>> znajdzWszystkich(){
        return new ResponseEntity<>(serwisUzytkownika.znajdzWszystkichUzytkownikow(),HttpStatus.OK);
    }

    @RequestMapping(value ="/pobierzPoImieniu/{imie}",method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<UzytkownikDTO>> znajdzPoImieniu(@PathVariable("imie")String aImie ){
        return new ResponseEntity<>(serwisUzytkownika.znajdzUzytkownikowPoImieniu(aImie),HttpStatus.OK);
    }

    @RequestMapping(value ="/pobierzPoNazwisku/{nazwisko}",method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<UzytkownikDTO>> znajdzPoNazwisku(@PathVariable("nazwisko")String aNazwisko){
        return new ResponseEntity<>(serwisUzytkownika.znajdzUzytkownikowPoNazwisku(aNazwisko),HttpStatus.OK);
    }

    @RequestMapping(value = "pobierzPoImieniuINazwisku/{imie},{nazwisko}",method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<UzytkownikDTO>> znajdzPoImieniuINazwisku(@PathVariable("imie")String aImie,@PathVariable("nazwisko") String aNazwisko){
        return new ResponseEntity<>(serwisUzytkownika.znajdzUzytkownikowPoImieniuINazwisku(aImie,aNazwisko),HttpStatus.OK);
    }

    @RequestMapping(value = "/zapiszUzytkownika",method = RequestMethod.POST,consumes = "application/json",produces = "application/json")
    @ResponseBody
    public ResponseEntity<UzytkownikDTO> zapiszUzytkownika(@RequestBody UzytkownikDTO aUzytkownikDTO){
      //  List<DziennikPlanowDTO> pDziennikiPlanowDTO = aUzytkownikDTO.getDziennikiPlanow();
      //  pDziennikiPlanowDTO.clear();
        return new ResponseEntity<>(serwisUzytkownika.zapiszUzytkownika(aUzytkownikDTO),HttpStatus.OK);
    }

    @RequestMapping(value = "usunPoId/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<Void> usunUzytkownika(@PathVariable("id")Long aId){
        serwisUzytkownika.usunUzytkownika(aId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "pobierzPoAktywnosci/{aktywnosc}",method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<UzytkownikDTO>> znajdzWszystkichPoAktywnosci(@PathVariable("aktywnosc")EStan aAktywnosc){
        return new ResponseEntity<>(serwisUzytkownika.znajdzUzytkownikowPoAktywnosci(aAktywnosc),HttpStatus.OK);
    }

    @RequestMapping(value = "pobierzPoNazwieGrupy/{grupa.nazwa}",method = RequestMethod.GET)
    public ResponseEntity<List<UzytkownikDTO>> znajdzWszystkichUzytkownikowWGrupie(@PathVariable("grupa.nazwa")String aNazwa){
        return new ResponseEntity<>(serwisUzytkownika.znajdzUzytkownikowPoGrupie(aNazwa),HttpStatus.OK);
    }
}
