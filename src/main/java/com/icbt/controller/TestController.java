package com.icbt.controller;

import com.icbt.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class TestController {

    @Autowired
    TestService testService;


    @GetMapping("/test-controller")
    public ResponseEntity testController(){
        return testService.testController();
    }
}
