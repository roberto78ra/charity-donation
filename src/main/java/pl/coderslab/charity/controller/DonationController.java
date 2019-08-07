package pl.coderslab.charity.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.entity.Category;
import pl.coderslab.charity.entity.Donation;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.repository.CategoryRepository;
import pl.coderslab.charity.repository.DonationRepository;
import pl.coderslab.charity.repository.InstitutionRepository;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/donation")
public class DonationController {

    @Autowired
    DonationRepository donationRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    InstitutionRepository institutionRepository;

    @ModelAttribute("allCategories")
    public List<Category> allCategories(){
        return categoryRepository.findAll();
    }

    @ModelAttribute("allInstitutions")
    public List<Institution> allInstitutions(){
        return institutionRepository.findAll();
    }

    @GetMapping("/addDonation")
    public String add(Model model) {
        model.addAttribute("donation", new Donation());
        return "donation/add";
    }

//    @PostMapping("/addDonation")
//    public String addPost (@ModelAttribute("donation") Donation donation) {
//        donationRepository.save(donation);
//        return "donation/confirmation";
//    }


    @PostMapping("/add")
    public String addDonation(@ModelAttribute Donation donation, Model model){
        model.addAttribute("donation",donation);
        donationRepository.save(donation);
        return "donation/confirmation";
    }
}
