package com.luxoft.ivko.domain;

import java.util.Objects;

public class Client {
    private Long id;
    private String name;
    private String surname;
    private String phone;
    private String email;
    private String password;
    private String age;

    public Client() {
    }

//    public Client(String name, String surname, String phone) {
//        this.name = name;
//        this.surname = surname;
//        this.phone = phone;
//    }

    public Client(String name, String surname, String email, String password, String phone, String age) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client)) return false;
        Client client = (Client) o;
        return getAge().equals(client.getAge()) &&
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
        return "Client credentials: id=" + id
                + "; name: " + name
                + "; surname: " + surname
                + "; phone: " + phone
                + "; age= " + age;
    }
}
