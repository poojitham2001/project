package com.project.flight_ticket_booking.model;

//import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name = "city")
@Entity(name = "city")

public class City {

	private long city_id;
	private String city_name;
	
//	@OneToOne(fetch=FetchType.LAZY, mappedBy="city")
//    private Employee employee;
	
	
	public City() {
		
	}

	public City(long city_id, String city_name) {
		super();
		this.city_id = city_id;
		this.city_name = city_name;
	}


	@Override
	public String toString() {
		return "City [city_id=" + city_id + ", city_name=" + city_name + "]";
	}


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getCity_id() {
		return city_id;
	}


	public void setCity_id(long city_id) {
		this.city_id = city_id;
	}


	public String getCity_name() {
		return city_name;
	}


	public void setCity_name(String city_name) {
		this.city_name = city_name;
	}
	
}
