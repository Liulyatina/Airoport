package by.it_academy.jd2.bookingFlights.service.api;

import by.it_academy.jd2.bookingFlights.dao.entity.FlightEntity;

import java.util.List;

public interface IFlightService {
    List<FlightEntity> getFlight(long pageNumber, long pageSize);
}
