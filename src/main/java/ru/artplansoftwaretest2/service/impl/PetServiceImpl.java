package ru.artplansoftwaretest2.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.artplansoftwaretest2.dao.PetDao;
import ru.artplansoftwaretest2.entity.Pet;
import ru.artplansoftwaretest2.service.PetService;

import java.util.List;

@Service("petService")
public class PetServiceImpl implements PetService{
    @Autowired
    private PetDao petDao;


    @Override
    public Pet addPet(Pet pet) {
        return petDao.create(pet);
    }

    @Override
    public List<Pet> getAllPet() {
        return petDao.getList();
    }

    @Override
    public Pet getPetById(long id) {
        return petDao.getById(id);
    }

    @Override
    public Pet deletePet(long id) {
        return petDao.delete(petDao.getById(id));
    }

    @Override
    public Pet updPet(Pet pet) {
        return petDao.update(pet);
    }

    @Override
    public List<Pet> getPetByName(String name) {
        return petDao.getPetByName(name);
    }
}
