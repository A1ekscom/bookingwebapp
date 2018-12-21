package com.sda.project.bookingwebapp.service;

import com.sda.project.bookingwebapp.converter.NewsletterEntityToModelConverter;
import com.sda.project.bookingwebapp.entity.NewsletterEntity;
import com.sda.project.bookingwebapp.model.NewsletterModel;
import com.sda.project.bookingwebapp.repository.NewsletterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NewsletterService {

    @Autowired
    private NewsletterRepository newsletterRepository;

    @Autowired
    private NewsletterEntityToModelConverter newsletterEntityToModelConverter;

    public void insertNewsletter(final String email) {
        Optional<NewsletterEntity> newsletterEntity = newsletterRepository.findByEmail(email);
        if (!newsletterEntity.isPresent()) {
            newsletterRepository.save(NewsletterEntity.builder().email(email).build());
        }
    }

    public List<NewsletterModel> getAllNewsletters() {
        List<NewsletterEntity> newsletterEntities = newsletterRepository.findAll();
        List<NewsletterModel> newsletterModels = newsletterEntities.stream().map(newsletterEntityToModelConverter::toModel).collect(Collectors.toList());
        return newsletterModels;
    }

    public NewsletterModel getNewsletterById(Long id) {
        Optional<NewsletterEntity> newsletterEntity = newsletterRepository.findById(id);
        return tryGetNewsletterModel(newsletterEntity);
    }

    private NewsletterModel tryGetNewsletterModel(Optional<NewsletterEntity> newsletterEntity) {
        try {
            NewsletterModel newsletterModel = newsletterEntity.map(newsletterEntityToModelConverter::toModel).get();
            return newsletterModel;
        } catch (NoSuchElementException e) {
            throw new RuntimeException("No such element found");
        }
    }

    public void updateNewsletter(NewsletterModel newsletterModel) {
        Optional<NewsletterEntity> newsletterEntity = newsletterRepository.findById(newsletterModel.getId());
        if (newsletterEntity.isPresent()) {
            NewsletterEntity updatedNewsletterEntity = newsletterEntity.get();
            updatedNewsletterEntity.setEmail(newsletterModel.getEmail());
            newsletterRepository.save(updatedNewsletterEntity);
        }
    }

    public void deleteNewsletterById(Long id) {
        Optional<NewsletterEntity> newsletterEntity = newsletterRepository.findById(id);
        if (newsletterEntity.isPresent()) {
            newsletterRepository.delete(newsletterEntity.get());
        } else {
            throw new RuntimeException("No such element found");
        }
    }
}
