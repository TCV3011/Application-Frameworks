package be.ehb.werkcollege1.opdracht3.controllers;

import be.ehb.werkcollege1.opdracht3.models.DataSource;
import be.ehb.werkcollege1.opdracht3.models.Evenement;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
public class ThirdController {

    @RequestMapping(value = "/evenementen", method = RequestMethod.GET)
    @ResponseBody
    public ArrayList<Evenement> evenements() {
        return  DataSource.getEvenements();
    }
}
