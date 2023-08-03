package com.db.grad.javaapi.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int user_id;
    private String bondholder;


    @Id
    @Column(name = "user_id", nullable = false)
    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    @Column(name = "bondholder", nullable = false)
    public String getBondholder() {
        return bondholder;
    }

    public void setBondholder(String bondholder) {
        this.bondholder = bondholder;
    }


    @Override
    public String toString() {
        return "Users{" +
                "user_id=" + user_id +
                ", bondholder='" + bondholder + '\'' +
                '}';
    }
}
