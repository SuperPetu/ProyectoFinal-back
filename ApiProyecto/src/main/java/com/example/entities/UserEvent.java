package com.example.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "user_event")
@Data
public class UserEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    Long id;

    @Column(name = "DATE")
    java.sql.Date date;

    @ManyToOne
    @JoinColumn(name = "USER", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "EVENT", nullable = false)
    private Event event;
}
