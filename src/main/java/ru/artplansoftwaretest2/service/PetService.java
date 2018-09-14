package ru.artplansoftwaretest2.service;

import ru.artplansoftwaretest2.entity.Pet;

import java.util.List;

public interface PetService {
    /**
     * method for add pet to base
     *
     * @param pet = new pet for creation in DB
     * @return created pet
     */
    Pet addPet(Pet pet);

    /**
     * method for receiving all pets
     *
     * @return all pets
     */
    List<Pet> getAllPet();

    /**
     * method for receive specify Pet by id
     *
     * @param id = uniq Pet id
     * @return specify Pet by id
     */
    Pet getPetById(long id);

    /**
     * method for pet delete
     *
     * @param id = Pet's id for delete
     * @return removed Pet
     */
    Pet deletePet(long id);

    /**
     * method for update Pet
     *
     * @param pet = update existing pet in DB
     * @return updated pet
     */
    Pet updPet(Pet pet);
}
