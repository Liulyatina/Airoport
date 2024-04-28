package by.it_academy.jd2.bookingFlights.dao.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;

@Table(name = "ticket_flights", schema = "bookings")
@Entity
public class TicketFlightsEntity {

    @Id
    @Column(name = "ticket_no")
    private Integer ticketNo;
    @Id
    @Column(name = "flight_id")
    private Integer flightId;
    @Column(name = "fare_conditions")
    private String fareConditions;
    @Column(precision = 10, scale = 2)
    private BigDecimal amount;

    public TicketFlightsEntity() {
    }

    public TicketFlightsEntity(Integer ticketNo, Integer flightId, String fareConditions, BigDecimal amount) {
        this.ticketNo = ticketNo;
        this.flightId = flightId;
        this.fareConditions = fareConditions;
        this.amount = amount;
    }

    public Integer getTicketNo() {
        return ticketNo;
    }

    public void setTicketNo(Integer ticketNo) {
        this.ticketNo = ticketNo;
    }

    public Integer getFlightId() {
        return flightId;
    }

    public void setFlightId(Integer flightId) {
        this.flightId = flightId;
    }

    public String getFareConditions() {
        return fareConditions;
    }

    public void setFareConditions(String fareConditions) {
        this.fareConditions = fareConditions;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
