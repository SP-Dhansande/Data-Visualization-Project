package com.api.data_visualization_dashboard.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Data {

    @Id
    private int id;
    private int end_year;
    private String citylng;
    private String citylat;
    private int intensity;
    private String sector;
    private String topic;
    private String insight;
    private String swot;
    private String url;
    private String region;
    private String start_year;
    private String impact;
    private String added;
    private String published;
    private String city;
    private String country;
    private int relevance;
    private String pestle;
    private String source;
    private String title;
    private int likelihood;

    
    public Data() {
    }

    
    public Data(int id, int end_year, String citylng, String citylat, int intensity, String sector, String topic,
            String insight, String swot, String url, String region, String start_year, String impact, String added,
            String published, String city, String country, int relevance, String pestle, String source, String title,
            int likelihood) {
        this.id = id;
        this.end_year = end_year;
        this.citylng = citylng;
        this.citylat = citylat;
        this.intensity = intensity;
        this.sector = sector;
        this.topic = topic;
        this.insight = insight;
        this.swot = swot;
        this.url = url;
        this.region = region;
        this.start_year = start_year;
        this.impact = impact;
        this.added = added;
        this.published = published;
        this.city = city;
        this.country = country;
        this.relevance = relevance;
        this.pestle = pestle;
        this.source = source;
        this.title = title;
        this.likelihood = likelihood;
    }


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getEnd_year() {
        return end_year;
    }
    public void setEnd_year(int end_year) {
        this.end_year = end_year;
    }
    public String getCitylng() {
        return citylng;
    }
    public void setCitylng(String citylng) {
        this.citylng = citylng;
    }
    public String getCitylat() {
        return citylat;
    }
    public void setCitylat(String citylat) {
        this.citylat = citylat;
    }
    public int getIntensity() {
        return intensity;
    }
    public void setIntensity(int intensity) {
        this.intensity = intensity;
    }
    public String getSector() {
        return sector;
    }
    public void setSector(String sector) {
        this.sector = sector;
    }
    public String getTopic() {
        return topic;
    }
    public void setTopic(String topic) {
        this.topic = topic;
    }
    public String getInsight() {
        return insight;
    }
    public void setInsight(String insight) {
        this.insight = insight;
    }
    public String getSwot() {
        return swot;
    }
    public void setSwot(String swot) {
        this.swot = swot;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getRegion() {
        return region;
    }
    public void setRegion(String region) {
        this.region = region;
    }
    public String getStart_year() {
        return start_year;
    }
    public void setStart_year(String start_year) {
        this.start_year = start_year;
    }
    public String getImpact() {
        return impact;
    }
    public void setImpact(String impact) {
        this.impact = impact;
    }
    public String getAdded() {
        return added;
    }
    public void setAdded(String added) {
        this.added = added;
    }
    public String getPublished() {
        return published;
    }
    public void setPublished(String published) {
        this.published = published;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public int getRelevance() {
        return relevance;
    }
    public void setRelevance(int relevance) {
        this.relevance = relevance;
    }
    public String getPestle() {
        return pestle;
    }
    public void setPestle(String pestle) {
        this.pestle = pestle;
    }
    public String getSource() {
        return source;
    }
    public void setSource(String source) {
        this.source = source;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public int getLikelihood() {
        return likelihood;
    }
    public void setLikelihood(int likelihood) {
        this.likelihood = likelihood;
    }


    @Override
    public String toString() {
        return "Data [id=" + id + ", end_year=" + end_year + ", citylng=" + citylng + ", citylat=" + citylat
                + ", intensity=" + intensity + ", sector=" + sector + ", topic=" + topic + ", insight=" + insight
                + ", swot=" + swot + ", url=" + url + ", region=" + region + ", start_year=" + start_year + ", impact="
                + impact + ", added=" + added + ", published=" + published + ", city=" + city + ", country=" + country
                + ", relevance=" + relevance + ", pestle=" + pestle + ", source=" + source + ", title=" + title
                + ", likelihood=" + likelihood + "]";
    }

   
}
