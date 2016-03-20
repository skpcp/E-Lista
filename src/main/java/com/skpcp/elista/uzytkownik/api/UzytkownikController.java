package com.skpcp.elista.uzytkownik.api;

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
@Transactional
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
        return new ResponseEntity<>(serwisUzytkownika.znajdzUzytkownikaPoImieniu(aImie),HttpStatus.OK);
    }

    @RequestMapping(value ="/pobierzPoNazwisku/{nazwisku}",method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<UzytkownikDTO>> znajdzPoNazwisku(@PathVariable("naziwsko")String aNazwisko){
        return new ResponseEntity<>(serwisUzytkownika.znajdzUzytkownikaPoNazwisku(aNazwisko),HttpStatus.OK);
    }

    @RequestMapping(value = "pobierzPoImieniuINazwisku/{imie},{nazwisko}",method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<UzytkownikDTO>> znajdzPoImieniuINazwisku(@PathVariable("imie")String aImie,@PathVariable("nazwisko") String aNazwisko){
        return new ResponseEntity<>(serwisUzytkownika.znajdzUzytkownikaPoImieniuINazwisku(aImie,aNazwisko),HttpStatus.OK);
    }
}
