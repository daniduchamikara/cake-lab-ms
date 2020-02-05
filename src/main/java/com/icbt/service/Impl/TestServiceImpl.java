package com.icbt.service.Impl;

import com.icbt.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@Service
public class TestServiceImpl implements TestService {


    @Value("${direct.endpoint.getAllDetails}")
    private String getAllDetails;

    @Autowired
    @Qualifier("cakeLabRestTemplate")
    RestTemplate cakeLabRestTemplate;

    @Override
    public ResponseEntity testController() {
        ResponseEntity responseEntity;

        Map<String, String> uriParams = new HashMap<>();

        URI uri = UriComponentsBuilder.fromUriString(getAllDetails)
                .buildAndExpand(uriParams)
                .toUri();

        HttpHeaders headers = new HttpHeaders();
        headers.set("cache-control", "no-cache");

        responseEntity = cakeLabRestTemplate.exchange(uri, HttpMethod.GET, new HttpEntity<>(headers), String.class);
        return responseEntity;
    }
}
