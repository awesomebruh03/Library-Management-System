package com.example.library_management_system.dto;

import com.example.library_management_system.entity.Students;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class StudentsDAO {

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("library_management_system");

    public void createStudent(Students student) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(student);
        em.getTransaction().commit();
        em.close();
    }

    public Students readStudent(Long studentId) {
        EntityManager em = emf.createEntityManager();
        Students student = em.find(Students.class, studentId);
        em.close();
        return student;
    }

    public void updateStudent(Students student) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(student);
        em.getTransaction().commit();
        em.close();
    }

    public void deleteStudent(Long studentId) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Students student = em.find(Students.class, studentId);
        if (student != null) {
            em.remove(student);
        }
        em.getTransaction().commit();
        em.close();
    }

    public List<Students> getAllStudents() {
        EntityManager em = emf.createEntityManager();
        List<Students> students = em.createQuery("SELECT s FROM Students s", Students.class).getResultList();
        em.close();
        return students;
    }
}