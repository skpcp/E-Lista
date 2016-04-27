package com.skpcp.elista.grupa.api;

import com.skpcp.elista.grupa.dto.GrupaBezUDTO;
import com.skpcp.elista.grupa.dto.GrupaDTO;
import com.skpcp.elista.grupa.service.IGrupaService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Tomasz Komoszeski on 2016-04-27.
 */

@RestController
@Transactional
@RequestMapping(value = "elista/grupy")
public class GrupaController {

    @Autowired
    IGrupaService iGrupaService;

    @RequestMapping(value = "/pobierzGrupePoId/{id}", method = RequestMethod.GET)
    @ResponseBody
    ResponseEntity<GrupaDTO> znajdzGrupePoId(@PathVariable("id") Long aId){
        return new ResponseEntity<>(iGrupaService.znajdzGrupePoId(aId), HttpStatus.OK);
    }

    @RequestMapping(value = "/zapiszGrupe",method = RequestMethod.POST,consumes = "application/json",produces = "application/json")
    @ResponseBody
    public ResponseEntity<GrupaDTO> zapiszGrupe(@RequestBody GrupaBezUDTO aGrupa){
        return new ResponseEntity<>(iGrupaService.zapiszGrupe(aGrupa),HttpStatus.OK);
    }

    @RequestMapping(value = "/dodajUzytkownikaDoGrupy/{id}",method = RequestMethod.POST,consumes = "application/json",produces = "application/json")
    @ResponseBody
    public ResponseEntity<GrupaDTO> dodajUzytkownikaDoGrupy(@PathVariable("id") Long aId,Long aIdUzytkownika){
        return new ResponseEntity<>(iGrupaService.dodajUzytkownikDoGrupy(aId,aIdUzytkownika),HttpStatus.OK);
    }

    @RequestMapping(value = "/pobierzGrupePoNazwie/{nazwa}", method = RequestMethod.GET)
    @ResponseBody
    ResponseEntity<GrupaDTO> znajdzGrupePoNazwie(@PathVariable("nazwa") String aNazwa){
        return new ResponseEntity<>(iGrupaService.znajdzGrupePoNazwie(aNazwa), HttpStatus.OK);
    }


    @RequestMapping(value = "/pobierzGrupePoLiderze/{lider.id}", method = RequestMethod.GET)
    @ResponseBody
    ResponseEntity<GrupaDTO> znajdzGrupePoLiderze(@PathVariable("lider.id") Long aId){
        return new ResponseEntity<>(iGrupaService.znajdzGrupePoLiderzeId(aId), HttpStatus.OK);
    }



}
