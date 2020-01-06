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

import com.adoptpet.pet.enums.Hours;
import com.adoptpet.pet.enums.SelectInterview;

/**
 *Implement entity to persist object User in database.
 *
 * @author jessikafernandes
 * @since 02/01/2020
 */

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

	/* Entrevista do usuario */

	// Possui experiencia com pets?
	@Column(name = "HAS_EXPERIENCE")
	private SelectInterview hasExperience;

	// Possui pets atualmente?
	@Column(name = "HAS_PETS")
	private SelectInterview hasPets;

	// how many petz do you own?
	// Quantos pets voce possui ?
	@Column(name = "HOW_MANY_PETS")
	private Integer howManyPets;

	// Costuma ficar alguem com os seus pets durante o dia ?
	@Column(name = "HAS_COMPANY")
	private SelectInterview hasCompany;

//	Quantas horas seus pet costuma ficar sozinho ?
	@Column(name = "HOURS_ALONE")
	private Hours hoursAlone;
	// private SimpleDateFormat hoursAlone = new SimpleDateFormat("hh:mm");

	// Conte nos um pouco sobre o comportamento dos seus pets
	@Column(name = "PETS_BEHAVIOR")
	private String petsBehavior;

	/* fim da entrevista do usuario */

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
			@NotEmpty(message = "*Please provide your Phone") String phone, SelectInterview hasExperience,
			SelectInterview hasPets, Integer howManyPets, SelectInterview hasCompany, Hours hoursAlone,
			String petsBehavior, Address address, List<Pet> petWithUser) {
		this.id = id;
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.hasExperience = hasExperience;
		this.hasPets = hasPets;
		this.howManyPets = howManyPets;
		this.hasCompany = hasCompany;
		this.hoursAlone = hoursAlone;
		this.petsBehavior = petsBehavior;
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

	public SelectInterview getHasExperience() {
		return hasExperience;
	}

	public void setHasExperience(SelectInterview hasExperience) {
		this.hasExperience = hasExperience;
	}

	public SelectInterview getHasPets() {
		return hasPets;
	}

	public void setHasPets(SelectInterview hasPets) {
		this.hasPets = hasPets;
	}

	public Integer getHowManyPets() {
		return howManyPets;
	}

	public void setHowManyPets(Integer howManyPets) {
		this.howManyPets = howManyPets;
	}

	public SelectInterview getHasCompany() {
		return hasCompany;
	}

	public void setHasCompany(SelectInterview hasCompany) {
		this.hasCompany = hasCompany;
	}

	public String getPetsBehavior() {
		return petsBehavior;
	}

	public void setPetsBehavior(String petsBehavior) {
		this.petsBehavior = petsBehavior;
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

	public Hours getHoursAlone() {
		return hoursAlone;
	}

	public void setHoursAlone(Hours hoursAlone) {
		this.hoursAlone = hoursAlone;
	}

}