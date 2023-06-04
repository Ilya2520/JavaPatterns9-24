package ru.emelyanov.prac14.dao;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.NoArgsConstructor;
import org.hibernate.Session;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.emelyanov.prac14.models.Post;

import java.util.List;

@NoArgsConstructor
@Component
public class PostDAO {

    @PersistenceContext
    private EntityManager em;

    public List<Post> findAll() {
        Session session = em.unwrap(Session.class);
        return session
                .createQuery("SELECT p from Post p", Post.class).getResultList();
    }

    @Transactional
    public void save(Post post) {
        Session session = em.unwrap(Session.class);
        session.persist(post);
        session.close();
    }

    @Transactional
    public void delete(String name) {
        Session session = em.unwrap(Session.class);

        String hql = ("From Post where name =: name");

        Object footballer = session.createQuery(hql).setParameter("name", name).getSingleResult();
        session.remove(footballer);

        session.close();
    }





}
