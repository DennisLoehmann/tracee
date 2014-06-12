package de.holisticon.tracee.carbookingsample.model;

import java.util.List;

/**
 * Created by dennis on 06.03.14.
 */
public class VehicleCategory {

    String name;
    List<Vehicle> vehicles;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }
}
