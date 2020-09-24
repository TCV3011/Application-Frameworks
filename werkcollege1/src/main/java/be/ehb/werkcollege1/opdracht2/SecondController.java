package be.ehb.werkcollege1.opdracht2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SecondController {

    @RequestMapping(value = "/power", method = RequestMethod.POST)
    @ResponseBody
    public int power(@RequestParam(name = "x", defaultValue = "1") int x){
        return x * x;
    }
}
