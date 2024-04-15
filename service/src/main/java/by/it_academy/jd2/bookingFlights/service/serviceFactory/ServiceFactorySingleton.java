package by.it_academy.jd2.bookingFlights.service.serviceFactory;

import by.it_academy.jd2.bookingFlights.dao.Factory.DaoFactory;
import by.it_academy.jd2.bookingFlights.service.FlightService;
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

