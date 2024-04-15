package by.it_academy.jd2.bookingFlights.dao.api;

import by.it_academy.jd2.bookingFlights.dao.entity.FlightEntity;

import java.util.List;

public interface IFlightDao {
    List<FlightEntity> getFlight(long page, long pageSize);
}
