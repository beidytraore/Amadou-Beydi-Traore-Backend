package com.example.Ogii.OGII.Controller;


import com.example.Ogii.OGII.model.ActeNaissance;
import com.example.Ogii.OGII.service.ActeNaissanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class Actenaissance {

    @Autowired
    ActeNaissanceService acteNaissanceService;

    @RequestMapping(value = "getallActeNaissance", method = RequestMethod.GET)

    public List<ActeNaissance> getallActeNaissance() {
        return acteNaissanceService.getallActeNaissance();
    }

    @RequestMapping(value = "AjouterActeNaissance",method = RequestMethod.POST)

    public String AjouterActeNaissance(@RequestBody ActeNaissance acteNaissance) {
        return acteNaissanceService.AjouterActeNaissance(acteNaissance);
    }

    @RequestMapping(value = "updateActeNaissance", method = RequestMethod.PUT)
    public String updateActeNaissance(@RequestBody ActeNaissance acteNaissance) {
        return acteNaissanceService.updateacteNaissance(acteNaissance);
    }

  //  @RequestMapping(value = "deleteActeNaissance", method = RequestMethod.DELETE)
   // public String deleteActeNaissance(@RequestBody ActeNaissance acteNaissance) {
    //    return acteNaissanceService.deleteActeNaissance(acteNaissance);
   // }

}
