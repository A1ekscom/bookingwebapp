package com.sda.project.bookingwebapp.repository;

import com.sda.project.bookingwebapp.entity.AddressEntity;
import com.sda.project.bookingwebapp.model.TopDestinationModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AddressRepository extends JpaRepository<AddressEntity, Long> {

    @Query("select new com.sda.project.bookingwebapp.model.TopDestinationModel(" +
            "count(distinct a.room.property),a.city,a.country) " +
            "from AddressEntity a " +
            "group by a.city,a.country " +
            "order by count(distinct a.room.property) desc ")
    List<TopDestinationModel> findTopDestinations();
}
