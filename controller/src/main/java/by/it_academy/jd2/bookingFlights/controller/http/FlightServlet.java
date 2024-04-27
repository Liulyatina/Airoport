package by.it_academy.jd2.bookingFlights.controller.http;

import by.it_academy.jd2.bookingFlights.controller.factory.ControllerFactory;
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
import java.util.List;

@WebServlet("/api/flight")
public class FlightServlet extends HttpServlet {

    private static final String ID_PARAM = "id";
    private static final String PAGE_PARAM = "page";
    private static final String SIZE_PARAM = "size";

    private final IFlightService flightService = ServiceFactorySingleton.getFlightService();

    private final ObjectMapper mapper = ControllerFactory.getMapper();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter(ID_PARAM);

        PrintWriter writer = response.getWriter();

        if (id != null && !id.isBlank()) {

            writer.write(mapper.writeValueAsString(flightService.getFlight(Integer.parseInt(id))));

        } else {
            String pageRaw = request.getParameter(PAGE_PARAM);
            String sizeRaw = request.getParameter(SIZE_PARAM);

            Integer page = pageRaw != null ? Integer.parseInt(pageRaw) : null;
            Integer size = sizeRaw != null ? Integer.parseInt(sizeRaw) : null;

            List<FlightDTO> data = flightService.getFlight(page, size);

            writer.write(mapper.writeValueAsString(data));
        }
    }
}