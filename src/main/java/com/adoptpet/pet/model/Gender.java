package com.adoptpet.pet.model;

/**
* Enumeration for reflecting user's/pet's gender.
* @author jessikafernandes!
*/

public enum Gender {
   /** Masculino. */
   M("Male"),
   /** Feminino. */
   F("Female"),
   /** Nao especificado */
   U("Unknown");

   private final String name;

   private Gender(String name) {
       this.name = name;
   }

   /**
    * @return Retorna a representação do elemento enumerado.
    */
   public String getName() {
       return this.name;
   }
}