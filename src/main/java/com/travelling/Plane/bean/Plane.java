package com.travelling.Plane.bean;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Component
@Entity
//@NamedQuery(name="Plane.findAll", query="SELECT p FROM Plane p")
@Table(name = "plane")
public class Plane implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="plane_id")
	private int planeId;

	@Column(name = "name")
	private String name;

	@Column(name = "seats")
	private int seats;

//	bi-directional many-to-one association to Flight
	@OneToMany(mappedBy="plane")
	private List<Flight> flights;

	public Plane() {
	}

	public int getPlaneId() {
		return this.planeId;
	}

	public void setPlaneId(int planeId) {
		this.planeId = planeId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSeats() {
		return this.seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	public List<Flight> getFlights() {
		return this.flights;
	}

	public void setFlights(List<Flight> flights) {
		this.flights = flights;
	}

	public Flight addFlight(Flight flight) {
		getFlights().add(flight);
		flight.setPlane(this);

		return flight;
	}

	public Flight removeFlight(Flight flight) {
		getFlights().remove(flight);
		flight.setPlane(null);

		return flight;
	}

}