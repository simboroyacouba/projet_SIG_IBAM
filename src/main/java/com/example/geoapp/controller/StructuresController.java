package com.example.geoapp.controller;

import com.example.geoapp.model.Structure;
import com.example.geoapp.service.StructuresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/structures")
public class StructuresController {

    @Autowired
    private StructuresService structuresService;



    @GetMapping(path = "/all")
    public List<Structure> findAll(){
        return structuresService.findAllStructures();
    }

    @RequestMapping(value = "/{idStructure}", method = RequestMethod.GET)
    public Structure findStructuresById(Long idStructure){
        return structuresService.findStructuresById(idStructure);
    }

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public Structure findStructuresByName(String name){
        return structuresService.findStructuresByName(name);
    }

    @GetMapping(path = "/ini")
    public void initialize(){
        structuresService.saveCsv();
    }
}
