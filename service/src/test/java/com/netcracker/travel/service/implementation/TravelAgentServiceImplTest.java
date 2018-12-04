package com.netcracker.travel.service.implementation;

import com.netcracker.travel.converter.TourConverter;
import com.netcracker.travel.converter.TravelAgentConverter;
import com.netcracker.travel.dao.implementation.TourDaoImpl;
import com.netcracker.travel.dao.implementation.TravelAgentDaoImpl;
import com.netcracker.travel.dto.TourDto;
import com.netcracker.travel.dto.TravelAgentDto;
import com.netcracker.travel.entity.Tour;
import com.netcracker.travel.entity.enumeration.TypeTour;
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
    private TravelAgentDaoImpl travelAgentDao;
    @Mock
    private TourDaoImpl tourDao;
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
        tourDto = tourConverter.convert(TourDaoImpl.getInstance().save(tourConverter.convert(tourDto)));
        TourDto actual = tourConverter.convert(TourDaoImpl.getInstance().getById(tourDto.getId()));
        Assert.assertEquals(tourDto, actual);
        TourDaoImpl.getInstance().delete(tourDto.getId());
    }

    @Test
    public void testGetAll() {
        List<TravelAgentDto> expected = TravelAgentDaoImpl.getInstance().getAll()
                .stream()
                .map(agent -> travelAgentConverter.convert(agent))
                .collect(Collectors.toList());
        when(travelAgentDao.getAll()).thenReturn(expected
                .stream()
                .map(agent -> travelAgentConverter.convert(agent))
                .collect(Collectors.toList()));
        List<TravelAgentDto> actual = travelAgentService.getAll();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetByUsername() {
        TravelAgentDto expected = travelAgentConverter.convert(TravelAgentDaoImpl.getInstance().getByUsername("TravelAgent1"));
        when(travelAgentDao.getByUsername("TravelAgent1")).thenReturn(travelAgentConverter.convert(expected));
        TravelAgentDto actual = travelAgentService.getByUsername("TravelAgent1");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testMakeDiscount() {
        TourDaoImpl.getInstance().save(tourConverter.convert(tourDto));
        tourDto.setPrice(10.0);
        TourDaoImpl.getInstance().updatePrice(tourConverter.convert(tourDto));
        TourDto actual = tourConverter.convert(TourDaoImpl.getInstance().getById(tourDto.getId()));
        TourDaoImpl.getInstance().delete(tourDto.getId());
        Assert.assertEquals(tourDto, actual);
    }

    @Test
    public void testEditTour() {
        TourDaoImpl.getInstance().save(tourConverter.convert(tourDto));
        tourDto.setDescription("New tour 5 person");
        TourDaoImpl.getInstance().updateDescription(tourConverter.convert(tourDto));
        TourDto actual = tourConverter.convert(TourDaoImpl.getInstance().getById(tourDto.getId()));
        TourDaoImpl.getInstance().delete(tourDto.getId());
        Assert.assertEquals(tourDto, actual);
    }

    @Test
    public void testDeleteTour() {
        UUID id = UUID.fromString("2be61a8a-3fa7-4f2d-a592-054de4f010dc");
        Tour tour = tourDao.getById(id);
        travelAgentService.deleteTour(id);
        verify(tourDao, times(1)).delete(id);
        tourDao.save(tour);
    }
}
