package com.db.grad.javaapi.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "securities")
public class Securities {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int security_id;
    private float unit_price;
    private String bond_currency;
    private float coupon_rate;
    private String cusip;
    private String isin;
    private int face_value;
    private String issuer_name;
    private Date mature_date;
    private String status;
    private String bond_type;
    private int book_id;


    //TODO: missing foreign keys!
    //book_id_fk2
    @Id
    @Column(name = "security_id", nullable = false)
    public int getSecurity_id() {
        return security_id;
    }

    public void setSecurity_id(int security_id) {
        this.security_id = security_id;
    }

    @Column(name = "unit_price", nullable = false)
    public float getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(float unit_price) {
        this.unit_price = unit_price;
    }

    @Column(name = "bond_currency", nullable = false)
    public String getBond_currency() {
        return bond_currency;
    }

    public void setBond_currency(String bond_currency) {
        this.bond_currency = bond_currency;
    }

    @Column(name = "coupon_rate", nullable = false)
    public float getCoupon_rate() {
        return coupon_rate;
    }

    public void setCoupon_rate(float coupon_rate) {
        this.coupon_rate = coupon_rate;
    }

    @Column(name = "cusip", nullable = false)
    public String getCusip() {
        return cusip;
    }

    public void setCusip(String cusip) {
        this.cusip = cusip;
    }

    @Column(name = "isin", nullable = false)
    public String getIsin() {
        return isin;
    }

    public void setIsin(String isin) {
        this.isin = isin;
    }

    @Column(name = "face_value", nullable = false)
    public int getFace_value() {
        return face_value;
    }

    public void setFace_value(int face_value) {
        this.face_value = face_value;
    }

    @Column(name = "issuer_name", nullable = false)
    public String getIssuer_name() {
        return issuer_name;
    }

    public void setIssuer_name(String issuer_name) {
        this.issuer_name = issuer_name;
    }

    @Column(name = "mature_date")
    public Date getMature_date() {
        return mature_date;
    }

    public void setMature_date(Date mature_date) {
        this.mature_date = mature_date;
    }

    @Column(name = "status", nullable = false)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Column(name = "bond_type", nullable = false)
    public String getBond_type() {
        return bond_type;
    }

    public void setBond_type(String bond_type) {
        this.bond_type = bond_type;
    }

    @Column(name = "book_id", nullable = false)
    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }


    @Override
    public String toString() {
        return "Securities{" +
                "security_id=" + security_id +
                ", unit_price=" + unit_price +
                ", bond_currency='" + bond_currency + '\'' +
                ", coupon_rate=" + coupon_rate +
                ", cusip='" + cusip + '\'' +
                ", isin='" + isin + '\'' +
                ", face_value=" + face_value +
                ", issuer_name='" + issuer_name + '\'' +
                ", mature_date=" + mature_date +
                ", status='" + status + '\'' +
                ", bond_type='" + bond_type + '\'' +
                ", book_id=" + book_id +
                '}';
    }
}
