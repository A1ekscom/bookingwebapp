package com.sda.project.bookingwebapp.repository;

import com.sda.project.bookingwebapp.entity.NewsletterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NewsletterRepository extends JpaRepository<NewsletterEntity, Long> {

    Optional<NewsletterEntity> findByEmail(final String email);


}
