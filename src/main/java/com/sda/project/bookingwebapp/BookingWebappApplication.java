package com.sda.project.bookingwebapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan
@EnableJpaRepositories
@EnableJpaAuditing
@SpringBootApplication
public class BookingWebappApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookingWebappApplication.class, args);
    }

}

