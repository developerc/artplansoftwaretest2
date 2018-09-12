package ru.artplansoftwaretest2.dao.impl;

import ru.artplansoftwaretest2.dao.AttemptsDao;
import ru.artplansoftwaretest2.entity.Attempts;

public class AttemptsDaoImpl extends BasicDaoImpl<Attempts> implements AttemptsDao {
    public AttemptsDaoImpl(Class<Attempts> entityClass) {
        super(entityClass);
    }
}
