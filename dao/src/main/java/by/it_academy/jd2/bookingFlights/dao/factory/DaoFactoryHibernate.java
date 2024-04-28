package by.it_academy.jd2.bookingFlights.dao.factory;

import by.it_academy.jd2.bookingFlights.dao.api.IFlightDao;
import by.it_academy.jd2.bookingFlights.dao.impl.FlightDaoHibernateImpl;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

public class DaoFactoryHibernate {

    private final static String DB_URL_ENV_NAME = "AIRPORT_DB_URL";
    private final static String USER_DB_ENV_NAME = "AIRPORT_DB_USER";
    private final static String PASSWORD_DB_ENV_NAME = "AIRPORT_DB_PASSWORD";
    private volatile static IFlightDao flightDao;

    private static final DataSource ds;

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

    private static final EntityManagerFactory entityManagerFactory;

    static {
        entityManagerFactory = Persistence.createEntityManagerFactory("jpa-entity-definition");
    }

    public static IFlightDao getFlightDao() {
        if (flightDao == null) {
            synchronized (DaoFactoryHibernate.class) {
                if (flightDao == null) {
                    flightDao = new FlightDaoHibernateImpl();
                }
            }
        }
        return flightDao;
    }

    public static EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }
}
