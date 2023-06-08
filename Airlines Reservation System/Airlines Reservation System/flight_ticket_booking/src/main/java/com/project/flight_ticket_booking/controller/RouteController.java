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
import com.project.flight_ticket_booking.model.City;
import com.project.flight_ticket_booking.model.Company;
import com.project.flight_ticket_booking.model.Employee;
import com.project.flight_ticket_booking.model.Route;
import com.project.flight_ticket_booking.model.Month;
import com.project.flight_ticket_booking.model.Route;
import com.project.flight_ticket_booking.model.Salary;
import com.project.flight_ticket_booking.model.Vehicle;
import com.project.flight_ticket_booking.repository.CityRepository;
import com.project.flight_ticket_booking.repository.RouteRepository;
import com.project.flight_ticket_booking.services.FileUploadService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class RouteController {

	@Autowired
	private RouteRepository routeRepository;
	
	@Autowired
	private CityRepository cityRepository;
	
	@Autowired
	public FileUploadService fileService;
	
	@PersistenceContext
    private EntityManager entityManager;

	@GetMapping("/route")
	public List<Route> getAllRoutes() {
		return routeRepository.findAll();
	}
	
	@GetMapping("/route/{id}")
	public ResponseEntity<Route> getRouteById(@PathVariable(value = "id") Long routeId)
			throws ResourceNotFoundException {
		Route route = routeRepository.findById(routeId)
				.orElseThrow(() -> new ResourceNotFoundException("Route not found for this id :: " + routeId));
		return ResponseEntity.ok().body(route);
	}
	
	@GetMapping("/route/route-details/{id}")
	public ArrayList getRouteDetailsById(@PathVariable(value = "id") Long routeId)
	 {
		String SQL = "SELECT vehicle, cat, comp, rout from vehicle vehicle, category cat, company comp, route rout WHERE route_vehicle_id = vehicle_id AND category_id = vehicle_category_id AND company_id = vehicle_company_id";
		 Query q = entityManager.createQuery(SQL);
		 if(!routeId.equals("0")) {
			 System.out.print("Route Id : "+routeId);

			 SQL = "SELECT vehicle, cat, comp, rout from vehicle vehicle, category cat, company comp, route rout WHERE route_vehicle_id = vehicle_id AND category_id = vehicle_category_id AND company_id = vehicle_company_id AND route_id = :routeId";
			 q = entityManager.createQuery(SQL);
			 q.setParameter("routeId", routeId);
		 } 
		 List<Object[]> route = q.getResultList();
		 ArrayList<HashMap<String, String>> resultArray = new ArrayList();
		 
		 for ( Object[] row : route ) {
			  Vehicle vehicle_details = (Vehicle)row[ 0 ];
			  Category category_details = (Category)row[ 1 ];
			  Company company_details = (Company)row[ 2 ];
			  Route route_details = (Route)row[ 3 ];
			
			    HashMap<String, String> results = new HashMap();
			   
			    results.put("route_vehicle_id",route_details.getRoute_vehicle_id());
			    results.put("route_from_city",route_details.getRoute_from_city());
			    results.put("route_from_arrival",route_details.getRoute_to_city());
			    results.put("route_from_departure",route_details.getRoute_from_departure());
			    results.put("route_to_city",route_details.getRoute_to_city());
			    results.put("route_economy_fare",route_details.getRoute_economy_fare());
			    results.put("route_business_fare",route_details.getRoute_business_fare());
			    results.put("route_duration",route_details.getRoute_duration());
			    results.put("route_from_name",cityRepository.getCityName(route_details.getRoute_from_city()));
			    results.put("route_to_name",cityRepository.getCityName(route_details.getRoute_to_city()));
			    results.put("category_title",category_details.getCategory_title());
			    results.put("from_city",cityRepository.getCityName(vehicle_details.getVehicle_from()));
			    results.put("to_city",cityRepository.getCityName(vehicle_details.getVehicle_to()));
				results.put("company_title",company_details.getCompany_title());
				results.put("company_title",company_details.getCompany_title());
				results.put("vehicle_id",String.valueOf(vehicle_details.getVehicle_id()));
				results.put("vehicle_company_id",String.valueOf(vehicle_details.getVehicle_company_id()));
				results.put("vehicle_category_id",String.valueOf(vehicle_details.getVehicle_category_id()));
				results.put("vehicle_name",vehicle_details.getVehicle_name());
				results.put("vehicle_no",vehicle_details.getVehicle_no());
				results.put("vehicle_from",vehicle_details.getVehicle_from());
				results.put("vehicle_deaprture",vehicle_details.getVehicle_deaprture());
				results.put("vehicle_to",String.valueOf(vehicle_details.getVehicle_to()));
				results.put("vehicle_arrival",vehicle_details.getVehicle_arrival());
				results.put("vehicle_travel_time",String.valueOf(vehicle_details.getVehicle_travel_time()));
				results.put("vehicle_total_distance",vehicle_details.getVehicle_total_distance());
				results.put("vehicle_image_filename",vehicle_details.getVehicle_image_filename());
				
			    resultArray.add(results);
			 
		 }	 

       return resultArray;
	}
	
	@GetMapping("/route/all-route/{id}")
	public ArrayList getAllSalaryFields(@PathVariable(value = "id") String vehicle_id) {
		City city_details = new City();
		String SQL = "SELECT vehicle, cat, comp, rout from vehicle vehicle, category cat, company comp, route rout WHERE route_vehicle_id = vehicle_id AND category_id = vehicle_category_id AND company_id = vehicle_company_id";
		 Query q = entityManager.createQuery(SQL);
		 if(!vehicle_id.equals("0")) {
			 SQL = "SELECT vehicle, cat, comp, rout from vehicle vehicle, category cat, company comp, route rout WHERE route_vehicle_id = vehicle_id AND category_id = vehicle_category_id AND company_id = vehicle_company_id AND vehicle_id = :vehicle_id";
			 q = entityManager.createQuery(SQL);
			 q.setParameter("vehicle_id", vehicle_id);
		 } 
		 List<Object[]> route = q.getResultList();
		 ArrayList<HashMap<String, String>> resultArray = new ArrayList();
		 
		 for ( Object[] row : route ) {
			  Vehicle vehicle_details = (Vehicle)row[ 0 ];
			  Category category_details = (Category)row[ 1 ];
			  Company company_details = (Company)row[ 2 ];
			  Route route_details = (Route)row[ 3 ];
			  
			
			    HashMap<String, String> results = new HashMap();
			    results.put("route_id",String.valueOf(route_details.getRoute_id()));
			    results.put("route_vehicle_id",route_details.getRoute_vehicle_id());
			    results.put("route_from_city",route_details.getRoute_from_city());
			    results.put("route_from_arrival",route_details.getRoute_to_city());
			    results.put("route_from_departure",route_details.getRoute_from_departure());
			    results.put("route_to_city",route_details.getRoute_to_city());
			    results.put("route_economy_fare",route_details.getRoute_economy_fare());
			    results.put("route_business_fare",route_details.getRoute_business_fare());
			    results.put("route_duration",route_details.getRoute_duration());
			    results.put("route_from_name",cityRepository.getCityName(route_details.getRoute_from_city()));
			    results.put("route_to_name",cityRepository.getCityName(route_details.getRoute_to_city()));
			    results.put("category_title",category_details.getCategory_title());
			    results.put("from_city",cityRepository.getCityName(vehicle_details.getVehicle_from()));
			    results.put("to_city",cityRepository.getCityName(vehicle_details.getVehicle_to()));
				results.put("company_title",company_details.getCompany_title());
				results.put("company_title",company_details.getCompany_title());
				results.put("vehicle_id",String.valueOf(vehicle_details.getVehicle_id()));
				results.put("vehicle_company_id",String.valueOf(vehicle_details.getVehicle_company_id()));
				results.put("vehicle_category_id",String.valueOf(vehicle_details.getVehicle_category_id()));
				results.put("vehicle_name",vehicle_details.getVehicle_name());
				results.put("vehicle_no",vehicle_details.getVehicle_no());
				results.put("vehicle_from",vehicle_details.getVehicle_from());
				results.put("vehicle_deaprture",vehicle_details.getVehicle_deaprture());
				results.put("vehicle_to",String.valueOf(vehicle_details.getVehicle_to()));
				results.put("vehicle_arrival",vehicle_details.getVehicle_arrival());
				results.put("vehicle_travel_time",String.valueOf(vehicle_details.getVehicle_travel_time()));
				results.put("vehicle_total_distance",vehicle_details.getVehicle_total_distance());
				results.put("vehicle_image_filename",vehicle_details.getVehicle_image_filename());
				
			    resultArray.add(results);
			 
		 }	 

        return resultArray;
	}
	
	@GetMapping("/route/search/{from}/{to}")
	public ArrayList searchRoute(@PathVariable(value = "from") String from_city, @PathVariable(value = "to") String to_city) {
		 String SQL = "SELECT vehicle, cat, comp, rout from vehicle vehicle, category cat, company comp, route rout WHERE route_vehicle_id = vehicle_id AND category_id = vehicle_category_id AND company_id = vehicle_company_id";
		 Query q = entityManager.createQuery(SQL);
		 if(!from_city.equals("0")) {
			 SQL = "SELECT vehicle, cat, comp, rout from vehicle vehicle, category cat, company comp, route rout WHERE route_vehicle_id = vehicle_id AND category_id = vehicle_category_id AND company_id = vehicle_company_id AND route_from_city = :from_city AND route_to_city = :to_city";
			 q = entityManager.createQuery(SQL);
			 q.setParameter("from_city", from_city);
			 q.setParameter("to_city", to_city);
		 } 
		 List<Object[]> route = q.getResultList();
		 ArrayList<HashMap<String, String>> resultArray = new ArrayList();
		 
		 for ( Object[] row : route ) {
			  Vehicle vehicle_details = (Vehicle)row[ 0 ];
			  Category category_details = (Category)row[ 1 ];
			  Company company_details = (Company)row[ 2 ];
			  Route route_details = (Route)row[ 3 ];
			  
			
			    HashMap<String, String> results = new HashMap();
			    results.put("route_id",String.valueOf(route_details.getRoute_id()));
			    results.put("route_vehicle_id",route_details.getRoute_vehicle_id());
			    results.put("route_from_city",route_details.getRoute_from_city());
			    results.put("route_from_arrival",route_details.getRoute_to_city());
			    results.put("route_from_departure",route_details.getRoute_from_departure());
			    results.put("route_to_city",route_details.getRoute_to_city());
			    results.put("route_economy_fare",route_details.getRoute_economy_fare());
			    results.put("route_business_fare",route_details.getRoute_business_fare());
			    results.put("route_duration",route_details.getRoute_duration());
			    results.put("route_from_name",cityRepository.getCityName(route_details.getRoute_from_city()));
			    results.put("route_to_name",cityRepository.getCityName(route_details.getRoute_to_city()));
			    results.put("category_title",category_details.getCategory_title());
			    results.put("from_city",cityRepository.getCityName(vehicle_details.getVehicle_from()));
			    results.put("to_city",cityRepository.getCityName(vehicle_details.getVehicle_to()));
				results.put("company_title",company_details.getCompany_title());
				results.put("company_title",company_details.getCompany_title());
				results.put("vehicle_id",String.valueOf(vehicle_details.getVehicle_id()));
				results.put("vehicle_company_id",String.valueOf(vehicle_details.getVehicle_company_id()));
				results.put("vehicle_category_id",String.valueOf(vehicle_details.getVehicle_category_id()));
				results.put("vehicle_name",vehicle_details.getVehicle_name());
				results.put("vehicle_no",vehicle_details.getVehicle_no());
				results.put("vehicle_from",vehicle_details.getVehicle_from());
				results.put("vehicle_deaprture",vehicle_details.getVehicle_deaprture());
				results.put("vehicle_to",String.valueOf(vehicle_details.getVehicle_to()));
				results.put("vehicle_arrival",vehicle_details.getVehicle_arrival());
				results.put("vehicle_travel_time",String.valueOf(vehicle_details.getVehicle_travel_time()));
				results.put("vehicle_total_distance",vehicle_details.getVehicle_total_distance());
				results.put("vehicle_image_filename",vehicle_details.getVehicle_image_filename());
				
			    resultArray.add(results);
			 
		 }	 

        return resultArray;
	}
	
	
	@PostMapping("/route")
	public Route createRoute(@Valid @RequestBody Route route) {
		System.out.print("I am here");
		System.out.print(route);
		return routeRepository.save(route);
	}
	
	@PutMapping("/route/{id}")
	public ResponseEntity<Route> updateRoute(@PathVariable(value = "id") Long routeId,
			@Valid @RequestBody Route routeDetails) throws ResourceNotFoundException {
		final Route updatedRoute = routeRepository.save(routeDetails);
		return ResponseEntity.ok(updatedRoute);
	}

	@DeleteMapping("/route/{id}")
	public Map<String, Boolean> deleteRoute(@PathVariable(value = "id") Long routeId)
			throws ResourceNotFoundException {
		Route route = routeRepository.findById(routeId)
				.orElseThrow(() -> new ResourceNotFoundException("Route not found for this id :: " + routeId));

		routeRepository.delete(route);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
