package com.sda.project.bookingwebapp.service;

import com.sda.project.bookingwebapp.converter.SimpleEntityToModelConverter;
import com.sda.project.bookingwebapp.entity.AddressEntity;
import com.sda.project.bookingwebapp.entity.PropertyEntity;
import com.sda.project.bookingwebapp.model.PropertyModel;
import com.sda.project.bookingwebapp.model.SearchPropertyModel;
import com.sda.project.bookingwebapp.repository.CustomPropertyRepository;
import com.sda.project.bookingwebapp.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.sda.project.bookingwebapp.repository.specification.PropertySpecification.prepareSearchPropertyQuery;

@Service
public class PropertyService {

    @Autowired
    private PropertyRepository propertyRepository;

    @Autowired
    private SimpleEntityToModelConverter simpleEntityToModelConverter;

    @Autowired
    private CustomPropertyRepository customPropertyRepository;

    public PropertyModel getPropertyByIdAndAdressId(final Long propertyId, final Long addressId) {
        Optional<PropertyEntity> propertyEntity = propertyRepository.findById(propertyId);

        if (propertyEntity.isPresent()) {
            return simpleEntityToModelConverter.propertyEntityToModel(propertyEntity.get(), addressId);
        } else {
            throw new NullPointerException("You don't have selected property!");
        }
    }

    public List<PropertyModel> getAllProperties() {
        return simpleEntityToModelConverter.propertyEntitiesToModels(propertyRepository.findAll());
    }

    public Page<PropertyModel> getSearchedProperties(final SearchPropertyModel searchPropertyModel) {

        List<AddressEntity> addressEntities = customPropertyRepository
                .findAll(prepareSearchPropertyQuery(searchPropertyModel));

        List<PropertyModel> propertyModels = simpleEntityToModelConverter
                .addressEntitiesToPropertyModels(addressEntities);

        return new PageImpl<>(propertyModels, PageRequest.of(0, 10), propertyModels.size());
    }

}
