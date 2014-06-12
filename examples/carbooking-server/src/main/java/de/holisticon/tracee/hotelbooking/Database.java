package de.holisticon.tracee.hotelbooking;

import java.util.Date;
import java.util.Map;
import java.util.Set;

/**
 * Created by dennis on 27.03.14.
 */
public interface Database {

    void createBooking(Room room, Guest guest, Date startDate, Date endDate);

    Room getRoom(String roomNumber);

    void deleteBooking(Booking booking);

    void deleteBookings();

    int getBookingsCount(Room room);

    Booking getBooking(Room room);

    void createBooking(Booking booking);

    Map<Room,Guest> findBookings(Map<Date, Map<Room, Guest>> bookingMap, Date date);

    Map<Date,Guest> findBookings(Map<Room, Map<Date, Guest>> bookingMap, Room room);

    Map<Date,Guest> findBookings(Room room);

    Map<Room,Guest> findBookings(Date date);

    Map<Date, Map<Room,Guest>> findBookings(Set<Date> dateSet);
}
