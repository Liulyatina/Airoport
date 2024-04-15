package by.it_academy.jd2.bookingFlights.service.api.dto;

import lombok.Builder;
import lombok.Getter;

import java.sql.Timestamp;
import java.time.Duration;

@Builder
@Getter
public class FlightDTO {
    private int flightId;
    private String flightNo;
    private Timestamp scheduledDeparture;
    private Timestamp scheduledArrival;
    private String departureAirport;
    private String departureAirportName;
    private String departureCity;
    private String arrivalAirport;
    private String arrivalAirportName;
    private String arrivalCity;
    private String status;
    private Timestamp actualDeparture;
    private Timestamp actualArrival;
    private Duration scheduledDuration;
    private Duration actualDuration;
}

