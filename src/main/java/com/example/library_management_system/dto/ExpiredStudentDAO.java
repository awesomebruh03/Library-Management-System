package com.example.library_management_system.dto;

import com.example.library_management_system.entity.ExpiredStudent;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class ExpiredStudentDAO {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("library_management_system");

    public void createExpiredStudent(ExpiredStudent expiredStudent) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(expiredStudent);
        em.getTransaction().commit();
        em.close();
    }

    public ExpiredStudent readExpiredStudent(Long id) {
        EntityManager em = emf.createEntityManager();
        ExpiredStudent expiredStudent = em.find(ExpiredStudent.class, id);
        em.close();
        return expiredStudent;
    }

    public void updateExpiredStudent(ExpiredStudent expiredStudent) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(expiredStudent);
        em.getTransaction().commit();
        em.close();
    }

    public void deleteExpiredStudent(Long id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        ExpiredStudent expiredStudent = em.find(ExpiredStudent.class, id);
        if (expiredStudent != null) {
            em.remove(expiredStudent);
        }
        em.getTransaction().commit();
        em.close();
    }

    public List<ExpiredStudent> getAllExpiredStudents() {
        EntityManager em = emf.createEntityManager();
        List<ExpiredStudent> expiredStudents = em.createQuery("SELECT e FROM ExpiredStudent e", ExpiredStudent.class).getResultList();
        em.close();
        return expiredStudents;
    }
}