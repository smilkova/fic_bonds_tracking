package com.db.grad.javaapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {
    @Id
    private long id;

    private String bondholder;

    @Column(name = "name", nullable = false)
    public String getBondholder() {
        return bondholder;
    }

    public void setBondholder(String bondholder) {
        this.bondholder = bondholder;
    }
}
