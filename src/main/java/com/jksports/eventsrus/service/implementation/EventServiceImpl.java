package com.jksports.eventsrus.service.implementation;

import com.jksports.eventsrus.enumeration.Status;
import com.jksports.eventsrus.model.Event;
import com.jksports.eventsrus.repository.EventRepository;
import com.jksports.eventsrus.service.EventService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Random;

@RequiredArgsConstructor // its a lombok thing
@Service
@Transactional
@Slf4j
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepo;

    @Override
    public Event create(Event event) {
        log.info("Saving new event: {}", event.getName());
        event.setImageUrl(setEventImageUrl());
        return eventRepo.save(event);
    }

    private String setEventImageUrl() {
        String[] imageNames = { "event1.png", "event2.png", "event3.png", "event4.png" };
        return ServletUriComponentsBuilder.fromCurrentContextPath().path("/event/image/" +
                imageNames[new Random().nextInt(4)]).toUriString();
    }

    @Override
    public Event launch(String name) {
        log.info("Launching new event: {}", name);
        Event event = eventRepo.findByName(name);
        event.setStatus(Status.EVENT_LIVE);
        eventRepo.save(event);
        return event;
    }

    @Override
    public Collection<Event> list(int limit) {
        log.info("Grabbing all events");
        return eventRepo.findAll(PageRequest.of(0, limit)).toList();
    }

    @Override
    public Event get(Long id) {
        log.info("Grabbing event by id: {}", id);
        return eventRepo.findById(id).get();
    }

    @Override
    public Event update(Event event) {
        log.info("Updating event: {}", event.getName());
        return eventRepo.save(event);
    }

    @Override
    public Boolean archive(String name) {
        Event event = eventRepo.findByName(name);
        log.info("Archiving event: {}", event.getName());
        event.setStatus(Status.EVENT_PAST);
        eventRepo.save(event);
        return Boolean.TRUE;
    }
}
