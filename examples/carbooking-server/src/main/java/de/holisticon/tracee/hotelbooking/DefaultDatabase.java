package de.holisticon.tracee.hotelbooking;

import javax.enterprise.inject.Default;
import javax.inject.Named;
import java.util.Date;

/**
 * Created by dennis on 27.03.14.
 */
@Default
@Named
public class DefaultDatabase implements Database {

    private static Database instance = new DefaultDatabase();

    private DefaultDatabase() {

    }

    static Database getInstance(Object requester) {
        if (requester instanceof RoomManager) {
            return instance;
        }
        return null;
    }

    @Override
    public void createBooking(Room room, Guest guest, Date startDate, Date endDate) {

    }

    @Override
    public Room getRoom(String roomNumber) {
        return null;
    }

    @Override
    public void deleteBooking(Booking booking) {

    }

    @Override
    public void deleteBookings() {

    }

    @Override
    public int getBookingsCount(Room room) {
        return 0;
    }

    @Override
    public Booking getBooking(Room room) {
        return null;
    }

    @Override
    public void createBooking(Booking booking) {

    }


}
