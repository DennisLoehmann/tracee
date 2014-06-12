package de.holisticon.tracee.carbookingsample.model;

import java.util.Date;
import java.util.Map;

/**
 * Created by dennis on 06.03.14.
 */
public class Vehicle {

    VehicleCategory category;
    String type;
    VehicleColour colour;
    String licenseNumber;
    Location parkingLot;
    Map<Date, Booking> bookings;
    Map<Date, Booking> availableSlots;
    Map<Date, String> remarks;
    Long mileage;
    Date registrationDate;


    public VehicleCategory getCategory() {
        return category;
    }

    public void setCategory(VehicleCategory category) {
        this.category = category;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public VehicleColour getColour() {
        return colour;
    }

    public void setColour(VehicleColour colour) {
        this.colour = colour;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }


    public Location getParkingLot() {
        return parkingLot;
    }

    public void setParkingLot(Location parkingLot) {
        this.parkingLot = parkingLot;
    }

    public Map<Date, Booking> getBookings() {
        return bookings;
    }

    public void setBookings(Map<Date, Booking> bookings) {
        this.bookings = bookings;
    }

    public Map<Date, String> getRemarks() {
        return remarks;
    }

    public void setRemarks(Map<Date, String> remarks) {
        this.remarks = remarks;
    }

    public Long getMileage() {
        return mileage;
    }

    public void setMileage(Long mileage) {
        this.mileage = mileage;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }
}
