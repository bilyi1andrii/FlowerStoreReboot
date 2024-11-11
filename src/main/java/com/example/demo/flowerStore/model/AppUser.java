package com.example.demo.flowerstore.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;
import java.time.Period;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private LocalDate dob;

    @Transient
    private Integer age;

    public AppUser(String email, LocalDate dob) {
        this.email = email;
        this.dob = dob;
    }

    public String getEmail() {
        return this.email;
    }

    public Integer getAge() {
        if (this.dob != null) {
            return Period.between(this.dob,
            LocalDate.now()).getYears();
        }
        return null;
    }


}