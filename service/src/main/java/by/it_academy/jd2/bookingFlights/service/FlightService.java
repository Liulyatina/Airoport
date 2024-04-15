package by.it_academy.jd2.bookingFlights.service;


import by.it_academy.jd2.bookingFlights.dao.api.IFlightDao;
import by.it_academy.jd2.bookingFlights.dao.entity.FlightEntity;
import by.it_academy.jd2.bookingFlights.service.api.IFlightService;

import java.util.List;

public class FlightService implements IFlightService {
    private final IFlightDao flightDao;

    public FlightService(IFlightDao flightDao) {
        this.flightDao = flightDao;
    }

    @Override
    public List<FlightEntity> getFlight(long page, long pageSize) {
        return flightDao.getFlight(page, pageSize);
    }
}