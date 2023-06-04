package ru.emelyanov.prac14.service;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import ru.emelyanov.prac14.models.Post;
import java.util.List;


@Service
public class PostService {
    @PersistenceContext
    private EntityManager em;

    public List<Post> sortByName() {
        Session session = em.unwrap(Session.class);

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Post> PostCriteriaQuery = builder.createQuery(Post.class);
        Root<Post> root = PostCriteriaQuery.from(Post.class);

        PostCriteriaQuery.select(root).orderBy(builder.asc(root.get("name")));
        return session.createQuery(PostCriteriaQuery).getResultList();
    }

}
