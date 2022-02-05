package com.jksports.eventsrus.model;

import com.jksports.eventsrus.enumeration.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

//@author jk 03Feb-22

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Event {
    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;
    @Column(unique = true)
    @NotEmpty(message = "Event name cannot be empty or null")
    private String name;
    private String location;
    private String contact;
    private double cost;
    private int capacity;
    private String imageUrl;
    private Status status;
}


