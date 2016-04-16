package com.skpcp.elista.nieobecnosci.api;


import com.skpcp.elista.nieobecnosci.dto.NieobecnoscDTO;

import com.skpcp.elista.nieobecnosci.service.INieobecnoscService;
import com.skpcp.elista.utils.CzasPracyConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

/**
 * Created by IGOR on 2016-04-04.
 */
@RestController
@Transactional
@RequestMapping(value = "elista/nieobecnosci")
public class NieobecnoscController {

    @Autowired
    INieobecnoscService serwisNieobecnosc;

    @RequestMapping(value = "pobierzPoId/{id}",method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<NieobecnoscDTO> znajdzNieobecnoscPoId(@PathVariable("id") Long aId){
        return new ResponseEntity<>(serwisNieobecnosc.znajdzNieobecnoscPoId(aId), HttpStatus.OK);
    }

    @RequestMapping(value = "/pobierzWszystkie",method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<NieobecnoscDTO>> znajdzWszystkie(){
        return new ResponseEntity<>(serwisNieobecnosc.znajdzWszystkieNieobecnosci(),HttpStatus.OK);
    }

    @RequestMapping(value ="/pobierzPoIdUzytkownika/{uzytkownik.id}",method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<NieobecnoscDTO>> znajdzPoIdUzytkownika(@PathVariable("uzytkownik.id")Long aId ){
        return new ResponseEntity<>(serwisNieobecnosc.znajdzNieobecnoscPoIdUzytkownika(aId),HttpStatus.OK);
    }

    @RequestMapping(value ="/pobierzPoDacie/{data},{uzytkownik.id}",method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<NieobecnoscDTO> znajdzPoDacie(@PathVariable("data")Date aData,@PathVariable("uzytkownik.id") Long aIdUzytkownika ){
        return new ResponseEntity<>(serwisNieobecnosc.znajdzNieobecnoscPoDacieIUzytkowniku(aData,aIdUzytkownika),HttpStatus.OK);
    }

    @RequestMapping(value ="/pobierzPoTypie/{typ}",method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<NieobecnoscDTO>> znajdzPoTypie(@PathVariable("typ")String aTyp ){
        return new ResponseEntity<>(serwisNieobecnosc.znajdzNieobecnosciPoTypie(aTyp),HttpStatus.OK);
    }

    @RequestMapping(value ="/pobierzPoTypieIUzytkowniku/{typ},{uzytkownik.id}",method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<NieobecnoscDTO>> znajdzPoTypieIUzytkowniku(@PathVariable("typ")String aTyp, @PathVariable("uzytkownik.id") Long aIdUzytkownika ){
        return new ResponseEntity<>(serwisNieobecnosc.znajdzNieobecnosciPoTypieIUzytkowniku(aTyp,aIdUzytkownika),HttpStatus.OK);
    }

    @RequestMapping(value = "/zapiszNieobecnosci",method = RequestMethod.POST,consumes = "application/json",produces = "application/json")
    @ResponseBody
    public ResponseEntity<NieobecnoscDTO> zapiszNieobecnosci(@RequestBody NieobecnoscDTO aNieobecnosciDTO){
        return new ResponseEntity<>(serwisNieobecnosc.zapiszNieobecnosc(aNieobecnosciDTO),HttpStatus.OK);
    }

    @RequestMapping(value = "usunPoId/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<Void> usunNieobecnosci(@PathVariable("id")Long aId){
        serwisNieobecnosc.usunNieobecnosci(aId);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
