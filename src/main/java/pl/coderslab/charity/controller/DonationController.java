package pl.coderslab.charity.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.entity.Donation;
import pl.coderslab.charity.repository.DonationRepository;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/donation")
public class DonationController {

    @Autowired
    DonationRepository donationRepository;

    @GetMapping("/addDonation")
    public String add(Model model) {
        model.addAttribute("donation", new Donation());
        return "donation/add";
    }

    @PostMapping("/addDonation")
    public String add (@ModelAttribute("donation") Donation donation) {
        donationRepository.save(donation);
        return "donation/confirmation"; // do zrobienia
    }
}
