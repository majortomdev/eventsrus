package com.jksports.eventsrus.service;

import com.jksports.eventsrus.model.Event;

import java.util.Collection;

public interface EventService {
    Event create(Event event);
    Event launch(String name);
    Collection<Event> list(int limit);
    Event get(Long id);
    Event update(Event event);
    Boolean archive(String name);
}
