package com.icbt.service.Impl;

import com.icbt.dto.Cake;
import com.icbt.service.CakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@Service
@Transactional
public class CakeServiceImpl implements CakeService {

    @Value("${direct.endpoint.createCake}")
    private String createCake;

    @Autowired
    @Qualifier("cakeLabRestTemplate")
    RestTemplate cakeLabRestTemplate;


    @Override
    public ResponseEntity create(Cake cake) {
        ResponseEntity responseBody;
        Map<String, String> uriParams = new HashMap<>();

        URI uri = UriComponentsBuilder.fromUriString(createCake)
                .buildAndExpand(uriParams)
                .toUri();

        HttpHeaders headers = new HttpHeaders();
        headers.set("cache-control", "no-cache");
        return cakeLabRestTemplate.exchange(uri, HttpMethod.POST, new HttpEntity<>(headers), String.class);

    }
}
