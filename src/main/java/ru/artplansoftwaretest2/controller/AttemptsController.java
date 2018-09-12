package ru.artplansoftwaretest2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.artplansoftwaretest2.entity.Attempts;
import ru.artplansoftwaretest2.service.AttemptsService;

import java.util.List;

@Controller
@RequestMapping("/attempts")
public class AttemptsController {
    @Autowired
    private AttemptsService attemptsService;

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Attempts addAttempts(@RequestBody Attempts attempts){
        return attemptsService.addAttempts(attempts);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public List<Attempts> getAttempts(){
        return attemptsService.getAllAttempts();
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Attempts getAttemptsById(@PathVariable(value = "id") String id){
        // exception
        return attemptsService.getAttemptsById(Long.parseLong(id));
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Attempts deleteAttempts(@PathVariable(value = "id") String id) {
        return attemptsService.deleteAttempts(Long.parseLong(id));
    }

    @RequestMapping(value = "/upd", method = RequestMethod.PUT, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Attempts updAttempts(@RequestBody Attempts attempts){
        return attemptsService.updAttempts(attempts);
    }
}
