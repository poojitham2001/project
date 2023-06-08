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
import com.project.flight_ticket_booking.model.Customer;
import com.project.flight_ticket_booking.model.Order;
import com.project.flight_ticket_booking.model.Route;
import com.project.flight_ticket_booking.model.Vehicle;
import com.project.flight_ticket_booking.model.Sell;
import com.project.flight_ticket_booking.repository.CityRepository;
import com.project.flight_ticket_booking.repository.OrderRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class OrderController {
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CityRepository cityRepository;
	
	@PersistenceContext
    private EntityManager entityManager;

	@GetMapping("/orders")
	public List<Order> getAllOrders() {
		return orderRepository.findAll();
	}
	
	@GetMapping("/orders/{id}")
	public ResponseEntity<Order> getOrderById(@PathVariable(value = "id") Long orderId)
			throws ResourceNotFoundException {
		Order order = orderRepository.findById(orderId)
				.orElseThrow(() -> new ResourceNotFoundException("Order not found for this id :: " + orderId));
		return ResponseEntity.ok().body(order);
	}

	@PostMapping("/orders")
	public Order createOrder(@Valid @RequestBody Order order) {
		return orderRepository.save(order);
	}

	@PutMapping("/orders/{id}")
	public ResponseEntity<Order> updateOrder(@PathVariable(value = "id") Long orderId,
			@Valid @RequestBody Order orderDetails) throws ResourceNotFoundException {
		final Order updatedOrder = orderRepository.save(orderDetails);
		return ResponseEntity.ok(updatedOrder);
	}
	
	@GetMapping("/orders/all-orders")
	public ArrayList getAllEmployeeFields() {
		 Query q = entityManager.createQuery("SELECT cust, ord, rout, vhl from orders ord, customer cust, route rout, vehicle vhl WHERE vehicle_id = route_vehicle_id AND order_status = 'Paid' AND customer_id = order_customer_id AND order_route_id = route_id");
		 List<Object[]> sell = q.getResultList();
		 ArrayList<HashMap<String, String>> resultArray = new ArrayList();
		 
		 for ( Object[] row : sell ) {
			  Order order_details = (Order)row[ 1 ];
			  Customer customer_details = (Customer)row[ 0 ];
			  Route route_details = (Route)row[ 2 ];
			  Vehicle vehicle_details = (Vehicle)row[ 3 ];
			  
			  HashMap<String, String> results = new HashMap();
			    results.put("order_id",String.valueOf(order_details.getOrder_id()));
			    results.put("order_customer_id",order_details.getOrder_customer_id());
			    results.put("order_total",order_details.getOrder_total());
			    results.put("order_status",order_details.getOrder_status());
			    results.put("order_travel_date",order_details.getOrder_travel_date());
			    results.put("order_date",order_details.getOrder_date());
			    results.put("customer_name",customer_details.getCustomer_first_name()+" "+customer_details.getCustomer_last_name());
			    results.put("customer_mobile",String.valueOf(customer_details.getCustomer_mobile()));
			    
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
			    results.put("from_city",cityRepository.getCityName(vehicle_details.getVehicle_from()));
			    results.put("to_city",cityRepository.getCityName(vehicle_details.getVehicle_to()));
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
	@GetMapping("/orders/customer-orders/{id}")
	public ArrayList getAllCustomerOrders(@PathVariable(value = "id") Long orderId) {
		 Query q = entityManager.createQuery("SELECT cust, ord, rout, vhl from orders ord, customer cust, route rout, vehicle vhl WHERE vehicle_id = route_vehicle_id AND order_status = 'Paid' AND customer_id = order_customer_id AND order_route_id = route_id AND order_customer_id = ?1");
		 List<Object[]> sell = q.setParameter(1, orderId).getResultList();
		 ArrayList<HashMap<String, String>> resultArray = new ArrayList();
		 
		 for ( Object[] row : sell ) {
			  Order order_details = (Order)row[ 1 ];
			  Customer customer_details = (Customer)row[ 0 ];
			  Route route_details = (Route)row[ 2 ];
			  Vehicle vehicle_details = (Vehicle)row[ 3 ];
			  
			  HashMap<String, String> results = new HashMap();
			    results.put("order_id",String.valueOf(order_details.getOrder_id()));
			    results.put("order_customer_id",order_details.getOrder_customer_id());
			    results.put("order_total",order_details.getOrder_total());
			    results.put("order_status",order_details.getOrder_status());
			    results.put("order_date",order_details.getOrder_date());
			    results.put("order_travel_date",order_details.getOrder_travel_date());
			    results.put("customer_name",customer_details.getCustomer_first_name()+" "+customer_details.getCustomer_last_name());
			    results.put("customer_mobile",String.valueOf(customer_details.getCustomer_mobile()));
			    
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
			    results.put("from_city",cityRepository.getCityName(vehicle_details.getVehicle_from()));
			    results.put("to_city",cityRepository.getCityName(vehicle_details.getVehicle_to()));
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
	
	@GetMapping("/orders/details/{id}")
	public ArrayList getOrderDetails(@PathVariable(value = "id") Long orderId) {
		 Query q = entityManager.createQuery("SELECT cust, ord, rout, vhl from orders ord, customer cust, route rout, vehicle vhl WHERE vehicle_id = route_vehicle_id AND order_status = 'Paid' AND customer_id = order_customer_id AND order_route_id = route_id AND order_id = ?1");
		 List<Object[]> sell = q.setParameter(1, orderId).getResultList();
		 ArrayList<HashMap<String, String>> resultArray = new ArrayList();
		 
		 for ( Object[] row : sell ) {
			 Order order_details = (Order)row[ 1 ];
			  Customer customer_details = (Customer)row[ 0 ];
			  Route route_details = (Route)row[ 2 ];
			  Vehicle vehicle_details = (Vehicle)row[ 3 ];
			  
			  HashMap<String, String> results = new HashMap();
			  results.put("order_id",String.valueOf(order_details.getOrder_id()));
			    results.put("order_customer_id",order_details.getOrder_customer_id());
			    results.put("order_total",order_details.getOrder_total());
			    results.put("order_status",order_details.getOrder_status());
			    results.put("order_date",order_details.getOrder_date());
			    results.put("order_travel_date",order_details.getOrder_travel_date());
			    results.put("customer_name",customer_details.getCustomer_first_name()+" "+customer_details.getCustomer_last_name());
			    results.put("customer_mobile",String.valueOf(customer_details.getCustomer_mobile()));
			    
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
			    results.put("from_city",cityRepository.getCityName(vehicle_details.getVehicle_from()));
			    results.put("to_city",cityRepository.getCityName(vehicle_details.getVehicle_to()));
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

	@DeleteMapping("/orders/{id}")
	public Map<String, Boolean> deleteOrder(@PathVariable(value = "id") Long orderId)
			throws ResourceNotFoundException {
		Order order = orderRepository.findById(orderId)
				.orElseThrow(() -> new ResourceNotFoundException("Order not found for this id :: " + orderId));

		orderRepository.delete(order);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
