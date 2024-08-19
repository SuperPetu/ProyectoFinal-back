package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.entities.UserEvent;

public interface UserEventRepository extends JpaRepository<UserEvent, Long> {
}
