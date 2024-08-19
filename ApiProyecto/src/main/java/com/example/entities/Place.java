package com.example.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "place")
@Data
public class Place {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", columnDefinition = "BIGINT")
    Long id;

    @Column(name = "RATING", nullable = false)
    Double rating;

    @Column(name = "USERS_RATE", nullable = false)
    Integer usersRate;

    @ManyToOne
    @JoinColumn(name = "CREATOR", nullable = false)
    Company creator;

    @OneToOne
    @JoinColumn(name = "ID", referencedColumnName = "ID", nullable = false)
    Activity activity;
}
