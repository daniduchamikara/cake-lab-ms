package com.icbt.controller;

import com.icbt.dto.Cake;
import com.icbt.service.CakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cake")
public class CakeController {

    @Autowired
    CakeService cakeService;

    @PostMapping("/")
    public ResponseEntity create(){
        Cake cake = new Cake("sasasa",10.0);
        return cakeService.create(cake);
    }
}
