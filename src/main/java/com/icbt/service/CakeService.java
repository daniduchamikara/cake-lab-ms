package com.icbt.service;

import com.icbt.dto.Cake;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseBody;

public interface CakeService {

    ResponseEntity create(Cake cake);
}
