package de.holisticon.tracee.carbookingsample.model;

import java.util.Date;

/**
 * Created by dennis on 06.03.14.
 */
public class Booking {

    String bookingRef;
    UserData username;
    Vehicle vehicle;
    Location start;
    Location target;
    Date bookingStart;
    Date bookingEnd;
    Date leaseStart;
    Date leaseEnd;
    String sessionId;
    Double fueledOnReturn;
    Long mileageOnReturn;
    String speedingProsecutionRef;

    public String getBookingRef() {
        return bookingRef;
    }

    public void setBookingRef(String bookingRef) {
        this.bookingRef = bookingRef;
    }

    public UserData getUsername() {
        return username;
    }

    public void setUsername(UserData username) {
        this.username = username;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Location getStart() {
        return start;
    }

    public void setStart(Location start) {
        this.start = start;
    }

    public Location getTarget() {
        return target;
    }

    public void setTarget(Location target) {
        this.target = target;
    }

    public Date getBookingStart() {
        return bookingStart;
    }

    public void setBookingStart(Date bookingStart) {
        this.bookingStart = bookingStart;
    }

    public Date getBookingEnd() {
        return bookingEnd;
    }

    public void setBookingEnd(Date bookingEnd) {
        this.bookingEnd = bookingEnd;
    }

    public Date getLeaseStart() {
        return leaseStart;
    }

    public void setLeaseStart(Date leaseStart) {
        this.leaseStart = leaseStart;
    }

    public Date getLeaseEnd() {
        return leaseEnd;
    }

    public void setLeaseEnd(Date leaseEnd) {
        this.leaseEnd = leaseEnd;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public Double getFueledOnReturn() {
        return fueledOnReturn;
    }

    public void setFueledOnReturn(Double fueledOnReturn) {
        this.fueledOnReturn = fueledOnReturn;
    }

    public Long getMileageOnReturn() {
        return mileageOnReturn;
    }

    public void setMileageOnReturn(Long mileageOnReturn) {
        this.mileageOnReturn = mileageOnReturn;
    }

    public String getSpeedingProsecutionRef() {
        return speedingProsecutionRef;
    }

    public void setSpeedingProsecutionRef(String speedingProsecutionRef) {
        this.speedingProsecutionRef = speedingProsecutionRef;
    }
}
