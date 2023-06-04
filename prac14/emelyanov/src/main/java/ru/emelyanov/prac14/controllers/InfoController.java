package ru.emelyanov.prac14.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InfoController {
    @GetMapping("/home")
    public String info() {
        return "info";
    }
}
