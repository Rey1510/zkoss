package com.fif.Repository;

import com.fif.Entity.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Repository
public class UserRepository {

    @PersistenceContext
    private EntityManager em;

    @Transactional(readOnly = true)
    public User get(String username) throws NoResultException {
        Query query = em.createQuery("SELECT u FROM User u WHERE u.username = :username", User.class);
        query.setParameter("username", username);
        return (User) query.getSingleResult();
    }
}
