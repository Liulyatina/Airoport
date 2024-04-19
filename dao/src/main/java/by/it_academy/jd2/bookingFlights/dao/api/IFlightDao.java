package by.it_academy.jd2.bookingFlights.dao.api;

import by.it_academy.jd2.bookingFlights.core.dto.FlightFilterDTO;
import by.it_academy.jd2.bookingFlights.dao.entity.FlightEntity;

import java.util.List;
import java.util.Optional;

public interface IFlightDao {
    Optional<FlightEntity> getFlight(int id);
    List<FlightEntity> getFlight();
    List<FlightEntity> getFlight(Integer page, Integer size);
    List<FlightEntity> getFlight(FlightFilterDTO filter);
}
