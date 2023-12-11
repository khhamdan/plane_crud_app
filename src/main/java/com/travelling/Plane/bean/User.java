package com.travelling.Plane.bean;//package com.techno.bean;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the user database table.
 *
 */
@Component
@Entity
//@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
@Table(name = "user")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="user_id")
	private int userId;

	@Temporal(TemporalType.DATE)
	private Date dob;

	private String email;

	private String firstName;

	private String lastName;

	private String phone;

	//bi-directional many-to-one association to Payment
	@ManyToOne
	@JoinColumn(name = "payment_payment_id")
	private Payment payment;

	//bi-directional many-to-one association to Userflight
	@OneToMany(mappedBy="user")
	private List<UserFlight> userFlights;

	public User() {
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Date getDob() {
		return this.dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Payment getPayment() {
		return this.payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public List<UserFlight> getUserFlights() {
		return this.userFlights;
	}

	public void setUserFlights(List<UserFlight> userFlights) {
		this.userFlights = userFlights;
	}

	public UserFlight addUserFlight(UserFlight userFlight) {
		getUserFlights().add(userFlight);
		userFlight.setUser(this);

		return userFlight;
	}

	public UserFlight removeUserFlight(UserFlight userFlight) {
		getUserFlights().remove(userFlight);
		userFlight.setUser(null);

		return userFlight;
	}

}