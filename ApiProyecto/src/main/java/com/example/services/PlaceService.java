package com.example.services;

import com.example.entities.Place;
import com.example.repository.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlaceService {

    @Autowired
    private PlaceRepository placeRepository;

    public List<Place> findAll() {
        return placeRepository.findAll();
    }

    public Optional<Place> findById(Long id) {
        return placeRepository.findById(id);
    }

    public Place save(Place place) {
        return placeRepository.save(place);
    }

    public void deleteById(Long id) {
        placeRepository.deleteById(id);
    }
}
