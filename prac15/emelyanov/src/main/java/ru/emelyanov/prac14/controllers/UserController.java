package ru.emelyanov.prac14.controllers;

import org.springframework.web.bind.annotation.*;
import ru.emelyanov.prac14.dao.UserDAO;
import ru.emelyanov.prac14.models.User;

import java.util.List;

@RestController
@RequestMapping("/u")
public class UserController {

    private final UserDAO dao;

    public UserController(UserDAO dao) {
        this.dao = dao;
    }

    @GetMapping()
    public List<User> getF() {
        return dao.findAll();
    }

    @PostMapping("/add")
    public void addF(@RequestBody User newUser) {
        dao.save(newUser);
    }

    @DeleteMapping("/delete/{name}")
    public void deleteF(@PathVariable("name") String name) {
        dao.delete(name);
    }

}