package de.holisticon.tracee.hotelbooking;

import java.text.SimpleDateFormat;

/**
 * Created by dennis on 26.03.14.
 */
public class Room {

    private static final SimpleDateFormat SDF = new SimpleDateFormat();

    private String roomNumber;
    private Category category;
    private Direction direction;
    private int squareMeters;


    public Room(String roomNumber, Category category, int squareMeters, Direction direction) {
        this.roomNumber = roomNumber;
        this.category = category;
        this.squareMeters = squareMeters;
        this.direction = direction;
    }

//    private Guest guest;
//    boolean booked;
//    Map<Date, Guest> bookingMap = new HashMap<Date, Guest>();


//    public boolean isBooked(Date forDate) {
//        return booked;
//    }


//    public void cancel(Guest guest, Date startDate, Date endDate) {
//        booked = false;
//        this.guest = null;
//    }
//
//    public Guest getGuest(Date forDate) {
//        return guest;
//    }
//

    public int getSquareMeters() {
        return squareMeters;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public Category getCategory() {
        return category;
    }

    public Direction getDirection() {
        return direction;
    }
}
