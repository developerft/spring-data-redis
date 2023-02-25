package com.furkant.redis.controller;

import com.furkant.redis.model.Cities;
import com.furkant.redis.service.CitiesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/city")
public class CitiesController {

    private final CitiesService citiesService;

    public CitiesController(CitiesService citiesService) {
        this.citiesService = citiesService;
    }

    @GetMapping
    public ResponseEntity<Cities> getCitiesById(@RequestParam Long id) {
        return ResponseEntity.ok(citiesService.getCitiesById(id));
    }

    @PostMapping
    public ResponseEntity<Cities> createCities(@RequestBody Cities cities) throws InterruptedException {
        return ResponseEntity.ok(citiesService.createCities(cities));
    }
}
