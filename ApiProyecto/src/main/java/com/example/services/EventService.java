package com.example.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entities.Event;
import com.example.repository.EventRepository;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    // Obtener todos los eventos
    public List<Event> findAllEvents() {
        return eventRepository.findAll();
    }

    // Crear un nuevo evento
    public Event createEvent(Event event) {
        validateEvent(event);  // Validar el evento antes de guardarlo
        return eventRepository.save(event);
    }

    // Actualizar un evento existente
    public Event updateEvent(Long id, Event event) {
        Optional<Event> existingEventOpt = eventRepository.findById(id);
        if (existingEventOpt.isPresent()) {
            Event existingEvent = existingEventOpt.get();
            validateEvent(event);  // Validar los datos del evento
            existingEvent.setDate(event.getDate());
            existingEvent.setCreator(event.getCreator());
            return eventRepository.save(existingEvent);
        } else {
            throw new RuntimeException("Event not found with id " + id);
        }
    }

    // Eliminar un evento existente
    public boolean deleteEvent(Long id) {
        if (eventRepository.existsById(id)) {
            eventRepository.deleteById(id);
            return true;
        } else {
            throw new RuntimeException("Event not found with id " + id);
        }
    }

    // Actualizar parcialmente un evento existente
    public Event patchEvent(Long id, Event event) {
        Optional<Event> existingEventOpt = eventRepository.findById(id);
        if (existingEventOpt.isPresent()) {
            Event existingEvent = existingEventOpt.get();
            if (event.getDate() != null) {
                existingEvent.setDate(event.getDate());
            }
            if (event.getCreator() != null) {
                existingEvent.setCreator(event.getCreator());
            }
            return eventRepository.save(existingEvent);
        } else {
            throw new RuntimeException("Event not found with id " + id);
        }
    }

    // Validar los datos del evento
    private void validateEvent(Event event) {
        if (event.getDate() == null) {
            throw new IllegalArgumentException("Event date cannot be null");
        }
        if (event.getCreator() == null) {
            throw new IllegalArgumentException("Event creator cannot be null or empty");
        }
        // Añadir más validaciones según sea necesario
    }
}
