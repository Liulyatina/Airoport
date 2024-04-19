package by.it_academy.jd2.bookingFlights.controller.factory;

import by.it_academy.jd2.bookingFlights.controller.utils.LocalDateTimeSerializer;
import by.it_academy.jd2.bookingFlights.controller.utils.OffsetDateTimeSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

public class ControllerFactory {

    private final static ObjectMapper mapper = new ObjectMapper();

    static {

        mapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);

        SimpleModule module = new SimpleModule();
        module.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer());
        module.addSerializer(OffsetDateTime.class, new OffsetDateTimeSerializer());

        mapper.registerModule(module);
    }

    public static ObjectMapper getMapper() {
        return mapper;
    }
}
