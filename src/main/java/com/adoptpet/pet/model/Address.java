package com.adoptpet.pet.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author jessikafernandess 
 */

//A classe Address representa uma entidade e seus objetos devem ser persistidos no banco de dados.
@Entity
@Table(name="ADDRESS")
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "ZIP", length = 9, nullable = false)
    private String zip;
	
	@Column (name = "CITY", length = 40, nullable = false)
	private String city;
	
	@Column (name = "UF", length = 2, nullable = false)
	private String uf;
	
	@JsonIgnore
	@OneToOne
	@PrimaryKeyJoinColumn
	private User user;
	
	@JsonIgnore
	@OneToOne
	@PrimaryKeyJoinColumn
	private Pet pet;
	
	public Address() {

	}

	public Address(Long id, String zip, String city, String uf) {
		this.id = id;
		this.zip = zip;
		this.city = city;
		this.uf = uf;
	}
	
	public Address(Long id, String zip, String city, String uf, User user) {
		this.id = id;
		this.zip = zip;
		this.city = city;
		this.uf = uf;
		this.user = user;
	}
	
	public Address(Long id, String zip, String city, String uf, Pet pet) {
		this.id = id;
		this.zip = zip;
		this.city = city;
		this.uf = uf;
		this.pet = pet;
	}

	/* Getters and Setters */

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Pet getPet() {
		return pet;
	}

	public void setPet(Pet pet) {
		this.pet = pet;
	}
	
	@Override
	  public String toString() {
	    return "Person [id=" + id + ", zip = " + zip + ", city = " + city + ", UF = " + uf + "]";
	  }
}
