package ru.artplansoftwaretest2.dao;

import ru.artplansoftwaretest2.entity.Users;

import java.util.List;

public interface UsersDao extends BasicDao<Users>{
    /**
     * method for finding List Users by login
     *@param lgn = login of user
     *@return List users  with success parameters
     * **/
    List<Users> getUsersByLgn(String lgn);
}
