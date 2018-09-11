package ru.artplansoftwaretest2.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.artplansoftwaretest2.dao.UsersDao;
import ru.artplansoftwaretest2.entity.Users;
import ru.artplansoftwaretest2.service.UsersService;

import java.util.List;

@Service("usersService")
public class UsersServiceImpl implements UsersService{
    @Autowired
    private UsersDao usersDao;

    @Override
    public Users addUsers(Users users) {
        //хешируем пароль при записи в базу
        Users criptUser = users;
        String psw = criptUser.getPassword();
        String criptPsw = new BCryptPasswordEncoder().encode(psw);
        criptUser.setPassword(criptPsw);
        return usersDao.create(criptUser);
    }

    @Override
    public List<Users> getAllUsers() {
        return usersDao.getList();
    }

    @Override
    public Users getUsersById(long id) {
        return usersDao.getById(id);
    }

    @Override
    public Users deleteUsers(long id) {
        return usersDao.delete(usersDao.getById(id));
    }

    @Override
    public Users updUsers(Users users) {
        return usersDao.update(users);
    }

    @Override
    public List<Users> getUsersByLgn(String lgn) {
        return usersDao.getUsersByLgn(lgn);
    }
}
