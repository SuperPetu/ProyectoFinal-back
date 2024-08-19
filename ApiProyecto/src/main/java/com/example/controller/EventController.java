package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.entities.Event;
import com.example.services.EventService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/event")
@CrossOrigin(origins = "http://localhost:3000")
public class EventController {

    @Autowired
    EventService eventService;

    @GetMapping
    public List<Event> getEvents() {
        log.info("Fetching all events");
        return eventService.findAllEvents();
    }

    @PostMapping
    public ResponseEntity<Event> createEvent(@RequestBody Event event) {
        log.info("Creating new event: {}", event);
        Event createdEvent = eventService.createEvent(event);
        return ResponseEntity.ok(createdEvent);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Event> updateEvent(@PathVariable Long id, @RequestBody Event event) {
        log.info("Updating event with id {}: {}", id, event);
        Event updatedEvent = eventService.updateEvent(id, event);
        return ResponseEntity.ok(updatedEvent);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEvent(@PathVariable Long id) {
        log.info("Deleting event with id {}", id);
        return eventService.deleteEvent(id) ? 
                ResponseEntity.ok("Event was deleted!") :
                ResponseEntity.notFound().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Event> patchEvent(@PathVariable Long id, @RequestBody Event event) {
        log.info("Patching event with id {}: {}", id, event);
        Event patchedEvent = eventService.patchEvent(id, event);
        return ResponseEntity.ok(patchedEvent);
    }
}
