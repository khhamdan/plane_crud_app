package com.travelling.Plane.bean;//package com.techno.bean;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;


/**
 * The persistent class for the userflights database table.
 *
 */
@Component
@Entity
@Table(name="userflights")
@NamedQuery(name="Userflight.findAll", query="SELECT u FROM UserFlight u")
public class UserFlight implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="userflights_id")
	private int userFlightsId;

	//bi-directional many-to-one association to Flight
	@ManyToOne
	private Flight flight;

	//bi-directional many-to-one association to User
	@ManyToOne
	private User user;

	public UserFlight() {
	}

	public int getUserFlightsId() {
		return this.userFlightsId;
	}

	public void setUserFlightsId(int userFlightsId) {
		this.userFlightsId = userFlightsId;
	}

	public Flight getFlight() {
		return this.flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}