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

@Table(name = "passengar")
@Entity(name = "passengar")

public class Passengar {

	private long passengar_id;
	private String passengar_booking_id;
	private String passengar_user_id;
	private String passengar_name;
	private String passengar_age;
	private String passengar_gender;
	
	
	public Passengar() {
		
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getPassengar_id() {
		return passengar_id;
	}


	public void setPassengar_id(long passengar_id) {
		this.passengar_id = passengar_id;
	}


	public String getPassengar_booking_id() {
		return passengar_booking_id;
	}


	public void setPassengar_booking_id(String passengar_booking_id) {
		this.passengar_booking_id = passengar_booking_id;
	}


	public String getPassengar_user_id() {
		return passengar_user_id;
	}


	public void setPassengar_user_id(String passengar_user_id) {
		this.passengar_user_id = passengar_user_id;
	}


	public String getPassengar_name() {
		return passengar_name;
	}


	public void setPassengar_name(String passengar_name) {
		this.passengar_name = passengar_name;
	}


	public String getPassengar_age() {
		return passengar_age;
	}


	public void setPassengar_age(String passengar_age) {
		this.passengar_age = passengar_age;
	}


	public String getPassengar_gender() {
		return passengar_gender;
	}


	public void setPassengar_gender(String passengar_gender) {
		this.passengar_gender = passengar_gender;
	}


	@Override
	public String toString() {
		return "Passengar [passengar_id=" + passengar_id + ", passengar_booking_id=" + passengar_booking_id
				+ ", passengar_user_id=" + passengar_user_id + ", passengar_name=" + passengar_name + ", passengar_age="
				+ passengar_age + ", passengar_gender=" + passengar_gender + "]";
	}


	public Passengar(long passengar_id, String passengar_booking_id, String passengar_user_id, String passengar_name,
			String passengar_age, String passengar_gender) {
		super();
		this.passengar_id = passengar_id;
		this.passengar_booking_id = passengar_booking_id;
		this.passengar_user_id = passengar_user_id;
		this.passengar_name = passengar_name;
		this.passengar_age = passengar_age;
		this.passengar_gender = passengar_gender;
	}
	
	
}
