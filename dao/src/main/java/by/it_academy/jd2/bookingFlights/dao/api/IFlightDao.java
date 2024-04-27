package by.it_academy.jd2.bookingFlights.dao.api;

import by.it_academy.jd2.bookingFlights.core.dto.FlightFilterDTO;
import by.it_academy.jd2.bookingFlights.dao.entity.ViewFlightEntity;

import java.util.List;
import java.util.Optional;

public interface IFlightDao {
    Optional<ViewFlightEntity> getFlight(int id);
    List<ViewFlightEntity> getFlight();
    List<ViewFlightEntity> getFlight(Integer page, Integer size);
    List<ViewFlightEntity> getFlight(FlightFilterDTO filter);
}
