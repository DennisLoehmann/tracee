package de.holisticon.tracee.hotelbooking;

import java.util.Date;

/**
 * Created by dennis on 27.03.14.
 */
public class Booking {
    private Guest guest;
    private Room room;

    public Booking(Room room, Guest guest, Date startDate, Date endDate) {
    }

    public Room getRoom() {
        return room;
    }

    public Guest getGuest() {
        return guest;
    }
}
