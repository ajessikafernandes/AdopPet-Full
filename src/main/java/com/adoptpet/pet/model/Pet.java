package com.adoptpet.pet.model;

import java.util.ArrayList;
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
import com.adoptpet.pet.enums.Status;
import com.adoptpet.pet.enums.TypePet;

import lombok.Data;

@Data
@Entity
@Table(name = "PET")
public class Pet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String breedName; // Nome da Raça

	private String namePet; // Nome do Pet

	private TypePet typePet; // Tipo de Pet

	private Gender gender; // Genero do pet

	private Size size; // Tamanho do pet

	private SelectOption vaccinated; //Tomou vacinas

	private SelectOption microchip; //Possui microchip

	private SelectOption castrated;

	private SelectOption sociality; //Socializavel com outros pets

	private SelectOption needsSpeciality; //Possui necessidades especiais

	private SelectOption experienceAdopt; //Precisa de um adotador com experiencia
	
	private Status status;

	private String petHistory;

	private String petDiet;

	@OneToOne(mappedBy = "pet", cascade = CascadeType.ALL)
	private Address address;

	//Pendente o envio por postman, 
	@ManyToMany(mappedBy = "petWithUser", cascade = CascadeType.ALL)
	private List<User> petWithUser;
	
	public Pet() {

	}	
	
	public Pet(Long id, String breedName, String namePet, TypePet typePet, Gender gender, Size size,
			SelectOption vaccinated, SelectOption microchip, SelectOption castrated, SelectOption sociality,
			SelectOption needsSpeciality, SelectOption experienceAdopt, Status status, String petHistory,
			String petDiet, Address address, List<User> petWithUser) {
		this.id = id;
		this.breedName = breedName;
		this.namePet = namePet;
		this.typePet = typePet;
		this.gender = gender;
		this.size = size;
		this.vaccinated = vaccinated;
		this.microchip = microchip;
		this.castrated = castrated;
		this.sociality = sociality;
		this.needsSpeciality = needsSpeciality;
		this.experienceAdopt = experienceAdopt;
		this.status = status;
		this.petHistory = petHistory;
		this.petDiet = petDiet;
		this.address = address;
		this.petWithUser = new ArrayList<>();
	}
	
}