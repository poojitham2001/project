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
import com.project.flight_ticket_booking.model.Category;
import com.project.flight_ticket_booking.model.Company;
import com.project.flight_ticket_booking.model.Country;
import com.project.flight_ticket_booking.model.Vehicle;
import com.project.flight_ticket_booking.model.Sell;
import com.project.flight_ticket_booking.model.State;
import com.project.flight_ticket_booking.repository.SellRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class SellController {
	@Autowired
	private SellRepository sellRepository;
	
	@PersistenceContext
    private EntityManager entityManager;

	@GetMapping("/sells")
	public List<Sell> getAllEmployees() {
		return sellRepository.findAll();
	}

	@GetMapping("/sells/search/{name}")
	public List<Sell> getEmployeeByName(@PathVariable(value = "name") String sellName) {
			return sellRepository.serchUserByName(sellName);
	}
	
	@GetMapping("/sells/search-state/{state}")
	public List<Sell> serchUserByState(@PathVariable(value = "state") String sellState) {
			return sellRepository.serchUserByState(sellState);
	}
	
	@GetMapping("/sells/all-sells/{id}")
	public ArrayList getAllEmployeeFields(@PathVariable(value = "id") Long orderId) {
		 Query q = entityManager.createQuery("SELECT prod, sel from vehicle prod, sell sel WHERE sell_vehicle_id = vehicle_id AND sell_order_id = ?1");
		 List<Object[]> sell = q.setParameter(1, orderId).getResultList();
		 ArrayList<HashMap<String, String>> resultArray = new ArrayList();
		 
		 for ( Object[] row : sell ) {
			  Sell sell_details = (Sell)row[ 1 ];
			  Vehicle vehicle_details = (Vehicle)row[ 0 ];
			  
			  HashMap<String, String> results = new HashMap();
			    results.put("sell_id",String.valueOf(sell_details.getSell_id()));
			    results.put("sell_order_id",sell_details.getSell_order_id());
			    results.put("sell_vehicle_id",sell_details.getSell_vehicle_id());
			    results.put("sell_units",sell_details.getSell_units());
			    results.put("sell_price_per_unit",sell_details.getSell_price_per_unit());
			    results.put("sell_total_cost",sell_details.getSell_total_cost());
			    results.put("vehicle_id",String.valueOf(vehicle_details.getVehicle_id()));
				results.put("vehicle_category_id",vehicle_details.getVehicle_category_id());
				results.put("vehicle_name",vehicle_details.getVehicle_name());
				results.put("vehicle_image",vehicle_details.getVehicle_image_filename());
				resultArray.add(results);
			 
		 }	 

        return resultArray;
	}
	
	@GetMapping("/sells/{id}")
	public ResponseEntity<Sell> getEmployeeById(@PathVariable(value = "id") Long sellId)
			throws ResourceNotFoundException {
		Sell sell = sellRepository.findById(sellId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + sellId));
		return ResponseEntity.ok().body(sell);
	}

	@PostMapping("/sells")
	public Sell createEmployee(@Valid @RequestBody Sell sell) {
		return sellRepository.save(sell);
	}

	@PutMapping("/sells/{id}")
	public ResponseEntity<Sell> updateEmployee(@PathVariable(value = "id") Long sellId,
			@Valid @RequestBody Sell sellDetails) throws ResourceNotFoundException {
		final Sell updatedEmployee = sellRepository.save(sellDetails);
		return ResponseEntity.ok(updatedEmployee);
	}

	@DeleteMapping("/sells/{id}")
	public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long sellId)
			throws ResourceNotFoundException {
		Sell sell = sellRepository.findById(sellId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + sellId));

		sellRepository.delete(sell);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
