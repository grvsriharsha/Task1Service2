package com.example.demo.controller;

import com.example.demo.DTO.ResponseDTO;
import com.example.demo.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("${service.route.path}")
@Api(value = "MicroService2")
public class ServiceController {

    private static final Logger LOG = Logger.getLogger(ServiceController.class.getName());
    @Autowired
    private Service service;
    @GetMapping
    @ApiOperation(value = "Gets hello string")
    public ResponseDTO getStatus() {
        LOG.log(Level.INFO, "i am in controller2");
        return service.getResponse();
    }

}
