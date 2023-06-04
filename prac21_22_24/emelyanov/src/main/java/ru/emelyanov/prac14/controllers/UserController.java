package ru.emelyanov.prac14.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.emelyanov.prac14.models.Post;
import ru.emelyanov.prac14.models.User;
import ru.emelyanov.prac14.service.EmailService;
import ru.emelyanov.prac14.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/u")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final EmailService emailService;

    @GetMapping()
    public List<User> getF() {
        return userService.findAll();
    }

    @PostMapping("/add")
    public void addF(@RequestBody User newUser) {
        userService.create(newUser);
        emailService.sendAddUserEmail(newUser);
    }

    @DeleteMapping("/delete/{name}")
    public void deleteF(@PathVariable("name") int id) {
        userService.delete(id);
    }

    @GetMapping("/{userId}/post")
    public Post getPostTeam(@PathVariable("userId") int userId) {
        return userService.getPostByUser(userId);
    }

    @GetMapping("/sort_by_firstname")
    public List<User> sortFootByFirstName() {
        return userService.sortFootByFirstName();
    }

    @GetMapping("/sort_by_lastname")
    public List<User> sortFootByLastName() {
        return userService.sortFootByLastName();
    }


}