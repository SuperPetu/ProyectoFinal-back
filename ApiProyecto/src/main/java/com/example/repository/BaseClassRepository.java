package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.entities.BaseClass;

public interface BaseClassRepository extends JpaRepository<BaseClass, Long> {
}
