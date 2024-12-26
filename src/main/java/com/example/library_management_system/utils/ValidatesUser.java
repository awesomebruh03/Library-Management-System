package com.example.library_management_system.utils;

import com.example.library_management_system.entity.Users;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ValidatesUser {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("library_management_system");

    // Other CRUD methods...
    public boolean findByUsername(String username, String password) {
        EntityManager em = emf.createEntityManager();
        boolean userExists = false;
        try {
            Users user = em.createQuery("SELECT u FROM Users u WHERE u.username = :username", Users.class)
                    .setParameter("username", username)
                    .getSingleResult();
            if (user != null) {
                userExists = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return userExists;
    }
}