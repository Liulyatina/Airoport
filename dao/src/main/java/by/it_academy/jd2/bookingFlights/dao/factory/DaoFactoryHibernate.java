package by.it_academy.jd2.bookingFlights.dao.factory;

import by.it_academy.jd2.bookingFlights.dao.api.IFlightDao;
import by.it_academy.jd2.bookingFlights.dao.impl.FlightDaoHibernateImpl;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class DaoFactoryHibernate {
    private volatile static IFlightDao flightDao;
    private static EntityManagerFactory entityManagerFactory;

    static {
        entityManagerFactory = Persistence.createEntityManagerFactory("jpa-entity-definition");
    }

    public static IFlightDao getFlightDao() {
        if (flightDao == null) {
            synchronized (DaoFactory.class) {
                if (flightDao == null) {
                    flightDao = new FlightDaoHibernateImpl();
                }
            }
        }
        return flightDao;
    }

    public static EntityManager getEntityManager(){
        return entityManagerFactory.createEntityManager();
    }
}
