package com.netcracker.travel.service.implementation;

import com.netcracker.travel.converter.CustomerConverter;
import com.netcracker.travel.converter.TourConverter;
import com.netcracker.travel.dto.CustomerDto;
import com.netcracker.travel.dto.TourDto;
import com.netcracker.travel.entity.enumeration.Role;
import com.netcracker.travel.entity.enumeration.TypeTour;
import com.netcracker.travel.repository.CustomerRepository;
import com.netcracker.travel.repository.TourRepository;
import org.junit.After;
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
import java.util.logging.Logger;
import java.util.stream.Collectors;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceImplTest {
    private static final Logger LOG = Logger.getLogger(CustomerServiceImplTest.class.getName());

    @InjectMocks
    private CustomerServiceImpl customerService;
    @InjectMocks
    private AdminServiceImpl adminService;

    @Mock
    private CustomerRepository customerRepository;
    @Mock
    private TourRepository tourRepository;

    private TourConverter tourConverter;
    private CustomerConverter customerConverter;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        tourConverter = new TourConverter();
        customerConverter = new CustomerConverter();
    }

    @Test
    public void testGetByUsername(){
        CustomerDto customer = customerConverter.convert(customerRepository.findByUsername("Customer1"));
        when(customerRepository.findByUsername("Customer1")).thenReturn(customerConverter.convert(customer));
        CustomerDto actual = customerService.getByUsername("Customer1");
        LOG.info(String.valueOf(actual));
        Assert.assertEquals(customer, actual);
    }

    @Test
    public void testGetAll() {
        List<CustomerDto> customers = customerRepository.findAll()
                .stream()
                .map(customer -> customerConverter.convert(customer))
                .collect(Collectors.toList());
        when(customerRepository.findAll()).thenReturn(customers
                .stream()
                .map(admin -> customerConverter.convert(admin))
                .collect(Collectors.toList()));
        List<CustomerDto> actual = customerService.getAll();
        LOG.info(String.valueOf(actual));
        Assert.assertEquals(customers, actual);
    }


    @Test
    public void testWatchTours() {
        UUID customerId = UUID.fromString("f16477b5-5571-472d-9d5d-6c77ddd75017");
        List<TourDto> tours = tourRepository.findAllByCustomerId(customerId)
                .stream()
                .map(tour -> tourConverter.convert(tour))
                .collect(Collectors.toList());
        when(tourRepository.findAllByCustomerId(customerId)).thenReturn(tours
                .stream()
                .map(tour -> tourConverter.convert(tour))
                .collect(Collectors.toList()));
        List<TourDto> actual = customerService.watchTours(customerId);
        LOG.info(String.valueOf(actual));
        Assert.assertEquals(tours, actual);
    }

    @Test
    public void testUpdatePhoneNumber(){
        CustomerDto customerDto = new CustomerDto(UUID.randomUUID(), "Vova", "Dinkevich", "Customer1", "null1111", "Customer@gmail.com", "qwdqscqwcdqwcd", Role.CUSTOMER, "+375-29-567-23-23", Date.valueOf("2000-10-10"), "123123", "123123");
        customerRepository.save(customerConverter.convert(customerDto));
        customerDto.setPhoneNumber("+375-44-123-54-34");
        customerRepository.save(customerConverter.convert(customerDto));
        CustomerDto actual = customerConverter.convert(customerRepository.getById(customerDto.getId()));
        Assert.assertEquals(customerDto, actual);
        customerRepository.delete(customerDto.getId());
    }

    @Test
    public void searchTourByNameTest() {
        String name = "Sea";
        List<TourDto> tours = tourRepository.findAll()
                .stream()
                .filter(tour -> tour.getName().equals(name))
                .map(tour -> tourConverter.convert(tour))
                .collect(Collectors.toList());
        when(tourRepository.findAll()).thenReturn(tours
                .stream()
                .map(tour -> tourConverter.convert(tour))
                .collect(Collectors.toList()));
        List<TourDto> actual = adminService.watchTours();
        Assert.assertEquals(tours, actual);
    }

    @Test
    public void searchTourByDateTest() {
        Date startDate = Date.valueOf("2000-10-10");
        List<TourDto> tours = tourRepository.findAll()
                .stream()
                .filter(tour -> tour.getStartDate().equals(startDate))
                .map(tour -> tourConverter.convert(tour))
                .collect(Collectors.toList());
        when(tourRepository.findAll()).thenReturn(tours
                .stream()
                .map(tour -> tourConverter.convert(tour))
                .collect(Collectors.toList()));
        List<TourDto> actual = adminService.watchTours();
        Assert.assertEquals(tours, actual);
    }

    @Test
    public void searchTourByTypeTest() {
        TypeTour typeTour = TypeTour.CRUISE;
        List<TourDto> tours = tourRepository.findAll()
                .stream()
                .filter(tour -> tour.getType().equals(typeTour))
                .map(tour -> tourConverter.convert(tour))
                .collect(Collectors.toList());
        when(tourRepository.findAll()).thenReturn(tours
                .stream()
                .map(tour -> tourConverter.convert(tour))
                .collect(Collectors.toList()));
        List<TourDto> actual = adminService.watchTours();
        Assert.assertEquals(tours, actual);
    }

    @Test
    public void searchTourByCountryTest() {
        String country = "greece";
        List<TourDto> tours = tourRepository.findAll()
                .stream()
                .filter(tour -> tour.getCountry().equals(country))
                .map(tour -> tourConverter.convert(tour))
                .collect(Collectors.toList());
        when(tourRepository.findAll()).thenReturn(tours
                .stream()
                .map(tour -> tourConverter.convert(tour))
                .collect(Collectors.toList()));
        List<TourDto> actual = adminService.watchTours();
        Assert.assertEquals(tours, actual);
    }

    @Test
    public void searchTourByTravelAgencyTest() {
        UUID travelAgencyId = UUID.fromString("65cd0390-576b-459c-818d-6d244661ff4a");
        List<TourDto> tours = tourRepository.findAll()
                .stream()
                .filter(tour -> tour.getTravelAgencyId().equals(travelAgencyId))
                .map(tour -> tourConverter.convert(tour))
                .collect(Collectors.toList());
        when(tourRepository.findAll()).thenReturn(tours
                .stream()
                .map(tour -> tourConverter.convert(tour))
                .collect(Collectors.toList()));
        List<TourDto> actual = adminService.watchTours();
        Assert.assertEquals(tours, actual);
    }

    @After
    public void tearDown(){
        customerConverter = null;
        tourConverter = null;
    }
}
