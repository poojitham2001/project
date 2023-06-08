package com.project.flight_ticket_booking.model;

import javax.persistence.CascadeType;
//import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.web.multipart.MultipartFile;

@Table(name = "route")
@Entity(name = "route")

public class Route {

	private long route_id;
	private String route_vehicle_id;
	private String route_from_city;
	private String route_from_arrival;
	private String route_from_departure;
	private String route_to_city;
	private String route_economy_fare;
	private String route_business_fare;
	private String route_duration;
	
	
	public Route() {
		
	}
	public Route(long route_id, String route_vehicle_id, String route_from_city, String route_from_arrival,
			String route_from_departure, String route_to_city, String route_economy_fare, String route_business_fare,
			String route_duration) {
		super();
		this.route_id = route_id;
		this.route_vehicle_id = route_vehicle_id;
		this.route_from_city = route_from_city;
		this.route_from_arrival = route_from_arrival;
		this.route_from_departure = route_from_departure;
		this.route_to_city = route_to_city;
		this.route_economy_fare = route_economy_fare;
		this.route_business_fare = route_business_fare;
		this.route_duration = route_duration;
	}
	
	@Override
	public String toString() {
		return "Route [route_id=" + route_id + ", route_vehicle_id=" + route_vehicle_id + ", route_from_city="
				+ route_from_city + ", route_from_arrival=" + route_from_arrival + ", route_from_departure="
				+ route_from_departure + ", route_to_city=" + route_to_city + ", route_economy_fare="
				+ route_economy_fare + ", route_business_fare=" + route_business_fare + ", route_duration="
				+ route_duration + "]";
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getRoute_id() {
		return route_id;
	}
	public void setRoute_id(long route_id) {
		this.route_id = route_id;
	}
	public String getRoute_vehicle_id() {
		return route_vehicle_id;
	}
	public void setRoute_vehicle_id(String route_vehicle_id) {
		this.route_vehicle_id = route_vehicle_id;
	}
	public String getRoute_from_city() {
		return route_from_city;
	}
	public void setRoute_from_city(String route_from_city) {
		this.route_from_city = route_from_city;
	}
	public String getRoute_from_arrival() {
		return route_from_arrival;
	}
	public void setRoute_from_arrival(String route_from_arrival) {
		this.route_from_arrival = route_from_arrival;
	}
	public String getRoute_from_departure() {
		return route_from_departure;
	}
	public void setRoute_from_departure(String route_from_departure) {
		this.route_from_departure = route_from_departure;
	}
	public String getRoute_to_city() {
		return route_to_city;
	}
	public void setRoute_to_city(String route_to_city) {
		this.route_to_city = route_to_city;
	}
	public String getRoute_economy_fare() {
		return route_economy_fare;
	}
	public void setRoute_economy_fare(String route_economy_fare) {
		this.route_economy_fare = route_economy_fare;
	}
	public String getRoute_business_fare() {
		return route_business_fare;
	}
	public void setRoute_business_fare(String route_business_fare) {
		this.route_business_fare = route_business_fare;
	}
	public String getRoute_duration() {
		return route_duration;
	}
	public void setRoute_duration(String route_duration) {
		this.route_duration = route_duration;
	}
	
	
	
	
}
