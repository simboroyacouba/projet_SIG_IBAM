package com.example.geoapp.service.impl;

import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.StreamSupport;

import com.example.geoapp.model.Structure;
import com.example.geoapp.repository.StructuresRepository;
import com.example.geoapp.service.StructuresService;

@Service
public class StructuresServiceImpl implements StructuresService {

    @Autowired
    StructuresRepository waterConsuptionRepository;

    public static <T> List<T> toList(final Iterable<T> iterable) {
        return StreamSupport.stream(iterable.spliterator(), false)
                .toList();
    }

    @Override
    public List<Structure> findAllStructures() {
        return  toList(waterConsuptionRepository.findAll());
    }

    @Override
    public Structure findStructuresById(Long id){
        return  waterConsuptionRepository.findById(id).orElse(null);
    }

    @Override
    public Structure findStructuresByName(String name){
        return  waterConsuptionRepository.findById(1L).orElse(null);
    }


    public void saveCsv(){
        //read all data from table on store on response object
        List<Structure> structures = findAllStructures();
        if(structures.isEmpty()){
            System.out.println("La liste des structures est vide");
            System.out.println("Début de l'initialisation");

            String[] HEADERS = {"nom", "sigle", "responsable", "adresse", "email", "telephone", "siteWeb", "pageFacebook","Latitude", "Longitude"};
            //String fileLocatiion = "C:\\workspace_nebrata\\Spring\\geoapp\\src\\main\\resources\\structures_data_old.csv";//"/home\\hp\\Workspace\\spring\\geoapp\\src\\main\\resources\\waterwatch_data.csv"
            String fileLocatiion = Paths.get("src", "main", "resources", "structures_data.csv").toString();

            try{
                Reader in = new FileReader(fileLocatiion);
                Iterable<CSVRecord> record = CSVFormat.newFormat(';')
                        .withHeader(HEADERS)
                        .withFirstRecordAsHeader()
                        .parse(in);
                for (CSVRecord record1 : record) {
                    String nom = record1.get("nom");
                    String sigle = record1.get("sigle");
                    String responsable = record1.get("responsable");
                    String adresse = record1.get("adresse");
                    String email = record1.get("email");
                    String telephone = record1.get("telephone");
                    String siteWeb = record1.get("siteWeb");
                    String pageFacebook = record1.get("pageFacebook");
                    String latitude = record1.get("Latitude");
                    String longitude = record1.get("Longitude");

                    Double dLatitude = Double.valueOf(latitude);
                    Double dLongitude = Double.valueOf(longitude);

                    Point geom = new GeometryFactory().createPoint(new Coordinate(dLongitude, dLatitude));

                    //load data
                    Structure structure = new Structure();
                    structure.setNom(nom);
                    structure.setSigle(sigle);
                    structure.setResponsable(responsable);
                    structure.setAdresse(adresse);
                    structure.setEmail(email);
                    structure.setSiteWeb(siteWeb);
                    structure.setPageFacebook(pageFacebook);
                    structure.setTelephone(telephone);
                    structure.setGeom(geom);

                    waterConsuptionRepository.save(structure);
                }

                System.out.println("les structures ont été initialisées");
            }catch (IOException e){
                e.printStackTrace();
            }
        }else{
            System.out.println("Data loaded");
        }

    }
}
