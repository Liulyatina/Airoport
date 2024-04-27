package by.it_academy.jd2.bookingFlights.service.factory;

import by.it_academy.jd2.bookingFlights.dao.factory.DaoFactory;
import by.it_academy.jd2.bookingFlights.service.impl.FlightService;
import by.it_academy.jd2.bookingFlights.service.api.IFlightService;

public class ServiceFactorySingleton {

    private volatile static IFlightService flightService;

    public static IFlightService getFlightService(){
        if(flightService == null){
            synchronized (ServiceFactorySingleton.class){
                if(flightService == null){
                    flightService = new FlightService(DaoFactory.getFlightDao());
                }
            }
        }
        return flightService;
    }
}

