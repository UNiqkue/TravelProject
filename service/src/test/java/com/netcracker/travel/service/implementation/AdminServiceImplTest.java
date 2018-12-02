package com.netcracker.travel.service.implementation;

import com.netcracker.travel.service.interfaces.AbstractService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AdminServiceImplTest {
  /*  protected static final Logger LOG_R = Logger
            .getLogger(AdminServiceImplTest.class);*/

    @InjectMocks
    private AdminServiceImpl adminService;

    @Mock
    private AbstractService abstractService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        adminService = new AdminServiceImpl();
    }

    @Test
    public void verifyPhoneNumberTest(){
    }

    @After
    public void tearDown(){
        adminService = null;
    }


}
