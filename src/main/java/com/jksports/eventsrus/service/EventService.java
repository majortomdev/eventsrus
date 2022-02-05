package com.jksports.eventsrus.service;

import java.util.Collection;

public interface EventService {
    Event create(Event event);
    Collection<Event> list(int limit);
    Event get(Long id);
    Event update(Event event);
    Boolean delete(Long id);
}
