package com.skpcp.elista.grupa.api;

import com.skpcp.elista.grupa.dto.*;
import com.skpcp.elista.grupa.service.IGrupaService;
import com.skpcp.elista.utils.exceptions.MyServerException;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    ResponseEntity<GrupaDTOUzytkownik> znajdzGrupePoId(@PathVariable("id") Long aId){
        try {
            return new ResponseEntity<>(iGrupaService.znajdzGrupePoId(aId), HttpStatus.OK);
        }catch (MyServerException e){
            return  new ResponseEntity<>(e.getHeaders(),e.getStatus());
        }
    }

    @PreAuthorize("hasAuthority('ADMIN') OR aGrupa.lider.email == authentication.name AND hasAuthority('LIDER')")
    @RequestMapping(value = "/zapiszGrupe",method = RequestMethod.POST,consumes = "application/json",produces = "application/json")
    @ResponseBody
    public ResponseEntity<GrupaDTOUzytkownik> zapiszGrupe(@RequestBody GrupaDTOBezIdTechDate aGrupa){
        try {
            return new ResponseEntity<>(iGrupaService.zapiszGrupe(aGrupa), HttpStatus.OK);
        }catch (MyServerException e){
            return new ResponseEntity<>(e.getHeaders(),e.getStatus());
        }
    }


    @RequestMapping(value = "/pobierzGrupePoNazwie/{nazwa}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<GrupaDTOUzytkownik> znajdzGrupePoNazwie(@PathVariable("nazwa") String aNazwa){
        try{
        return new ResponseEntity<>(iGrupaService.znajdzGrupePoNazwie(aNazwa), HttpStatus.OK);
        }catch (MyServerException e){
            return new ResponseEntity<>(e.getHeaders(),e.getStatus());
        }
    }

    @RequestMapping(value = "/pobierzGrupePoLiderze/{lider.id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<GrupaDTOBezLiderAleZIdTechDate>> znajdzGrupePoLiderze(@PathVariable("lider.id") Long aId){
        try{
        return new ResponseEntity<>(iGrupaService.znajdzGrupePoIdLidera(aId), HttpStatus.OK);
        }catch(MyServerException e){
            return new ResponseEntity<>(e.getHeaders(),e.getStatus());
        }
    }

    @RequestMapping(value = "/pobierzGrupePoEmailuLidera/{lider.email}",method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<GrupaDTOBezLiderAleZIdTechDate>> znajdzGrupePoEmailuLidera(@PathVariable("lider.email") String aEmail){
        return new ResponseEntity<>(iGrupaService.znajdzGrupePoNazwieLidera(aEmail),HttpStatus.OK);
    }

    @RequestMapping(value = "/usunGrupePoId/{id}",method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<Void> usunGrupePoId(@PathVariable("id")Long aId){
        iGrupaService.usunGrupePoId(aId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/pobierzWszystkieGrupy",method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<GrupaDTOUzytkownik>> znajdzWszystkieGrupy(){
        return new ResponseEntity<>(iGrupaService.znajdzWszystkieGrupy(),HttpStatus.OK);
    }

}
