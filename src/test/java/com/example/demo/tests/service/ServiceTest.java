package com.example.demo.tests.service;

import com.example.demo.service.Service;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;

public class ServiceTest {

    @InjectMocks
    private Service service;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetResponse() throws Exception {

        assertEquals(service.getResponse().getResponse(), "Hello");

    }


}
