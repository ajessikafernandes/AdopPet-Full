package com.adoptpet.pet.enums;

/**
 *Implement enum to select hours company by user.
 *
 * @author jessikafernandes
 * @since 02/01/2020
 */

public enum Hours {

	
	QUATRO_A_SEIS("Quatro a seis horas"),
	SEIS_A_OITO("Seis a oito horas"),
	OITO_OU_MAIS("Oito ou mais horas");
	
//	UMA("01:00"), DUAS("02:00"), TRES("03:00"), QUATRO("04:00"), CINCO("05:00"), SEIS("06:00"), SETE("07:00"),
//	OITO("08:00"), NOVE("09:00"), DEZ("10:00"), ONZE("11:00"), DOZE("12:00"), TREZE("13:00"), QUATORZE("14:00"),
//	QUINZE("15:00"), DESSEZEIS("16:00"), DEZESSETE("17:00"), DEZOITO("18:00"), DEZENOVE("19:00"), VINTE("20:00"),
//	VINTE_E_UMA("21:00"), VINTE_E_DUAS("22:00"), VINTE_E_TRES("23:00"), VINTE_E_QUATRO("00:00");

	private final String descricao;

	private Hours(String descricao) {
		this.descricao = descricao;
	}

	public String getName() {
		return this.descricao;
	}

}
