package com.project.domain;


import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.*;
import java.io.Serializable;


// @DiscriminatorColumn(name = "role", discriminatorType = DiscriminatorType.STRING)


@Entity
@Table(name = "user")
@DiscriminatorColumn(name = "role", discriminatorType = DiscriminatorType.STRING)
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true,nullable = false)
    private Long id;

    @Column(nullable = true,unique = true)
    private String username;

    @JsonProperty
    @NotBlank
    @Column(nullable = false)
    private String password;


    @NotBlank
    @Column(nullable = false)
    private String name;


    @NotBlank
    @Column(nullable = false)
    private String surname;

    @Email
    @Column(nullable = false, unique = true)
    private String email;

    @NotBlank
    @Column(nullable = false)
    private String city;

    @Column(nullable = true)  // Posto nema za obicne usere
    @XmlElement(name="adress", required=false)
    private String adress;


    @Size(min = 6)
    @Column(nullable = false)
    private String number;

    // @Enumerated(EnumType.STRING)
    @Column(name="role", nullable=false, updatable=false, insertable=false)
    private String role;

    @Column(nullable = false)
    private boolean activated;


    public User() {}


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordHash() {
        return password;
    }

    public void setPasswordHash(String passwordHash) {
        this.password = passwordHash;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

//    public Role getRole() {
//        return role;
//    }
//
//    public void setRole(Role role) {
//        this.role = role;
//    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }
}
