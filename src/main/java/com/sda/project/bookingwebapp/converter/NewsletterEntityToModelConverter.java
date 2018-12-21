package com.sda.project.bookingwebapp.converter;

import com.sda.project.bookingwebapp.entity.NewsletterEntity;
import com.sda.project.bookingwebapp.model.NewsletterModel;
import org.springframework.stereotype.Component;

@Component
public class NewsletterEntityToModelConverter {

    public NewsletterModel toModel(final NewsletterEntity newsletterEntity) {
        NewsletterModel newsletterModel = new NewsletterModel();
        newsletterModel.setId(newsletterEntity.getId());
        newsletterModel.setCreatedAt(newsletterEntity.getCreatedAt());
        newsletterModel.setEmail(newsletterEntity.getEmail());
        return newsletterModel;
    }
}
