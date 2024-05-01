package by.it_academy.jd2.bookingFlights.controller.factory;

import by.it_academy.jd2.bookingFlights.controller.utils.LocalDateTimeSerializer;
import by.it_academy.jd2.bookingFlights.controller.utils.OffsetDateTimeSerializer;
import by.it_academy.jd2.bookingFlights.service.api.IFlightService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

public class AppFactory {

    private static final ApplicationContext context;


    private final static ObjectMapper mapper = new ObjectMapper();

    static {

        context = new ClassPathXmlApplicationContext("application-context.xml");


        mapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);

        SimpleModule module = new SimpleModule();
        module.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer());
        module.addSerializer(OffsetDateTime.class, new OffsetDateTimeSerializer());

        mapper.registerModule(module);
    }

    public static ObjectMapper getMapper() {
        return mapper;
    }

    public static IFlightService getFlightService() {
        return context.getBean(IFlightService.class);
    }
}
