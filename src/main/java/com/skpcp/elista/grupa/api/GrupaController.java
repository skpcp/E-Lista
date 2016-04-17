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
    IGrupaService serwisRola;

    @RequestMapping(value = "znajdzRolePoNazwie/{nazwa}",method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity <GrupaDTO> znajdzRolePoNazwie(@PathVariable("nazwa") String aNazwa)
    {
        return new ResponseEntity<>(serwisRola.znajdzGrupaPoNazwie(aNazwa), HttpStatus.OK);
    }

    @RequestMapping(value = "/pobierzWszystkieRole", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<GrupaDTO>> znajdzWszystkieRole()
    {
        return new ResponseEntity<>(serwisRola.znajdzWszystkieGrupa(), HttpStatus.OK);
    }


    @RequestMapping(value = "usunRole/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<Void> usunRole(@PathVariable("id")Long aId)
    {
        serwisRola.usunRole(aId);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}





