package com.skpcp.elista.nieobecnosci.api;


import com.skpcp.elista.nieobecnosci.dto.*;

import com.skpcp.elista.nieobecnosci.service.INieobecnoscService;
import com.skpcp.elista.utils.exceptions.MyServerException;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
    public ResponseEntity<NieobecnoscDTOUzytkownik> znajdzNieobecnoscPoId(@PathVariable("id") Long aId){
        try {
            return new ResponseEntity<>(serwisNieobecnosc.znajdzNieobecnoscPoId(aId), HttpStatus.OK);
        }catch (MyServerException e){
            return new ResponseEntity<>(e.getHeaders(),e.getStatus());
        }
    }

    @RequestMapping(value = "/pobierzWszystkie",method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<NieobecnoscDTOUzytkownik>> znajdzWszystkie(){
        return new ResponseEntity<>(serwisNieobecnosc.znajdzWszystkieNieobecnosci(),HttpStatus.OK);
    }

    @RequestMapping(value ="/pobierzPoIdUzytkownika/{uzytkownik.id}",method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<NieobecnoscDTOUzytkownik>> znajdzPoIdUzytkownika(@PathVariable("uzytkownik.id")Long aId ){
        return new ResponseEntity<>(serwisNieobecnosc.znajdzNieobecnoscPoIdUzytkownika(aId),HttpStatus.OK);
    }

    @RequestMapping(value ="/pobierzPoDacie/{data},{uzytkownik.id}",method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<NieobecnoscDTOBezUzytkownika> znajdzPoDacie(@PathVariable("data") String aData, @PathVariable("uzytkownik.id") Long aIdUzytkownika ){
        SimpleDateFormat dzienPracy = new SimpleDateFormat("YYYY-MM-dd");
        DateTime jodaData;
        Date dzienWalidacja;
        Date dzien;

        try{
            dzienWalidacja = dzienPracy.parse(aData);
            jodaData = DateTime.parse(aData, DateTimeFormat.forPattern("YYYY-MM-dd"));
            dzien = jodaData.toDate();

        }catch (ParseException e)
        {
            HttpHeaders hedery = new HttpHeaders();
            hedery.add("stan:","Zly format daty");
            return new ResponseEntity<>(hedery,HttpStatus.METHOD_NOT_ALLOWED);
        }catch (IllegalArgumentException e){
            HttpHeaders hedery = new HttpHeaders();
            hedery.add("stan:","Zly format dat lub czasu");
            return new ResponseEntity<>(hedery,HttpStatus.METHOD_NOT_ALLOWED);
        }
        try{
        return new ResponseEntity<>(serwisNieobecnosc.znajdzNieobecnoscPoDacieIUzytkowniku(dzien,aIdUzytkownika),HttpStatus.OK);
        }catch (MyServerException e){
            return new ResponseEntity<>(e.getHeaders(),e.getStatus());
        }
    }

    @RequestMapping(value ="/pobierzPoTypie/{typ}",method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<NieobecnoscDTOUzytkownik>> znajdzPoTypie(@PathVariable("typ")String aTyp ){
        return new ResponseEntity<>(serwisNieobecnosc.znajdzNieobecnosciPoTypie(aTyp),HttpStatus.OK);
    }

    @RequestMapping(value ="/pobierzPoTypieIUzytkowniku/{typ},{uzytkownik.id}",method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<NieobecnoscDTOBezUzytkownika>> znajdzPoTypieIUzytkowniku(@PathVariable("typ")String aTyp, @PathVariable("uzytkownik.id") Long aIdUzytkownika ){
        return new ResponseEntity<>(serwisNieobecnosc.znajdzNieobecnosciPoTypieIUzytkowniku(aTyp,aIdUzytkownika),HttpStatus.OK);
    }
    @PreAuthorize("#aNieobecnosciDTO.uzytkownik.email == authentication.name AND hasAuthority('PRACOWNIK') OR hasAnyAuthority('ADMIN,LIDER')")
    @RequestMapping(value = "/zapiszNieobecnosci",method = RequestMethod.POST,consumes = "application/json",produces = "application/json")
    @ResponseBody
    public ResponseEntity<NieobecnoscDTOUzytkownik> zapiszNieobecnosci(@RequestBody NieobecnoscDTOString aNieobecnosciDTO){
        SimpleDateFormat dzienPracy = new SimpleDateFormat("YYYY-MM-dd");
        DateTime jodaData;
        Date dzienWalidacja;
        Date dzien;

        try{
            dzienWalidacja = aNieobecnosciDTO.getData() == null ? null : dzienPracy.parse(aNieobecnosciDTO.getData());
            jodaData = aNieobecnosciDTO.getData() == null ? null : DateTime.parse(aNieobecnosciDTO.getData(), DateTimeFormat.forPattern("YYYY-MM-dd"));
            dzien = jodaData.toDate();

        }catch (ParseException e)
        {
            HttpHeaders hedery = new HttpHeaders();
            hedery.add("stan:","Zly format dat lub czasu");
            return new ResponseEntity<>(hedery,HttpStatus.METHOD_NOT_ALLOWED);
        }catch (IllegalArgumentException e){
            HttpHeaders hedery = new HttpHeaders();
            hedery.add("stan:","Zly format dat lub czasu");
            return new ResponseEntity<>(hedery,HttpStatus.METHOD_NOT_ALLOWED);
        }
        NieobecnoscDTOBezTechDate pNieboecnoscDTO = new NieobecnoscDTOBezTechDate(aNieobecnosciDTO.getId(),aNieobecnosciDTO.getUzytkownikId(),dzien,aNieobecnosciDTO.getIlosc(),aNieobecnosciDTO.getTyp());
        try
        {
            return new ResponseEntity<>(serwisNieobecnosc.zapiszNieobecnosc(pNieboecnoscDTO),HttpStatus.OK);
        }catch (MyServerException e){
            return new ResponseEntity<>(e.getHeaders(),e.getStatus());
        }
    }

    @RequestMapping(value = "usunPoId/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<Void> usunNieobecnosci(@PathVariable("id")Long aId){
        serwisNieobecnosc.usunNieobecnosci(aId);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
