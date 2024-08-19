package com.example.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "event")
@Data
public class Event {

    @Id
    @Column(name = "ID")
    Long id;

    @Column(name = "DATE")
    java.sql.Date date;

    @Column(name = "CREATOR")
    Long creator;

    @ManyToOne
    @JoinColumn(name = "ID", insertable = false, updatable = false)
    private Activity activity;

    @ManyToOne
    @JoinColumn(name = "CREATOR", insertable = false, updatable = false)
    private BaseClass creatorDetails;
}
