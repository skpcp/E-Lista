package com.skpcp.elista.nieobecnosci.api;

import com.skpcp.elista.nieobecnosci.EJednostka;
import com.skpcp.elista.nieobecnosci.dto.NieobecnosciDTO;
import com.skpcp.elista.nieobecnosci.service.INieobecnosciService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created by IGOR on 2016-04-04.
 */
@RestController
@Transactional
@RequestMapping(value = "elista/nieobecnosci")
public class NieobecnosciController {
    @Autowired
    INieobecnosciService serwisNieobecnosci;

    @RequestMapping(value = "pobierzPoId/{id}",method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<NieobecnosciDTO> znajdzNieobecnoscPoId(@PathVariable("id") Long aId){
        return new ResponseEntity<>(serwisNieobecnosci.znajdzNieobecnoscPoId(aId), HttpStatus.OK);
    }

    @RequestMapping(value = "/pobierzWszystkie",method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<NieobecnosciDTO>> znajdzWszystkie(){
        return new ResponseEntity<>(serwisNieobecnosci.znajdzWszystkieNieobecnosci(),HttpsStatus.OK);
    }
    @RequestMapping(value ="/pobierzPoIdUzytkownika/{idUzytkownika}",method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<NieobecnosciDTO>> znajdzPoIdUzytkownika(@PathVariable("IdUzytkownika")Long aID ){
        return new ResponseEntity<>(serwisNieobecnosci.znajdzNieobecnoscPoId(aID),HttpStatus.OK);
    }
    @RequestMapping(value ="/pobierzPoDacie/{Data}",method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<NieobecnosciDTO>> znajdzPoDacie(@PathVariable("Data")Date aID ){
        return new ResponseEntity<>(serwisNieobecnosci.znajdzNieobecnoscPoDacie(aID),HttpStatus.OK);
    }
    @RequestMapping(value ="/pobierzPoTypie/{Typ}",method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<NieobecnosciDTO>> znajdzPoTypie(@PathVariable("Typ")EJednostka aID ){
        return new ResponseEntity<>(serwisNieobecnosci.znajdzNieobecnoscPoTypie(aID),HttpStatus.OK);
    }
    @RequestMapping(value = "/zapiszNieobecnosci",method = RequestMethod.POST,consumes = "application/json",produces = "application/json")
    @ResponseBody
    public ResponseEntity<NieobecnosciDTO> zapiszNieobecnosci(@RequestBody NieobecnosciDTO aNieobecnosciDTO){
        return new ResponseEntity<>(serwisNieobecnosci.zapiszNieobecnosci(aNieobecnosciDTO),HttpStatus.OK);
    }

    @RequestMapping(value = "usunPoId/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<Void> usunNieobecnosci(@PathVariable("id")Long aId){
        serwisNieobecnosci.usunNieobecnosci(aId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @RequestMapping(value ="zmienPoTypie/{id},{Typ}",method = RequestMethod.POST,consumes = "application/json",produces = "application/json")
    @ResponseBody
    public ResponseEntity<NieobecnosciDTO> zmienNieobecnoscPoTypie(@PathVariable("id")EJednostka aId,@PathVariable("Typ") EJednostka aTyp){
        return new ResponseEntity<>(serwisNieobecnosci.zmienDateNieobecnosciPoId(aId,aNieobecnosci),HttpStatus.OK);
    }
    @RequestMapping(value ="zmienPoIlosci/{id},{ilosc}",method = RequestMethod.POST,consumes = "application/json",produces = "application/json")
    @ResponseBody
    public ResponseEntity<NieobecnosciDTO> zmienNieobecnoscPoIlosci(@PathVariable("id")Integer aId,@PathVariable("ilosc") Integer aIlosc){
        return new ResponseEntity<>(serwisNieobecnosci.zmienIloscNieobecnosciPoId(aId,aNieobecnosci),HttpStatus.OK);
    }
    @RequestMapping(value ="zmienPoDacie/{id},{data}",method = RequestMethod.POST,consumes = "application/json",produces = "application/json")
    @ResponseBody
    public ResponseEntity<NieobecnosciDTO> zmienNieobecnoscPoDacie(@PathVariable("id")Date aId, @PathVariable("data") Date aData){
        return new ResponseEntity<>(serwisNieobecnosci.zmienDateNieobecnosciPoId(aId,aNieobecnosci),HttpStatus.OK);
    }
    







}
