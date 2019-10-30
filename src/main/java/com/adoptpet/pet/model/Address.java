package com.adoptpet.pet.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
	
	public Address() {

	}

	public Address(String zip, String city, String uf) {
		this.zip = zip;
		this.city = city;
		this.uf = uf;
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
	
	 @Override
	  public String toString() {
	    return "Person [id=" + id + ", zip = " + zip + ", city = " + city + ", UF = " + uf + "]";
	  }
}
