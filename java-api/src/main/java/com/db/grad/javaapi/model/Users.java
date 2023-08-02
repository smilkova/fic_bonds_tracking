package com.db.grad.javaapi.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="user_id")
    private int userid;

    private String bondholder;

    @Column(name = "name", nullable = false)
    public String getBondholder() {
        return bondholder;
    }

    public void setBondholder(String bondholder) {
        this.bondholder = bondholder;
    }
}
