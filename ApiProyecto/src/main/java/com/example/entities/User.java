package com.example.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "user")
@Data
public class User {

    @Id
    @Column(name = "ID")
    Long id;

    @Column(name = "VERIFIED")
    Boolean verified;

    @OneToOne
    @JoinColumn(name = "ID", insertable = false, updatable = false)
    private BaseClass baseClass;
}
