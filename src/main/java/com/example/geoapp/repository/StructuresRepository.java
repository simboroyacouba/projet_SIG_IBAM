package com.example.geoapp.repository;

import com.example.geoapp.model.Structure;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;


public interface StructuresRepository extends CrudRepository<Structure, Long> {
    Optional<Structure> findByNom(String nom);

    List<Structure> findAllByOrderByNumeroAsc();
}
