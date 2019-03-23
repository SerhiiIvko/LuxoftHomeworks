package com.luxoft.ivko.web.dto;

import java.io.Serializable;
import java.util.Objects;

public class ClientCreateDto implements Serializable {
    private static final long serialVersionUID = 751014166558232361L;
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private String phone;
    private String age;

    public ClientCreateDto(String name, String surname, String email, String password, String phone, String age) {
        this(null, name, surname, email, password, phone, age);
    }

    public ClientCreateDto(Long id, String name, String surname, String email, String password, String phone, String age) {
        this.id = id;
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

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
    }

    public String getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ClientCreateDto)) return false;
        ClientCreateDto that = (ClientCreateDto) o;
        return getId().equals(that.getId()) &&
                getName().equals(that.getName()) &&
                getSurname().equals(that.getSurname()) &&
                getEmail().equals(that.getEmail()) &&
                getPassword().equals(that.getPassword()) &&
                getPhone().equals(that.getPhone()) &&
                getAge().equals(that.getAge());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getSurname(), getEmail(), getPassword(), getPhone(), getAge());
    }
}
