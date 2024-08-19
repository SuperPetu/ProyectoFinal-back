package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entities.Activity;
import com.example.services.ActivityServices;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/activity")
@CrossOrigin(origins = "http://localhost:3000")
public class ActivityController {

    @Autowired
    ActivityServices activityServices;

    @GetMapping
    public List<Activity> getActivities() {
        log.info("Fetching all activities");
        return activityServices.findAllActivities();
    }

    @PostMapping
    public ResponseEntity<Activity> createActivity(@RequestBody Activity activity) {
        log.info("Creating new activity: {}", activity);
        Activity createdActivity = activityServices.createActivity(activity);
        return ResponseEntity.ok(createdActivity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Activity> updateActivity(@PathVariable Long id, @RequestBody Activity activity) {
        log.info("Updating activity with id {}: {}", id, activity);
        Activity updatedActivity = activityServices.updateActivity(id, activity);
        return ResponseEntity.ok(updatedActivity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteActivity(@PathVariable Long id) {
        log.info("Deleting activity with id {}", id);
        return activityServices.deleteActivity(id) ? 
                ResponseEntity.ok("Activity was deleted!") :
                ResponseEntity.notFound().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Activity> patchActivity(@PathVariable Long id, @RequestBody Activity activity) {
        log.info("Patching activity with id {}: {}", id, activity);
        Activity patchedActivity = activityServices.patchActivity(id, activity);
        return ResponseEntity.ok(patchedActivity);
    }
}
