package com.example.geoapp.service;

import com.example.geoapp.model.Structure;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StructuresService {
    List<Structure> findAllStructures();
    Structure findStructuresById(Long id);
    Structure findStructuresByName(String name);

//    List<Structure> findTopTenWaterConsuptions();
    void saveCsv();
}
