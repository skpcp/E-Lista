package com.skpcp.elista.czaspracy.api;

import com.skpcp.elista.czaspracy.dto.*;
import com.skpcp.elista.czaspracy.service.ICzasPracyService;
import com.skpcp.elista.utils.exceptions.MyServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


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
    public ResponseEntity<CzasPracyDTOUzytkownik> zapiszCzasPracy(@RequestBody CzasPracyDTOBezIdTechDate aCzasPracyDTO){
        try {
            return new ResponseEntity<>(serwisCzasPracy.zapiszCzasPracy(aCzasPracyDTO), HttpStatus.OK);
        }catch (MyServerException e){
            return new ResponseEntity<>(e.getHeaders(),e.getStatus());
        }
    }

    @PreAuthorize("#aCzasPracyDTO.uzytkownik == authentication.name AND hasAuthority('PRACOWNIK') OR hasAnyAuthority('ADMIN,LIDER')")
    @RequestMapping(value = "/zapiszCzasPracyWedlugPlanu",method = RequestMethod.POST,consumes = "application/json",produces = "application/json")
    @ResponseBody
    public ResponseEntity<CzasPracyDTOUzytkownik> zapiszCzasPracyWedlugPlanu(@RequestBody CzasPracyDTOWedlugPlanu aCzasPracyDTO){
          try{
              return  new ResponseEntity<>(serwisCzasPracy.zapiszCzasPracyWedlugPlanu(aCzasPracyDTO),HttpStatus.CREATED);
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
}