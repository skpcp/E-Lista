package com.skpcp.elista.role.api;


import com.skpcp.elista.role.dto.RolaDTO;
import com.skpcp.elista.role.service.IRoleService;
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
public class RolaController
{
    @Autowired
    IRoleService serwisRola;

    @RequestMapping(value = "znajdzRolePoNazwie/{nazwa}",method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity <RolaDTO> znajdzRolePoNazwie(@PathVariable("nazwa") String aNazwa)
    {
        return new ResponseEntity<>(serwisRola.znajdzRolePoNazwie(aNazwa), HttpStatus.OK);
    }

    @RequestMapping(value = "/pobierzWszystkieRole", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<RolaDTO>> znajdzWszystkieRole()
    {
        return new ResponseEntity<>(serwisRola.znajdzWszystkieRole(), HttpStatus.OK);
    }


    @RequestMapping(value = "usunRole/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<Void> usunRole(@PathVariable("id")Long aId)
    {
        serwisRola.usunRole(aId);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}





