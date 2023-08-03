package com.db.grad.javaapi.model;

import javax.persistence.*;

@Entity
@Table(name = "counter_party")
public class CounterParty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cp_id;
    @ManyToOne
    @JoinColumn(name="user_id", nullable = false)
    private Users user_id;
    // TODO: foreign key user_id_fk2


    @Id
    @Column(name = "cp_id", nullable = false)
    public int getCp_id() {
        return cp_id;
    }

    public void setCp_id(int cp_id) {
        this.cp_id = cp_id;
    }

    public Users getUser_id() {
        return user_id;
    }

    public void setUser_id(Users user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "CounterParty{" +
                "cp_id=" + cp_id +
                ", user_id=" + user_id +
                '}';
    }
}
