package com.skpcp.elista.grupy.api;


import com.skpcp.elista.grupy.dto.GrupaDTO;
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
public class GrupaController
{
    @Autowired
    IGrupyService serwisGrupy;

    @RequestMapping(value = "znajdzGrupePoNazwie/{nazwa}",method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity <GrupaDTO> znajdzGrupePoNazwie(@PathVariable("nazwa") String aNazwa)
    {
        return new ResponseEntity<>(serwisGrupy.znajdzGrupePoNazwie(aNazwa), HttpStatus.OK);
    }

    @RequestMapping(value = "/pobierzWszystkieGrupy", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<GrupaDTO>>znajdzWszystkieGrupy()
    {
        return new ResponseEntity<>(serwisGrupy.znajdzWszystkieGrupy(), HttpStatus.OK);
    }

//    @RequestMapping(value ="/pobierzGrupeUzytkownika/{id}",method = RequestMethod.GET)
//    @ResponseBody
//    public ResponseEntity<List<GrupyDTO>> znajdzUzytkownikaPoGrupie (@PathVariable("id") Long aId, String anazwaGrupy )
//    {
//        return new ResponseEntity<>(serwisGrupy.znajdzUzytkownikaPoGrupie(aId, anazwaGrupy),HttpStatus.OK );
//    }

    @RequestMapping(value = "usunGrupe/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<Void> usunGrupe(@PathVariable("id")Long aId)
    {
        serwisGrupy.usunGrupe(aId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/zapiszGrupe",method = RequestMethod.POST,consumes = "application/json",produces = "application/json")
    @ResponseBody
    public ResponseEntity<GrupaDTO> zapiszGrupe (@RequestBody GrupaDTO aGrupaDTO)
    {
        return new ResponseEntity<>(serwisGrupy.zapiszGrupe(aGrupaDTO),HttpStatus.OK);
    }
}





