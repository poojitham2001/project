package com.project.flight_ticket_booking.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.validation.Valid;
import java.nio.file.Files;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.project.flight_ticket_booking.exception.ResourceNotFoundException;
import com.project.flight_ticket_booking.model.Category;
import com.project.flight_ticket_booking.model.Passengar;
import com.project.flight_ticket_booking.model.Customer;
import com.project.flight_ticket_booking.model.Employee;
import com.project.flight_ticket_booking.model.Month;
import com.project.flight_ticket_booking.model.Order;
import com.project.flight_ticket_booking.model.Vehicle;
import com.project.flight_ticket_booking.model.Salary;
import com.project.flight_ticket_booking.repository.PassengarRepository;
import com.project.flight_ticket_booking.services.FileUploadService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class PassengarController {

	@Autowired
	private PassengarRepository passengarRepository;
	
	@Autowired
	public FileUploadService fileService;
	
	@PersistenceContext
    private EntityManager entityManager;

	@GetMapping("/passengar")
	public List<Passengar> getAllPassengars() {
		return passengarRepository.findAll();
	}
	
	@GetMapping("/passengar/{id}")
	public ResponseEntity<Passengar> getPassengarById(@PathVariable(value = "id") Long passengarId)
			throws ResourceNotFoundException {
		Passengar passengar = passengarRepository.findById(passengarId)
				.orElseThrow(() -> new ResourceNotFoundException("Passengar not found for this id :: " + passengarId));
		return ResponseEntity.ok().body(passengar);
	}
	
	@GetMapping("/passengar/all-passengar/{id}")
	public ArrayList getAllSalaryFields(@PathVariable(value = "id") String order_id) {
		
		String SQL = "SELECT passen, cust, ordr from passengar passen, customer cust, orders ordr WHERE order_id = passengar_booking_id";
		 Query q = entityManager.createQuery(SQL);
		 if(!order_id.equals("0")) {
			 System.out.print("Employee Id : "+order_id);

			 SQL = "SELECT passen, ordr from passengar passen, orders ordr WHERE order_id = passengar_booking_id AND order_id = :order_id";
			 q = entityManager.createQuery(SQL);
			 q.setParameter("order_id", order_id);
		 } 
		 List<Object[]> passengar = q.getResultList();
		 ArrayList<HashMap<String, String>> resultArray = new ArrayList();
		 
		 for ( Object[] row : passengar ) {
			  Passengar passengar_details = (Passengar)row[ 0 ];
			  Order order_details = (Order)row[ 1 ];
			
			    HashMap<String, String> results = new HashMap();
			   
				results.put("passengar_id",String.valueOf(passengar_details.getPassengar_id()));
				results.put("passengar_name",passengar_details.getPassengar_name());
				results.put("passengar_booking_id",String.valueOf(passengar_details.getPassengar_booking_id()));
				results.put("passengar_gender",passengar_details.getPassengar_gender());
				results.put("passengar_age",passengar_details.getPassengar_age());
				
			    resultArray.add(results);
			 
		 }	 

        return resultArray;
	}
	
	@GetMapping("/passengar/all-users-passengar/{id}")
	public ArrayList getAllUsersPassengar(@PathVariable(value = "id") String user_id) {
		
		String SQL = "SELECT passen, cust, ordr from passengar passen, customer cust, orders ordr WHERE customerorder_id = passengar_booking_id";
		 Query q = entityManager.createQuery(SQL);
		 if(!user_id.equals("0")) {

			 SQL = "SELECT passen, ordr from passengar passen, orders ordr WHERE order_id = passengar_booking_id AND customer_id = :user_id";
			 q = entityManager.createQuery(SQL);
			 q.setParameter("user_id", user_id);
		 } 
		 List<Object[]> passengar = q.getResultList();
		 ArrayList<HashMap<String, String>> resultArray = new ArrayList();
		 
		 for ( Object[] row : passengar ) {
			  Passengar passengar_details = (Passengar)row[ 0 ];
			  Customer customer_details = (Customer)row[ 1 ];
			  Vehicle order_details = (Vehicle)row[ 2 ];
			
			    HashMap<String, String> results = new HashMap();
			   
			    results.put("passengar_id",String.valueOf(passengar_details.getPassengar_id()));
				results.put("passengar_name",passengar_details.getPassengar_name());
				results.put("passengar_booking_id",String.valueOf(passengar_details.getPassengar_booking_id()));
				results.put("passengar_gender",passengar_details.getPassengar_gender());
				results.put("passengar_age",passengar_details.getPassengar_age());
				results.put("customer_name",customer_details.getCustomer_first_name()+" "+customer_details.getCustomer_last_name());
				results.put("order_id",String.valueOf(order_details.getVehicle_id()));
				results.put("order_name",order_details.getVehicle_name());
				
			    resultArray.add(results);
			 
		 }	 

        return resultArray;
	}

	@PostMapping("/passengar")
	public Passengar createPassengar(@Valid @RequestBody Passengar passengar) {
		return passengarRepository.save(passengar);
	}
	
	@PutMapping("/passengar/{id}")
	public ResponseEntity<Passengar> updatePassengar(@PathVariable(value = "id") Long passengarId,
			@Valid @RequestBody Passengar passengarDetails) throws ResourceNotFoundException {
		final Passengar updatedPassengar = passengarRepository.save(passengarDetails);
		return ResponseEntity.ok(updatedPassengar);
	}

	@DeleteMapping("/passengar/{id}")
	public Map<String, Boolean> deletePassengar(@PathVariable(value = "id") Long passengarId)
			throws ResourceNotFoundException {
		Passengar passengar = passengarRepository.findById(passengarId)
				.orElseThrow(() -> new ResourceNotFoundException("Passengar not found for this id :: " + passengarId));

		passengarRepository.delete(passengar);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
