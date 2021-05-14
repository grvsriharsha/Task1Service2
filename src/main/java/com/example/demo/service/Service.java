package com.example.demo.service;

import com.example.demo.DTO.ResponseDTO;
import com.example.demo.controller.ServiceController;
import org.springframework.stereotype.Component;

import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class Service {

    private static final Logger LOG = Logger.getLogger(Service.class.getName());

    public ResponseDTO getResponse() {
        LOG.log(Level.INFO, "i am in service2");
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setResponse("Hello");
        return responseDTO;
    }
}
