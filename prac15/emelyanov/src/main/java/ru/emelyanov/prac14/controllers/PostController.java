package ru.emelyanov.prac14.controllers;

import org.springframework.web.bind.annotation.*;
import ru.emelyanov.prac14.dao.PostDAO;
import ru.emelyanov.prac14.models.Post;

import java.util.List;



@RestController
@RequestMapping("/p")
public class PostController {

    private final PostDAO dao;

    public PostController(PostDAO dao) {
        this.dao = dao;
    }

    @GetMapping()
    public List<Post> getF() {
        return dao.findAll();
    }

    @PostMapping("/add")
    public void addF(@RequestBody Post post) {
        dao.save(post);
    }

    @DeleteMapping("/delete/{name}")
    public void deleteF(@PathVariable("name") String name) {
        dao.delete(name);
    }
}
