package com.skpcp.elista.grupa.api;


import com.skpcp.elista.grupa.dto.GrupaDTO;
import com.skpcp.elista.grupa.service.IGrupaService;
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
    IGrupaService serwisGrupa;

    @RequestMapping(value = "znajdzGrupaPoNazwie/{nazwa}",method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity <GrupaDTO> znajdzGrupaPoNazwie(@PathVariable("nazwa") String aNazwa)
    {
        return new ResponseEntity<>(serwisGrupa.znajdzGrupaPoNazwie(aNazwa), HttpStatus.OK);
    }

    @RequestMapping(value = "/pobierzWszystkieGrupa", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<GrupaDTO>> znajdzWszystkieGrupa()
    {
        return new ResponseEntity<>(serwisGrupa.znajdzWszystkieGrupa(), HttpStatus.OK);
    }


    @RequestMapping(value = "usunGrupa/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<Void> usunGrupa(@PathVariable("id")Long aId)
    {
        serwisGrupa.usunRole(aId);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}





