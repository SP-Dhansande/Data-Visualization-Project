package com.api.data_visualization_dashboard.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.api.data_visualization_dashboard.entities.Data;

public interface DataRepository extends JpaRepository<Data, Integer> {
    
// *******************For getting Column wise data from database**********************

   /*  @Query("SELECT DISTINCT l.city FROM Data l WHERE l.city IS NOT NULL AND TRIM(l.city) <> ''")
    List<String> findDistinctCities();

    @Query("SELECT DISTINCT l.country FROM Data l WHERE l.country IS NOT NULL AND TRIM(l.country) <> ''")
    List<String> findDistinctCountries();

    @Query("SELECT DISTINCT l.swot FROM Data l WHERE l.swot IS NOT NULL AND TRIM(l.swot) <> ''")
    List<String> findDistinctSwots();

    @Query("SELECT DISTINCT l.topic FROM Data l WHERE l.topic IS NOT NULL AND TRIM(l.topic) <> ''")
    List<String> findDistinctTopics();

    @Query("SELECT DISTINCT l.region FROM Data l WHERE l.region IS NOT NULL AND TRIM(l.region) <> ''")
    List<String> findDistinctRegions();

    @Query("SELECT DISTINCT l.pestle FROM Data l WHERE l.pestle IS NOT NULL AND TRIM(l.pestle) <> ''")
    List<String> findDistinctPestles();

    @Query("SELECT DISTINCT l.source FROM Data l WHERE l.source IS NOT NULL AND TRIM(l.source) <> ''")
    List<String> findDistinctSources();

    @Query("SELECT DISTINCT l.end_year FROM Data l ")
    List<String> findDistinctEndYears();

    @Query("SELECT DISTINCT l.sector FROM Data l WHERE l.sector IS NOT NULL AND TRIM(l.sector) <> ''")
    List<String> findDistinctSectors();*/

    // **************** Queries For getting counts for City and country from databse*************** 
    @Query("SELECT d.city, COUNT(d.id) FROM Data d GROUP BY d.city")
    List<Object[]> countCities();

    @Query("SELECT d.country, COUNT(d.id) FROM Data d GROUP BY d.country")
    List<Object[]> countCountries();
}
