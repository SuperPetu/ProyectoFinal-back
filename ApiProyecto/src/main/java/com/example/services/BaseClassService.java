package com.example.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entities.BaseClass;
import com.example.repository.BaseClassRepository;

@Service
public class BaseClassService {

    @Autowired
    private BaseClassRepository baseClassRepository;

    // Obtener todas las instancias de BaseClass
    public List<BaseClass> findAllBaseClasses() {
        return baseClassRepository.findAll();
    }

    // Crear una nueva instancia de BaseClass
    public BaseClass createBaseClass(BaseClass baseClass) {
        validateBaseClass(baseClass);  // Validación antes de guardar
        return baseClassRepository.save(baseClass);
    }

    // Actualizar una instancia existente de BaseClass
    public BaseClass updateBaseClass(Long id, BaseClass baseClass) {
        Optional<BaseClass> existingBaseClassOpt = baseClassRepository.findById(id);
        if (existingBaseClassOpt.isPresent()) {
            BaseClass existingBaseClass = existingBaseClassOpt.get();
            existingBaseClass.setName(baseClass.getName());
            existingBaseClass.setEmail(baseClass.getEmail());
            existingBaseClass.setPassword(baseClass.getPassword());
            existingBaseClass.setCountry(baseClass.getCountry());
            existingBaseClass.setPostalCode(baseClass.getPostalCode());
            existingBaseClass.setImg(baseClass.getImg());
            return baseClassRepository.save(existingBaseClass);
        } else {
            throw new RuntimeException("BaseClass not found with id " + id);
        }
    }

    // Eliminar una instancia existente de BaseClass
    public boolean deleteBaseClass(Long id) {
        if (baseClassRepository.existsById(id)) {
            baseClassRepository.deleteById(id);
            return true;
        } else {
            throw new RuntimeException("BaseClass not found with id " + id);
        }
    }

    // Actualizar parcialmente una instancia existente de BaseClass
    public BaseClass patchBaseClass(Long id, BaseClass baseClass) {
        Optional<BaseClass> existingBaseClassOpt = baseClassRepository.findById(id);
        if (existingBaseClassOpt.isPresent()) {
            BaseClass existingBaseClass = existingBaseClassOpt.get();
            if (baseClass.getName() != null) {
                existingBaseClass.setName(baseClass.getName());
            }
            if (baseClass.getEmail() != null) {
                existingBaseClass.setEmail(baseClass.getEmail());
            }
            if (baseClass.getPassword() != null) {
                existingBaseClass.setPassword(baseClass.getPassword());
            }
            if (baseClass.getCountry() != null) {
                existingBaseClass.setCountry(baseClass.getCountry());
            }
            if (baseClass.getPostalCode() != null) {
                existingBaseClass.setPostalCode(baseClass.getPostalCode());
            }
            if (baseClass.getImg() != null) {
                existingBaseClass.setImg(baseClass.getImg());
            }
           
            
            return baseClassRepository.save(existingBaseClass);
        } else {
            throw new RuntimeException("BaseClass not found with id " + id);
        }
    }

    // Validar los datos de una instancia de BaseClass
    private void validateBaseClass(BaseClass baseClass) {
        if (baseClass.getName() == null || baseClass.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("BaseClass name cannot be null or empty");
        }
        if (baseClass.getEmail() == null || baseClass.getEmail().trim().isEmpty()) {
            throw new IllegalArgumentException("BaseClass email cannot be null or empty");
        }
        // Validación de formato de correo electrónico (simple)
        if (!baseClass.getEmail().matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            throw new IllegalArgumentException("BaseClass email format is invalid");
        }
        if (baseClass.getPassword() == null || baseClass.getPassword().trim().isEmpty()) {
            throw new IllegalArgumentException("BaseClass password cannot be null or empty");
        }
        if (baseClass.getCountry() == null || baseClass.getCountry().trim().isEmpty()) {
            throw new IllegalArgumentException("BaseClass country cannot be null or empty");
        }
        if (baseClass.getPostalCode() == null) {
            throw new IllegalArgumentException("BaseClass postal code cannot be null or empty");
        }
        // Añadir más validaciones según sea necesario
    }
}
