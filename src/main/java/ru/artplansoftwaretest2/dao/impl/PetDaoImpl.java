package ru.artplansoftwaretest2.dao.impl;

import ru.artplansoftwaretest2.dao.PetDao;
import ru.artplansoftwaretest2.entity.Pet;

import javax.persistence.Query;
import java.util.List;

public class PetDaoImpl extends BasicDaoImpl<Pet> implements PetDao {
    public PetDaoImpl(Class<Pet> entityClass) {
        super(entityClass);
    }

    @Override
    public List<Pet> getPetByName(String name) {
        Query query = getSessionFactory().createQuery("SELECT a FROM Pet as a WHERE (a.name = :Name)");
        query.setParameter("Name", name);
        return query.getResultList();
    }
}
