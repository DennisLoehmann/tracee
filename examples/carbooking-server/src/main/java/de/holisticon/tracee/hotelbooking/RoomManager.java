package de.holisticon.tracee.hotelbooking;

import java.util.Date;
import java.util.Map;

/**
 * Created by dennis on 27.03.14.
 */
public interface RoomManager {

    public void setDatabase(Database db);

    Room getRoom(String s);

    Booking bookRoom(Room room, Guest guest, Date startDate, Date endDate) throws IncompleteDataException, RoomAlreadyBookedException;

    Booking bookRoom(Room room, Guest guest, Date startDate, int numberOfDays) throws RoomAlreadyBookedException;

    int getBookingsCount(Date forDate);

    int getBookingsCount(Room room, Date forDate);

    void cancelRoom(Room room, Guest guest, Date startDate, Date endDate);

    void deleteAllBookings();

    Map<String,Room> findRooms();

    Map<String,Room> findRooms(SearchParameters parameters);

    Map<String,Room> findBookings(SearchParameters parameters);

    boolean isRoomBooked(Room room, Date bookingStartDate);
}
