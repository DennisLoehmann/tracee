package de.holisticon.tracee.hotelbooking;

import java.util.Date;

/**
 * Created by dennis on 16.04.14.
 */
public class SearchParameters {

    private Date bookingStartDate;
    private Date bookingEndDate;
    private String guestName;
    private String roomNumber;
    private Category roomCategory;
    private Direction roomViewDirection;

    public SearchParameters() {
    }

    public SearchParameters(Date bookingStartDate, Date bookingEndDate, String guestName, String roomNumber, Category roomCategory, Direction roomViewDirection) {
        this.bookingStartDate = bookingStartDate;
        this.bookingEndDate = bookingEndDate;
        this.guestName = guestName;
        this.roomNumber = roomNumber;
        this.roomCategory = roomCategory;
        this.roomViewDirection = roomViewDirection;
    }

    public Date getBookingStartDate() {
        return bookingStartDate;
    }

    public void setBookingStartDate(Date bookingStartDate) {
        this.bookingStartDate = bookingStartDate;
    }

    public Date getBookingEndDate() {
        return bookingEndDate;
    }

    public void setBookingEndDate(Date bookingEndDate) {
        this.bookingEndDate = bookingEndDate;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Category getRoomCategory() {
        return roomCategory;
    }

    public void setRoomCategory(Category roomCategory) {
        this.roomCategory = roomCategory;
    }

    public Direction getRoomViewDirection() {
        return roomViewDirection;
    }

    public void setRoomViewDirection(Direction roomViewDirection) {
        this.roomViewDirection = roomViewDirection;
    }
}
