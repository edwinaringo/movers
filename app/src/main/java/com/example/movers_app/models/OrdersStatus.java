package com.example.movers_app.models;

import java.util.Objects;

public class OrdersStatus {

    private String uid;
    private String name;
    private String email;
    private String status;

    public OrdersStatus() {
    }
    public OrdersStatus(String uid, String name, String email, String status) {
        this.uid = uid;
        this.name = name;
        this.email = email;
        this.status = status;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrdersStatus status1 = (OrdersStatus) o;
        return Objects.equals(uid, status1.uid) &&
                Objects.equals(name, status1.name) &&
                Objects.equals(email, status1.email) &&
                Objects.equals(status, status1.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uid, name, email, status);
    }
}
