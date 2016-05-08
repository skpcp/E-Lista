package com.skpcp.elista.rola.api;


import com.skpcp.elista.rola.dto.RolaDTO;
import com.skpcp.elista.rola.dto.RolaDTOBezUprawnien;
import com.skpcp.elista.rola.dto.RolaDTOZmiana;
import com.skpcp.elista.rola.service.IRolaService;
import com.skpcp.elista.utils.exceptions.MyServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by padyyajs on 22.03.2016.
 */

@RestController
@Transactional
@RequestMapping(value = "elista/role")
public class RolaController
{
    @Autowired
    IRolaService serwisRola;

    @RequestMapping(value = "znajdzRolePoNazwie/{nazwa}",method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity <RolaDTO> znajdzRolePoNazwie(@PathVariable("nazwa") String aNazwa)
    {
        try{
            return new ResponseEntity<>(serwisRola.znajdzRolePoNazwie(aNazwa), HttpStatus.OK);
        }catch (MyServerException e){
            return new ResponseEntity<>(e.getHeaders(),e.getStatus());
        }
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

    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/edytujNazweRoli" , method = RequestMethod.POST, consumes = "application/json",produces = "application/json" )
    @ResponseBody
    public ResponseEntity<RolaDTO> edytujNazweRoli(@RequestBody RolaDTOZmiana aRolaDTO){
        try{
            return new ResponseEntity<>(serwisRola.edytujNazweRoli(aRolaDTO),HttpStatus.OK);
        }catch(MyServerException e)
        {
          return  new ResponseEntity<>(e.getHeaders(),e.getStatus());
        }
    }

}





