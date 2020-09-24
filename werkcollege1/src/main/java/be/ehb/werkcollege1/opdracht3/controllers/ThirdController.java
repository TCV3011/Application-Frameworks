package be.ehb.werkcollege1.opdracht3.controllers;

import be.ehb.werkcollege1.opdracht3.models.DataSource;
import be.ehb.werkcollege1.opdracht3.models.Evenement;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class ThirdController {

    @RequestMapping(value = "/evenementen", method = RequestMethod.GET)
    @ResponseBody
    public ArrayList<Evenement> getEvenements() {
        return  DataSource.getEvenements();
    }

    // challenge 1
    @RequestMapping(value = "/evenement/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Evenement getEvenementById(@PathVariable(value = "id") int id) {
        return DataSource.getEvenementById(id);
    }

    //challenge 2
    @RequestMapping(value = "/addEvenement", method = RequestMethod.POST)
    @ResponseBody
    public  Evenement addEvenement(@RequestParam(name = "id") int id, @RequestParam(name = "naam") String naam, @RequestParam(name = "soort") String soort) {
        Evenement temp = new Evenement(id, naam, soort);
        DataSource.addEvenement(temp);
        return temp;
    }
}
