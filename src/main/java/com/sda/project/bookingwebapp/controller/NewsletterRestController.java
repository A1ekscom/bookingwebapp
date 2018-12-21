package com.sda.project.bookingwebapp.controller;

import com.sda.project.bookingwebapp.model.NewsletterModel;
import com.sda.project.bookingwebapp.service.NewsletterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class NewsletterRestController {

    @Autowired
    private NewsletterService newsletterService;

    @GetMapping("/newsletter")
    public HttpStatus createNewsletter(@RequestParam("email") final String email) {
        newsletterService.insertNewsletter(email);
        return HttpStatus.OK;
    }

    @GetMapping("/newsletter/{id}")
    public NewsletterModel getNewsletterById(@PathVariable("id") final Long id) {
        return newsletterService.getNewsletterById(id);
    }

    @PostMapping("/newsletter")
    public HttpStatus addNewsletter(@RequestParam("email") final String email) {
        newsletterService.insertNewsletter(email);
        return HttpStatus.OK;
    }

    @PutMapping("/newsletter")
    public HttpStatus updateNewsletter(@Valid @RequestBody final NewsletterModel newsletterModel) {
        newsletterService.updateNewsletter(newsletterModel);
        return HttpStatus.OK;
    }

    @DeleteMapping("/newsletter/{id}")
    public HttpStatus deleteNewsletter(@PathVariable("id") final Long id) {
        newsletterService.deleteNewsletterById(id);
        return HttpStatus.OK;
    }

    @GetMapping("/newsletters")
    public List<NewsletterModel> getAllNewsletters() {
        List<NewsletterModel> newsletterModels = newsletterService.getAllNewsletters();
        return newsletterModels;
    }
}
