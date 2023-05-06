package ca.tetervak.petdatademo.controller;

import ca.tetervak.petdatademo.data.PetDataService;
import ca.tetervak.petdatademo.model.Pet;
import ca.tetervak.petdatademo.model.PetDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

@Controller
@RequestMapping("/pets")
public class PetController {

    private final Logger log = LoggerFactory.getLogger(UserController.class);
    private final PetDataService petDataService;

    public PetController(PetDataService petDataService) {
        this.petDataService = petDataService;
    }

    @GetMapping
    ModelAndView petList(){
        log.trace("petList() is called");
        List<Pet> list = petDataService.findAllPets();
        log.debug("list.size()=" + list.size());
        return new ModelAndView("PetList", "pets", list);
    }

    @GetMapping("/{id}")
    String petDetails(@PathVariable(name = "id") String ids, Model model){
        log.trace("petDetails() is called");
        log.debug("id=" + ids);
        try{
            int id = Integer.parseInt(ids);
            PetDetails pet = petDataService.findPetDetailsById(id).orElseThrow();
            model.addAttribute("pet", pet);
            return "PetDetails";
        }catch (NumberFormatException e){
            model.addAttribute("message", "The pet id must be an integer");
            return "DataNotFound";
        }
    }

    @ModelAttribute("localDate")
    LocalDate getlLocalDate(){
        return LocalDate.now();
    }

    @ExceptionHandler(NoSuchElementException.class)
    ModelAndView dataNotFound(NoSuchElementException e){
        ModelAndView mv = new ModelAndView("DataNotFound", "message", e.getMessage());
        mv.addObject("localDate", getlLocalDate());
        return mv;
    }
}
