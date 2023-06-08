package com.project.flight_ticket_booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.flight_ticket_booking.model.Month;

@Repository
public interface MonthRepository extends JpaRepository<Month, Long> {

}
