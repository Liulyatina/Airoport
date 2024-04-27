package by.it_academy.jd2.bookingFlights.dao.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.*;
@Table(name = "flights_v", schema = "bookings")
@Entity
public class ViewFlightEntity {
    @Id
    @Column(name = "flight_id")
    private Integer flightId;
    @Column(name = "flight_no")
    private String flightNo;
    @Column(name = "scheduled_departure")
    private OffsetDateTime scheduledDeparture;
    @Column(name = "scheduled_departure_local")
    private LocalDateTime scheduledDepartureLocal;
    @Column(name = "scheduled_arrival")
    private OffsetDateTime scheduledArrival;
    @Column(name = "scheduled_arrival_local")
    private LocalDateTime scheduledArrivalLocal;
    //    @Column(name = "scheduled_duration
//    private  scheduledDuration;
    @Column(name = "departure_airport")
    private String departureAirport;
    @Column(name = "departure_airport_name")
    private String departureAirportName;
    @Column(name = "departure_city")
    private String departureCity;
    @Column(name = "arrival_airport")
    private String arrivalAirport;
    @Column(name = "arrival_airport_name")
    private String arrivalAirportName;
    @Column(name = "arrival_city")
    private String arrivalCity;
    @Column
    private String status;
    @Column(name = "aircraft_code")
    private String aircraftCode;
    @Column(name = "actual_departure")
    private OffsetDateTime actualDeparture;
    @Column(name = "actual_departure_local")
    private LocalDateTime actualDepartureLocal;
    @Column(name = "actual_arrival")
    private OffsetDateTime actualArrival;
    @Column(name = "actual_arrival_local")
    private LocalDateTime actualArrivalLocal;
//    @Column(name = "actual_duration
//    private actual_duration;

    public ViewFlightEntity() {
    }

    public Integer getFlightId() {
        return flightId;
    }

    public void setFlightId(Integer flightId) {
        this.flightId = flightId;
    }

    public String getFlightNo() {
        return flightNo;
    }

    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo;
    }

    public OffsetDateTime getScheduledDeparture() {
        return scheduledDeparture;
    }

    public void setScheduledDeparture(OffsetDateTime scheduledDeparture) {
        this.scheduledDeparture = scheduledDeparture;
    }

    public LocalDateTime getScheduledDepartureLocal() {
        return scheduledDepartureLocal;
    }

    public void setScheduledDepartureLocal(LocalDateTime scheduledDepartureLocal) {
        this.scheduledDepartureLocal = scheduledDepartureLocal;
    }

    public OffsetDateTime getScheduledArrival() {
        return scheduledArrival;
    }

    public void setScheduledArrival(OffsetDateTime scheduledArrival) {
        this.scheduledArrival = scheduledArrival;
    }

    public LocalDateTime getScheduledArrivalLocal() {
        return scheduledArrivalLocal;
    }

    public void setScheduledArrivalLocal(LocalDateTime scheduledArrivalLocal) {
        this.scheduledArrivalLocal = scheduledArrivalLocal;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(String departureAirport) {
        this.departureAirport = departureAirport;
    }

    public String getDepartureAirportName() {
        return departureAirportName;
    }

    public void setDepartureAirportName(String departureAirportName) {
        this.departureAirportName = departureAirportName;
    }

    public String getDepartureCity() {
        return departureCity;
    }

    public void setDepartureCity(String departureCity) {
        this.departureCity = departureCity;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(String arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    public String getArrivalAirportName() {
        return arrivalAirportName;
    }

    public void setArrivalAirportName(String arrivalAirportName) {
        this.arrivalAirportName = arrivalAirportName;
    }

    public String getArrivalCity() {
        return arrivalCity;
    }

    public void setArrivalCity(String arrivalCity) {
        this.arrivalCity = arrivalCity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAircraftCode() {
        return aircraftCode;
    }

    public void setAircraftCode(String aircraftCode) {
        this.aircraftCode = aircraftCode;
    }

    public OffsetDateTime getActualDeparture() {
        return actualDeparture;
    }

    public void setActualDeparture(OffsetDateTime actualDeparture) {
        this.actualDeparture = actualDeparture;
    }

    public LocalDateTime getActualDepartureLocal() {
        return actualDepartureLocal;
    }

    public void setActualDepartureLocal(LocalDateTime actualDepartureLocal) {
        this.actualDepartureLocal = actualDepartureLocal;
    }

    public OffsetDateTime getActualArrival() {
        return actualArrival;
    }

    public void setActualArrival(OffsetDateTime actualArrival) {
        this.actualArrival = actualArrival;
    }

    public LocalDateTime getActualArrivalLocal() {
        return actualArrivalLocal;
    }

    public void setActualArrivalLocal(LocalDateTime actualArrivalLocal) {
        this.actualArrivalLocal = actualArrivalLocal;
    }

    @Override
    public String toString() {
        return "FlightEntity{" +
                "flightId=" + flightId +
                ", flightNo='" + flightNo + '\'' +
                ", scheduledDeparture=" + scheduledDeparture +
                ", scheduledDepartureLocal=" + scheduledDepartureLocal +
                ", scheduledArrival=" + scheduledArrival +
                ", scheduledArrivalLocal=" + scheduledArrivalLocal +
                ", departureAirport='" + departureAirport + '\'' +
                ", departureAirportName='" + departureAirportName + '\'' +
                ", departureCity='" + departureCity + '\'' +
                ", arrivalAirport='" + arrivalAirport + '\'' +
                ", arrivalAirportName='" + arrivalAirportName + '\'' +
                ", arrivalCity='" + arrivalCity + '\'' +
                ", status='" + status + '\'' +
                ", aircraftCode='" + aircraftCode + '\'' +
                ", actualDeparture=" + actualDeparture +
                ", actualDepartureLocal=" + actualDepartureLocal +
                ", actualArrival=" + actualArrival +
                ", actualArrivalLocal=" + actualArrivalLocal +
                '}';
    }
}


