package ca.tetervak.petdatademo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.time.LocalDate;

@Controller
public class HomeController {

    private final Logger log = LoggerFactory.getLogger(HomeController.class);

    @GetMapping("/index")
    String index(){
        log.trace("index() is called");
        return "Index";
    }

    @GetMapping(value = {"/", "/home"})
    String home(){
        log.trace("home() is called");
        return "redirect:/users";
    }

    @ModelAttribute("localDate")
    LocalDate getlLocalDate(){
        return LocalDate.now();
    }
}
