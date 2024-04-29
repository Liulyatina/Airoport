package by.it_academy.jd2.bookingFlights.dao.entity;

import jakarta.persistence.*;

import java.awt.*;

@Table(name = "airports_data", schema = "bookings")
@Entity
public class AirportDataEntity {

    @Id
    @Column(name = "airport_code")
    private Integer airportCode;
    @Column(name = "airport_name", columnDefinition = "jsonb")
    private String airportName;
    @Column(columnDefinition = "jsonb")
    private String city;
    private Point coordinates;
    private String timezone;

    public AirportDataEntity() {
    }

    public AirportDataEntity(Integer airportCode, String airportName, String city, Point coordinates, String timezone) {
        this.airportCode = airportCode;
        this.airportName = airportName;
        this.city = city;
        this.coordinates = coordinates;
        this.timezone = timezone;
    }

    public Integer getAirportCode() {
        return airportCode;
    }

    public void setAirportCode(Integer airportCode) {
        this.airportCode = airportCode;
    }

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Point getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Point coordinates) {
        this.coordinates = coordinates;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }
}
