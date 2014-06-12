package de.holisticon.tracee.hotelbooking;

import javax.inject.Named;
import java.util.*;

/**
 * Created by dennis on 27.03.14.
 */
@Mock
@Named
public class DatabaseMock implements Database {

    private static Database instance = new DatabaseMock();

    Map<String, Room> roomMap = new HashMap<String, Room>();
    Map<Room, Map<Date, Guest>> bookingMapByRoom = new HashMap<Room, Map<Date, Guest>> ();
    Map<Date, Map<Room, Guest>> bookingMapByDate = new HashMap<Date, Map<Room, Guest>> ();



    private void createMockData() {
        roomMap.put("1", RoomFactory.createRoom("1", Category.SINGLE_STANDARD, 12, Direction.SOUTHWEST));
        roomMap.put("2", RoomFactory.createRoom("2", Category.SINGLE_EXECUTIVE, 18, Direction.SOUTH));
        roomMap.put("3", RoomFactory.createRoom("3", Category.DOUBLE_STANDARD, 18, Direction.SOUTHEAST));
        roomMap.put("4", RoomFactory.createRoom("4", Category.DOUBLE_EXECUTIVE, 24, Direction.EAST));
        roomMap.put("5", RoomFactory.createRoom("5", Category.SINGLE_STANDARD, 12, Direction.SOUTHEAST));
        roomMap.put("6", RoomFactory.createRoom("6", Category.DOUBLE_STANDARD, 18, Direction.SOUTH));
    }

   private DatabaseMock() {
       createMockData();
   }


    public static Database getInstance() {
        return instance;
    }


    private Map<String, Room> getRoomMap() {
        if (roomMap == null) {
            roomMap = new HashMap<String, Room>();
        }
        return roomMap;
    }

    private Map<Room, Map<Date, Guest>> getBookingMapByRoom() {
        if (bookingMapByRoom == null) {
            bookingMapByRoom = new HashMap<Room, Map<Date, Guest>>();
        }
        return bookingMapByRoom;
    }

    private Map<Date, Map<Room, Guest>> getBookingMapByDate() {
        if (bookingMapByDate == null) {
            bookingMapByDate = new HashMap<Date, Map<Room, Guest>>();
        }
        return bookingMapByDate;
    }


    public void createBooking(Room room, Guest guest, Date startDate, Date endDate) throws RoomAlreadyBookedException {

        Map<Date, Guest> bookingsPerRoom = bookingMap.get(room);

        Calendar cal =  new GregorianCalendar();



        for (cal.setTime(startDate); cal.before(endDate); cal.add(Calendar.DATE, 1)) {
            Date date = cal.getTime();
            if (bookingsPerRoom.get(date) != null) {
                bookingsPerRoom.put(date, guest);
            } else {
                Guest alreadyBookedGuest = bookingsPerRoom.get(date);
                StringBuilder sb = new StringBuilder();
                sb.append("Tried to book Room: ");
 //               sb.append(roomNumber);
                sb.append(" for Guest ");
                sb.append(guest.getName());
                sb.append(" and date ");
//                sb.append(SDF.format(date));
                sb.append(". Room is already booked with guest ");
                sb.append(alreadyBookedGuest.getName());
                sb.append(" !");
                throw new RoomAlreadyBookedException(sb.toString());
            }
        }
    }

    @Override
    public Room getRoom(String roomNumber) {
        return getRoomMap().get(roomNumber);
    }

    @Override
    public void deleteBooking(Booking booking) {
        getBookingMap().remove(booking);
    }

    @Override
    public void deleteBookings() {
        getBookingMap().clear();
    }

    @Override
    public int getBookingsCount(Room room) {
        return (getBookingMap().get(room) != null ? 1 : 0);
    }

    @Override
    public Booking getBooking(Room room) {
        return null;
    }

    @Override
    public void createBooking(Booking booking) {

    }

    @Override
    public Map<Room,Guest> findBookings(Map<Date, Map<Room,Guest>> bookingMap, Date date) {
        return bookingMap.get(date);
    }
    @Override
    public Map<Date,Guest> findBookings(Map<Room, Map<Date,Guest>> bookingMap, Room room) {
        return bookingMap.get(room);
    }

    @Override
    public Map<Date,Guest> findBookings(Room room) {
        return findBookings(getBookingMapByRoom(), room);
    }

    @Override
    public Map<Room,Guest> findBookings(Date date) {
        return findBookings(getBookingMapByDate(), date);
    }

    @Override
    public Map<Date, Map<Room,Guest>> findBookings(Set<Date> dateSet) {
        Map<Date, Map<Room,Guest>> resultMap = new HashMap <Date, Map<Room,Guest>>();
        for (Date date : dateSet) {
            resultMap.put(date, findBookings(date));
        }
        return resultMap;
    }

}
