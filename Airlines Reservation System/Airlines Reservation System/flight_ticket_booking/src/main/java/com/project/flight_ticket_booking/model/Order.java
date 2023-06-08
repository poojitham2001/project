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

@Table(name = "orders")
@Entity(name = "orders")

public class Order {

	private long order_id;
	private String order_customer_id;
	private String order_total;
	private String order_status;
	private String order_date;
	private String order_route_id;
	private String order_travel_date;
	
	public Order() {
		
	}
	

	public Order(long order_id, String order_customer_id, String order_total, String order_status, String order_date,
			String order_route_id, String order_travel_date) {
		super();
		this.order_id = order_id;
		this.order_customer_id = order_customer_id;
		this.order_total = order_total;
		this.order_status = order_status;
		this.order_date = order_date;
		this.order_route_id = order_route_id;
		this.order_travel_date = order_travel_date;
	}


	@Override
	public String toString() {
		return "Order [order_id=" + order_id + ", order_customer_id=" + order_customer_id + ", order_total="
				+ order_total + ", order_status=" + order_status + ", order_date=" + order_date + ", order_route_id="
				+ order_route_id + ", order_travel_date=" + order_travel_date + "]";
	}


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getOrder_id() {
		return order_id;
	}

	public void setOrder_id(long order_id) {
		this.order_id = order_id;
	}

	public String getOrder_customer_id() {
		return order_customer_id;
	}

	public void setOrder_customer_id(String order_customer_id) {
		this.order_customer_id = order_customer_id;
	}

	public String getOrder_total() {
		return order_total;
	}

	public void setOrder_total(String order_total) {
		this.order_total = order_total;
	}

	public String getOrder_status() {
		return order_status;
	}

	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}

	public String getOrder_date() {
		return order_date;
	}

	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}

	public String getOrder_route_id() {
		return order_route_id;
	}

	public void setOrder_route_id(String order_route_id) {
		this.order_route_id = order_route_id;
	}

	public String getOrder_travel_date() {
		return order_travel_date;
	}

	public void setOrder_travel_date(String order_travel_date) {
		this.order_travel_date = order_travel_date;
	}
	
}
