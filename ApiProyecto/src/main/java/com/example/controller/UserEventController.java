package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.entities.UserEvent;
import com.example.services.UserEventService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/user-event")
@CrossOrigin(origins = "http://localhost:3000")
public class UserEventController {

    @Autowired
    UserEventService userEventService;

    @GetMapping
    public List<UserEvent> getUserEvents() {
        log.info("Fetching all user events");
        return userEventService.findAllUserEvents();
    }

    @PostMapping
    public ResponseEntity<UserEvent> createUserEvent(@RequestBody UserEvent userEvent) {
        log.info("Creating new user event: {}", userEvent);
        UserEvent createdUserEvent = userEventService.createUserEvent(userEvent);
        return ResponseEntity.ok(createdUserEvent);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserEvent> updateUserEvent(@PathVariable Long id, @RequestBody UserEvent userEvent) {
        log.info("Updating user event with id {}: {}", id, userEvent);
        UserEvent updatedUserEvent = userEventService.updateUserEvent(id, userEvent);
        return ResponseEntity.ok(updatedUserEvent);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUserEvent(@PathVariable Long id) {
        log.info("Deleting user event with id {}", id);
        return userEventService.deleteUserEvent(id) ? 
                ResponseEntity.ok("UserEvent was deleted!") :
                ResponseEntity.notFound().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<UserEvent> patchUserEvent(@PathVariable Long id, @RequestBody UserEvent userEvent) {
        log.info("Patching user event with id {}: {}", id, userEvent);
        UserEvent patchedUserEvent = userEventService.patchUserEvent(id, userEvent);
        return ResponseEntity.ok(patchedUserEvent);
    }
}
