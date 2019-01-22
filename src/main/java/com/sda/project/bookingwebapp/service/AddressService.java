package com.sda.project.bookingwebapp.service;

import com.sda.project.bookingwebapp.model.TopDestinationModel;
import com.sda.project.bookingwebapp.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public AddressService(final AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public List<TopDestinationModel> getTopDestinations() {
        List<TopDestinationModel> topDestinationModels = addressRepository.findTopDestinations();
        return topDestinationModels.size() > 8 ? topDestinationModels.subList(0, 8) : topDestinationModels;
    }

}
