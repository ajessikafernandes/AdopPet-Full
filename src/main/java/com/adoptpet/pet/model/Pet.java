package com.adoptpet.pet.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.adoptpet.pet.enums.Gender;
import com.adoptpet.pet.enums.Size;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "PET")
public class Pet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
		
	private String breedName;
	
	private TypePet typePet;
	
	private Gender gender;
	
	private Size size;
	
	private Boolean vaccinated = true;
	
	private Boolean microchip = true;
	
	private Boolean domestic = true;
	
	private Boolean sociality = true;
	
	private Boolean needsSpeciality = true;
	
	private Boolean experienceAdopt = true;
	
	private String petHistory;
	
	private String petDiet;
	
	@Column(name = "FIRST_NAME")
	@NotEmpty(message = "*Please provide your Fist Name")
	private String firstName;
	
	@OneToOne(mappedBy = "pet", cascade = CascadeType.ALL)
	private Address address;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "petWithUser", cascade = CascadeType.ALL)
	private List<User> petWithUser;
	
	public Pet () {
		
	}

	public Pet(Long id, String breedName, TypePet typePet, Gender gender, Size size,
			Boolean vaccinated, Boolean microchip, Boolean domestic, Boolean sociality, Boolean needsSpeciality,
			Boolean experienceAdopt, String petHistory, String petDiet,
			@NotEmpty(message = "*Please provide your Fist Name") String firstName, Address address,
			List<User> petWithUser) {
		this.id = id;
		this.breedName = breedName;
		this.typePet = typePet;
		this.gender = gender;
		this.size = size;
		this.vaccinated = vaccinated;
		this.microchip = microchip;
		this.domestic = domestic;
		this.sociality = sociality;
		this.needsSpeciality = needsSpeciality;
		this.experienceAdopt = experienceAdopt;
		this.petHistory = petHistory;
		this.petDiet = petDiet;
		this.firstName = firstName;
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

	public String getBreedName() {
		return breedName;
	}

	public void setBreedName(String breedName) {
		this.breedName = breedName;
	}

	public TypePet getTypePet() {
		return typePet;
	}

	public void setTypePet(TypePet typePet) {
		this.typePet = typePet;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	public Boolean getVaccinated() {
		return vaccinated;
	}

	public void setVaccinated(Boolean vaccinated) {
		this.vaccinated = vaccinated;
	}

	public Boolean getMicrochip() {
		return microchip;
	}

	public void setMicrochip(Boolean microchip) {
		this.microchip = microchip;
	}

	public Boolean getDomestic() {
		return domestic;
	}

	public void setDomestic(Boolean domestic) {
		this.domestic = domestic;
	}

	public Boolean getSociality() {
		return sociality;
	}

	public void setSociality(Boolean sociality) {
		this.sociality = sociality;
	}

	public Boolean getNeedsSpeciality() {
		return needsSpeciality;
	}

	public void setNeedsSpeciality(Boolean needsSpeciality) {
		this.needsSpeciality = needsSpeciality;
	}

	public Boolean getExperienceAdopt() {
		return experienceAdopt;
	}

	public void setExperienceAdopt(Boolean experienceAdopt) {
		this.experienceAdopt = experienceAdopt;
	}

	public String getPetHistory() {
		return petHistory;
	}

	public void setPetHistory(String petHistory) {
		this.petHistory = petHistory;
	}

	public String getPetDiet() {
		return petDiet;
	}

	public void setPetDiet(String petDiet) {
		this.petDiet = petDiet;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<User> getPetWithUser() {
		return petWithUser;
	}

	public void setPetWithUser(List<User> petWithUser) {
		this.petWithUser = petWithUser;
	}
	
}
