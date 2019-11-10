package com.adoptpet.pet.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "USER")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "email")
	@Email(message = "*Please provide a valid Email")
	@NotEmpty(message = "*Please provide an email")
	private String email;

	@Column(name = "password")
	@Length(min = 8, message = "*Your password must have at least 8 characters")
	@NotEmpty(message = "*Please provide your password")
	private String password;

	@Column(name = "FIRST_NAME")
	@NotEmpty(message = "*Please provide your Fist Name")
	private String firstName;

	@Column(name = "LAST_NAME")
	@NotEmpty(message = "*Please provide your Last Name")
	private String lastName;

	@Column(name = "PHONE")
	@NotEmpty(message = "*Please provide your Phone")
	private String phone;

	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
	private Address address;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "PET_USER", joinColumns = { @JoinColumn(name = "USER_ID_USER") }, inverseJoinColumns = {
			@JoinColumn(name = "PET_ID_PET") })
	private List<Pet> petWithUser = new ArrayList<>();

	public User() {

	}

	public User(Long id,
			@Email(message = "*Please provide a valid Email") @NotEmpty(message = "*Please provide an email") String email,
			@Length(min = 8, message = "*Your password must have at least 8 characters") @NotEmpty(message = "*Please provide your password") String password,
			@NotEmpty(message = "*Please provide your Fist Name") String firstName,
			@NotEmpty(message = "*Please provide your Last Name") String lastName,
			@NotEmpty(message = "*Please provide your Phone") String phone, Address address, List<Pet> petWithUser) {
		this.id = id;
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.address = address;
		this.petWithUser = petWithUser;
	}

	/* Getters and Setters */

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Pet> getPetWithUser() {
		return petWithUser;
	}

	public void setPetWithUser(List<Pet> petWithUser) {
		this.petWithUser = petWithUser;
	}

	@Override
	public String toString() {
		return "Person [id = " + id + ", firstName = " + firstName + ", city = " + address.getCity() + ", uf = "
				+ address.getUf();
	}

}
