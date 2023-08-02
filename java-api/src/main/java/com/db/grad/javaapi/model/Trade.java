package com.db.grad.javaapi.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "trade")
public class Trade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int trade_id;
    private String trade_type;
    private String currency;
    private int quantity;
    private Date settle_date;
    private String t_status;
    private Date trade_date;
    private int book_id;
    private int security_id;
    private int cp_id;

    //TODO: missing foreign keys!
    //book_id_fk3
    //security_id_fk1
    //cp_id_fk

    @Id
    @Column(name = "trade_id", nullable = false)
    public int getTrade_id() {
        return trade_id;
    }

    public void setTrade_id(int trade_id) {
        this.trade_id = trade_id;
    }
    @Column(name = "trade_type", nullable = true)
    public String getTrade_type() {
        return trade_type;
    }

    public void setTrade_type(String trade_type) {
        this.trade_type = trade_type;
    }

    @Column(name = "currency", nullable = false)
    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
    @Column(name = "quantity", nullable = false)
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Column(name = "settle_date")
    public Date getSettle_date() {
        return settle_date;
    }

    public void setSettle_date(Date settle_date) {
        this.settle_date = settle_date;
    }

    @Column(name = "t_status", nullable = false)
    public String getT_status() {
        return t_status;
    }

    public void setT_status(String t_status) {
        this.t_status = t_status;
    }

    @Column(name = "trade_date")
    public Date getTrade_date() {
        return trade_date;
    }

    public void setTrade_date(Date trade_date) {
        this.trade_date = trade_date;
    }

    @Column(name = "book_id", nullable = false)
    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    @Column(name = "security_id", nullable = false)
    public int getSecurity_id() {
        return security_id;
    }

    public void setSecurity_id(int security_id) {
        this.security_id = security_id;
    }

    @Column(name = "cp_id", nullable = false)
    public int getCp_id() {
        return cp_id;
    }

    public void setCp_id(int cp_id) {
        this.cp_id = cp_id;
    }

    @Override
    public String toString() {
        return "Trade{" +
                "trade_id=" + trade_id +
                ", trade_type='" + trade_type + '\'' +
                ", currency='" + currency + '\'' +
                ", quantity=" + quantity +
                ", settle_date=" + settle_date +
                ", t_status='" + t_status + '\'' +
                ", trade_date=" + trade_date +
                ", book_id=" + book_id +
                ", security_id=" + security_id +
                ", cp_id=" + cp_id +
                '}';
    }
}
