package ru.emelyanov.prac14.controllers;

import org.springframework.web.bind.annotation.*;
import ru.emelyanov.prac14.models.Post;

import java.util.List;


@RestController
@RequestMapping("/p")

public class PostController {
    private final Post post;

    public PostController(Post post) {
        this.post = post;
    }

    @GetMapping()
    public List<Post> getF() {
        post.fillArray();
        return Post.getPosts();
    }

    @PostMapping("/add")
    public void addF(@RequestBody Post post1) {
        post.addPostInList(post1);
    }

    @DeleteMapping("/delete/{name}")
    public void deleteF(@PathVariable("name") String name) {
        post.deletePost(name);
    }
}
