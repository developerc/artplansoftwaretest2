package ru.artplansoftwaretest2.dao.impl;

import ru.artplansoftwaretest2.dao.UsersDao;
import ru.artplansoftwaretest2.entity.Users;

import javax.persistence.Query;
import java.util.List;

public class UsersDaoImpl extends BasicDaoImpl<Users> implements UsersDao {
    public UsersDaoImpl(Class<Users> entityClass) {
        super(entityClass);
    }

    @Override
    public List<Users> getUsersByLgn(String lgn) {
        Query query = getSessionFactory().createQuery("SELECT a FROM Users as a WHERE (a.login = :Lgn)");
        query.setParameter("Lgn", lgn);
        return query.getResultList();
    }
}
