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
import com.project.flight_ticket_booking.model.Month;
import com.project.flight_ticket_booking.model.Vehicle;
import com.project.flight_ticket_booking.model.Salary;
import com.project.flight_ticket_booking.repository.CityRepository;
import com.project.flight_ticket_booking.repository.VehicleRepository;
import com.project.flight_ticket_booking.services.FileUploadService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class VehicleController {

	@Autowired
	private VehicleRepository vehicleRepository;
	
	@Autowired
	private CityRepository cityRepository;
	
	@Autowired
	public FileUploadService fileService;
	
	@PersistenceContext
    private EntityManager entityManager;

	@GetMapping("/vehicle")
	public List<Vehicle> getAllVehicles() {
		return vehicleRepository.findAll();
	}
	
	@GetMapping("/vehicle/{id}")
	public ResponseEntity<Vehicle> getVehicleById(@PathVariable(value = "id") Long vehicleId)
			throws ResourceNotFoundException {
		Vehicle vehicle = vehicleRepository.findById(vehicleId)
				.orElseThrow(() -> new ResourceNotFoundException("Vehicle not found for this id :: " + vehicleId));
		return ResponseEntity.ok().body(vehicle);
	}
	
	@GetMapping("/vehicle/vehicle-details/{id}")
	public ArrayList getVehicleDetailsById(@PathVariable(value = "id") Long vehicleId)
	 {
		String SQL = "SELECT vehicle, cat, comp from vehicle vehicle, category cat, company comp WHERE category_id = vehicle_category_id AND company_id = vehicle_company_id";
		 Query q = entityManager.createQuery(SQL);
		 if(!vehicleId.equals("0")) {
			 System.out.print("Vehicle Id : "+vehicleId);

			 SQL = "SELECT vehicle, cat, comp from vehicle vehicle, category cat, company comp WHERE category_id = vehicle_category_id AND company_id = vehicle_company_id AND vehicle_id = :vehicleId";
			 q = entityManager.createQuery(SQL);
			 q.setParameter("vehicleId", vehicleId);
		 } 
		 List<Object[]> vehicle = q.getResultList();
		 ArrayList<HashMap<String, String>> resultArray = new ArrayList();
		 
		 for ( Object[] row : vehicle ) {
			  Vehicle vehicle_details = (Vehicle)row[ 0 ];
			  Category category_details = (Category)row[ 1 ];
			  Company company_details = (Company)row[ 2 ];
			
			    HashMap<String, String> results = new HashMap();
			   
				results.put("category_title",category_details.getCategory_title());
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
	
	@GetMapping("/vehicle/all-vehicle/{id}")
	public ArrayList getAllSalaryFields(@PathVariable(value = "id") String category_id) {
		City city_details = new City();
		String SQL = "SELECT vehicle, cat, comp from vehicle vehicle, category cat, company comp WHERE category_id = vehicle_category_id AND company_id = vehicle_company_id";
		 Query q = entityManager.createQuery(SQL);
		 if(!category_id.equals("0")) {
			 System.out.print("Employee Id : "+category_id);

			 SQL = "SELECT vehicle, cat, comp from vehicle vehicle, category cat, company comp WHERE category_id = vehicle_category_id AND company_id = vehicle_company_id AND category_id = :category_id";
			 q = entityManager.createQuery(SQL);
			 q.setParameter("category_id", category_id);
		 } 
		 List<Object[]> vehicle = q.getResultList();
		 ArrayList<HashMap<String, String>> resultArray = new ArrayList();
		 
		 for ( Object[] row : vehicle ) {
			  Vehicle vehicle_details = (Vehicle)row[ 0 ];
			  Category category_details = (Category)row[ 1 ];
			  Company company_details = (Company)row[ 2 ];
			  
			
			    HashMap<String, String> results = new HashMap();
			    System.out.print("City Name : "+cityRepository.getCityName("1"));
			    results.put("from_city",cityRepository.getCityName(vehicle_details.getVehicle_from()));
			    results.put("to_city",cityRepository.getCityName(vehicle_details.getVehicle_to()));
			    results.put("category_title",category_details.getCategory_title());
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
	
	@GetMapping("/vehicle/all-search/{search}")
	public ArrayList searchVehicle(@PathVariable(value = "search") String search) {
		
		String SQL = "SELECT vehicle, cat from vehicle vehicle, category cat WHERE category_id = vehicle_category_id";
		 Query q = entityManager.createQuery(SQL);
		 if(!search.equals("0")) {

			 SQL = "SELECT vehicle, cat from vehicle vehicle, category cat WHERE category_id = vehicle_category_id AND (vehicle_title LIKE :title OR category_title LIKE :title)";
			 q = entityManager.createQuery(SQL);
			 q.setParameter("title",  "%" + search + "%");
		 } 
		 List<Object[]> vehicle = q.getResultList();
		 ArrayList<HashMap<String, String>> resultArray = new ArrayList();
		 
		 for ( Object[] row : vehicle ) {
			  Vehicle vehicle_details = (Vehicle)row[ 0 ];
			  Category category_details = (Category)row[ 1 ];
			
			    HashMap<String, String> results = new HashMap();
			   
			    results.put("category_title",category_details.getCategory_title());
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
	

	@RequestMapping(value = "/vehicle", method = RequestMethod.POST,
    consumes = {"multipart/form-data"})	
	public Vehicle createVehicle(@RequestParam("vehicle_image") MultipartFile vehicle_image, 
			@ModelAttribute("form") Vehicle vehicle) {
		System.out.print("File Data");
		try {
			long unixTime = System.currentTimeMillis() / 1000L;
			String fileName = unixTime+"_" +vehicle_image.getOriginalFilename();
			System.out.print("File URL : ");
			System.out.print(this.fileService.uploadToLocalFileSystem(vehicle_image, fileName));  
            vehicle.setVehicle_image_filename(fileName);
		
		}  catch (Exception e) {
			e.printStackTrace();
		}
		return vehicleRepository.save(vehicle);
	}
	
	 
    // For Downloading Files
    @GetMapping("/vehicle/vehicle_image/{fileName:.+}")
    public Path getFileUrl(@PathVariable(name = "fileName") String fileName) throws IOException {
    	System.out.print("Printing URL");
    	System.out.print(this.fileService.getFileURL(fileName));
    	Path fileLocation = this.fileService.getFileLocation(fileName);
    	File file = new File(fileLocation.toString());
    	InputStreamResource resource = new InputStreamResource(new FileInputStream(fileLocation.toString()));
   
    	return fileLocation;
    }

    @RequestMapping(value = "/vehicle/{id}", method = RequestMethod.POST,
    consumes = {"multipart/form-data"})	
	public Vehicle updateVehicle(@RequestParam("vehicle_image") MultipartFile vehicle_image, 
			@ModelAttribute("form") Vehicle vehicle) {
		System.out.print("File Data");
		try {
			if(!vehicle_image.isEmpty()) {
				long unixTime = System.currentTimeMillis() / 1000L;
				String fileName = unixTime+"_" +vehicle_image.getOriginalFilename();
				this.fileService.uploadToLocalFileSystem(vehicle_image, fileName);
	            vehicle.setVehicle_image_filename(fileName);
			}
		}  catch (Exception e) {
			e.printStackTrace();
		}
		return vehicleRepository.save(vehicle);
	}
    
    @PutMapping("/vehicle/{id}")
	public ResponseEntity<Vehicle> updateVehicle(@PathVariable(value = "id") Long vehicleId,
			@Valid @RequestBody Vehicle vehicleDetails) throws ResourceNotFoundException {
		final Vehicle updatedVehicle = vehicleRepository.save(vehicleDetails);
		return ResponseEntity.ok(updatedVehicle);
	}

	@DeleteMapping("/vehicle/{id}")
	public Map<String, Boolean> deleteVehicle(@PathVariable(value = "id") Long vehicleId)
			throws ResourceNotFoundException {
		Vehicle vehicle = vehicleRepository.findById(vehicleId)
				.orElseThrow(() -> new ResourceNotFoundException("Vehicle not found for this id :: " + vehicleId));

		vehicleRepository.delete(vehicle);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
