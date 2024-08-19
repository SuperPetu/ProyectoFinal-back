package com.example.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entities.UserEvent;
import com.example.repository.UserEventRepository;

@Service
public class UserEventService {

    @Autowired
    private UserEventRepository userEventRepository;

    // Obtener todos los UserEvent
    public List<UserEvent> findAllUserEvents() {
        return userEventRepository.findAll();
    }

    // Crear un nuevo UserEvent
    public UserEvent createUserEvent(UserEvent userEvent) {
        validateUserEvent(userEvent);  // Validar antes de guardar
        return userEventRepository.save(userEvent);
    }

    // Actualizar un UserEvent existente
    public UserEvent updateUserEvent(Long id, UserEvent userEvent) {
        UserEvent existingUserEvent = userEventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("UserEvent not found with id " + id));

        // Actualizar campos
        existingUserEvent.setDate(userEvent.getDate());
        existingUserEvent.setUser(userEvent.getUser());
        existingUserEvent.setEvent(userEvent.getEvent());

        return userEventRepository.save(existingUserEvent);
    }

    // Eliminar un UserEvent por ID
    public boolean deleteUserEvent(Long id) {
        if (!userEventRepository.existsById(id)) {
            throw new RuntimeException("UserEvent not found with id " + id);
        }
        userEventRepository.deleteById(id);
        return true;
    }

    // Actualizar parcialmente un UserEvent existente
    public UserEvent patchUserEvent(Long id, UserEvent userEvent) {
        UserEvent existingUserEvent = userEventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("UserEvent not found with id " + id));

        // Actualizar campos si no son nulos
        if (userEvent.getDate() != null) {
            existingUserEvent.setDate(userEvent.getDate());
        }
        if (userEvent.getUser() != null) {
            existingUserEvent.setUser(userEvent.getUser());
        }
        if (userEvent.getEvent() != null) {
            existingUserEvent.setEvent(userEvent.getEvent());
        }

        return userEventRepository.save(existingUserEvent);
    }

    // Validar los datos del UserEvent
    private void validateUserEvent(UserEvent userEvent) {
        if (userEvent.getDate() == null) {
            throw new IllegalArgumentException("Event date cannot be null");
        }
        if (userEvent.getUser() == null) {
            throw new IllegalArgumentException("User cannot be null");
        }
        if (userEvent.getEvent() == null) {
            throw new IllegalArgumentException("Event cannot be null");
        }
    }
}
