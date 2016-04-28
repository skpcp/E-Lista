package com.skpcp.elista.czaspracy.api;

import com.skpcp.elista.czaspracy.dto.CzasPracyDTO;
import com.skpcp.elista.czaspracy.service.ICzasPracyService;
import com.skpcp.elista.utils.exceptions.MyServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<CzasPracyDTO>> pobierzCzasPracyUzytkownika(@PathVariable("uzytkownik.id") Long aIdUzytkownika){
        return new ResponseEntity<>(serwisCzasPracy.wyswietlCzasyPracyPoUzytkowniku(aIdUzytkownika),HttpStatus.OK);
    }

   

    @RequestMapping(value = "/zapiszCzasPracy",method = RequestMethod.POST,consumes = "application/json",produces = "application/json")
    @ResponseBody
    public ResponseEntity<CzasPracyDTO> zapiszCzasPracy(@RequestBody CzasPracyDTO aCzasPracyDTO){
        try {
            return new ResponseEntity<>(serwisCzasPracy.zapiszCzasPracy(aCzasPracyDTO), HttpStatus.OK);
        }catch (MyServerException e){
            return new ResponseEntity<>(e.getHeaders(),e.getStatus());
        }
    }


    @RequestMapping(value = "/zapiszCzasPracyWedlugPlanu",method = RequestMethod.POST,consumes = "application/json",produces = "application/json")
    @ResponseBody
    public ResponseEntity<CzasPracyDTO> zapiszCzasPracyWedlugPlanu(@RequestBody CzasPracyDTO aCzasPracyDTO){
          try{
              return  new ResponseEntity<>(serwisCzasPracy.zapiszCzasPracyWedlugPlanu(aCzasPracyDTO),HttpStatus.CREATED);
          }catch (MyServerException e){
              return new ResponseEntity<>(e.getHeaders(),e.getStatus());
          }
    }

    @RequestMapping(value = "usunCzasPracy/{id}",method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<Void> usunCzasPracy(@PathVariable("id") Long aId){
            serwisCzasPracy.usunCzasPracy(aId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "pobierzCzasPracy/{id}",method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<CzasPracyDTO> pobierzCzasPracy(@PathVariable("id") Long aId){
        try {
            return new ResponseEntity<>(serwisCzasPracy.znajdzCzasPracyPoId(aId), HttpStatus.OK);
        }catch (MyServerException e){
            return new ResponseEntity<>(e.getHeaders(),e.getStatus());
        }
    }
}