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

    @RequestMapping(value ="/pobierzPoNazwisku/{nazwisku}",method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<UzytkownikDTO>> znajdzPoNazwisku(@PathVariable("naziwsko")String aNazwisko){
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

    @RequestMapping(value ="zmienPoIdAktywnosc/{id},{aktywnosc}",method = RequestMethod.POST,consumes = "application/json",produces = "application/json")
    @ResponseBody
    public ResponseEntity<UzytkownikDTO> zmienAktywnoscPoId(@PathVariable("id")Long aId,@PathVariable("aktywnosc") EStan aAktywnosc){
        return new ResponseEntity<>(serwisUzytkownika.zmienAktywnoscUzytkownikaPoId(aId,aAktywnosc),HttpStatus.OK);
    }

    @RequestMapping(value="zmienDaneOsobowe/{id},{imie},{nazwisko},{telefon}",method = RequestMethod.POST,consumes = "application/json",produces = "application/json")
    @ResponseBody
    public ResponseEntity<UzytkownikDTO> zmienDaneOsobowePoId(@PathVariable("id")Long aId,@PathVariable("imie") String aImie,@PathVariable("nazwisko") String aNazwisko, @PathVariable("telefon")String aTelefon){
        return new ResponseEntity<>(serwisUzytkownika.zmienDaneOsobowePoId(aId,aImie,aNazwisko,aTelefon),HttpStatus.OK);
    }

    @RequestMapping(value="zmienDaneDostepuPoId/{id},{email},{haslo}",method = RequestMethod.POST,consumes = "application/json",produces = "application/json")
    @ResponseBody
    public ResponseEntity<UzytkownikDTO> zmienDaneDostepuPoId(@PathVariable("id")Long aId,@PathVariable("email") String aEmail,@PathVariable("haslo") String aHaslo){
        return new ResponseEntity<>(serwisUzytkownika.zmienDaneDostepuPoId(aId,aEmail,aHaslo),HttpStatus.OK);
    }

}
