package com.sda.project.bookingwebapp.repository;

import com.sda.project.bookingwebapp.entity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CustomPropertyRepository extends JpaRepository<AddressEntity, Long>, JpaSpecificationExecutor {
}
