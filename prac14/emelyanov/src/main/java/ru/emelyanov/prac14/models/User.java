package ru.emelyanov.prac14.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Component
@NoArgsConstructor
@Getter
@Setter
@ToString
public class User {
    private String firstName;
    private String lastName;
    private static List<User> people = new ArrayList<>();

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public void addUsertInlist(User User) {
        people.add(User);
    }

    public void deleteUser(String firstName) {
        people.removeIf(User -> Objects.equals(User.getFirstName(), firstName));
    }

    public void fillArray() {
        if (people.size() == 0) {
            people.add(new User("Tom", "Johnson"));
            people.add(new User("Katy", "Lambda"));
            people.add(new User("Man", "Johnson"));
            people.add(new User("Danil", "Matrosov"));
        }
    }

    public static List<User> getPeople() {
        return people;
    }

}
