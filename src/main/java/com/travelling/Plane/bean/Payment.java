package com.travelling.Plane.bean;//package com.techno.bean;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


/**
 * The persistent class for the payment database table.
 *
 */
@Component
@Entity
@NamedQuery(name="Payment.findAll", query="SELECT p FROM Payment p")
@Table(name = "payment")
public class Payment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="payment_id")
	private int paymentId;

	@Column(name="credit_card_number")
	private int creditCardNumber;

	@Column(name="expiry_date")
	private String expiryDate;

	@Column(name="payment_method")
	private String paymentMethod;

	//bi-directional many-to-one association to User
	@OneToMany(mappedBy="payment")
	private List<User> users;

	public Payment() {
	}

	public int getPaymentId() {
		return this.paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public int getCreditCardNumber() {
		return this.creditCardNumber;
	}

	public void setCreditCardNumber(int creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}

	public String getExpiryDate() {
		return this.expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getPaymentMethod() {
		return this.paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public User addUser(User user) {
		getUsers().add(user);
		user.setPayment(this);

		return user;
	}

	public User removeUser(User user) {
		getUsers().remove(user);
		user.setPayment(null);

		return user;
	}

}