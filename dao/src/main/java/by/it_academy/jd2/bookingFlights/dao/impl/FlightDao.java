package by.it_academy.jd2.bookingFlights.dao.impl;

import by.it_academy.jd2.bookingFlights.core.dto.FlightFilterDTO;
import by.it_academy.jd2.bookingFlights.dao.factory.DaoFactory;
import by.it_academy.jd2.bookingFlights.dao.api.IFlightDao;
import by.it_academy.jd2.bookingFlights.dao.entity.ViewFlightEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class FlightDao implements IFlightDao {

    private final static String GET_BY_ID = "SELECT\n" +
            "    flight_id,\n" +
            "    flight_no,\n" +
            "    scheduled_departure,\n" +
            "    scheduled_departure_local,\n" +
            "    scheduled_arrival,\n" +
            "    scheduled_arrival_local,\n" +
            "    scheduled_duration,\n" +
            "    departure_airport,\n" +
            "    departure_airport_name,\n" +
            "    departure_city,\n" +
            "    arrival_airport,\n" +
            "    arrival_airport_name,\n" +
            "    arrival_city,\n" +
            "    status,\n" +
            "    aircraft_code,\n" +
            "    actual_departure,\n" +
            "    actual_departure_local,\n" +
            "    actual_arrival,\n" +
            "    actual_arrival_local,\n" +
            "    actual_duration\n" +
            "FROM\n" +
            "    bookings.flights_v\n" +
            "WHERE flight_id = ?;\n";

    private final static String GET_ALL = "SELECT\n" +
            "    flight_id,\n" +
            "    flight_no,\n" +
            "    scheduled_departure,\n" +
            "    scheduled_departure_local,\n" +
            "    scheduled_arrival,\n" +
            "    scheduled_arrival_local,\n" +
            "    scheduled_duration,\n" +
            "    departure_airport,\n" +
            "    departure_airport_name,\n" +
            "    departure_city,\n" +
            "    arrival_airport,\n" +
            "    arrival_airport_name,\n" +
            "    arrival_city,\n" +
            "    status,\n" +
            "    aircraft_code,\n" +
            "    actual_departure,\n" +
            "    actual_departure_local,\n" +
            "    actual_arrival,\n" +
            "    actual_arrival_local,\n" +
            "    actual_duration\n" +
            "FROM\n" +
            "    bookings.flights_v;\n";

    private final static String GET_PAGE = "SELECT\n" +
            "    flight_id,\n" +
            "    flight_no,\n" +
            "    scheduled_departure,\n" +
            "    scheduled_departure_local,\n" +
            "    scheduled_arrival,\n" +
            "    scheduled_arrival_local,\n" +
            "    scheduled_duration,\n" +
            "    departure_airport,\n" +
            "    departure_airport_name,\n" +
            "    departure_city,\n" +
            "    arrival_airport,\n" +
            "    arrival_airport_name,\n" +
            "    arrival_city,\n" +
            "    status,\n" +
            "    aircraft_code,\n" +
            "    actual_departure,\n" +
            "    actual_departure_local,\n" +
            "    actual_arrival,\n" +
            "    actual_arrival_local,\n" +
            "    actual_duration\n" +
            "FROM\n" +
            "    bookings.flights_v\n" +
            "ORDER BY scheduled_departure\n" +
            "LIMIT ? OFFSET ?;\n";

    private final static String GET_FILTER_PAGE = "SELECT *\n" +
            "FROM bookings.flights_v\n" +
            "WHERE \n" +
            "    (departure_airport = COALESCE(?, null)) AND\n" +
            "    (arrival_airport = COALESCE(?, null)) AND\n" +
            "    (status = COALESCE(?, null)) AND\n" +
            "    (scheduled_departure >= COALESCE(?, null)) AND\n" +
            "    (scheduled_departure <= COALESCE(?, null)) AND\n" +
            "    (scheduled_arrival >= COALESCE(?, null)) AND\n" +
            "    (scheduled_arrival <= COALESCE(?, null));";

    @Override
    public Optional<ViewFlightEntity> getFlight(int id) {
        try (Connection conn = DaoFactory.getConnection();
             PreparedStatement st = conn.prepareStatement(GET_BY_ID)) {
            st.setInt(1, id);
            try (ResultSet rs = st.executeQuery()) {
                while (rs.next()) {
                    return Optional.of(read(rs));
                }
                return Optional.empty();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<ViewFlightEntity> getFlight() {
        try (Connection conn = DaoFactory.getConnection();
             PreparedStatement st = conn.prepareStatement(GET_ALL);
             ResultSet rs = st.executeQuery()) {
            List<ViewFlightEntity> data = new ArrayList<>();
            while (rs.next()) {
                data.add(read(rs));
            }
            return data;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<ViewFlightEntity> getFlight(Integer page, Integer size) {
        try (Connection conn = DaoFactory.getConnection();
             PreparedStatement st = conn.prepareStatement(GET_PAGE)) {

            st.setLong(1, size);
            st.setLong(2, (page - 1L) * size);

            try (ResultSet rs = st.executeQuery()) {
                List<ViewFlightEntity> data = new ArrayList<>();
                while (rs.next()) {
                    data.add(read(rs));
                }
                return data;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<ViewFlightEntity> getFlight(FlightFilterDTO filter) {
        try (Connection conn = DaoFactory.getConnection();
             PreparedStatement st = conn.prepareStatement(GET_FILTER_PAGE)) {

            st.setObject(1, filter.getDepartureAirport());

            st.setObject(2, filter.getArrivalAirport());

            st.setObject(3, filter.getStatus());

            st.setObject(4, filter.getDepartureDateFrom());

            st.setObject(5, filter.getDepartureDateTo());

            st.setObject(6, filter.getArrivalDateFrom());

            st.setObject(7, filter.getArrivalDateTo());


            try (ResultSet rs = st.executeQuery()) {
                List<ViewFlightEntity> data = new ArrayList<>();
                while (rs.next()) {
                    data.add(read(rs));
                }
                return data;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    private ViewFlightEntity read(ResultSet rs) throws SQLException {
        ViewFlightEntity entity = new ViewFlightEntity();
        entity.setFlightId(rs.getInt("flight_id"));
        entity.setFlightNo(rs.getString("flight_no"));
        entity.setScheduledDeparture(rs.getObject("scheduled_departure", OffsetDateTime.class));
        entity.setScheduledDepartureLocal(rs.getObject("scheduled_departure_local", LocalDateTime.class));
        entity.setScheduledArrival(rs.getObject("scheduled_arrival", OffsetDateTime.class));
        entity.setScheduledArrivalLocal(rs.getObject("scheduled_arrival_local", LocalDateTime.class));
        entity.setDepartureAirport(rs.getString("departure_airport"));
        entity.setDepartureAirportName(rs.getString("departure_airport_name"));
        entity.setDepartureCity(rs.getString("departure_city"));
        entity.setArrivalAirport(rs.getString("arrival_airport"));
        entity.setArrivalAirportName(rs.getString("arrival_airport_name"));
        entity.setArrivalCity(rs.getString("arrival_city"));
        entity.setStatus(rs.getString("status"));
        entity.setAircraftCode(rs.getString("aircraft_code"));
        entity.setActualDeparture(rs.getObject("actual_departure", OffsetDateTime.class));
        entity.setActualDepartureLocal(rs.getObject("actual_departure_local", LocalDateTime.class));
        entity.setActualArrival(rs.getObject("actual_arrival", OffsetDateTime.class));
        entity.setActualArrivalLocal(rs.getObject("actual_arrival_local", LocalDateTime.class));
        return entity;
    }
}
