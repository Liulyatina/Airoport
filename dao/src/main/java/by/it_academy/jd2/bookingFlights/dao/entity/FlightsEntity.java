package by.it_academy.jd2.bookingFlights.dao.entity;

import jakarta.persistence.*;

import java.time.OffsetDateTime;
import java.util.List;

@Table(name = "flights", schema = "bookings")
@Entity
public class FlightsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long flightId;
    @Column(name = "flight_no")
    private String flightNo;
    @Column(name = "scheduled_departure")
    private OffsetDateTime scheduledDeparture;
    @Column(name = "scheduled_arrival")
    private OffsetDateTime scheduledArrival;
    @ManyToOne
    @JoinColumn(name = "departure_airport", referencedColumnName = "airport_code")
    private AirportDataEntity departureAirport;

    @ManyToOne
    @JoinColumn(name = "arrival_airport", referencedColumnName = "airport_code")
    private AirportDataEntity arrivalAirport;
    @Column
    private String status;
    @ManyToOne
    @JoinColumn(name = "aircraft_code", referencedColumnName = "aircraft_code")
    private AircraftsDataEntity aircraftCode;
    @Column(name = "actual_departure")
    private OffsetDateTime actualDeparture;
    @Column(name = "actual_arrival")
    private OffsetDateTime actualArrival;

    @OneToMany(mappedBy = "flightId")
    private List<TicketFlightsEntity> ticketFlights;


    public FlightsEntity() {
    }

    public FlightsEntity(Long flightId, String flightNo, OffsetDateTime scheduledDeparture, OffsetDateTime scheduledArrival,
                         AirportDataEntity departureAirport, AirportDataEntity arrivalAirport, String status, AircraftsDataEntity aircraftCode,
                         OffsetDateTime actualDeparture, OffsetDateTime actualArrival) {
        this.flightId = flightId;
        this.flightNo = flightNo;
        this.scheduledDeparture = scheduledDeparture;
        this.scheduledArrival = scheduledArrival;
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.status = status;
        this.aircraftCode = aircraftCode;
        this.actualDeparture = actualDeparture;
        this.actualArrival = actualArrival;
    }

    public Long getFlightId() {
        return flightId;
    }

    public void setFlightId(Long flightId) {
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

    public OffsetDateTime getScheduledArrival() {
        return scheduledArrival;
    }

    public void setScheduledArrival(OffsetDateTime scheduledArrival) {
        this.scheduledArrival = scheduledArrival;
    }

    public AirportDataEntity getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(AirportDataEntity departureAirport) {
        this.departureAirport = departureAirport;
    }

    public AirportDataEntity getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(AirportDataEntity arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public AircraftsDataEntity getAircraftCode() {
        return aircraftCode;
    }

    public void setAircraftCode(AircraftsDataEntity aircraftCode) {
        this.aircraftCode = aircraftCode;
    }

    public OffsetDateTime getActualDeparture() {
        return actualDeparture;
    }

    public void setActualDeparture(OffsetDateTime actualDeparture) {
        this.actualDeparture = actualDeparture;
    }

    public OffsetDateTime getActualArrival() {
        return actualArrival;
    }

    public void setActualArrival(OffsetDateTime actualArrival) {
        this.actualArrival = actualArrival;
    }
}
