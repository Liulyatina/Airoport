package by.it_academy.jd2.bookingFlights.dao.entity;

import jakarta.persistence.*;

import java.util.List;

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
    private Double latitude;
    private Double longitude;
    private String timezone;

    public AirportDataEntity() {
    }

    public AirportDataEntity(Integer airportCode, String airportName, String city, Double latitude, Double longitude, String timezone) {
        this.airportCode = airportCode;
        this.airportName = airportName;
        this.city = city;
        this.latitude = latitude;
        this.longitude = longitude;
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

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }
}
