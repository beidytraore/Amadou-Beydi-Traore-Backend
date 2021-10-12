package com.example.Ogii.OGII.Controller;

import com.example.Ogii.OGII.model.Mairie;
import com.example.Ogii.OGII.service.MairieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class MairieController {

    @Autowired
    MairieService mairieService;

    @RequestMapping(value = "getallmairie", method = RequestMethod.GET)

    public List<Mairie> getAllMairie() {
        return mairieService.getAllMairie();
    }
    @RequestMapping(value = "addmairie",method = RequestMethod.POST)

    public String addEmployee(@RequestBody Mairie mairie) {
        return mairieService.addMairie(mairie);
    }
}
