package com.example.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "base_class")
@Data
public class BaseClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", columnDefinition = "BIGINT")
    Long id;

    @Column(name = "NAME", length = 255, nullable = false)
    String name;

    @Column(name = "EMAIL", length = 255, nullable = false)
    String email;

    @Column(name = "PASSWORD", length = 255, nullable = false)
    String password;

    @Column(name = "COUNTRY", length = 255, nullable = false)
    String country;

    @Column(name = "POSTAL_CODE", nullable = false)
    Integer postalCode;

    @Column(name = "IMG", nullable = true)
   String img;
}
