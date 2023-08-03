package com.db.grad.javaapi.model;

import javax.persistence.*;

@Entity
@Table(name = "book_user")
public class BookUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int book_user_id;
    @ManyToOne
    @JoinColumn(name="book_id", nullable = false)
    private Book book_id;
    @ManyToOne
    @JoinColumn(name="user_id", nullable = false)
    private Users user_id;

    @Id
    @Column(name = "book_user_id", nullable = false)
    public int getBook_user_id() {
        return book_user_id;
    }

    public void setBook_user_id(int book_user_id) {
        this.book_user_id = book_user_id;
    }

    public Book getBook_id() {
        return book_id;
    }

    public void setBook_id(Book book_id) {
        this.book_id = book_id;
    }

    public Users getUser_id() {
        return user_id;
    }

    public void setUser_id(Users user_id) {
        this.user_id = user_id;
    }


    @Override
    public String toString() {
        return "BookUser{" +
                "book_user_id=" + book_user_id +
                ", book_id=" + book_id +
                ", user_id=" + user_id +
                '}';
    }
}
