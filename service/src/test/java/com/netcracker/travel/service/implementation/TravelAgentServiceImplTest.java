package com.netcracker.travel.service.implementation;

import com.netcracker.travel.converter.TourConverter;
import com.netcracker.travel.converter.TravelAgentConverter;
import com.netcracker.travel.dto.TourDto;
import com.netcracker.travel.dto.TravelAgentDto;
import com.netcracker.travel.entity.Tour;
import com.netcracker.travel.entity.enumeration.TypeTour;
import com.netcracker.travel.repository.TourRepository;
import com.netcracker.travel.repository.TravelAgentRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import java.sql.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TravelAgentServiceImplTest {

    @Mock
    private TravelAgentRepository travelAgentRepository;
    @Mock
    private TourRepository tourRepository;
    private TourConverter tourConverter;
    private TravelAgentConverter travelAgentConverter;
    private TourDto tourDto;

    @InjectMocks
    private TravelAgentServiceImpl travelAgentService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(TravelAgentServiceImpl.class);
        tourConverter = new TourConverter();
        travelAgentConverter = new TravelAgentConverter();
        tourDto = new TourDto(UUID.randomUUID(), "Tour by sea", "Dinkevich", 100.0, TypeTour.CRUISE, "Tailand", Date.valueOf("2000-10-10"), Date.valueOf("2000-10-10"), UUID.fromString("65cd0390-576b-459c-818d-6d244661ff4a"), UUID.fromString("91ccd7a5-6446-4e8e-bfc6-010a66e12228"), true);

    }

    @Test
    public void testCreateTour() {
        tourDto = tourConverter.convert(tourRepository.save(tourConverter.convert(tourDto)));
        TourDto actual = tourConverter.convert(tourRepository.getById(tourDto.getId()));
        Assert.assertEquals(tourDto, actual);
        tourRepository.delete(tourDto.getId());
    }
/*
    @Test
    public void testGetAll() {
        List<TravelAgentDto> expected = travelAgentRepository.findAll()
                .stream()
                .map(agent -> travelAgentConverter.convert(agent))
                .collect(Collectors.toList());
        when(travelAgentRepository.findAll()).thenReturn(expected
                .stream()
                .map(agent -> travelAgentConverter.convert(agent))
                .collect(Collectors.toList()));
        List<TravelAgentDto> actual = travelAgentService.getAll();
        Assert.assertEquals(expected, actual);
    }
*/
    @Test
    public void testGetByUsername() {
        TravelAgentDto expected = travelAgentConverter.convert(travelAgentRepository.findByUsername("TravelAgent1"));
        when(travelAgentRepository.findByUsername("TravelAgent1")).thenReturn(travelAgentConverter.convert(expected));
        TravelAgentDto actual = travelAgentService.getByUsername("TravelAgent1");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testMakeDiscount() {
        tourRepository.save(tourConverter.convert(tourDto));
        tourDto.setPrice(10.0);
        tourRepository.save(tourConverter.convert(tourDto));
        TourDto actual = tourConverter.convert(tourRepository.getById(tourDto.getId()));
        tourRepository.delete(tourDto.getId());
        Assert.assertEquals(tourDto, actual);
    }

    @Test
    public void testEditTour() {
        tourRepository.save(tourConverter.convert(tourDto));
        tourDto.setDescription("New tour 5 person");
        tourRepository.save(tourConverter.convert(tourDto));
        TourDto actual = tourConverter.convert(tourRepository.getById(tourDto.getId()));
        tourRepository.delete(tourDto.getId());
        Assert.assertEquals(tourDto, actual);
    }

    @Test
    public void testDeleteTour() {
        UUID id = UUID.fromString("2be61a8a-3fa7-4f2d-a592-054de4f010dc");
        Tour tour = tourRepository.getById(id);
        travelAgentService.deleteTour(id);
        verify(tourRepository, times(1)).delete(id);
        tourRepository.save(tour);
    }
}
