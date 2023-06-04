package ru.emelyanov.prac14.models;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Component
@NoArgsConstructor
public class Post {
    private String text;
    private String create_date;

    private static List<Post> Posts= new ArrayList<>();



    public void addPostInList(Post Post) {
        Posts.add(Post);
    }

    public void deletePost(String name) {
        Posts.removeIf(Post -> Objects.equals(Post.getText(), name));
    }

    public void fillArray() {
        if (Posts.size() == 0) {
            Posts.add(new Post("MIREA", "01.02.1975"));
            Posts.add(new Post("MGU", "03.08.1956"));
            Posts.add(new Post("HSE", "11.11.1964"));
            Posts.add(new Post("MFTI", "06.10.1970"));
        }
    }

    public Post(String name, String creationDate) {
        this.text = name;
        this.create_date = creationDate;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getCreate_date() {
        return create_date;
    }

    public void setCreate_date(String create_date) {
        this.create_date = create_date;
    }

    public static List<Post> getPosts() {
        return Posts;
    }

}


