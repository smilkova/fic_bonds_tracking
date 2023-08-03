package com.db.grad.javaapi.model;

import javax.persistence.*;

@Entity
@Table(name = "securities")
public class Counter_party {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cp_id;
    private int user_id;
    // TODO: foreign key user_id_fk2
    @ManyToOne
    @JoinColumn(name="user_id", nullable = false)
    private Users user_id_fk2;

    @Id
    @Column(name = "cp_id", nullable = false)
    public int getCp_id() {
        return cp_id;
    }

    public void setCp_id(int cp_id) {
        this.cp_id = cp_id;
    }

    @Column(name = "user_id", nullable = false)
    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public Users getUser_id_fk2() {
        return user_id_fk2;
    }

    public void setUser_id_fk2(Users user_id_fk2) {
        this.user_id_fk2 = user_id_fk2;
    }

    @Override
    public String toString() {
        return "Counter_party{" +
                "cp_id=" + cp_id +
                ", user_id=" + user_id +
                ", user_id_fk2=" + user_id_fk2 +
                '}';
    }
}
