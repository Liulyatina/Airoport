package by.it_academy.jd2.bookingFlights.core.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FlightFilterDTO {

    private String departureAirport;
    private String arrivalAirport;
    private String status;
    private LocalDateTime departureDateFrom;
    private LocalDateTime departureDateTo;
    private LocalDateTime arrivalDateFrom;
    private LocalDateTime arrivalDateTo;

}
