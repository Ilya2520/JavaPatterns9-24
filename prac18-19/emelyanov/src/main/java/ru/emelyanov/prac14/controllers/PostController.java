package ru.emelyanov.prac14.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.emelyanov.prac14.models.Post;
import ru.emelyanov.prac14.service.PostService;

import java.util.List;



@RestController
@RequestMapping("/p")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping()
    public List<Post> getF() {
        return postService.findAll();
    }

    @PostMapping("/add")
    public void addF(@RequestBody Post post) {
        postService.create(post);
    }

    @DeleteMapping("/delete/{name}")
    public void deleteF(@PathVariable("name") int name) {
        postService.delete(name);
    }

    @GetMapping("/sort_by_name")
    public List<Post> sortByName() {
        return postService.sortByName();
    }


}
