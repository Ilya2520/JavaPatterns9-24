package ru.emelyanov.prac14.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.emelyanov.prac14.models.User;

import java.util.List;


@RestController
@RequestMapping("/u")
@RequiredArgsConstructor
public class UserController {

    private final User user;

    @GetMapping()
    public List<User> getF() {
        user.fillArray();
        return User.getPeople();
    }

    @PostMapping("/add")
    public void addF(@RequestBody User newUser) {
        user.addUsertInlist(newUser);
    }

    @DeleteMapping("/delete/{name}")
    public void deleteF(@PathVariable("name") String name) {
        user.deleteUser(name);
    }
}
