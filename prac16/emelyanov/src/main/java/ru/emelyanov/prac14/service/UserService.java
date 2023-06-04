package ru.emelyanov.prac14.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import ru.emelyanov.prac14.models.Post;
import ru.emelyanov.prac14.models.User;


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
}