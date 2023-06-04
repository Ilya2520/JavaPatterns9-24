package ru.emelyanov.prac14.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.NoArgsConstructor;
import org.hibernate.Session;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.emelyanov.prac14.models.User;

import java.util.List;

@NoArgsConstructor
@Component
public class UserDAO {

    @PersistenceContext
    private EntityManager em;

    public List<User> findAll() {
        Session session = em.unwrap(Session.class);
        return session.createQuery("from User", User.class).getResultList();
    }

    @Transactional
    public void save(User user) {
        Session session = em.unwrap(Session.class);
        session.persist(user);
        session.close();
    }

    @Transactional
    public void delete(String name) {
        Session session = em.unwrap(Session.class);

        String hql = ("From User where firstName =: name");

        Object User = session.createQuery(hql).setParameter("name", name).getSingleResult();
        session.remove(User);

        session.close();
    }





}

