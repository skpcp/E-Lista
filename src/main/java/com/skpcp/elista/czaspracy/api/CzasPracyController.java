package com.skpcp.elista.czaspracy.api;

import com.skpcp.elista.czaspracy.dto.*;
import com.skpcp.elista.czaspracy.service.ICzasPracyService;
import com.skpcp.elista.utils.exceptions.MyServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Achilles on 2016-03-22.
 */
@RestController
@Transactional
@RequestMapping(value = "elista/czasPracy")
public class CzasPracyController {
    @Autowired
    ICzasPracyService serwisCzasPracy;


    @RequestMapping(value = "/pobierzWszystkieCzasyPracyUzytkownika/{uzytkownik.id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<CzasPracyDTOBezUzytkownika>> pobierzCzasPracyUzytkownika(@PathVariable("uzytkownik.id") Long aIdUzytkownika){
        return new ResponseEntity<>(serwisCzasPracy.wyswietlCzasyPracyPoUzytkowniku(aIdUzytkownika),HttpStatus.OK);
    }


    @PreAuthorize("#aCzasPracyDTO.uzytkownik.email == authentication.name AND hasAuthority('PRACOWNIK') OR hasAnyAuthority('ADMIN,LIDER')")
    @RequestMapping(value = "/zapiszCzasPracy",method = RequestMethod.POST,consumes = "application/json",produces = "application/json")
    @ResponseBody
    public ResponseEntity<CzasPracyDTOUzytkownik> zapiszCzasPracy(@RequestBody CzasPracyDTODatyString aCzasPracyDTO){
        SimpleDateFormat dzienPracy = new SimpleDateFormat("YYYY-MM-dd");
        SimpleDateFormat czas = new SimpleDateFormat("HH:mm");
        Date dzien;
        Date rozpoczecie;
        Date zakonczenie;
        try{
               dzien = aCzasPracyDTO.getDzien() == null ? null : dzienPracy.parse(aCzasPracyDTO.getDzien());
               rozpoczecie = aCzasPracyDTO.getRozpoczecie() == null ? null : czas.parse(aCzasPracyDTO.getRozpoczecie());
               zakonczenie = aCzasPracyDTO.getZakonczenie() == null ? null : czas.parse(aCzasPracyDTO.getZakonczenie());
        }catch (ParseException e)
        {

            HttpHeaders hedery = new HttpHeaders();
            hedery.add("stan:","Zly format dat lub czasu");
            return new ResponseEntity<>(hedery,HttpStatus.METHOD_NOT_ALLOWED);
        }
        CzasPracyDTOBezIdTechDate pCzasPracyDTO = new CzasPracyDTOBezIdTechDate(aCzasPracyDTO.getId(),aCzasPracyDTO.getUzytkownikId(),dzien,rozpoczecie,zakonczenie,aCzasPracyDTO.getZakresPracy());
        try {
            return new ResponseEntity<>(serwisCzasPracy.zapiszCzasPracy(pCzasPracyDTO), HttpStatus.OK);
        }catch (MyServerException e){
            return new ResponseEntity<>(e.getHeaders(),e.getStatus());
        }
    }

    @PreAuthorize("#aCzasPracyDTO.uzytkownik == authentication.name AND hasAuthority('PRACOWNIK') OR hasAnyAuthority('ADMIN,LIDER')")
    @RequestMapping(value = "/zapiszCzasPracyWedlugPlanu",method = RequestMethod.POST,consumes = "application/json",produces = "application/json")
    @ResponseBody
    public ResponseEntity<CzasPracyDTOUzytkownik> zapiszCzasPracyWedlugPlanu(@RequestBody CzasPracyDTOPlanString aCzasPracyDTO){
        SimpleDateFormat dzienPracy = new SimpleDateFormat("YYYY-MM-dd");

        Date dzien;

        try{
            dzien = aCzasPracyDTO.getDzien() == null ? null : dzienPracy.parse(aCzasPracyDTO.getDzien());
        }catch (ParseException e)
        {
            HttpHeaders hedery = new HttpHeaders();
            hedery.add("stan:","Zly format dat lub czasu");
            return new ResponseEntity<>(hedery,HttpStatus.METHOD_NOT_ALLOWED);
        }
        CzasPracyDTOWedlugPlanu pCzasPracyDTO = new CzasPracyDTOWedlugPlanu(aCzasPracyDTO.getId(),aCzasPracyDTO.getUzytkownikId(),dzien,aCzasPracyDTO.getZakresPracy());
          try{
              return  new ResponseEntity<>(serwisCzasPracy.zapiszCzasPracyWedlugPlanu(pCzasPracyDTO),HttpStatus.CREATED);
          }catch (MyServerException e){
              return new ResponseEntity<>(e.getHeaders(),e.getStatus());
          }
    }

    @PreAuthorize("hasAnyAuthority('ADMIN,LIDER')")
    @RequestMapping(value = "usunCzasPracy/{id}",method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<Void> usunCzasPracy(@PathVariable("id") Long aId){
            serwisCzasPracy.usunCzasPracy(aId);
            return new ResponseEntity<>(HttpStatus.OK);
    }


    @RequestMapping(value = "pobierzCzasPracy/{id}",method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<CzasPracyDTOUzytkownik> pobierzCzasPracy(@PathVariable("id") Long aId){
        try {
            return new ResponseEntity<>(serwisCzasPracy.znajdzCzasPracyPoId(aId), HttpStatus.OK);
        }catch (MyServerException e){
            return new ResponseEntity<>(e.getHeaders(),e.getStatus());
        }
    }

    @RequestMapping(value = "/pobierzCzasPracyPoDacieIUzytkowniku/{uzytkownik.id},{dzien}",method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<CzasPracyDTOBezUzytkownika> pobierzCzasPracyUzytkownikaPoIdOrazDniu(@PathVariable("uzytkownik.id") Long aId,@PathVariable("dzien") String aDate)
    {
        SimpleDateFormat dzienPracy = new SimpleDateFormat("YYYY-MM-dd");
        Date dzien;
        try {
            dzien = dzienPracy.parse(aDate);
        }catch (ParseException e){
            HttpHeaders hedery = new HttpHeaders();
            hedery.add("stan:","Zly format dat lub czasu");
            return new ResponseEntity<>(hedery,HttpStatus.METHOD_NOT_ALLOWED);
        }

        try{
                return new ResponseEntity<>(serwisCzasPracy.wyswietlCzasPracyUzytkownikaPoDacieIPoUzytkowniku(dzien,aId),HttpStatus.OK);
        }catch (MyServerException e) {
                return new ResponseEntity<>(e.getHeaders(), e.getStatus());
        }

    }
}