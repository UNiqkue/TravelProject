package com.netcracker.travel.converter;

import com.netcracker.travel.dto.TravelAgentDto;
import com.netcracker.travel.entity.TravelAgent;
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
public class TravelAgentConverterTest {

    @Mock
    private TravelAgent travelAgent;
    @Mock
    private TravelAgentDto travelAgentDto;
    private TravelAgentConverter travelAgentConverter;
    private String firstName = "testFirstName";
    private String lastName = "testLastName";
    private UUID id = UUID.fromString("91ccd7a5-6446-4e8e-bfc6-010a66e12228");

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        travelAgentConverter = new TravelAgentConverter();
        travelAgent = mock(TravelAgent.class);
        travelAgentDto = mock(TravelAgentDto.class);
    }

    @Test
    public void testConvertFromDtoToEntity() {
        when(travelAgentDto.getId()).thenReturn(id);
        when(travelAgentDto.getFirstName()).thenReturn(firstName);
        when(travelAgentDto.getLastName()).thenReturn(lastName);
        travelAgent = travelAgentConverter.convert(travelAgentDto);
        Assert.assertNotNull(travelAgent);
        Assert.assertEquals(id, travelAgent.getId());
        Assert.assertEquals(firstName, travelAgent.getFirstName());
        Assert.assertEquals(lastName, travelAgent.getLastName());
    }

    @Test
    public void testConvertFromEntityToDto() {
        when(travelAgent.getId()).thenReturn(id);
        when(travelAgent.getFirstName()).thenReturn(firstName);
        when(travelAgent.getLastName()).thenReturn(lastName);
        travelAgentDto = travelAgentConverter.convert(travelAgent);
        Assert.assertNotNull(travelAgentDto);
        Assert.assertEquals(id, travelAgentDto.getId());
        Assert.assertEquals(firstName, travelAgentDto.getFirstName());
        Assert.assertEquals(lastName, travelAgentDto.getLastName());
    }

    @After
    public void tearDown() {
        travelAgent = null;
        travelAgentDto = null;
    }
}


