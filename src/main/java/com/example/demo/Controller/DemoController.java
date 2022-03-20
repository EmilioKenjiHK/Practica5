package com.example.demo.Controller;

import java.util.ArrayList;

import javax.validation.Valid;

import com.example.demo.Services.Dogs;
import com.example.demo.Services.Respuesta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

// Primera Capa (propio API)
@Slf4j
@RestController
public class DemoController {
    private ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();

    @Autowired
    private Dogs dogs;

    @GetMapping("/cuestionario")
    public @ResponseBody ResponseEntity<ArrayList<Respuesta>> getDatos() {

        return ResponseEntity.ok().body(respuestas);
    }

    @PostMapping("/cuestionario")
    public void postDatos(@Valid @RequestBody Respuesta r) {
        respuestas.add(r);
    }

    @GetMapping("/dogs")
    public @ResponseBody String getDogs() {
        return dogs.getDogs();
    }
    
}
