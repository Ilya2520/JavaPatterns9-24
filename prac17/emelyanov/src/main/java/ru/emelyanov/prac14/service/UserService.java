package ru.emelyanov.prac14.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import ru.emelyanov.prac14.models.Post;
import ru.emelyanov.prac14.models.User;

import java.util.List;


@Service
@RequiredArgsConstructor
public class UserService {

    @PersistenceContext
    private EntityManager em;

    public Post getPostByUser(int userId) {
        Session session = em.unwrap(Session.class);
        return session.createQuery("From User where id =: userId", User.class)
                .setParameter("userId", userId).getSingleResult().getPost();
    }

    public List<User> sortFootByFirstName() {
        Session session = em.unwrap(Session.class);

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> footCriteriaQuery = builder.createQuery(User.class);
        Root<User> root = footCriteriaQuery.from(User.class);

        footCriteriaQuery.select(root).orderBy(builder.asc(root.get("firstName")));
        return session.createQuery(footCriteriaQuery).getResultList();
    }

    public List<User> sortFootByLastName() {
        Session session = em.unwrap(Session.class);

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> footCriteriaQuery = builder.createQuery(User.class);
        Root<User> root = footCriteriaQuery.from(User.class);

        footCriteriaQuery.select(root).orderBy(builder.asc(root.get("lastName")));
        return session.createQuery(footCriteriaQuery).getResultList();
    }
}