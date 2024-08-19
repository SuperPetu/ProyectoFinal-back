package com.example.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "company") // Puedes mantener el nombre de la tabla o cambiarlo si es necesario
@Data
public class Company { // Renombrado de Entity a MyEntity

    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "WEB")
    private String web;

    @Column(name = "COOR_X")
    private Double coorX;

    @Column(name = "COOR_Y")
    private Double coorY;

    @Column(name = "PHONE")
    private String phone;

    @OneToOne
    @JoinColumn(name = "ID", insertable = false, updatable = false)
    private BaseClass baseClass;
}
