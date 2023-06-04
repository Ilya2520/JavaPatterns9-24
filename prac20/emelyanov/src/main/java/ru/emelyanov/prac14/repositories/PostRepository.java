package ru.emelyanov.prac14.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.emelyanov.prac14.models.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {

}
