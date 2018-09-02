package ru.artplansoftwaretest2.dao.impl;

import ru.artplansoftwaretest2.dao.UsersDao;
import ru.artplansoftwaretest2.entity.Users;

public class UsersDaoImpl extends BasicDaoImpl<Users> implements UsersDao {
    public UsersDaoImpl(Class<Users> entityClass) {
        super(entityClass);
    }
}
