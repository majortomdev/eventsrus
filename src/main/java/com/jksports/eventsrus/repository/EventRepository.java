package com.jksports.eventsrus.repository;

import com.jksports.eventsrus.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

//@author jk 03Feb-22

public interface EventRepository extends JpaRepository<Event, Long> {
    Event findByName(String name);
}
