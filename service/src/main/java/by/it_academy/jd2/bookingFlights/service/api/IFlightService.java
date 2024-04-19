package by.it_academy.jd2.bookingFlights.service.api;

import by.it_academy.jd2.bookingFlights.core.dto.FlightFilterDTO;
import by.it_academy.jd2.bookingFlights.service.api.dto.FlightDTO;

import java.util.List;

public interface IFlightService {

    FlightDTO getFlight(int id);
    List<FlightDTO> getFlight();
    List<FlightDTO> getFlight(Integer page, Integer size);

    List<FlightDTO> getFlight(FlightFilterDTO filter);

}
