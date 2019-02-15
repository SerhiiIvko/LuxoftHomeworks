package com.luxoft.ivko.domain;

import java.math.BigDecimal;
import java.util.Objects;

public class Client {
    private BigDecimal id;
    private String name;
    private String surname;
    private String phone;
    private String email;
    private int age;

    public Client(String name, String surname, String phone) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
    }

    public Client(String name, String surname, String phone, String email, int age) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.email = email;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client)) return false;
        Client client = (Client) o;
        return getAge() == client.getAge() &&
                getName().equals(client.getName()) &&
                getSurname().equals(client.getSurname()) &&
                getPhone().equals(client.getPhone()) &&
                getEmail().equals(client.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getSurname(), getPhone(), getEmail(), getAge());
    }

    @Override
    public String toString() {
        return "Client credentials: "
                + "name: " + name
                + "; surname: " + surname
                + "; phone: " + phone;
    }
}