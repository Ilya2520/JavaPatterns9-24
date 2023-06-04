package ru.emelyanov.prac14.models;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "post", schema = "public")
@NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "creation_data")
    private String creationDate;

    @OneToMany(mappedBy = "post")
    private List<User> users;
}

