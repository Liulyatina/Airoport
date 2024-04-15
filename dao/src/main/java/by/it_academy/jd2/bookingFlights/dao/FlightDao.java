package by.it_academy.jd2.bookingFlights.dao;

import by.it_academy.jd2.bookingFlights.dao.Factory.DaoFactory;
import by.it_academy.jd2.bookingFlights.dao.api.IFlightDao;
import by.it_academy.jd2.bookingFlights.dao.entity.FlightEntity;
import org.postgresql.util.PGInterval;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Duration;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class FlightDao implements IFlightDao {

    private final static String GET_LIST = "SELECT * FROM flights_v LIMIT ? OFFSET ?";

    @Override
    public List<FlightEntity> getFlight(long page, long pageSize) {
        List<FlightEntity> flights = new ArrayList<>();
        long offset = (page - 1) * pageSize;
        try (Connection conn = DaoFactory.getConnection();
             PreparedStatement st = conn.prepareStatement(GET_LIST);
        ) {
            st.setLong(1, pageSize);
            st.setLong(2, offset);

            try (ResultSet rs = st.executeQuery();) {
                while (rs.next()) {
                    Duration scheduledDuration = null;
                    PGInterval scheduledInterval = (PGInterval) rs.getObject("scheduled_duration");
                    if (scheduledInterval != null) {
                        long millis = (long) (scheduledInterval.getSeconds() * 1000);
                        scheduledDuration = Duration.ofMillis(millis);
                    }

                    Duration actualDuration = null;
                    long actualDurationSeconds = rs.getLong("actual_duration");
                    if (actualDurationSeconds != 0) {
                        actualDuration = Duration.ofSeconds(actualDurationSeconds);
                    }

                    FlightEntity flight = new FlightEntity(
                            rs.getLong("flight_id"),
                            rs.getString("flight_no"),
                            rs.getTimestamp("scheduled_departure").toInstant().atZone(ZoneId.systemDefault()),
                            rs.getTimestamp("scheduled_arrival").toInstant().atZone(ZoneId.systemDefault()),
                            rs.getString("departure_airport"),
                            rs.getString("departure_airport_name"),
                            rs.getString("departure_city"),
                            rs.getString("arrival_airport"),
                            rs.getString("arrival_airport_name"),
                            rs.getString("arrival_city"),
                            rs.getString("status"),
                            rs.getTimestamp("actual_departure") != null ? rs.getTimestamp("actual_departure").toInstant().atZone(ZoneId.systemDefault()) : null,
                            rs.getTimestamp("actual_arrival") != null ? rs.getTimestamp("actual_arrival").toInstant().atZone(ZoneId.systemDefault()) : null,
                            scheduledDuration,
                            actualDuration
                    );
                    flights.add(flight);
                }
            }
        } catch (SQLException e) {
            throw new IllegalStateException("Ошибка выполнения запроса к БД", e);
        }

        return flights;
    }
}
