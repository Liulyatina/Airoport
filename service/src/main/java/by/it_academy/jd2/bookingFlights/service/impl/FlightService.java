package by.it_academy.jd2.bookingFlights.service.impl;


import by.it_academy.jd2.bookingFlights.core.dto.FlightFilterDTO;
import by.it_academy.jd2.bookingFlights.dao.api.IFlightDao;
import by.it_academy.jd2.bookingFlights.dao.entity.ViewFlightEntity;
import by.it_academy.jd2.bookingFlights.service.api.IConverter;
import by.it_academy.jd2.bookingFlights.service.api.IFlightService;
import by.it_academy.jd2.bookingFlights.service.api.dto.FlightDTO;


import java.util.List;
import java.util.stream.Collectors;


public class FlightService implements IFlightService {
    private final IFlightDao flightDao;
    private final IConverter<ViewFlightEntity, FlightDTO> convert;

    public FlightService(IFlightDao flightDao, IConverter<ViewFlightEntity, FlightDTO> converter) {
        this.flightDao = flightDao;
        this.convert = converter;
    }

    @Override
    public FlightDTO getFlight(int id) {
        return convert.converter(flightDao.getFlight(id).orElseThrow());
    }

    @Override
    public List<FlightDTO> getFlight() {
        return flightDao.getFlight().stream()
                .map(convert::converter)
                .collect(Collectors.toList());
    }

    @Override
    public List<FlightDTO> getFlight(Integer page, Integer size) {
        return flightDao.getFlight(page, size).stream()
                .map(convert::converter)
                .collect(Collectors.toList());
    }

    @Override
    public List<FlightDTO> getFlight(FlightFilterDTO filter) {
        return flightDao.getFlight(filter).stream()
                .map(convert::converter)
                .collect(Collectors.toList());
    }
}
