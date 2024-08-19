package com.example.services;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entities.Activity;
import com.example.repository.ActivityRepository;

@Service
public class ActivityServices {

    @Autowired
    private ActivityRepository activityRepository;

    // Lista de tipos válidos
    private static final List<String> VALID_TYPES = Arrays.asList(
        "Runner", "Ball", "Racket", "Yoga", "Aquatic", "Several", "Gym"
    );

    // Obtener todas las actividades
    public List<Activity> findAllActivities() {
        return activityRepository.findAll();
    }

    // Crear una nueva actividad
    public Activity createActivity(Activity activity) {
        validateActivity(activity);  // Validación antes de guardar
        return activityRepository.save(activity);
    }

    // Actualizar una actividad existente
    public Activity updateActivity(Long id, Activity activity) {
        Optional<Activity> existingActivityOpt = activityRepository.findById(id);
        if (existingActivityOpt.isPresent()) {
            Activity existingActivity = existingActivityOpt.get();
            // Actualiza los campos con nuevos valores si no son nulos
            if (activity.getFree() != null) {
                existingActivity.setFree(activity.getFree());
            }
            if (activity.getCoorX() != null) {
                existingActivity.setCoorX(activity.getCoorX());
            }
            if (activity.getCoorY() != null) {
                existingActivity.setCoorY(activity.getCoorY());
            }
            if (activity.getName() != null) {
                existingActivity.setName(activity.getName());
            }
            if (activity.getDescription() != null) {
                existingActivity.setDescription(activity.getDescription());
            }
            if (activity.getImg() != null) {
                existingActivity.setImg(activity.getImg());
            }
            if (activity.getType() != null) {
                validateType(activity.getType());
                existingActivity.setType(activity.getType());
            }
            return activityRepository.save(existingActivity);
        } else {
            throw new RuntimeException("Activity not found with id " + id);
        }
    }

    // Eliminar una actividad existente
    public boolean deleteActivity(Long id) {
        if (activityRepository.existsById(id)) {
            activityRepository.deleteById(id);
            return true;
        } else {
            throw new RuntimeException("Activity not found with id " + id);
        }
    }

    // Actualizar parcialmente una actividad existente
    public Activity patchActivity(Long id, Activity activity) {
        Optional<Activity> existingActivityOpt = activityRepository.findById(id);
        if (existingActivityOpt.isPresent()) {
            Activity existingActivity = existingActivityOpt.get();
            // Actualiza solo los campos que se proporcionan
            if (activity.getFree() != null) {
                existingActivity.setFree(activity.getFree());
            }
            if (activity.getCoorX() != null) {
                existingActivity.setCoorX(activity.getCoorX());
            }
            if (activity.getCoorY() != null) {
                existingActivity.setCoorY(activity.getCoorY());
            }
            if (activity.getName() != null) {
                existingActivity.setName(activity.getName());
            }
            if (activity.getDescription() != null) {
                existingActivity.setDescription(activity.getDescription());
            }
            if (activity.getImg() != null) {
                existingActivity.setImg(activity.getImg());
            }
            if (activity.getType() != null) {
                validateType(activity.getType());
                existingActivity.setType(activity.getType());
            }
            return activityRepository.save(existingActivity);
        } else {
            throw new RuntimeException("Activity not found with id " + id);
        }
    }

    // Validar los datos de una actividad
    private void validateActivity(Activity activity) {
        if (activity.getName() == null || activity.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("Activity name cannot be null or empty");
        }
        if (activity.getDescription() == null || activity.getDescription().trim().isEmpty()) {
            throw new IllegalArgumentException("Activity description cannot be null or empty");
        }
        if (activity.getCoorX() == null || activity.getCoorY() == null) {
            throw new IllegalArgumentException("Activity coordinates cannot be null");
        }
        if (activity.getFree() == null) {
            throw new IllegalArgumentException("Activity free status cannot be null");
        }
        if (activity.getType() != null) {
            validateType(activity.getType());
        }
    }

    // Validar que el tipo sea válido
    private void validateType(String type) {
        if (!VALID_TYPES.contains(type)) {
            throw new IllegalArgumentException("Invalid Activity type: " + type + ". Valid types are: " + VALID_TYPES);
        }
    }
}
