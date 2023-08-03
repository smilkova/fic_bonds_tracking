package com.db.grad.javaapi.model;

import javax.persistence.*;

@Entity
@Table(name = "book_user")
public class BookUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int book_id;
    private int user_id;
    @ManyToOne
    @JoinColumn(name="book_id", nullable = false)
    private Book book_id_fk1;
    @ManyToOne
    @JoinColumn(name="user_id", nullable = false)
    private Book user_id_fk1;


    @Id
    @Column(name = "book_id", nullable = false)
    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    @Column(name = "user_id", nullable = false)
    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public Book getBook_id_fk1() {
        return book_id_fk1;
    }

    public void setBook_id_fk1(Book book_id_fk1) {
        this.book_id_fk1 = book_id_fk1;
    }

    public Book getUser_id_fk1() {
        return user_id_fk1;
    }

    public void setUser_id_fk1(Book user_id_fk1) {
        this.user_id_fk1 = user_id_fk1;
    }

    @Override
    public String toString() {
        return "BookUser{" +
                "book_id=" + book_id +
                ", user_id=" + user_id +
                ", book_id_fk1=" + book_id_fk1 +
                ", user_id_fk1=" + user_id_fk1 +
                '}';
    }
}
