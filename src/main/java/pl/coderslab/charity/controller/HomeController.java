package pl.coderslab.charity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.repository.InstitutionRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    InstitutionRepository institutionRepository;


    @RequestMapping("/")
    public String homeAction(Model model){
        //TODO
        model.addAttribute("allInstitutions", institutionRepository.findAll());
        //List<Institution> institutions = Arrays.asList(new Institution());
        //model.addAttribute("allInstitutions", institutions);
        return "index";
    }

//    @RequestMapping("/allInstitutions")
//    public String allInstitutions(Model model) {
//        return "/allInstitutions";
//    }

}
