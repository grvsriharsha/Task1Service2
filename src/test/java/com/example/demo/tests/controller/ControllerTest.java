package com.example.demo.tests.controller;

import com.example.demo.DTO.ResponseDTO;
import com.example.demo.controller.ServiceController;
import com.example.demo.service.Service;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = {ServiceController.class})
@AutoConfigureMockMvc
public class ControllerTest {

    @Autowired
    private MockMvc mvc;

    @Value("${service.route.path}")
    private String apiUrl;

    @MockBean
    Service service;

    @BeforeClass
    public static void setUp() {

    }


    @Test
    public void testGet() throws Exception {

        String uri = apiUrl ;
        ResponseDTO responseDTO=new ResponseDTO();
        responseDTO.setResponse("Hello");

        given(this.service.getResponse()).willReturn(responseDTO);

        mvc.perform(get("http://localhost:8082/"+apiUrl)
                .contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
                .andExpect(jsonPath("$.response",is("Hello")));

    }
}