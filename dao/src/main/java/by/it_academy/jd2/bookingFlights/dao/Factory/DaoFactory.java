package by.it_academy.jd2.bookingFlights.dao.Factory;

import by.it_academy.jd2.bookingFlights.dao.impl.FlightDao;
import by.it_academy.jd2.bookingFlights.dao.api.IFlightDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DaoFactory {
    private volatile static IFlightDao flightDao;

    private static final String url = "jdbc:postgresql://83.166.237.101:15432/demo";

    private static final Properties props = new Properties();

    static {
        props.setProperty("user", "airport_app");
        props.setProperty("password", "1234");

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static IFlightDao getFlightDao() {
        if (flightDao == null) {
            synchronized (DaoFactory.class) {
                if (flightDao == null) {
                    flightDao = new FlightDao();
                }
            }
        }
        return flightDao;
    }

    public static Connection getConnection(){
        try {
            return DriverManager.getConnection(url, props);
        } catch (SQLException e){
            throw new IllegalStateException("Невозможно подключиться к базе данных", e);
        }
    }
}
