package by.it_academy.jd2.bookingFlights.service.api;

public interface IConverter<FROM, TO> {
    TO converter(FROM item);
}
