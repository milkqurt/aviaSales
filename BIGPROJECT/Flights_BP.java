package BIGPROJECT;

import java.io.Serializable;

public class Flights_BP implements Serializable {
    Long id;
    Long aircraft_id;
    Long departure_city_id;
    Long arrival_city_id;
    String departure_time;
    int econom_place_price;
    int business_place_price;

    String aircraft_name;
    String departure_city_name;
    String arrival_city_name;

    public Flights_BP() {
    }

    public Flights_BP(Long id, Long aircraft_id, Long departure_city_id, Long arrival_city_id, String departure_time, int econom_place_price, int business_place_price, String aircraft_name, String departure_city_name, String arrival_city_name) {
        this.id = id;
        this.aircraft_id = aircraft_id;
        this.departure_city_id = departure_city_id;
        this.arrival_city_id = arrival_city_id;
        this.departure_time = departure_time;
        this.econom_place_price = econom_place_price;
        this.business_place_price = business_place_price;
        this.aircraft_name = aircraft_name;
        this.departure_city_name = departure_city_name;
        this.arrival_city_name = arrival_city_name;
    }

    public Flights_BP(Long id, Long aircraft_id, Long departure_city_id, Long arrival_city_id, String departure_time, int econom_place_price, int business_place_price) {
        this.id = id;
        this.aircraft_id = aircraft_id;
        this.departure_city_id = departure_city_id;
        this.arrival_city_id = arrival_city_id;
        this.departure_time = departure_time;
        this.econom_place_price = econom_place_price;
        this.business_place_price = business_place_price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAircraft_id() {
        return aircraft_id;
    }

    public void setAircraft_id(Long aircraft_id) {
        this.aircraft_id = aircraft_id;
    }

    public Long getDeparture_city_id() {
        return departure_city_id;
    }

    public void setDeparture_city_id(Long departure_city_id) {
        this.departure_city_id = departure_city_id;
    }

    public Long getArrival_city_id() {
        return arrival_city_id;
    }

    public void setArrival_city_id(Long arrival_city_id) {
        this.arrival_city_id = arrival_city_id;
    }

    public String getDeparture_time() {
        return departure_time;
    }

    public void setDeparture_time(String departure_time) {
        this.departure_time = departure_time;
    }

    public int getEconom_place_price() {
        return econom_place_price;
    }

    public void setEconom_place_price(int econom_place_price) {
        this.econom_place_price = econom_place_price;
    }

    public int getBusiness_place_price() {
        return business_place_price;
    }

    public void setBusiness_place_price(int business_place_price) {
        this.business_place_price = business_place_price;
    }

    public String getAircraft_name() {
        return aircraft_name;
    }

    public void setAircraft_name(String aircraft_name) {
        this.aircraft_name = aircraft_name;
    }

    public String getDeparture_city_name() {
        return departure_city_name;
    }

    public void setDeparture_city_name(String departure_city_name) {
        this.departure_city_name = departure_city_name;
    }

    public String getArrival_city_name() {
        return arrival_city_name;
    }

    public void setArrival_city_name(String arrival_city_name) {
        this.arrival_city_name = arrival_city_name;
    }
}
