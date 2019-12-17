package com.adoptpet.pet.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.adoptpet.pet.enums.Gender;
import com.adoptpet.pet.enums.SelectOption;
import com.adoptpet.pet.enums.Size;
import com.adoptpet.pet.enums.TypePet;

@Entity
@Table(name = "PET")
public class Pet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
		
	private String breedName; //Nome da Raça
	
	private String namePet; //Nome do Pet
	
	private TypePet typePet; //Tipo de Pet
	
	private Gender gender; //Genero
	
	private Size size; //Tamanho
	
	private SelectOption vaccinated;
	
	private SelectOption microchip;
	
	private SelectOption domestic;
	
	private SelectOption sociality;
	
	private SelectOption needsSpeciality;
	
	private SelectOption experienceAdopt;
	
	private String petHistory;
	
	private String petDiet;
	
	@OneToOne(mappedBy = "pet", cascade = CascadeType.ALL)
	private Address address;
	
	@ManyToMany(mappedBy = "petWithUser", cascade = CascadeType.ALL)
	private List<User> petWithUser;
	
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

	public String getNamePet() {
		return namePet;
	}

	public void setNamePet(String namePet) {
		this.namePet = namePet;
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

	public SelectOption getVaccinated() {
		return vaccinated;
	}

	public void setVaccinated(SelectOption vaccinated) {
		this.vaccinated = vaccinated;
	}

	public SelectOption getMicrochip() {
		return microchip;
	}

	public void setMicrochip(SelectOption microchip) {
		this.microchip = microchip;
	}

	public SelectOption getDomestic() {
		return domestic;
	}

	public void setDomestic(SelectOption domestic) {
		this.domestic = domestic;
	}

	public SelectOption getSociality() {
		return sociality;
	}

	public void setSociality(SelectOption sociality) {
		this.sociality = sociality;
	}

	public SelectOption getNeedsSpeciality() {
		return needsSpeciality;
	}

	public void setNeedsSpeciality(SelectOption needsSpeciality) {
		this.needsSpeciality = needsSpeciality;
	}

	public SelectOption getExperienceAdopt() {
		return experienceAdopt;
	}

	public void setExperienceAdopt(SelectOption experienceAdopt) {
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
