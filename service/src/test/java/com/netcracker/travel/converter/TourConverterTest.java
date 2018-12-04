package com.netcracker.travel.converter;

import com.netcracker.travel.dto.TourDto;
import com.netcracker.travel.entity.Tour;
import com.netcracker.travel.entity.enumeration.TypeTour;
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
public class TourConverterTest {

    @Mock
    private Tour tour;
    @Mock
    private TourDto tourDto;
    private TourConverter tourConverter;
    private String name = "testTour";
    private Double price = 100.50;
    private UUID id = UUID.fromString("3de61a8a-3fa7-4f2d-a592-054de4f010dc");
    private TypeTour typeTour = TypeTour.SHOPTOUR;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        tourConverter = new TourConverter();
        tour = mock(Tour.class);
        tourDto  = mock(TourDto .class);
    }

    @Test
    public void testConvertFromDtoToEntity() {
        when(tourDto.getId()).thenReturn(id);
        when(tourDto.getName()).thenReturn(name);
        when(tourDto.getPrice()).thenReturn(price);
        when(tourDto.getType()).thenReturn(typeTour);
        tour = tourConverter.convert(tourDto );
        Assert.assertNotNull(tour);
        Assert.assertEquals(id, tour.getId());
        Assert.assertEquals(name, tour.getName());
        Assert.assertEquals(price, tour.getPrice());
    }

    @Test
    public void testConvertFromEntityToDto() {
        when(tour.getId()).thenReturn(id);
        when(tour.getName()).thenReturn(name);
        when(tour.getPrice()).thenReturn(price);
        when(tour.getType()).thenReturn(typeTour);
        tourDto  = tourConverter.convert(tour);
        Assert.assertNotNull(tourDto );
        Assert.assertEquals(id, tourDto.getId());
        Assert.assertEquals(name, tourDto.getName());
        Assert.assertEquals(price, tourDto.getPrice());
    }

    @After
    public void tearDown() {
        tour = null;
        tourDto  = null;
    }
}
