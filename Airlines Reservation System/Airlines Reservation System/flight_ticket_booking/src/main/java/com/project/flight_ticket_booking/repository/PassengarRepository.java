package com.project.flight_ticket_booking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.flight_ticket_booking.model.Passengar;

@Repository
public interface PassengarRepository extends JpaRepository<Passengar, Long> {


}
