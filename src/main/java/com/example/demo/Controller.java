package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;
import jakarta.validation.Valid;
@RestController
@RequestMapping(
    path = "api/v1/sms", 
produces = {MediaType.APPLICATION_ATOM_XML_VALUE,
     MediaType.APPLICATION_JSON_VALUE}, 
    consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE 
)

public class Controller {
    private final Service service;


    @Autowired
    public Controller(Service service) {
        this.service = service;
    }
    @PostMapping()
    public void sendSms(@Valid @RequestBody SmsRequest smsRequest){
        service.sendSms(smsRequest);
}
}
