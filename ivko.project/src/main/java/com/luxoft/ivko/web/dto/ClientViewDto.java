package com.luxoft.ivko.web.dto;

import java.io.Serializable;
import java.util.Objects;

public class ClientViewDto implements Serializable {
    private Long id;
    private String name;
    private String surname;
    private String age;
    private String email;

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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ClientViewDto)) return false;
        ClientViewDto that = (ClientViewDto) o;
        return getId().equals(that.getId()) &&
                getName().equals(that.getName()) &&
                getSurname().equals(that.getSurname()) &&
                getAge().equals(that.getAge()) &&
                getEmail().equals(that.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getSurname(), getAge(), getEmail());
    }
}
