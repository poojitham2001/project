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

@Table(name = "vehicle")
@Entity(name = "vehicle")

public class Vehicle {

	private long vehicle_id;
	private MultipartFile vehicle_image;
	private String vehicle_company_id;
	private String vehicle_category_id;
	private String vehicle_name;
	private String vehicle_no;
	private String vehicle_from;
	private String vehicle_deaprture;
	private String vehicle_to;
	private String vehicle_arrival;
	private String vehicle_travel_time;
	private String vehicle_total_distance;
	private String vehicle_image_filename;
	
	
	public Vehicle() {
		
	}
	public Vehicle(long vehicle_id, MultipartFile vehicle_image, String vehicle_company_id, String vehicle_category_id,
			String vehicle_name, String vehicle_no, String vehicle_from, String vehicle_deaprture, String vehicle_to,
			String vehicle_arrival, String vehicle_travel_time, String vehicle_total_distance,
			String vehicle_image_filename) {
		super();
		this.vehicle_id = vehicle_id;
		this.vehicle_image = vehicle_image;
		this.vehicle_company_id = vehicle_company_id;
		this.vehicle_category_id = vehicle_category_id;
		this.vehicle_name = vehicle_name;
		this.vehicle_no = vehicle_no;
		this.vehicle_from = vehicle_from;
		this.vehicle_deaprture = vehicle_deaprture;
		this.vehicle_to = vehicle_to;
		this.vehicle_arrival = vehicle_arrival;
		this.vehicle_travel_time = vehicle_travel_time;
		this.vehicle_total_distance = vehicle_total_distance;
		this.vehicle_image_filename = vehicle_image_filename;
	}
	@Override
	public String toString() {
		return "Vehicle [vehicle_id=" + vehicle_id + ", vehicle_image=" + vehicle_image + ", vehicle_company_id="
				+ vehicle_company_id + ", vehicle_category_id=" + vehicle_category_id + ", vehicle_name=" + vehicle_name
				+ ", vehicle_no=" + vehicle_no + ", vehicle_from=" + vehicle_from + ", vehicle_deaprture="
				+ vehicle_deaprture + ", vehicle_to=" + vehicle_to + ", vehicle_arrival=" + vehicle_arrival
				+ ", vehicle_travel_time=" + vehicle_travel_time + ", vehicle_total_distance=" + vehicle_total_distance
				+ ", vehicle_image_filename=" + vehicle_image_filename + "]";
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getVehicle_id() {
		return vehicle_id;
	}
	public void setVehicle_id(long vehicle_id) {
		this.vehicle_id = vehicle_id;
	}
	
	public void setVehicle_image(MultipartFile vehicle_image) {
		this.vehicle_image = vehicle_image;
	}
	public String getVehicle_company_id() {
		return vehicle_company_id;
	}
	public void setVehicle_company_id(String vehicle_company_id) {
		this.vehicle_company_id = vehicle_company_id;
	}
	public String getVehicle_category_id() {
		return vehicle_category_id;
	}
	public void setVehicle_category_id(String vehicle_category_id) {
		this.vehicle_category_id = vehicle_category_id;
	}
	public String getVehicle_name() {
		return vehicle_name;
	}
	public void setVehicle_name(String vehicle_name) {
		this.vehicle_name = vehicle_name;
	}
	public String getVehicle_no() {
		return vehicle_no;
	}
	public void setVehicle_no(String vehicle_no) {
		this.vehicle_no = vehicle_no;
	}
	public String getVehicle_from() {
		return vehicle_from;
	}
	public void setVehicle_from(String vehicle_from) {
		this.vehicle_from = vehicle_from;
	}
	public String getVehicle_deaprture() {
		return vehicle_deaprture;
	}
	public void setVehicle_deaprture(String vehicle_deaprture) {
		this.vehicle_deaprture = vehicle_deaprture;
	}
	public String getVehicle_to() {
		return vehicle_to;
	}
	public void setVehicle_to(String vehicle_to) {
		this.vehicle_to = vehicle_to;
	}
	public String getVehicle_arrival() {
		return vehicle_arrival;
	}
	public void setVehicle_arrival(String vehicle_arrival) {
		this.vehicle_arrival = vehicle_arrival;
	}
	public String getVehicle_travel_time() {
		return vehicle_travel_time;
	}
	public void setVehicle_travel_time(String vehicle_travel_time) {
		this.vehicle_travel_time = vehicle_travel_time;
	}
	public String getVehicle_total_distance() {
		return vehicle_total_distance;
	}
	public void setVehicle_total_distance(String vehicle_total_distance) {
		this.vehicle_total_distance = vehicle_total_distance;
	}
	public String getVehicle_image_filename() {
		return vehicle_image_filename;
	}
	public void setVehicle_image_filename(String vehicle_image_filename) {
		this.vehicle_image_filename = vehicle_image_filename;
	}
}
