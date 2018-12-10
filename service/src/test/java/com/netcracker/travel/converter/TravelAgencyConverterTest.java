package com.netcracker.travel.converter;

import com.netcracker.travel.dto.TravelAgencyDto;
import com.netcracker.travel.domain.TravelAgency;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.UUID;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TravelAgencyConverterTest {
    @Mock
    private TravelAgency travelAgency;
    @Mock
    private TravelAgencyDto travelAgencyDto;
    private TravelAgencyConverter travelAgencyConverter;
    private String name = "testTravelAgency";
    private Integer countTour = 10;
    private UUID id = UUID.fromString("91ccd7a5-6446-4e8e-bfc6-010a66e12228");

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        travelAgencyConverter = new TravelAgencyConverter();
        travelAgency = mock(TravelAgency.class);
        travelAgencyDto = mock(TravelAgencyDto.class);
    }

    @Test
    public void testConvertFromDtoToEntity() {
        when(travelAgencyDto.getId()).thenReturn(id);
        when(travelAgencyDto.getName()).thenReturn(name);
        when(travelAgencyDto.getCountTour()).thenReturn(countTour);
        travelAgency = travelAgencyConverter.convert(travelAgencyDto);
        Assert.assertNotNull(travelAgency);
        Assert.assertEquals(id, travelAgency.getId());
        Assert.assertEquals(name, travelAgency.getName());
        Assert.assertEquals(countTour, travelAgency.getCountTour());
    }

    @Test
    public void testConvertFromEntityToDto() {
        when(travelAgency.getId()).thenReturn(id.toString());
        when(travelAgency.getName()).thenReturn(name);
        when(travelAgency.getCountTour()).thenReturn(countTour);
        travelAgencyDto = travelAgencyConverter.convert(travelAgency);
        Assert.assertNotNull(travelAgencyDto);
        Assert.assertEquals(id, travelAgencyDto.getId());
        Assert.assertEquals(name, travelAgencyDto.getName());
        Assert.assertEquals(countTour, travelAgencyDto.getCountTour());
    }

    @After
    public void tearDown() {
        travelAgency = null;
        travelAgencyDto = null;
    }
}
