package by.it_academy.jd2.bookingFlights.controller.http;

import by.it_academy.jd2.bookingFlights.controller.factory.ControllerFactory;
import by.it_academy.jd2.bookingFlights.core.dto.FlightFilterDTO;
import by.it_academy.jd2.bookingFlights.service.api.IFlightService;
import by.it_academy.jd2.bookingFlights.service.api.dto.FlightDTO;
import by.it_academy.jd2.bookingFlights.service.factory.ServiceFactorySingleton;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.List;

@WebServlet("/api/filter")
public class FilterServlet extends HttpServlet {
    private static final String DEPARTURE_AIRPORT = "departureAirport";
    private static final String ARRIVAL_AIRPORT = "arrivalAirport";
    private static final String STATUS = "status";
    private static final String DEPARTURE_DATE_FROM = "departureDateFrom";
    private static final String DEPARTURE_DATE_TO = "departureDateTo";
    private static final String ARRIVAL_DATE_FROM = "arrivalDateFrom";
    private static final String ARRIVAL_DATE_TO = "arrivalDateTo";

    private final IFlightService flightService = ServiceFactorySingleton.getFlightService();
    private final ObjectMapper mapper = ControllerFactory.getMapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        try (PrintWriter writer = resp.getWriter()) {
            String departureAirport = req.getParameter(DEPARTURE_AIRPORT);
            String arrivalAirport = req.getParameter(ARRIVAL_AIRPORT);
            String status = req.getParameter(STATUS);

            LocalDateTime departureDateFrom = parseLocalDateTime(req.getParameter(DEPARTURE_DATE_FROM));
            LocalDateTime departureDateTo = parseLocalDateTime(req.getParameter(DEPARTURE_DATE_TO));
            LocalDateTime arrivalDateFrom = parseLocalDateTime(req.getParameter(ARRIVAL_DATE_FROM));
            LocalDateTime arrivalDateTo = parseLocalDateTime(req.getParameter(ARRIVAL_DATE_TO));

            FlightFilterDTO filter = new FlightFilterDTO();
            filter.setDepartureAirport(departureAirport);
            filter.setArrivalAirport(arrivalAirport);
            filter.setStatus(status);
            filter.setDepartureDateFrom(departureDateFrom);
            filter.setDepartureDateTo(departureDateTo);
            filter.setArrivalDateFrom(arrivalDateFrom);
            filter.setArrivalDateTo(arrivalDateTo);

            List<FlightDTO> flights = flightService.getFlight(filter);

            writer.write(mapper.writeValueAsString(flights));
        } catch (Exception e) {
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            e.printStackTrace();
        }
    }

    private LocalDateTime parseLocalDateTime(String dateTimeString) {
        if (dateTimeString != null && !dateTimeString.isEmpty()) {
            return LocalDateTime.parse(dateTimeString);
        }
        return null;
    }
}
