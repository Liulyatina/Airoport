package by.it_academy.jd2.bookingFlights.dao.entity;

import jakarta.persistence.*;

import java.util.List;

@Table(name = "aircrafts_data", schema = "bookings")
@Entity
public class AircraftsDataEntity {

    @Id
    @Column(name = "aircraft_code")
    private Integer aircraftCode;
    @Column(columnDefinition = "jsonb")
    private String model;
    private Integer range;

    public AircraftsDataEntity() {
    }
    public AircraftsDataEntity(Integer aircraftCode, String model, Integer range) {
        this.aircraftCode = aircraftCode;
        this.model = model;
        this.range = range;
    }

    public Integer getAircraftCode() {
        return aircraftCode;
    }

    public void setAircraftCode(Integer aircraftCode) {
        this.aircraftCode = aircraftCode;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getRange() {
        return range;
    }

    public void setRange(Integer range) {
        this.range = range;
    }
}
