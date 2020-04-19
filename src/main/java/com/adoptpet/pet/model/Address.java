package com.adoptpet.pet.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.adoptpet.pet.enums.State;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
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
	private State uf;
	
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

	public Address(Long id, String zip, String city, State uf, User user, Pet pet) {
		this.id = id;
		this.zip = zip;
		this.city = city;
		this.uf = uf;
		this.user = user;
		this.pet = pet;
	}

}