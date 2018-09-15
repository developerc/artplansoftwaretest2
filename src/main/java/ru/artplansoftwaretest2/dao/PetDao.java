package ru.artplansoftwaretest2.dao;

import ru.artplansoftwaretest2.entity.Pet;

import java.util.List;

public interface PetDao extends BasicDao<Pet>  {
    /**
     * method for finding List Pet by name
     *@param name = name of pet
     *@return List pets  with success parameters
     * **/
    List<Pet> getPetByName(String name);
}
