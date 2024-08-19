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
@Table(name = "activity")
@Data
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", columnDefinition = "INT")
    Long id;

    @Column(name = "FREE", nullable = false)
    Boolean free;

    @Column(name = "COOR_X", nullable = false)
    Double coorX;

    @Column(name = "COOR_Y", nullable = false)
    Double coorY;

    @Column(name = "NAME", length = 255, nullable = false)
    String name;

    @Column(name = "DESCRIPTION", columnDefinition = "TEXT", nullable = true)
    String description;

    @Column(name = "IMG", nullable = true)
    String img;
    
    @Column(name = "TYPE", nullable = true)
    String type;
}
