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

import com.example.entities.BaseClass;
import com.example.services.BaseClassService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/base-class")
@CrossOrigin(origins = "http://localhost:3000")
public class BaseClassController {

    @Autowired
    BaseClassService baseClassService;

    @GetMapping
    public List<BaseClass> getBaseClasses() {
        log.info("Fetching all BaseClasses");
        return baseClassService.findAllBaseClasses();
    }

    @PostMapping
    public ResponseEntity<BaseClass> createBaseClass(@RequestBody BaseClass baseClass) {
        log.info("Creating new BaseClass: {}", baseClass);
        BaseClass createdBaseClass = baseClassService.createBaseClass(baseClass);
        return ResponseEntity.ok(createdBaseClass);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BaseClass> updateBaseClass(@PathVariable Long id, @RequestBody BaseClass baseClass) {
        log.info("Updating BaseClass with id {}: {}", id, baseClass);
        BaseClass updatedBaseClass = baseClassService.updateBaseClass(id, baseClass);
        return ResponseEntity.ok(updatedBaseClass);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBaseClass(@PathVariable Long id) {
        log.info("Deleting BaseClass with id {}", id);
        return baseClassService.deleteBaseClass(id) ? 
                ResponseEntity.ok("BaseClass was deleted!") :
                ResponseEntity.notFound().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<BaseClass> patchBaseClass(@PathVariable Long id, @RequestBody BaseClass baseClass) {
        log.info("Patching BaseClass with id {}: {}", id, baseClass);
        BaseClass patchedBaseClass = baseClassService.patchBaseClass(id, baseClass);
        return ResponseEntity.ok(patchedBaseClass);
    }
}
