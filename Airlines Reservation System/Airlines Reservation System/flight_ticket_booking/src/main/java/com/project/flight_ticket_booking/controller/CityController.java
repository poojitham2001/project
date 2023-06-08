package com.project.flight_ticket_booking.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.flight_ticket_booking.exception.ResourceNotFoundException;
import com.project.flight_ticket_booking.model.City;
import com.project.flight_ticket_booking.model.Employee;
import com.project.flight_ticket_booking.model.Login;
import com.project.flight_ticket_booking.repository.CityRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class CityController {

	@Autowired
	private CityRepository cityRepository;
	
	@PersistenceContext
    private EntityManager entityManager;

	@GetMapping("/city")
	public List<City> getAllCitys() {
		return cityRepository.findAll();
	}
	
	@GetMapping("/city/{id}")
	public ResponseEntity<City> getCityById(@PathVariable(value = "id") Long cityId)
			throws ResourceNotFoundException {
		City city = cityRepository.findById(cityId)
				.orElseThrow(() -> new ResourceNotFoundException("City not found for this id :: " + cityId));
		return ResponseEntity.ok().body(city);
	}

	@PostMapping("/city")
	public City createCity(@Valid @RequestBody City city) {
		return cityRepository.save(city);
	}

	@PutMapping("/city/{id}")
	public ResponseEntity<City> updateCity(@PathVariable(value = "id") Long cityId,
			@Valid @RequestBody City cityDetails) throws ResourceNotFoundException {
		final City updatedCity = cityRepository.save(cityDetails);
		return ResponseEntity.ok(updatedCity);
	}

	@DeleteMapping("/city/{id}")
	public Map<String, Boolean> deleteCity(@PathVariable(value = "id") Long cityId)
			throws ResourceNotFoundException {
		City city = cityRepository.findById(cityId)
				.orElseThrow(() -> new ResourceNotFoundException("City not found for this id :: " + cityId));
		
		cityRepository.delete(city);
		
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	
}
