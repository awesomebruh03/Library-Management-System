package com.example.library_management_system.dto;

import com.example.library_management_system.entity.Borrower;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class BorrowerDAO {

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("library_management_system");

    public void createBorrower(Borrower borrower) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(borrower);
        em.getTransaction().commit();
        em.close();
    }

    public Borrower readBorrower(Long id) {
        EntityManager em = emf.createEntityManager();
        Borrower borrower = em.find(Borrower.class, id);
        em.close();
        return borrower;
    }

    public void updateBorrower(Borrower borrower) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(borrower);
        em.getTransaction().commit();
        em.close();
    }

    public void deleteBorrower(Long id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Borrower borrower = em.find(Borrower.class, id);
        if (borrower != null) {
            em.remove(borrower);
        }
        em.getTransaction().commit();
        em.close();
    }

    public List<Borrower> getAllBorrowers() {
        EntityManager em = emf.createEntityManager();
        List<Borrower> borrowers = em.createQuery("SELECT b FROM Borrower b", Borrower.class).getResultList();
        em.close();
        return borrowers;
    }
}