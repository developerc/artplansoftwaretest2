package ru.artplansoftwaretest2.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.artplansoftwaretest2.dao.AttemptsDao;
import ru.artplansoftwaretest2.entity.Attempts;
import ru.artplansoftwaretest2.service.AttemptsService;

import java.util.List;

@Service("attemptsService")
public class AttemptsServiceImpl implements AttemptsService{
    @Autowired
    private AttemptsDao attemptsDao;

    @Override
    public Attempts addAttempts(Attempts attempts) {
        return attemptsDao.create(attempts);
    }

    @Override
    public List<Attempts> getAllAttempts() {
        return attemptsDao.getList();
    }

    @Override
    public Attempts getAttemptsById(long id) {
        return attemptsDao.getById(id);
    }

    @Override
    public Attempts deleteAttempts(long id) {
        return attemptsDao.delete(attemptsDao.getById(id));
    }

    @Override
    public Attempts updAttempts(Attempts attempts) {
        return attemptsDao.update(attempts);
    }
}
