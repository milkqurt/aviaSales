package BIGPROJECT;

import java.io.Serializable;

public class PackageData_BP implements Serializable {
    String operationType;
    Aircrafts_BP aircrafts_bp;
    Cities_BP cities_bp;
    Flights_BP flights_bp;
    Tickets_BP tickets_bp;

    public PackageData_BP() {
    }

    public PackageData_BP(String operationType, Aircrafts_BP aircrafts_bp) {
        this.operationType = operationType;
        this.aircrafts_bp = aircrafts_bp;
    }

    public PackageData_BP(String operationType, Cities_BP cities_bp) {
        this.operationType = operationType;
        this.cities_bp = cities_bp;
    }

    public PackageData_BP(String operationType, Flights_BP flights_bp) {
        this.operationType = operationType;
        this.flights_bp = flights_bp;
    }

    public PackageData_BP(String operationType, Tickets_BP tickets_bp) {
        this.operationType = operationType;
        this.tickets_bp = tickets_bp;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public Aircrafts_BP getAircrafts_bp() {
        return aircrafts_bp;
    }

    public void setAircrafts_bp(Aircrafts_BP aircrafts_bp) {
        this.aircrafts_bp = aircrafts_bp;
    }

    public Cities_BP getCities_bp() {
        return cities_bp;
    }

    public void setCities_bp(Cities_BP cities_bp) {
        this.cities_bp = cities_bp;
    }

    public Flights_BP getFlights_bp() {
        return flights_bp;
    }

    public void setFlights_bp(Flights_BP flights_bp) {
        this.flights_bp = flights_bp;
    }

    public Tickets_BP getTickets_bp() {
        return tickets_bp;
    }

    public void setTickets_bp(Tickets_BP tickets_bp) {
        this.tickets_bp = tickets_bp;
    }
}
