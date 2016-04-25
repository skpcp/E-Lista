package com.skpcp.elista.czaspracy.api;

import com.skpcp.elista.czaspracy.dto.CzasPracyDTO;
import com.skpcp.elista.czaspracy.service.ICzasPracyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.http.HTTPException;
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

   
//    @PreAuthorize("#aCzasPracyDTO.uzytkownik.email == authentication.name OR hasAuthority('ADMIN')")
    @RequestMapping(value = "/zapiszCzasPracy",method = RequestMethod.POST,consumes = "application/json",produces = "application/json")
    @ResponseBody
    public ResponseEntity<CzasPracyDTO> zapiszCzasPracy(@RequestBody CzasPracyDTO aCzasPracyDTO){
        return  new ResponseEntity<>(serwisCzasPracy.zapiszCzasPracy(aCzasPracyDTO),HttpStatus.OK);
    }

    @RequestMapping(value = "/zapiszCzasPracyWedlugPlanu",method = RequestMethod.POST,consumes = "application/json",produces = "application/json")
    @ResponseBody
    public ResponseEntity<CzasPracyDTO> zapiszCzasPracyWedlugPlanu(@RequestBody CzasPracyDTO aCzasPracyDTO){
        return  new ResponseEntity<>(serwisCzasPracy.zapiszCzasPracyWedlugPlanu(aCzasPracyDTO),HttpStatus.OK);
    }

    @RequestMapping(value = "usunCzasPracy/{id}",method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<Void> usunCzasPracy(@PathVariable("id") Long aId){
        serwisCzasPracy.usunCzasPracy(aId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "pobierzCzasPracy/{id}",method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<CzasPracyDTO> pobierzCzasPracy(@PathVariable("id") Long aId){
        return new ResponseEntity<>(serwisCzasPracy.znajdzCzasPracyPoId(aId),HttpStatus.OK);
    }
}