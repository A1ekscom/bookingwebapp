package com.sda.project.bookingwebapp.converter;


import com.sda.project.bookingwebapp.entity.NewsletterEntity;
import com.sda.project.bookingwebapp.entity.PropertyEntity;
import com.sda.project.bookingwebapp.model.NewsletterModel;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SimpleEntityToModelConverterUnitTest {

    private SimpleEntityToModelConverter simpleEntityToModelConverter;

    @Before
    public void setup() {
        simpleEntityToModelConverter = new SimpleEntityToModelConverter();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void shouldConvertNewsletterEntityToNewsletterModel() {
        NewsletterEntity actualNewsletterEntity = NewsletterEntity.builder().id(1L).email("test@gmail.com").build();

        NewsletterModel actualNewsletterModel = simpleEntityToModelConverter.newsletterEntityToModel(actualNewsletterEntity);

        Assert.assertEquals("test@gmail.com", actualNewsletterModel.getEmail());
        Assert.assertEquals(1L, actualNewsletterModel.getId());
    }

    // todo Create unit test for propertyEntityToModel()
    @Test
    public void shouldConvertPropertyEntityToPropertyModel() {
        PropertyEntity actualPropertyEntity = new PropertyEntity();
    }
}
