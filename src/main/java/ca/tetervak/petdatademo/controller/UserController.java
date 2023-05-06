package ca.tetervak.petdatademo.controller;

import ca.tetervak.petdatademo.data.PetOwnerDataService;

import ca.tetervak.petdatademo.model.PetOwner;
import ca.tetervak.petdatademo.model.PetOwnerDetails;
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
@RequestMapping("/users")
public class UserController {

    private final Logger log = LoggerFactory.getLogger(UserController.class);
    private final PetOwnerDataService petOwnerDataService;

    public UserController(PetOwnerDataService petOwnerDataService) {
        this.petOwnerDataService = petOwnerDataService;
    }

    @GetMapping
    ModelAndView userList(){
        log.trace("userList() is called");
        List<PetOwner> list = petOwnerDataService.findAllPetOwners();
        log.debug("list.size()=" + list.size());
        return new ModelAndView("UserList", "users", list);
    }

    @GetMapping("/{id}")
    String userDetails(@PathVariable(name = "id") String ids, Model model){
        log.trace("userDetails() is called");
        log.debug("id=" + ids);
        try{
            int id = Integer.parseInt(ids);
            PetOwnerDetails ownerDetails = petOwnerDataService.findPetOwnerDetailsById(id).orElseThrow();
            log.debug("user=" + ownerDetails);
            model.addAttribute("user", ownerDetails);
            return "UserDetails";
        }catch (NumberFormatException e){
            log.warn("User data id={} is not integer", ids);
            model.addAttribute("message", "The user id must be an integer");
            return "DataNotFound";
        }
    }

    @ModelAttribute("localDate")
    LocalDate getlLocalDate(){
        return LocalDate.now();
    }

    @ExceptionHandler(NoSuchElementException.class)
    ModelAndView dataNotFound(NoSuchElementException e){
        log.warn("User data is not found.");
        ModelAndView mv = new ModelAndView("DataNotFound", "message", e.getMessage());
        mv.addObject("localDate", getlLocalDate());
        return mv;
    }
}
