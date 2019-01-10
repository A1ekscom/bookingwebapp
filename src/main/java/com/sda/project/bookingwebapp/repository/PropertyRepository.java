package com.sda.project.bookingwebapp.repository;

import com.sda.project.bookingwebapp.entity.PropertyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyRepository extends JpaRepository<PropertyEntity, Long> {


}
