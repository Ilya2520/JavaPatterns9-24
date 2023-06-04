package ru.emelyanov.prac14.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.emelyanov.prac14.models.User;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
