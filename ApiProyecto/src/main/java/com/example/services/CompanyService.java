package com.example.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entities.Company;
import com.example.repository.CompanyRepository;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    // Obtener todas las instancias de Company
    public List<Company> findAllCompanies() {
        return companyRepository.findAll();
    }

    // Crear una nueva instancia de Company
    public Company createCompany(Company company) {
        validateCompany(company);  // Validación antes de guardar
        return companyRepository.save(company);
    }

    // Actualizar una instancia existente de Company
    public Company updateCompany(Long id, Company company) {
        Optional<Company> existingCompanyOpt = companyRepository.findById(id);
        if (existingCompanyOpt.isPresent()) {
            Company existingCompany = existingCompanyOpt.get();
            existingCompany.setWeb(company.getWeb());
            existingCompany.setCoorX(company.getCoorX());
            existingCompany.setCoorY(company.getCoorY());
            existingCompany.setPhone(company.getPhone());
            return companyRepository.save(existingCompany);
        } else {
            throw new RuntimeException("Company not found with id " + id);
        }
    }

    // Eliminar una instancia existente de Company
    public boolean deleteCompany(Long id) {
        if (companyRepository.existsById(id)) {
            companyRepository.deleteById(id);
            return true;
        } else {
            throw new RuntimeException("Company not found with id " + id);
        }
    }

    // Actualizar parcialmente una instancia existente de Company
    public Company patchCompany(Long id, Company company) {
        Optional<Company> existingCompanyOpt = companyRepository.findById(id);
        if (existingCompanyOpt.isPresent()) {
            Company existingCompany = existingCompanyOpt.get();
            if (company.getWeb() != null) {
                existingCompany.setWeb(company.getWeb());
            }
            if (company.getCoorX() != null) {
                existingCompany.setCoorX(company.getCoorX());
            }
            if (company.getCoorY() != null) {
                existingCompany.setCoorY(company.getCoorY());
            }
            if (company.getPhone() != null) {
                existingCompany.setPhone(company.getPhone());
            }
            return companyRepository.save(existingCompany);
        } else {
            throw new RuntimeException("Company not found with id " + id);
        }
    }

    // Validar los datos de una instancia de Company
    private void validateCompany(Company company) {
        if (company.getWeb() == null || company.getWeb().trim().isEmpty()) {
            throw new IllegalArgumentException("Company web cannot be null or empty");
        }
        if (company.getPhone() == null || company.getPhone().trim().isEmpty()) {
            throw new IllegalArgumentException("Company phone cannot be null or empty");
        }
        if (company.getCoorX() == null) {
            throw new IllegalArgumentException("Company coordinate X cannot be null");
        }
        if (company.getCoorY() == null) {
            throw new IllegalArgumentException("Company coordinate Y cannot be null");
        }
        // Añadir más validaciones según sea necesario
    }
}
