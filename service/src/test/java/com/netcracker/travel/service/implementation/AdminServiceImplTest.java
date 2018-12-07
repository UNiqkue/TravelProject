package com.netcracker.travel.service.implementation;

import com.netcracker.travel.converter.AdminConverter;
import com.netcracker.travel.converter.TourConverter;
import com.netcracker.travel.dto.AdminDto;
import com.netcracker.travel.repository.AdminRepository;
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

import java.util.logging.Logger;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AdminServiceImplTest {
    private static final Logger LOG = Logger.getLogger(AdminServiceImplTest.class.getName());

    @InjectMocks
    private AdminServiceImpl adminService;

    @Mock
    private AdminRepository adminRepository;
    @Mock
    private TourRepository tourRepository;

    private TourConverter tourConverter;
    private AdminConverter adminConverter;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        tourConverter = new TourConverter();
        adminConverter = new AdminConverter();
    }

    @Test
    public void testGetByUsername(){
        AdminDto oldAdmin = adminConverter.convert(adminRepository.findByUsername("Administrator"));
        when(adminRepository.findByUsername("Administrator")).thenReturn(adminConverter.convert(oldAdmin));
        AdminDto newAdmin = adminService.getByUsername("Administrator");
        LOG.info(String.valueOf(newAdmin));
        Assert.assertEquals(oldAdmin, newAdmin);
    }
/*
    @Test
    public void testGetAll() {
        List<AdminDto> oldAdmins = adminRepository.findAll()
                .stream()
                .map(admin -> adminConverter.convert(admin))
                .collect(Collectors.toList());
        when(adminRepository.findAll()).thenReturn(oldAdmins
                .stream()
                .map(admin -> adminConverter.convert(admin))
                .collect(Collectors.toList()));
        List<AdminDto> newAdmins = adminService.getAll();
        LOG.info(String.valueOf(newAdmins));
        Assert.assertEquals(oldAdmins, newAdmins);
    }

    @Test
    public void testWatchTours() {
        List<TourDto> oldTours = tourRepository.findAll()
                .stream()
                .map(tour -> tourConverter.convert(tour))
                .collect(Collectors.toList());
        when(tourRepository.findAll()).thenReturn(oldTours
                .stream()
                .map(tour -> tourConverter.convert(tour))
                .collect(Collectors.toList()));
        List<TourDto> newTours = adminService.watchTours();
        LOG.info(String.valueOf(newTours));
        Assert.assertEquals(oldTours, newTours);
    }
*/
    @After
    public void tearDown() {
        tourConverter = null;
        adminConverter = null;
    }


}
