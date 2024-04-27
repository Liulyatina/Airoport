package by.it_academy.jd2.bookingFlights.service.impl;


import by.it_academy.jd2.bookingFlights.core.dto.FlightFilterDTO;
import by.it_academy.jd2.bookingFlights.dao.api.IFlightDao;
import by.it_academy.jd2.bookingFlights.dao.entity.ViewFlightEntity;
import by.it_academy.jd2.bookingFlights.service.api.IFlightService;
import by.it_academy.jd2.bookingFlights.service.api.dto.FlightDTO;

import java.util.List;
import java.util.stream.Collectors;

public class FlightService implements IFlightService {
    private final IFlightDao flightDao;

    public FlightService(IFlightDao flightDao) {
        this.flightDao = flightDao;
    }

    @Override
    public FlightDTO getFlight(int id) {
        return convert(flightDao.getFlight(id).orElseThrow());
    }

    @Override
    public List<FlightDTO> getFlight() {
        return flightDao.getFlight().stream()
                .map(this::convert).
                collect(Collectors.toList());
    }

    @Override
    public List<FlightDTO> getFlight(Integer page, Integer size) {
        return flightDao.getFlight(page, size).stream()
                .map(this::convert).
                collect(Collectors.toList());
    }

    @Override
    public List<FlightDTO> getFlight(FlightFilterDTO filter) {
        return flightDao.getFlight(filter).stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }

    private FlightDTO convert(ViewFlightEntity entity){
        return FlightDTO.builder()
                .flightId(entity.getFlightId())
                .flightNo(entity.getFlightNo())
                .scheduledDeparture(entity.getScheduledDeparture())
                .scheduledDepartureLocal(entity.getScheduledDepartureLocal())
                .scheduledArrival(entity.getScheduledArrival())
                .scheduledArrivalLocal(entity.getScheduledArrivalLocal())
                .departureAirport(entity.getDepartureAirport())
                .departureAirportName(entity.getDepartureAirportName())
                .departureCity(entity.getDepartureCity())
                .arrivalAirport(entity.getArrivalAirport())
                .arrivalAirportName(entity.getArrivalAirportName())
                .arrivalCity(entity.getArrivalCity())
                .status(entity.getStatus())
                .aircraftCode(entity.getAircraftCode())
                .actualDeparture(entity.getActualDeparture())
                .actualDepartureLocal(entity.getActualDepartureLocal())
                .actualArrival(entity.getActualArrival())
                .actualArrivalLocal(entity.getActualArrivalLocal())
                .build();
    }
}