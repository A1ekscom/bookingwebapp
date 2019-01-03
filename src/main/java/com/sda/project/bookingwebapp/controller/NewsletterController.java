package com.sda.project.bookingwebapp.controller;

import com.sda.project.bookingwebapp.model.NewsletterModel;
import com.sda.project.bookingwebapp.service.NewsletterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NewsletterController {

    @Autowired
    private NewsletterService newsletterService;

    @GetMapping("/newsletter")
    public ModelAndView indexPage() {
        return new ModelAndView("index-old")
                .addObject("newsletter", new NewsletterModel())
                .addObject("user", "Aleks");
    }

    @PostMapping("/newsletter")
    public ModelAndView insertNewsletter(@ModelAttribute("email") final String email) {
        newsletterService.insertNewsletter(email);
        return new ModelAndView("result").addObject("email", email);
    }
}
