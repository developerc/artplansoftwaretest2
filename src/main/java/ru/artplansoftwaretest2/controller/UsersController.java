package ru.artplansoftwaretest2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.artplansoftwaretest2.entity.Users;
import ru.artplansoftwaretest2.service.UsersService;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private UsersService usersService;

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Users addUsers(@RequestBody Users users){
        return usersService.addUsers(users);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public List<Users> getUsers(){
        return usersService.getAllUsers();
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Users getUsersById(@PathVariable(value = "id") String id){
        Users userById;
        userById = usersService.getUsersById(Long.parseLong(id));
        if (userById == null){
            Users errUser = new Users();
            errUser.setId(Long.parseLong(id));
            errUser.setLogin("error");
            errUser.setPassword("Can't get user with that ID");
            return errUser;
        }  else {
            return userById;
        }
        /*try {
            userById = usersService.getUsersById(Long.parseLong(id));
            return userById;
        } catch (Exception e){
            Users errUser = new Users();
            errUser.setId(Long.parseLong(id));
            errUser.setLogin("error");
            errUser.setPassword("Can't get user with that ID");
            return errUser;
        }*/
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Users deleteUsers(@PathVariable(value = "id") String id) {
        return usersService.deleteUsers(Long.parseLong(id));
    }

    @RequestMapping(value = "/upd", method = RequestMethod.PUT, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Users updUsers(@RequestBody Users users){
        return usersService.updUsers(users);
    }

}
