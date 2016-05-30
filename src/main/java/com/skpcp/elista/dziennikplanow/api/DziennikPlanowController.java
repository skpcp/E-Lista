package com.skpcp.elista.dziennikplanow.api;
import com.skpcp.elista.dziennikplanow.dto.DziennikPlanowDTOBezTechDate;
import com.skpcp.elista.dziennikplanow.dto.DziennikPlanowDTOBezUzytkownika;
import com.skpcp.elista.dziennikplanow.dto.DziennikPlanowDTOUzytkownik;
import com.skpcp.elista.dziennikplanow.service.IDziennikPlanowService;
import com.skpcp.elista.dziennikplanow.dto.DziennikPlanowDTO;
import com.skpcp.elista.utils.exceptions.MyServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


import java.util.List;
/**
 * Created by bidzis on 2016-03-22.
 */
@RestController
@Transactional
@RequestMapping(value = "elista/dziennikplanow")
public class DziennikPlanowController {
    @Autowired
    IDziennikPlanowService serwisDziennikaPlanow;


    @RequestMapping(value = "pobierzPoId/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<DziennikPlanowDTOUzytkownik> znajdzDziennikPlanowPoId(@PathVariable("id") Long aId) {
        try {
            return new ResponseEntity<>(serwisDziennikaPlanow.znajdzDziennikPlanowPoId(aId), HttpStatus.OK);
        }catch (MyServerException e){
            return new ResponseEntity<>(e.getHeaders(),e.getStatus());
        }
    }

    @RequestMapping(value = "/pobierzWszystkie", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<DziennikPlanowDTOUzytkownik>> znajdzWszystkieDziennikiPlanow() {
        return new ResponseEntity<>(serwisDziennikaPlanow.znajdzWszystkieDziennikiPlanow(), HttpStatus.OK);
    }

    @RequestMapping(value = "pobierzPoUzytkowniku/{uzytkownik.id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<DziennikPlanowDTOBezUzytkownika>> znajdzDziennikiPlanowPoUzytkowniku(@PathVariable("uzytkownik.id") Long aIdUzytkownika) {
     return new ResponseEntity<>(serwisDziennikaPlanow.znajdzDziennikiPlanowPoUzytkowniku(aIdUzytkownika), HttpStatus.OK);
 }

    @PreAuthorize("#aDziennikPlanowDTO.uzytkownik.email == authentication.name AND hasAuthority('PRACOWNIK') OR hasAnyAuthority('ADMIN,LIDER')")
    @RequestMapping(value = "/zapiszDziennikPlanow",method = RequestMethod.POST,consumes = "application/json",produces = "application/json")
    @ResponseBody

    public ResponseEntity<DziennikPlanowDTOUzytkownik> zapiszDziennikPlanow(@RequestBody DziennikPlanowDTOBezTechDate aDziennikPlanowDTO){
        try {
            return new ResponseEntity<>(serwisDziennikaPlanow.zapiszDziennikPlanow(aDziennikPlanowDTO), HttpStatus.OK);
        }catch (MyServerException e)
        {
            return  new ResponseEntity<>(e.getHeaders(),e.getStatus());
        }
    }


  //  @PreAuthorize("hasAnyAuthority('ADMIN,LIDER')")
  //  @RequestMapping(value = "usunPoId/{id}", method = RequestMethod.PUT)
  //  @ResponseBody
  //  public ResponseEntity<Void> usunDziennikPlanow(@PathVariable("id")Long aId){
  //      serwisDziennikaPlanow.usunDziennikPlanow(aId);
  //      return new ResponseEntity<>(HttpStatus.OK);
  //  }
}

