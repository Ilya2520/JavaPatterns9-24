package ru.emelyanov.prac14.service;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import ru.emelyanov.prac14.models.Post;
import ru.emelyanov.prac14.repositories.PostRepository;

import java.util.List;


@Service
@RequiredArgsConstructor
@Slf4j
public class PostService {
    private final PostRepository postRepository;

    public Post create(Post Post) {
        log.info("App post");
        return postRepository.save(Post);
    }

    public List<Post> findAll() {
        log.info("Find all posts");
        return postRepository.findAll();
    }

    public void delete(int id) {
        log.info("Delete post");
        postRepository.deleteById(id);
    }

    @PersistenceContext
    private EntityManager em;

    public List<Post> sortByName() {
        log.info("Sort by name");
        Session session = em.unwrap(Session.class);

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Post> PostCriteriaQuery = builder.createQuery(Post.class);
        Root<Post> root = PostCriteriaQuery.from(Post.class);

        PostCriteriaQuery.select(root).orderBy(builder.asc(root.get("name")));
        return session.createQuery(PostCriteriaQuery).getResultList();
    }

}
