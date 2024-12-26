package com.example.library_management_system.dto;

import com.example.library_management_system.entity.Users;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class UserDAO {

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("library_management_system");

    public void createUser(Users user) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
        em.close();
    }

    public Users readUser(Long userId) {
        EntityManager em = emf.createEntityManager();
        Users user = em.find(Users.class, userId);
        em.close();
        return user;
    }

    public void updateUser(Users user) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(user);
        em.getTransaction().commit();
        em.close();
    }

    public void deleteUser(Long userId) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Users user = em.find(Users.class, userId);
        if (user != null) {
            em.remove(user);
        }
        em.getTransaction().commit();
        em.close();
    }

    public List<Users> getAllUsers() {
        EntityManager em = emf.createEntityManager();
        List<Users> users = em.createQuery("SELECT u FROM Users u", Users.class).getResultList();
        em.close();
        return users;
    }
}