package com.example.library_management_system.entity;

import javax.persistence.*;

@Entity
@Table(name = "expired_student")
public class ExpiredStudent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "student_id", nullable = false)
    private Long studentId;

    @Column(name = "book_id", nullable = false)
    private Long bookId;

    @Column(name = "student_name", nullable = false)
    private String studentName;

    @Column(name = "book_name", nullable = false)
    private String bookName;

    @Column(name = "student_dept", nullable = false)
    private String studentDept;

    @Column(name = "book_dept", nullable = false)
    private String bookDept;

    @Column(name = "book_author", nullable = false)
    private String bookAuthor;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getStudentDept() {
        return studentDept;
    }

    public void setStudentDept(String studentDept) {
        this.studentDept = studentDept;
    }

    public String getBookDept() {
        return bookDept;
    }

    public void setBookDept(String bookDept) {
        this.bookDept = bookDept;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }
}