package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.entities.Company;
import com.example.services.CompanyService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/company")
@CrossOrigin(origins = "http://localhost:3000")
public class CompanyController {

    @Autowired
    CompanyService companyService;

    @GetMapping
    public List<Company> getCompanies() {
        log.info("Fetching all companies");
        return companyService.findAllCompanies();
    }

    @PostMapping
    public ResponseEntity<Company> createCompany(@RequestBody Company company) {
        log.info("Creating new company: {}", company);
        Company createdCompany = companyService.createCompany(company);
        return ResponseEntity.ok(createdCompany);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Company> updateCompany(@PathVariable Long id, @RequestBody Company company) {
        log.info("Updating company with id {}: {}", id, company);
        Company updatedCompany = companyService.updateCompany(id, company);
        return ResponseEntity.ok(updatedCompany);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCompany(@PathVariable Long id) {
        log.info("Deleting company with id {}", id);
        return companyService.deleteCompany(id) ? 
                ResponseEntity.ok("Company was deleted!") :
                ResponseEntity.notFound().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Company> patchCompany(@PathVariable Long id, @RequestBody Company company) {
        log.info("Patching company with id {}: {}", id, company);
        Company patchedCompany = companyService.patchCompany(id, company);
        return ResponseEntity.ok(patchedCompany);
    }
}
