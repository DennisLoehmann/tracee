package de.holisticon.tracee.carbookingsample.service.ServiceObjects;

import de.holisticon.tracee.carbookingsample.model.Booking;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by dennis on 06.03.14.
 */
@XmlRootElement
public class IssuedVehicle {

    private Long id;
    private Booking booking;
    private String bookingNumber;
    private String bookingState;
    private String user;
    private String parkingLot;
    private String bookedFrom;
    private String bookedTo;
    private String lentFrom;
    private String lentTo;
    private String vehicleCategory;
    private String vehicleType;
    private String vehicleColour;
    private String vehicleLicenseNumber;
    private String vehicleFuelUp;
    private String vehicleMileage;
    private String destination;
    private String ActionButtons;

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public String getBookingNumber() {
        return bookingNumber;
    }

    public void setBookingNumber(String bookingNumber) {
        this.bookingNumber = bookingNumber;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getParkingLot() {
        return parkingLot;
    }

    public void setParkingLot(String parkingLot) {
        this.parkingLot = parkingLot;
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

    public String getVehicleLicenseNumber() {
        return vehicleLicenseNumber;
    }

    public void setVehicleLicenseNumber(String vehicleLicenseNumber) {
        this.vehicleLicenseNumber = vehicleLicenseNumber;
    }

    public String getActionButtons() {
        return ActionButtons;
    }

    public void setActionButtons(String actionButtons) {
        ActionButtons = actionButtons;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getBookingState() {
        return bookingState;
    }

    public void setBookingState(String bookingState) {
        this.bookingState = bookingState;
    }

    public String getBookedFrom() {
        return bookedFrom;
    }

    public void setBookedFrom(String bookedFrom) {
        this.bookedFrom = bookedFrom;
    }

    public String getBookedTo() {
        return bookedTo;
    }

    public void setBookedTo(String bookedTo) {
        this.bookedTo = bookedTo;
    }

    public String getLentFrom() {
        return lentFrom;
    }

    public void setLentFrom(String lentFrom) {
        this.lentFrom = lentFrom;
    }

    public String getLentTo() {
        return lentTo;
    }

    public void setLentTo(String lentTo) {
        this.lentTo = lentTo;
    }

    public String getVehicleFuelUp() {
        return vehicleFuelUp;
    }

    public void setVehicleFuelUp(String vehicleFuelUp) {
        this.vehicleFuelUp = vehicleFuelUp;
    }

    public String getVehicleMileage() {
        return vehicleMileage;
    }

    public void setVehicleMileage(String vehicleMileage) {
        this.vehicleMileage = vehicleMileage;
    }


}
