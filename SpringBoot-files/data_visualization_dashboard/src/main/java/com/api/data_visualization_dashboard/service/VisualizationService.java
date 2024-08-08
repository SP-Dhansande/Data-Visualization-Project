package com.api.data_visualization_dashboard.service;

import com.api.data_visualization_dashboard.dao.DataRepository;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;

import java.util.List;
//import com.api.data_visualization_dashboard.entities.Data;
import java.util.Map;

@Component
public class VisualizationService {
    @Autowired
    private DataRepository dataRepository;
//*******************************  For getting all the data from database  **************************
   /*  public List<Data> getAllData() {
        List<Data> list = (List<Data>) this.dataRepository.findAll();
        return list;
    }*/

    // *******************For getting Column wise data from database**********************
   /*  public List<String> getAllCity() {
        return dataRepository.findDistinctCities();

    }

    public List<String> getAllCountry() {
        return dataRepository.findDistinctCountries();

    }

    public List<String> getAllTopic() {
        return dataRepository.findDistinctTopics();

    }

    public List<String> getAllSector() {
        return dataRepository.findDistinctSectors();

    }

    public List<String> getAllRegion() {
        return dataRepository.findDistinctRegions();

    }

    public List<String> getAllSwot() {
        return dataRepository.findDistinctSwots();

    }

    public List<String> getAllEndYear() {
        return dataRepository.findDistinctEndYears();

    }

    public List<String> getAllPestle() {
        return dataRepository.findDistinctPestles();

    }

    public List<String> getAllSource() {
        return dataRepository.findDistinctSources();

    }*/

    // ****************getting counts for City and country from databse***************

    public Map<String, Long> getCityCounts() {
        List<Object[]> results = dataRepository.countCities();
        Map<String, Long> cityCounts = new HashMap<>();

        for (Object[] result : results) {
            String city = (String) result[0];
            Long count = ((Number) result[1]).longValue();
            if (city != null && !city.trim().isEmpty()) {
                cityCounts.put(city, count);
            }
        }

        return cityCounts;
    }

    public Map<String, Long> getCountryCounts() {
        List<Object[]> results = dataRepository.countCountries();
        Map<String, Long> countryCounts = new HashMap<>();

        for (Object[] result : results) {
            String country = (String) result[0];
            Long count = ((Number) result[1]).longValue();
            if (country != null && !country.trim().isEmpty()) {
                countryCounts.put(country, count);
            }
        }

        return countryCounts;
    }

}
