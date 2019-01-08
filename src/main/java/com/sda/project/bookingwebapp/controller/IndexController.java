package com.sda.project.bookingwebapp.controller;

import com.sda.project.bookingwebapp.model.NewsletterModel;
import com.sda.project.bookingwebapp.model.SearchPropertyModel;
import com.sda.project.bookingwebapp.model.TopDestinationModel;
import com.sda.project.bookingwebapp.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private AddressService addressService;

    @GetMapping("/")
    public ModelAndView indexPage() {
        List<TopDestinationModel> topDestinationModels = addressService.getTopDestinations();
        return new ModelAndView("index")
                .addObject("searchPropertyModel", new SearchPropertyModel())
                .addObject("newsletter", new NewsletterModel())
                .addObject("topDestinationModels", topDestinationModels);
    }

    @GetMapping("/search")
    public ModelAndView searchProperty(@ModelAttribute SearchPropertyModel searchPropertyModel) {
        return new ModelAndView("result");
    }

    // not used at the moment - change with anything proper
    @GetMapping("/search/{city}")
    public ModelAndView searchPropertyByCity(@PathVariable("city") String city) {
        return new ModelAndView("result");
    }
}
