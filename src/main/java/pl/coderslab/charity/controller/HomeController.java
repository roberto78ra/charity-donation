package pl.coderslab.charity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.repository.CategoryRepository;
import pl.coderslab.charity.repository.DonationRepository;
import pl.coderslab.charity.repository.InstitutionRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    InstitutionRepository institutionRepository;

    @Autowired
    DonationRepository donationRepository;




    @RequestMapping("/")
    public String homeAction(Model model){
        model.addAttribute("allInstitutions", institutionRepository.findAll());
        model.addAttribute("countQuantity", donationRepository.countQuantity());
        model.addAttribute("donationsAmount", donationRepository.donationsAmount());
        model.addAttribute("institutionAmount", institutionRepository.institutionsCount());
        return "index";
    }


}
