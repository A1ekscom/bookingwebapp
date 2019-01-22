package com.sda.project.bookingwebapp.service;

import com.sda.project.bookingwebapp.model.TopDestinationModel;
import com.sda.project.bookingwebapp.repository.AddressRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class AddressServiceUnitTest {

    @InjectMocks
    private AddressRepository addressRepository = mock(AddressRepository.class);
    private AddressService addressService = new AddressService(addressRepository);
    private List<TopDestinationModel> topDestinationModels = new ArrayList<>();

    @Before
    public void setup() {
        for (int i = 10; i > 0; i--) {
            TopDestinationModel topDestinationModel = new TopDestinationModel();
            topDestinationModel.setAmount(i);
            topDestinationModel.setCity("City" + i);
            topDestinationModel.setCountry("Country" + i);
            topDestinationModels.add(topDestinationModel);
        }
    }

    @After
    public void tearDown() {
    }

    @Test
    public void shouldHave8TopDestinations() {
        // given
        Mockito.when(addressRepository.findTopDestinations()).thenReturn(topDestinationModels);

        // when
        List<TopDestinationModel> topDestinationModels = addressService.getTopDestinations();

        // then
        assertNotNull(topDestinationModels);
        assertEquals(8, topDestinationModels.size());
    }

    @Test
    public void shouldHaveSameTopDestinationsWithResultWhenTopDestinationLessThen8() {
        // given
        List<TopDestinationModel> reducedSizeTopDestinationModels = topDestinationModels.subList(0, 5);
        int actualSize = reducedSizeTopDestinationModels.size();
        Mockito.when(addressRepository.findTopDestinations()).thenReturn(reducedSizeTopDestinationModels);

        // when
        List<TopDestinationModel> topDestinationModels = addressService.getTopDestinations();

        // then
        assertNotNull(topDestinationModels);
        assertEquals(actualSize, topDestinationModels.size());
    }

    @Test
    public void shouldBringTOpDestinationsFromRepository() {
        // given, when
        addressService.getTopDestinations();

        // then
        verify(addressRepository).findTopDestinations();
    }

}
