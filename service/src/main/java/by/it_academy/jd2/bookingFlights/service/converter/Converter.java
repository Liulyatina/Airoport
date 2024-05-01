package by.it_academy.jd2.bookingFlights.service.converter;


import by.it_academy.jd2.bookingFlights.dao.entity.ViewFlightEntity;
import by.it_academy.jd2.bookingFlights.service.api.dto.FlightDTO;
import by.it_academy.jd2.bookingFlights.service.api.IConverter;

public class Converter implements IConverter<ViewFlightEntity, FlightDTO> {
    @Override
    public FlightDTO converter(ViewFlightEntity entity) {
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
