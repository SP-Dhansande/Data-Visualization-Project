package com.api.data_visualization_dashboard.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;
import com.api.data_visualization_dashboard.service.VisualizationService;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import java.util.Optional;
//import com.api.data_visualization_dashboard.entities.Data;
//import java.util.List;

@RestController
public class DataController {
    @Autowired
    private VisualizationService visualizationService;
     // ****************getting counts for City and country***************

     @GetMapping("/citycounts")
     public Map<String, Long> getCityCounts() {
         return visualizationService.getCityCounts();
     }
 
     @GetMapping("/countrycounts")
     public Map<String, Long> getCountryCounts() {
         return visualizationService.getCountryCounts();
     }
//*******************************  For getting all the data   **************************
   /* @GetMapping("/data")
    public ResponseEntity<List<Data>> getData() {

        List<Data> list = visualizationService.getAllData();
        if (list.size() <= 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            return ResponseEntity.of(Optional.of(list));
        }
    }*/ 

    // *******************For getting Column wise data**********************

    /*@GetMapping("/getCities")
    public List<String> getCities() {
        return visualizationService.getAllCity();
    }

    @GetMapping("/getCountries")
    public List<String> getCountries() {
        return visualizationService.getAllCountry();
    }

    @GetMapping("/getRegions")
    public List<String> getRegions() {
        return visualizationService.getAllRegion();
    }

    @GetMapping("/getTopics")
    public List<String> getTopics() {
        return visualizationService.getAllTopic();
    }

    @GetMapping("/getSwots")
    public List<String> getSwots() {
        return visualizationService.getAllSwot();
    }

    @GetMapping("/getPestles")
    public List<String> getPestles() {
        return visualizationService.getAllPestle();
    }

    @GetMapping("/getSectors")
    public List<String> getSectors() {
        return visualizationService.getAllSector();
    }

    @GetMapping("/getSources")
    public List<String> getSources() {
        return visualizationService.getAllSource();
    }

    @GetMapping("/getEndYears")
    public List<String> getEndYears() {
        return visualizationService.getAllEndYear();
    }*/

   
}
