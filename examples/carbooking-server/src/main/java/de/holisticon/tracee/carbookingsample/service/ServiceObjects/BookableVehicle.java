package de.holisticon.tracee.carbookingsample.service.ServiceObjects;

import de.holisticon.tracee.carbookingsample.model.Booking;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by dennis on 06.03.14.
 */
@XmlRootElement
public class BookableVehicle extends Booking {

    private Long id;
    private Booking booking;
    private String vehicleCategory;
    private String vehicleType;
    private String vehicleColour;
    private String vehicleColourHex;
    private String licenseNumber;
    private String availableFrom;
    private String availableTil;
    private String parkingLot;
    private String buttonColumn;
    private String mileage;
    private String registrationDate;
    private String distanceFromUser;
    private boolean booked;

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public String getVehicleCategory() {
        return vehicleCategory;
    }

    public void setVehicleCategory(String vehicleCategory) {
        this.vehicleCategory = vehicleCategory;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getVehicleColour() {
        return vehicleColour;
    }

    public void setVehicleColour(String vehicleColour) {
        this.vehicleColour = vehicleColour;
    }

    public String getVehicleColourHex() {
        return vehicleColourHex;
    }

    public void setVehicleColourHex(String vehicleColourHex) {
        this.vehicleColourHex = vehicleColourHex;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public String getParkingLot() {
        return parkingLot;
    }

    public void setParkingLot(String parkingLot) {
        this.parkingLot = parkingLot;
    }

    public String getButtonColumn() {
        return buttonColumn;
    }

    public void setButtonColumn(String buttonColumn) {
        this.buttonColumn = buttonColumn;
    }

    public boolean isBooked() {
        return booked;
    }

    public void setBooked(boolean booked) {
        this.booked = booked;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAvailableFrom() {
        return availableFrom;
    }

    public void setAvailableFrom(String availableFrom) {
        this.availableFrom = availableFrom;
    }

    public String getAvailableTil() {
        return availableTil;
    }

    public void setAvailableTil(String availableTil) {
        this.availableTil = availableTil;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getMileage() {
        return mileage;
    }

    public void setMileage(String mileage) {
        this.mileage = mileage;
    }

    public String getDistanceFromUser() {
        return distanceFromUser;
    }

    public void setDistanceFromUser(String distanceFromUser) {
        this.distanceFromUser = distanceFromUser;
    }
}
