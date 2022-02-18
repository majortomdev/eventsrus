package com.jksports.eventsrus.resource;

import com.jksports.eventsrus.model.Event;
import com.jksports.eventsrus.service.implementation.EventServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.awt.*;
import java.nio.file.Files;
import java.nio.file.Paths;

@RestController
@RequestMapping("/event")
@RequiredArgsConstructor
public class EventController {
    private final EventServiceImpl eventService;

//    @GetMapping("/list")
//    public ResponseEntity<Event> getEvents() {
//        return ResponseEntity.ok(
//                new Event()
//        )
//    }

    @PostMapping("/save")
    public ResponseEntity<Boolean> saveEvent(Event event){
        return ResponseEntity.ok(Boolean.TRUE);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Boolean> getEvent(@PathVariable("id") Long id) {
        return {"name","barney"};


//                ResponseEntity.ok(Boolean.FALSE);
    }

    @GetMapping(path = "/image/{fileName}", produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] getEventImage(@PathVariable("fileName") String fileName) throws Exception {
        return Files.readAllBytes(Paths.get(System.getProperty("user.home") + "Downloads/images/" + fileName));
    }
}



