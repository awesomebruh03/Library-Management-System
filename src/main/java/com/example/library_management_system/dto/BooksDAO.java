package com.example.library_management_system.dto;

import com.example.library_management_system.entity.Books;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class BooksDAO {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("library_management_system");

    public void createBook(Books book) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(book);
        em.getTransaction().commit();
        em.close();
    }

    public Books readBook(Long bookId) {
        EntityManager em = emf.createEntityManager();
        Books book = em.find(Books.class, bookId);
        em.close();
        return book;
    }

    public void updateBook(Books book) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(book);
        em.getTransaction().commit();
        em.close();
    }

    public void deleteBook(Long bookId) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Books book = em.find(Books.class, bookId);
        if (book != null) {
            em.remove(book);
        }
        em.getTransaction().commit();
        em.close();
    }

    public List<Books> getAllBooks() {
        EntityManager em = emf.createEntityManager();
        List<Books> books = em.createQuery("SELECT b FROM Books b", Books.class).getResultList();
        em.close();
        return books;
    }
}