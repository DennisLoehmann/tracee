package de.holisticon.tracee.hotelbooking;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Collection;
import java.util.Date;
import java.util.Map;

/**
 * Created by dennis on 26.03.14.
 */
@Default
@Named
public class RoomManagerImpl implements RoomManager {

    private static RoomManagerImpl instance = new RoomManagerImpl();

    @Inject
    private Database database;

    @Inject @Mock
    private Database mockedDatabase;

    public RoomManagerImpl() {
    }

    public static RoomManagerImpl getInstance() {
//        instance.useDefaultDatabase();
        return instance;
    }

    public static RoomManagerImpl getInstance(Database db) {
        instance.setDatabase(db);
        return instance;
    }

    public void setDatabase(Database db) {
        this.database = db;
    }

    public void useDefaultDatabase() {
        database = DefaultDatabase.getInstance(this);
    }



    public Room getRoom(String roomNumber) {
        return database.getRoom(roomNumber);
    }

    @Override
    public Booking bookRoom(Room room, Guest guest, Date startDate, Date endDate) throws IncompleteDataException, RoomAlreadyBookedException {
//        room.book(guest,  startDate, endDate);
        Booking booking = new Booking(room, guest, startDate, endDate);
        database.createBooking(booking);
        return booking;
    }


    @Override
    public Booking bookRoom(Room room, Guest guest, Date startDate, int numberOfDays) throws RoomAlreadyBookedException {
        return null;
    }

    @Override
    public int getBookingsCount(Date forDate) {
        return 0;
    }

    @Override
    public int getBookingsCount(Room room, Date forDate) {
        return 0;
    }

    @Override
    public void cancelRoom(Room room, Guest guest, Date startDate, Date endDate) {
        Booking booking = database.getBooking(room);
        database.deleteBooking(booking);
    }

    @Override
    public void deleteAllBookings() {

    }

    @Override
    public Map<String, Room> findRooms() {
        return null;
    }

    @Override
    public Map<String, Room> findRooms(SearchParameters parameters) {
        return null;
    }

    @Override
    public Collection<Guest> findBookings(Date date, Room room) {
      return database.findBookings(date).get(room);
    }

    @Override
    public boolean isRoomBooked(Room room, Date bookingStartDate) {

        return false;
    }

    public Booking bookRoom(Room room, Guest guest) {
        return null;
    }


    public void deleteBooking(Booking booking) {
        Room room = booking.getRoom();
        Guest guest = booking.getGuest();
        database.deleteBooking(booking);
    }

    public void clearAllBookings() {

        database.deleteBookings();
    }



}
