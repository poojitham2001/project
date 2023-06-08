package com.project.flight_ticket_booking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.flight_ticket_booking.model.Category;
import com.project.flight_ticket_booking.model.City;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
	
	@Query(value = "SELECT city_name FROM city WHERE city_id = ?1", nativeQuery = true)
	public String getCityName(String city_id);

}
