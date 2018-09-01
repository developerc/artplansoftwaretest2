package ru.artplansoftwaretest2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {
    @RequestMapping("/")
    public String helloPage(){
        return "index";
    }

    @RequestMapping("/setaccount")
    public String insidefeaturePage(){
        return "setaccount";
    }

    @RequestMapping("/pet")
    public String petPage(){
        return "pet";
    }

    @RequestMapping("/customlgnpg")
    public String customlgnpgPage(){
        return "customlgnpg";
    }

    @RequestMapping("/successpg")
    public String successpgPage(){
        return "successpg";
    }

    @RequestMapping("/failurepg")
    public String failurepgPage(){
        return "failurepg";
    }
}
