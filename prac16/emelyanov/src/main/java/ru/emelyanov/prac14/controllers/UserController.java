package ru.emelyanov.prac14.controllers;

import org.springframework.web.bind.annotation.*;
import ru.emelyanov.prac14.dao.UserDAO;
import ru.emelyanov.prac14.models.Post;
import ru.emelyanov.prac14.models.User;
import ru.emelyanov.prac14.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/u")
public class UserController {

    private final UserDAO dao;

    private final UserService userService;

    public UserController(UserDAO dao, UserService userService) {
        this.dao = dao;
        this.userService = userService;
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

    @GetMapping("/{userId}/post")
    public Post getPostTeam(@PathVariable("userId") int userId) {
        return userService.getPostByUser(userId);
    }

}