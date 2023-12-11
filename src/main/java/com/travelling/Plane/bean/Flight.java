package com.travelling.Plane.bean;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the flight database table.
 *
 */
@Component
@Entity
//@NamedQuery(name="Flight.findAll", query="SELECT f FROM Flight f")
@Table(name = "flight")
public class Flight implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="flight_id")
	private int flightId;

	private String arrival;

	@Column(name="business_adult_price")
	private String businessAdultPrice;

	@Column(name="business_child_price")
	private String businessChildPrice;

	private String departure;

//	@Temporal(TemporalType.DATE)
	@Column(name="departure_date")
	private Date departureDate;

	@Column(name="economy_adult_price")
	private String economyAdultPrice;

	@Column(name="economy_child_price")
	private String economyChildPrice;

	//bi-directional many-to-one association to Plane
	@ManyToOne
	@JoinColumn(name = "plane_plane_id")
	private Plane plane;

	//bi-directional many-to-one association to Userflight
	@OneToMany(mappedBy="flight")
	private List<UserFlight> userFlights;

	public Flight() {
	}

	public int getFlightId() {
		return this.flightId;
	}

	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}

	public String getArrival() {
		return this.arrival;
	}

	public void setArrival(String arrival) {
		this.arrival = arrival;
	}

	public String getBusinessAdultPrice() {
		return this.businessAdultPrice;
	}

	public void setBusinessAdultPrice(String businessAdultPrice) {
		this.businessAdultPrice = businessAdultPrice;
	}

	public String getBusinessChildPrice() {
		return this.businessChildPrice;
	}

	public void setBusinessChildPrice(String businessChildPrice) {
		this.businessChildPrice = businessChildPrice;
	}

	public String getDeparture() {
		return this.departure;
	}

	public void setDeparture(String departure) {
		this.departure = departure;
	}

	public Date getDepartureDate() {
		return this.departureDate;
	}

	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}

	public String getEconomyAdultPrice() {
		return this.economyAdultPrice;
	}

	public void setEconomyAdultPrice(String economyAdultPrice) {
		this.economyAdultPrice = economyAdultPrice;
	}

	public String getEconomyChildPrice() {
		return this.economyChildPrice;
	}

	public void setEconomyChildPrice(String economyChildPrice) {
		this.economyChildPrice = economyChildPrice;
	}

	public Plane getPlane() {
		return this.plane;
	}

	public void setPlane(Plane plane) {
		this.plane = plane;
	}

	public List<UserFlight> getUserFlights() {
		return this.userFlights;
	}

	public void setUserFlights(List<UserFlight> userFlights) {
		this.userFlights = userFlights;
	}

	public UserFlight addUserflight(UserFlight userFlight) {
		getUserFlights().add(userFlight);
		userFlight.setFlight(this);

		return userFlight;
	}

	public UserFlight removeUserflight(UserFlight userFlight) {
		getUserFlights().remove(userFlight);
		userFlight.setFlight(null);

		return userFlight;
	}

}