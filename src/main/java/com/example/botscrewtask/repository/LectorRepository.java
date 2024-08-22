package com.example.botscrewtask.repository;

import java.util.List;

import com.example.botscrewtask.model.Lector;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LectorRepository extends JpaRepository<Lector, Long> {
    @EntityGraph(attributePaths = {"degree"})
    List<Lector> findByDepartmentsName(String department);
    Integer countByDepartmentsName(String department);
    List<Lector> findByNameContaining(String template);
}
