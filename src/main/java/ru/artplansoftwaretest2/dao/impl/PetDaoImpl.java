package ru.artplansoftwaretest2.dao.impl;

import ru.artplansoftwaretest2.dao.PetDao;
import ru.artplansoftwaretest2.entity.Pet;

public class PetDaoImpl extends BasicDaoImpl<Pet> implements PetDao {
    public PetDaoImpl(Class<Pet> entityClass) {
        super(entityClass);
    }
}
