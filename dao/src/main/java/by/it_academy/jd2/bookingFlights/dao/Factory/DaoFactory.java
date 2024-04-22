package by.it_academy.jd2.bookingFlights.dao.Factory;

import by.it_academy.jd2.bookingFlights.dao.impl.FlightDao;
import by.it_academy.jd2.bookingFlights.dao.api.IFlightDao;
import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DaoFactory {

    private final static String DB_URL_ENV_NAME = "AIRPORT_DB_URL";
    private final static String USER_DB_ENV_NAME = "AIRPORT_DB_USER";
    private final static String PASSWORD_DB_ENV_NAME = "AIRPORT_DB_PASSWORD";
    private volatile static IFlightDao flightDao;

    private static DataSource ds;

    static {
        ComboPooledDataSource cpds = new ComboPooledDataSource();

        try {
            cpds.setDriverClass("org.postgresql.Driver");
        } catch (PropertyVetoException e) {
            throw new RuntimeException(e);
        }

        cpds.setJdbcUrl(System.getenv(DB_URL_ENV_NAME));
        cpds.setUser(System.getenv(USER_DB_ENV_NAME));
        cpds.setPassword(System.getenv(PASSWORD_DB_ENV_NAME));

        cpds.setMinPoolSize(5);
        cpds.setAcquireIncrement(5);
        cpds.setMaxPoolSize(20);

        ds = cpds;
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

    public static Connection getConnection() {
        try {
            return ds.getConnection();
        } catch (SQLException e) {
            throw new IllegalStateException("Невозможно подключиться к базе данных", e);
        }
    }
}