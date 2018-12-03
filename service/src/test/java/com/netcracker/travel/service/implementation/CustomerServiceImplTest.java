package com.netcracker.travel.service.implementation;

import com.netcracker.travel.converter.CustomerConverter;
import com.netcracker.travel.converter.TourConverter;
import com.netcracker.travel.dao.implementation.CustomerDaoImpl;
import com.netcracker.travel.dao.implementation.TourDaoImpl;
import com.netcracker.travel.dto.CustomerDto;
import com.netcracker.travel.dto.RegistrationRequestDto;
import com.netcracker.travel.dto.TourDto;
import com.netcracker.travel.exception.PhoneNumberException;
import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceImplTest {
    private static final Logger LOG = Logger.getLogger(CustomerServiceImplTest.class.getName());

    @InjectMocks
    private CustomerServiceImpl customerService;

    @Mock
    private CustomerDaoImpl customerDao;
    @Mock
    private TourDaoImpl tourDao;

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
        CustomerDto customer = customerConverter.convert(CustomerDaoImpl.getInstance().getByUsername("Customer1"));
        when(customerDao.getByUsername("Customer1")).thenReturn(customerConverter.convert(customer));
        CustomerDto actual = customerService.getByUsername("Customer1");
        LOG.info(String.valueOf(actual));
        Assert.assertEquals(customer, actual);
    }

    @Test
    public void testGetAll() {
        List<CustomerDto> customers = CustomerDaoImpl.getInstance().getAll()
                .stream()
                .map(customer -> customerConverter.convert(customer))
                .collect(Collectors.toList());
        when(customerDao.getAll()).thenReturn(customers
                .stream()
                .map(admin -> customerConverter.convert(admin))
                .collect(Collectors.toList()));
        List<CustomerDto> actual = customerService.getAll();
        LOG.info(String.valueOf(actual));
        Assert.assertEquals(customers, actual);
    }

    @Test
    @Ignore
    public void testUpdatePhoneNumber(){
        String phoneNumber = "+375-29-123-45-67";
        CustomerDto customer = customerConverter.convert(CustomerDaoImpl.getInstance().getByUsername("Customer1"));

        when(customerDao.getById(UUID.fromString("91ccd7a5-6446-4e8e-bfc6-010a66e12228"))).thenReturn(customerConverter.convert(customer));
        when(customerService.updatePhoneNumber(customer.getUsername(), phoneNumber)).thenReturn(customer);
         customerService.updatePhoneNumber(customer.getUsername(), phoneNumber);

        Assert.assertEquals(customer, customer);
    }

    @Test
    public void testWatchTours() {
        UUID customerId = UUID.fromString("f16477b5-5571-472d-9d5d-6c77ddd75017");
        List<TourDto> tours = TourDaoImpl.getInstance().getToursById(customerId)
                .stream()
                .map(tour -> tourConverter.convert(tour))
                .collect(Collectors.toList());
        when(tourDao.getToursById(customerId)).thenReturn(tours
                .stream()
                .map(tour -> tourConverter.convert(tour))
                .collect(Collectors.toList()));
        List<TourDto> actual = customerService.watchTours(customerId);
        LOG.info(String.valueOf(actual));
        Assert.assertEquals(tours, actual);
    }

    @Test
    public void testBookTourTest(){

    }

    @Test
    public void testBuyTourTest(){

    }

    @Test
    public void cancelTourTest() {

    }

    @Test
    public void searchTourByNameTest() {
    }

    @Test
    public void searchTourByDateTest() {

    }

    @Test
    public void searchTourByTypeTest() {

    }

    @Test
    public void searchTourByCountryTest() {

    }

    @Test
    public void searchTourByTravelAgencyTest() {
    }


    @Test
    public void verifyPhoneNumberTest() throws PhoneNumberException, Exception {
        PhoneNumberException exception = new PhoneNumberException();
        //customerService.verifyPhoneNumber();
        doThrow(exception).when(customerService).verifyPhoneNumber("1234567890");
    }

    @Test
    public void registrationTest(){
        RegistrationRequestDto registrationRequestDto = new RegistrationRequestDto();
        CustomerDto customerDto = new CustomerDto();
        customerDto.setUsername("qwerty");
        customerDto.setPassword("1234567");
        registrationRequestDto.setUsername("qwerty");
        registrationRequestDto.setPassword("1234567");
        when(customerService.registration(registrationRequestDto)).thenReturn(customerDto);

    }

    @After
    public void tearDown(){
        customerConverter = null;
        tourConverter = null;
    }
}
