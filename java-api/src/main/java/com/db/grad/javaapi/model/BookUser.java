package com.db.grad.javaapi.model;
import org.apache.catalina.User;
import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "book_user")
public class BookUser {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="book_user_id")
    private int id;

    @OneToMany(mappedBy="book_user")
    private Set<User> users;
    @OneToMany(mappedBy="book_user")
    private Set<Book> books;
}
