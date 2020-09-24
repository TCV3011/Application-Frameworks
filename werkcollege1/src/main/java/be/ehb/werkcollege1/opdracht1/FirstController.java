package be.ehb.werkcollege1.opdracht1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FirstController {

    @RequestMapping(value = "/lucky", method = RequestMethod.GET)
    @ResponseBody
    public int luckyNumberOfTheDay() {
        return (int)(Math.random() * 10 + 1);
    }
}
