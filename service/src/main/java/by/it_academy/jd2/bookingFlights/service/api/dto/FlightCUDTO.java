package by.it_academy.jd2.bookingFlights.service.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class FlightCUDTO {
    private long page;
    private long pageSize;
}
