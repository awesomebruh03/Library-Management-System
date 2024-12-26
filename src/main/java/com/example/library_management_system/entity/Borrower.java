package com.example.library_management_system.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "borrower")
public class Borrower {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Students student;

    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    private Books book;

    @Column(name = "student_name", nullable = false)
    private String studentName;

    @Column(name = "book_name", nullable = false)
    private String bookName;

    @Column(name = "student_dept", nullable = false)
    private String studentDept;

    @Column(name = "book_auth", nullable = false)
    private String bookAuth;

    @Column(name = "book_dept", nullable = false)
    private String bookDept;

    @Column(name = "browing_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date browingDate;

    @Column(name = "expire_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date expireDate;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Students getStudent() {
        return student;
    }

    public void setStudent(Students student) {
        this.student = student;
    }

    public Books getBook() {
        return book;
    }

    public void setBook(Books book) {
        this.book = book;
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

    public String getBookAuth() {
        return bookAuth;
    }

    public void setBookAuth(String bookAuth) {
        this.bookAuth = bookAuth;
    }

    public String getBookDept() {
        return bookDept;
    }

    public void setBookDept(String bookDept) {
        this.bookDept = bookDept;
    }

    public Date getBrowingDate() {
        return browingDate;
    }

    public void setBrowingDate(Date browingDate) {
        this.browingDate = browingDate;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }
}