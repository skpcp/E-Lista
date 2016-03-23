package com.skpcp.elista.czaspracy.api;

import com.skpcp.elista.czaspracy.dto.CzasPracyDTO;
import com.skpcp.elista.czaspracy.service.ICzasPracyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * Created by Achilles on 2016-03-22.
 */
@RestController
@Transactional
@RequestMapping(value = "elista/czasPracy")
public class CzasPracyController {
    @Autowired
    ICzasPracyService serwisCzasPracy;

    @RequestMapping(value = "wyswietlPoIdUzytkownika/{idUzytkownika}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<CzasPracyDTO> wyswietlCzasPracyPoIdUzytkownika(@PathVariable("idUzytkownika") Long aIdUzytkownika) {
        return new ResponseEntity<>(serwisCzasPracy.wyswietlCzasPracyPoIdUzytkownika(aIdUzytkownika), HttpStatus.OK);
    }

    @RequestMapping(value = "wprowadzGodzineRozpoczecia/{idUzytkownika},{rozpoczecie}", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    @ResponseBody
    public ResponseEntity<CzasPracyDTO> wprowadzGodzineRozpoczeciaPoIdUzytkownika(@PathVariable("idUzytkownika") Long aIdUzytkownika, @PathVariable("rozpoczecie") Date aRozpoczecie) {
        return new ResponseEntity<>(serwisCzasPracy.wprowadzGodzineRozpoczeciaPoIdUzytkownika(aIdUzytkownika, aRozpoczecie), HttpStatus.OK);
    }

    @RequestMapping(value = "wprowadzGodzineZakonczenia/{idUzytkownika},{zakonczenie}", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    @ResponseBody
    public ResponseEntity<CzasPracyDTO> wprowadzGodzineZakonczeniaPoIdUzytkownika(@PathVariable("idUzytkownika") Long aIdUzytkownika, @PathVariable("zakonczenie") Date aZakonczenie) {
        return new ResponseEntity<>(serwisCzasPracy.wprowadzGodzineZakonczeniaPoIdUzytkownika(aIdUzytkownika, aZakonczenie), HttpStatus.OK);
    }

    @RequestMapping(value = "wprowadzZakresPracy/{idUzytkownika},{zakresPracy}", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    @ResponseBody
    public ResponseEntity<CzasPracyDTO> wprowadzZakresPracyPoIdUzytkownika(@PathVariable("idUzytkownika") Long aIdUzytkownika, @PathVariable("zakresPracy") String aZakresPracy) {
        return new ResponseEntity<>(serwisCzasPracy.wprowadzZakresPracyPoIdUzytkownika(aIdUzytkownika, aZakresPracy), HttpStatus.OK);
    }

    @RequestMapping(value = "wyswietlGodzineRozpoczecia/{idUzytkownika}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<CzasPracyDTO> wyswietlGodzineRozpoczeciaPoIdUzytkownika(@PathVariable("idUzytkownika") Long aIdUzytkownika) {
        return new ResponseEntity<>(serwisCzasPracy.wyswietlGodzineRozpoczeciaPoIdUzytkownika(aIdUzytkownika), HttpStatus.OK);
    }

    @RequestMapping(value = "wyswietlGodzineZakonczenia/{idUzytkownika}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<CzasPracyDTO> wyswietlGodzineZakonczeniaPoIdUzytkownika(@PathVariable("idUzytkownika") Long aIdUzytkownika) {
        return new ResponseEntity<>(serwisCzasPracy.wyswietlGodzineZakonczeniaPoIdUzytkownika(aIdUzytkownika), HttpStatus.OK);
    }

    @RequestMapping(value = "wyswietlZakresPracy/{idUzytkownika}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<CzasPracyDTO> wyswietlZakresPracyPoIdUzytkownika(@PathVariable("idUzytkownika") Long aIdUzytkownika) {
        return new ResponseEntity<>(serwisCzasPracy.wyswietlZakresPracyPoIdUzytkownika(aIdUzytkownika), HttpStatus.OK);
    }
}