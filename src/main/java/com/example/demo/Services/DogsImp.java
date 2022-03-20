package com.example.demo.Services;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class DogsImp implements Dogs{

    private String url = "https://dog.ceo/api/breeds/image/random";
    Logger log = LoggerFactory.getLogger(DogsImp.class);
    
    @Override
    public String getDogs() {
        log.info("Accediendo API");

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();

        log.info("Datos obtenidos");
        
        return client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
            .thenApply(HttpResponse::body)
            .join();
        
    }

    
}
