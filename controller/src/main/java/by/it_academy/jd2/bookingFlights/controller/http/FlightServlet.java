package by.it_academy.jd2.bookingFlights.controller.http;

import by.it_academy.jd2.bookingFlights.controller.factory.ControllerFactory;
import by.it_academy.jd2.bookingFlights.dao.entity.FlightEntity;
import by.it_academy.jd2.bookingFlights.service.api.IFlightService;
import by.it_academy.jd2.bookingFlights.service.api.dto.FlightCUDTO;
import by.it_academy.jd2.bookingFlights.service.serviceFactory.ServiceFactorySingleton;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/api/flights")
public class FlightServlet extends HttpServlet {

    private final IFlightService flightService = ServiceFactorySingleton.getFlightService();

    private final ObjectMapper mapper = ControllerFactory.getMapper();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FlightCUDTO pageRequest = mapper.readValue(request.getInputStream(), FlightCUDTO.class);

        long page = pageRequest.getPage();
        long pageSize = pageRequest.getPageSize();

        if (page < 0 || pageSize < 0) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().write("Page and page size must be positive numbers.");
            return;
        }

        List<FlightEntity> flights = flightService.getFlight(page, pageSize);

        for (FlightEntity flight : flights) {
            response.getWriter().write(flight.toString() + "\n");
        }
    }
}
