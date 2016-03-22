package com.skpcp.elista.dziennikplanow.api;
import com.skpcp.elista.dziennikplanow.EDniTygodnia;
import com.skpcp.elista.dziennikplanow.service.IDziennikPlanowService;
import com.skpcp.elista.dziennikplanow.dto.DziennikPlanowDTO;
import com.skpcp.elista.dziennikplanow.service.IDziennikPlanowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


import java.util.Date;
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
    public ResponseEntity<DziennikPlanowDTO> znajdzDziennikPlanowPoId(@PathVariable("id") Long aId) {
        return new ResponseEntity<>(serwisDziennikaPlanow.znajdzDziennikPlanowPoId(aId), HttpStatus.OK);
    }

    @RequestMapping(value = "/pobierzWszystkie", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<DziennikPlanowDTO>> znajdzWszystkieDziennikiPlanow() {
        return new ResponseEntity<>(serwisDziennikaPlanow.znajdzWszystkieDziennikiPlanow(), HttpStatus.OK);
    }

    @RequestMapping(value = "pobierzPoId/{idUzytkownika}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<DziennikPlanowDTO> znajdzDziennikPlanowPoIdUzytkownika(@PathVariable("idUzytkownika") Long aIdUzytkownika) {
        return new ResponseEntity<>(serwisDziennikaPlanow.znajdzDziennikPlanowPoIdUzytkownika(aIdUzytkownika), HttpStatus.OK);

    }
    @RequestMapping(value = "pobierzPoDniuTygodnia/{dzienTygodnia}",method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<DziennikPlanowDTO>> znajdzDziennikPoDniuTygodnia(@PathVariable("dzienTygodnia")EDniTygodnia eDzien){
        return new ResponseEntity<>(serwisDziennikaPlanow.znajdzDziennikPoDniuTygodnia(eDzien),HttpStatus.OK);
    }
    @RequestMapping(value = "/zapiszUzytkownika",method = RequestMethod.POST,consumes = "application/json",produces = "application/json")
    @ResponseBody
    public ResponseEntity<DziennikPlanowDTO> zapiszDziennikPlanow(@RequestBody DziennikPlanowDTO aDziennikPlanowDTO){
        return new ResponseEntity<>(serwisDziennikaPlanow.zapiszDziennikPlanow(aDziennikPlanowDTO),HttpStatus.OK);
    }
    @RequestMapping(value = "usunPoId/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<Void> usunDziennikPlanow(@PathVariable("id")Long aId){
        serwisDziennikaPlanow.usunDziennikPlanow(aId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @RequestMapping(value="zmienDaneDzienikaPoId/{id},{dzienTygodnia},{planOd},{planDo}",method = RequestMethod.POST,consumes = "application/json",produces = "application/json")
    @ResponseBody
    public ResponseEntity<DziennikPlanowDTO> zmienDziennikPlanuPoId(@PathVariable("id")Long aId, @PathVariable("dzienTygodnia") EDniTygodnia aDzien, @PathVariable("planOd") Date aPlanOd, @PathVariable("planDo")Date aPlanDo){
        return new ResponseEntity<>(serwisDziennikaPlanow.zmienDziennikPlanuPoId(aId,aDzien,aPlanOd,aPlanDo),HttpStatus.OK);
    }
    @RequestMapping(value="zmienDaneDzienikaPoIdUzytkownika/{idUzytkownika},{dzienTygodnia},{planOd},{planDo}",method = RequestMethod.POST,consumes = "application/json",produces = "application/json")
    @ResponseBody
    public ResponseEntity<DziennikPlanowDTO> zmienDziennikPlanuPoIdUzytkownika(@PathVariable("idUzytkownika")Long aIdUzytkownika, @PathVariable("dzienTygodnia") EDniTygodnia aDzien, @PathVariable("planOd") Date aPlanOd, @PathVariable("planDo")Date aPlanDo){
        return new ResponseEntity<>(serwisDziennikaPlanow.zmienDziennikPlanuPoIdUzytkownika(aIdUzytkownika,aDzien,aPlanOd,aPlanDo),HttpStatus.OK);
    }

}
