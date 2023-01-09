package ua.ithillel.lesson40.homework.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PingController {

    @GetMapping("/ping")
    @ResponseBody
    public String ping() {
        return "OK";
    }
}
