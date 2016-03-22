package com.skpcp.elista.grupy.api;

import com.skpcp.elista.grupy.dto.GrupyDTO;
import com.skpcp.elista.grupy.service.IGrupyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by padyyajs on 22.03.2016.
 */

@RestController
@Transactional
@RequestMapping(value = "elista/grupy")

public class GrupyController
{
    @Autowired
    IGrupyService serwisGrupy;

    @RequestMapping(value = "znajdzGrupePoNazwie/{nazwaGrupy}",method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity <GrupyDTO> znajdzGrupePoNazwie(@PathVariable("nazwaGrupy") Long anazwaGrupy)
    {
        return new ResponseEntity<>(serwisGrupy.znajdzGrupePoNazwie(anazwaGrupy), HttpStatus.OK);
    }
    @RequestMapping(value = "/pobierzWszystkieGrupy", method = RequestMethod.GET)
    @ResponseBody

    public ResponseEntity<List<GrupyDTO>>znajdzWszystkieGrupy()
    {
        return new ResponseEntity<>(serwisGrupy.znajdzWszystkieGrupy(), HttpStatus.OK);
    }
    @RequestMapping(value ="/pobierzUzytkownikaPoGrupie/{id}",method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<GrupyDTO>> znajdzUzytkownikaPoGrupie (@PathVariable("id") Long aId, String anazwaGrupy )
    {
        return new ResponseEntity<>(serwisGrupy.znajdzUzytkownikaPoGrupie(aId, anazwaGrupy),HttpStatus.OK );
    }

    @RequestMapping(value = "usunGrupe/{nazwaGrupy}", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<Void> usunGrupe(@PathVariable("nazwaGrupy")String anazwaGrupy)
    {
        serwisGrupy.usunGrupe(anazwaGrupy);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/zapiszGrupe",method = RequestMethod.POST,consumes = "application/json",produces = "application/json")
    @ResponseBody
    public ResponseEntity<GrupyDTO> zapiszGrupe (@RequestBody GrupyDTO aGrupyDTO)
    {
        return new ResponseEntity<>(serwisGrupy.zapiszGrupe(aGrupyDTO),HttpStatus.OK);
    }
}





