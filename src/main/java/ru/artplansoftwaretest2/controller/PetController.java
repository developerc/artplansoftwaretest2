package ru.artplansoftwaretest2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.artplansoftwaretest2.entity.Pet;
import ru.artplansoftwaretest2.service.PetService;

import java.util.List;

@Controller
@RequestMapping("/pet")
public class PetController {
    @Autowired
    private PetService petService;

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Pet addPet(@RequestBody Pet pet){
        return petService.addPet(pet);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public List<Pet> getPet(){
        return petService.getAllPet();
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Pet getPetById(@PathVariable(value = "id") String id){
        // exception
        return petService.getPetById(Long.parseLong(id));
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Pet deletePet(@PathVariable(value = "id") String id) {
        return petService.deletePet(Long.parseLong(id));
    }

    @RequestMapping(value = "/upd", method = RequestMethod.PUT, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Pet updPet(@RequestBody Pet pet){
        return petService.updPet(pet);
    }
}
