package de.holisticon.tracee.hotelbooking;

import org.cdisource.beancontainer.BeanContainer;
import org.cdisource.beancontainer.BeanContainerManager;
import org.junit.*;

import javax.inject.Inject;
import java.text.SimpleDateFormat;
import java.util.Date;

import static junit.framework.TestCase.*;


/**
 * Created by dennis on 26.03.14.
 */
public class TestHotelBookingWithMocking {

    @Inject
    private RoomManager rm = beanContainer
            .getBeanByType(RoomManager.class);
    @Inject
    @Mock
    private Database db = beanContainer
            .getBeanByType(Database.class);
    private static BeanContainer beanContainer = BeanContainerManager.getInstance();

    private static final SimpleDateFormat SDF = new SimpleDateFormat("dd/MM/yyyy");


/*
    Als Benutzer möchte ich ein Hotelzimmer für einen bestimmten Zeitraum buchen können.

    In einer dafür vorgesehenen Maske kann ich einen Suchzeitraum (Beginn, Ende) vorgeben
    und auf einen Suchknopf drücken. Daraufhin werden mir die Hotelzimmer angezeigt, die
    von Anfang bis Ende meines Zeitraums ununterbrochen verfügbar sind.

    Der Benutzer drückt neben einem Hotelzimmer auf den „Buchen“-Knopf, um dieses zu reservieren.
    Im Hintergrund wird ein Buchungsobjekt erstellt.
*/

/*
    a) Ein Gast kann ein Hotelzimmer buchen. Die Anzahl der Buchungen im System erhöht sich auf 1
    b) Buchungen werden pro Zimmer und global gezählt
    c) Ein gebuchtes Hotelzimmer kann storniert werden. Die Anzahl der Buchungen wird um 1 gesenkt
    d) Ein nicht gebuchtes Hotelzimmer kann nicht storniert werden. Das System erzeugt eine Fehlermeldung.
    e) Ein bereits gebuchtes Zimmer kann nicht noch einmal gebucht werden. Das System erzeugt in diesem Falle eine Fehlermeldung. Die Anzahl der Buchungen bleibt unverändert.

    f) Ein Hotelzimmer wird für einen bestimmten Zeitraum gebucht. Der Zeitraum ist gekennzeichnet durch Anfangs- und Endedatum
    f) Ein Hotelzimmer darf nur gebucht werden, wenn es innerhalb des Zeitraumes keine Buchungen für dieses Zimmer gibt
    g) Ein Hotelzimmer kann nur von einem Gast zur Zeit gebucht werden
    h) Ein Gast kann pro Zeitraum beliebig viele Zimmer buchen

    i) Ein Hotelzimmer hat als weitere Eigenschaften: Kategorie (Einfach Single, Luxus Single, Einfach Zweibett, Luxus Zweibett)

    j) Die Suche nach einem Hotelzimmer benutzt die folgenden Parameter: Startdatum, Endedatum, Kategorie. Es dürfen nur Zimmer angezeigt werden, die für den kompletten Zeitraum nicht belegt sind und in die ausgewählte Kategorie passen



 */

    Date bookingStartDate = null;
    Date bookingEndDate = null;


    @Before
    public void setUp() {
//        db.clearBookings();
        try {
            bookingStartDate = SDF.parse("30/03/2014");
            bookingEndDate = SDF.parse("31/03/2014");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @After
    public void tearDown() {
        rm.deleteAllBookings();

    }



    //    a) Ein Gast kann ein Hotelzimmer buchen. Die Anzahl der Buchungen im System erhöht sich auf 1
    @Test
    public void testBookRoomForGuest() {
        Room room = rm.getRoom("1");
        Guest guest = new Guest();

        rm.bookRoom(room, guest, bookingStartDate, bookingEndDate);
        assertTrue(rm.isRoomBooked(room, bookingStartDate));
        assertEquals(1, rm.getBookingsCount(bookingStartDate));
        assertEquals(1, rm.getBookingsCount(room, bookingStartDate));

    }

////     b) Buchungen werden pro Zimmer und global gezählt
//
//    @Test
//    public void testCountBookingsForRoomAndGlobally() {
//        Room room1 = rm.getRoom("1");
//        Guest guest1 = new Guest();
//        Room room2 = rm.getRoom("2");
//        Guest guest2 = new Guest();
//        assertEquals(0, rm.getBookingsCount(room1, bookingStartDate));
//        assertEquals(0, rm.getBookingsCount(room2, bookingStartDate));
//        assertEquals(0, rm.getBookingsCount(bookingStartDate));
//        rm.bookRoom(room1, guest1, bookingStartDate, bookingEndDate);
//        assertEquals(1, rm.getBookingsCount(room1, bookingStartDate));
//        assertEquals(0, rm.getBookingsCount(room2, bookingStartDate));
//        assertEquals(1, rm.getBookingsCount(bookingStartDate));
//        rm.bookRoom(room2, guest2, bookingStartDate, bookingEndDate);
//        assertEquals(1, rm.getBookingsCount(room1, bookingStartDate));
//        assertEquals(1, rm.getBookingsCount(room2, bookingStartDate));
//        assertEquals(2, rm.getBookingsCount(bookingStartDate));
//
//    }
//
//    //     c) Ein gebuchtes Hotelzimmer kann storniert werden. Die Anzahl der Buchungen wird um 1 gesenkt
//    @Test
//    public void testCancelRoomForGuest() {
//
//        Room room = rm.getRoom("1");
//        Guest guest = new Guest();
//        rm.bookRoom(room, guest, bookingStartDate, bookingEndDate);
//        assertTrue(room.isBooked(bookingStartDate));
//        assertEquals(guest, room.getGuest(bookingStartDate));
//        rm.cancelRoom(room, guest, bookingStartDate, bookingEndDate);
//        assertFalse(room.isBooked(bookingStartDate));
//        assertNull(room.getGuest(bookingStartDate));
//        assertEquals(0, rm.getBookingsCount(bookingStartDate));
//        assertEquals(0, rm.getBookingsCount(room, bookingStartDate));
//
//    }
//
////    d) Ein nicht gebuchtes Hotelzimmer kann nicht storniert werden. Das System erzeugt eine Fehlermeldung.
//
//    @Test
//    public void testCancelUnbookedRoom() {
//        Room room = rm.getRoom("1");
//        Guest guest = new Guest();
//        try {
//            rm.cancelRoom(room, guest, bookingStartDate, bookingEndDate);
//        } catch (IllegalCancelRoomException e) {
//            assertTrue(true);
//        }
//        fail();
//    }
//
////    e) Ein bereits gebuchtes Zimmer kann nicht noch einmal gebucht werden. Das System erzeugt in diesem Falle eine Fehlermeldung. Die Anzahl der Buchungen bleibt unverändert.
//
//    @Test
//    public void testBookRoomTwiceForSameGuest() {
//        Room room = rm.getRoom("1");
//        Guest guest = new Guest();
//        rm.bookRoom(room, guest, bookingStartDate, bookingEndDate);
//        assertTrue(room.isBooked(bookingStartDate));
//        try {
//            rm.bookRoom(room, guest, bookingStartDate, bookingEndDate);
//        } catch (RoomAlreadyBookedException e) {
//            assertTrue(true);
//        }
//        fail();
//    }
//
//    @Test
//    public void testBookRoomTwiceForOtherGuest() {
//        Room room = rm.getRoom("1");
//        Guest guest1 = new Guest();
//        Guest guest2 = new Guest();
//        rm.bookRoom(room, guest1, bookingStartDate, bookingEndDate);
//        assertTrue(room.isBooked(bookingStartDate));
//        try {
//            rm.bookRoom(room, guest2, bookingStartDate, bookingEndDate);
//        } catch (RoomAlreadyBookedException e) {
//            assertTrue(true);
//        }
//        fail();
//    }
//
//    //    f) Ein Hotelzimmer wird für einen bestimmten Zeitraum gebucht. Der Zeitraum ist gekennzeichnet durch Anfangs- und Endedatum
//    @Test
//    public void testBookRoomForGuestWith_Start_And_EndDate() throws ParseException {
//
//        Date beforeDate = SDF.parse("31/03/2014");
//        Date startDate = SDF.parse("01/04/2014");
//        Date middleDate = SDF.parse("02/04/2014");
//        Date endDate = SDF.parse("03/04/2014");
//        Date afterDate = SDF.parse("04/04/2014");
//        Room room = rm.getRoom("1");
//        Guest guest = new Guest();
//
//        rm.bookRoom(room, guest, startDate, endDate);
//
//        assertFalse(room.isBooked(beforeDate));
//        assertTrue(room.isBooked(startDate));
//        assertTrue(room.isBooked(middleDate));
//        // am Checkout-Datum wird das Zimmer wieder frei
//        assertFalse(room.isBooked(endDate));
//        assertFalse(room.isBooked(afterDate));
//
//        assertEquals(guest, room.getGuest(beforeDate));
//        assertEquals(guest, room.getGuest(startDate));
//        assertEquals(guest, room.getGuest(middleDate));
//        assertNull(room.getGuest(endDate));
//        assertNull(room.getGuest(afterDate));
//
//        assertEquals(0, rm.getBookingsCount(beforeDate));
//        assertEquals(1, rm.getBookingsCount(startDate));
//        assertEquals(1, rm.getBookingsCount(middleDate));
//        assertEquals(0, rm.getBookingsCount(endDate));
//        assertEquals(0, rm.getBookingsCount(afterDate));
//
//        assertEquals(0, rm.getBookingsCount(room, beforeDate));
//        assertEquals(1, rm.getBookingsCount(room, startDate));
//        assertEquals(1, rm.getBookingsCount(room, middleDate));
//        assertEquals(0, rm.getBookingsCount(room, endDate));
//        assertEquals(0, rm.getBookingsCount(room, afterDate));
//
//    }
//
//    @Test
//    public void testBookRoomForGuestWith_StartDate_And_Duration() throws ParseException {
//
//        Date startDate = SDF.parse("01/04/2014");
//        Date day1After = SDF.parse("02/04/2014");
//        Date day2After = SDF.parse("03/04/2014");
//        Date day3After = SDF.parse("04/04/2014");
//        Date day4After = SDF.parse("05/04/2014");
//
//        int bookingDays = 3;
//        Room room = rm.getRoom("1");
//        Guest guest = new Guest();
//        rm.bookRoom(room, guest, startDate, bookingDays);
//        assertTrue(room.isBooked(startDate));
//        assertTrue(room.isBooked(day1After));
//        assertTrue(room.isBooked(day2After));
//        assertFalse(room.isBooked(day3After));
//        assertFalse(room.isBooked(day4After));
//        assertEquals(guest, room.getGuest(startDate));
//        assertEquals(guest, room.getGuest(day1After));
//        assertEquals(guest, room.getGuest(day2After));
//        assertNull(room.getGuest(day3After));
//        assertNull(room.getGuest(day4After));
//
//        assertEquals(1, rm.getBookingsCount(room, startDate));
//        assertEquals(1, rm.getBookingsCount(room, day1After));
//        assertEquals(1, rm.getBookingsCount(room, day2After));
//        assertEquals(0, rm.getBookingsCount(room, day3After));
//        assertEquals(0, rm.getBookingsCount(room, day4After));
//
//    }
//
//    // ein Hotelzimmer kann nur gebucht werden, wenn es ein Startdatum und ein Endedatum gibt
//    @Test
//    public void testBookRoomWithIncompleteData() throws ParseException {
//            Room room = rm.getRoom("1");
//            Guest guest = new Guest();
//            try {
//                rm.bookRoom(room, guest, bookingStartDate, null);
//            } catch (IncompleteDataException e1) {
//                assertFalse(room.isBooked(bookingStartDate));
//                try {
//                    rm.bookRoom(room, guest, null, bookingEndDate);
//                } catch (IncompleteDataException e2) {
//                    assertFalse(room.isBooked(bookingEndDate));
//                    return;
//                }
//            }
//
//        fail();
//    }
//
//
////    f) Ein Hotelzimmer darf nur gebucht werden, wenn es innerhalb des Zeitraumes keine Buchungen für dieses Zimmer gibt
//
//    @Test
//    public void bookRoomThatIsAlreadyBookedWithDate() throws ParseException {
//        Date startDate = SDF.parse("01/04/2014");
//        Date middleDate1 = SDF.parse("02/04/2014");
//        Date middleDate2 = SDF.parse("03/04/2014");
//        Date endDate = SDF.parse("04/04/2014");
//        Room room = rm.getRoom("1");
//        Guest guest = new Guest();
//
//        rm.bookRoom(room, guest, startDate, endDate);
//        try {
//            rm.bookRoom(room, guest, startDate, endDate);
//        } catch (RoomAlreadyBookedException e1) {
//            try {
//                rm.bookRoom(room, guest, startDate, middleDate1);
//            } catch (RoomAlreadyBookedException e2) {
//                try {
//                    rm.bookRoom(room, guest, middleDate2, endDate);
//                } catch (RoomAlreadyBookedException e3) {
//                    try {
//                        rm.bookRoom(room, guest, middleDate1, middleDate2);
//                    } catch (RoomAlreadyBookedException e4) {
//                        return;
//                    }
//                }
//            }
//        }
//        fail();
//    }
//
//    //    f) Ein Hotelzimmer darf für verschiedene Zeiträume von verschiedenen Gästen gebucht werden
//
//    @Test
//    public void bookRoomForDifferentDaysAndGuests() throws ParseException {
//        Date beforeDate = SDF.parse("31/03/2014");
//        Date startDate1 = SDF.parse("01/04/2014");
//        Date endDate1 = SDF.parse("02/04/2014");
//        Date startDate2 = SDF.parse("02/04/2014");
//        Date middleDate2 = SDF.parse("03/04/2014");
//        Date endDate2 = SDF.parse("04/04/2014");
//        Date afterDate = SDF.parse("05/04/2014");
//
//        Room room = rm.getRoom("1");
//        Guest guest1 = new Guest();
//        Guest guest2 = new Guest();
//
//        rm.bookRoom(room, guest1, startDate1, endDate1);
//        rm.bookRoom(room, guest2, startDate2, middleDate2);
//        rm.bookRoom(room, guest2, middleDate2, endDate2);
//
//        assertTrue(room.isBooked(startDate1));
//        assertTrue(room.isBooked(endDate1));
//        assertTrue(room.isBooked(startDate2));
//        assertTrue(room.isBooked(middleDate2));
//        assertTrue(room.isBooked(endDate2));
//
//        assertNull(room.getGuest(beforeDate));
//        assertEquals(guest1, room.getGuest(startDate1));
//        assertEquals(guest2, room.getGuest(endDate1));
//        assertEquals(guest2, room.getGuest(startDate2));
//        assertEquals(guest2, room.getGuest(middleDate2));
//        assertNull(room.getGuest(endDate2));
//        assertNull(room.getGuest(afterDate));
//
//    }
//
////    h) Ein Gast kann pro Zeitraum beliebig viele Zimmer buchen
//
//    @Test
//    public void testOneGuestBooksSeveralRooms() throws ParseException {
//        Date beforeDate = SDF.parse("31/03/2014");
//        Date startDate = SDF.parse("01/04/2014");
//        Date endDate = SDF.parse("02/04/2014");
//        Date afterDate = SDF.parse("03/04/2014");
//
//        Room room1 = rm.getRoom("1");
//        Room room2 = rm.getRoom("2");
//        Guest guest = new Guest();
//
//        rm.bookRoom(room1, guest, startDate, endDate);
//        rm.bookRoom(room2, guest, startDate, endDate);
//
//        assertTrue(room1.isBooked(startDate));
//        assertFalse(room2.isBooked(endDate));
//
//        assertNull(room1.getGuest(beforeDate));
//        assertEquals(guest, room1.getGuest(startDate));
//        assertNull(room1.getGuest(endDate));
//        assertNull(room1.getGuest(afterDate));
//
//        assertNull(room2.getGuest(beforeDate));
//        assertEquals(guest, room2.getGuest(startDate));
//        assertNull(room2.getGuest(endDate));
//        assertNull(room2.getGuest(afterDate));
//    }
//
//    //    h) Zwei Gäste können pro Zeitraum zwei verschiedene Zimmer buchen
//    @Test
//    public void testTwoGuestsBookingDifferentRooms() throws ParseException {
//
//        Date beforeDate = SDF.parse("31/03/2014");
//        Date startDate = SDF.parse("01/04/2014");
//        Date endDate = SDF.parse("02/04/2014");
//        Date afterDate = SDF.parse("03/04/2014");
//
//        Room room1 = rm.getRoom("1");
//        Room room2 = rm.getRoom("2");
//        Guest guest1 = new Guest();
//        Guest guest2 = new Guest();
//
//        rm.bookRoom(room1, guest1, startDate, endDate);
//        rm.bookRoom(room2, guest2, startDate, endDate);
//
//        assertTrue(room1.isBooked(startDate));
//        assertFalse(room2.isBooked(endDate));
//
//        assertNull(room1.getGuest(beforeDate));
//        assertEquals(guest1, room1.getGuest(startDate));
//        assertNull(room1.getGuest(endDate));
//        assertNull(room1.getGuest(afterDate));
//
//        assertNull(room2.getGuest(beforeDate));
//        assertEquals(guest2, room2.getGuest(startDate));
//        assertNull(room2.getGuest(endDate));
//        assertNull(room2.getGuest(afterDate));
//    }
//
//
////    j) Die Suche nach einem Hotelzimmer benutzt die folgenden Parameter: Startdatum, Endedatum, Kategorie. Es dürfen nur Zimmer angezeigt werden, die für den kompletten Zeitraum nicht belegt sind und in die ausgewählte Kategorie passen
//
//    @Test
//    public void testFindAllRooms() {
//
//        Map<String, Room> result = rm.findRooms();
//
//    }
//
//    @Test
//    public void testFindAllBookings() {
//
//        Map<String, Room> result = rm.findRooms();
//
//    }
//
//    @Test
//    public void testFindAllGuests() {
//
//        Map<String, Room> result = rm.findRooms();
//
//    }
//
//    @Test
//    public void testFindBookingsForDateRange() throws ParseException {
//
//        Date bookingStartDate1 = SDF.parse("01/04/2014");
//        Date bookingEndDate1 = SDF.parse("03/04/2014");
//        Date bookingStartDate2 = SDF.parse("02/04/2014");
//        Date bookingEndDate2 = SDF.parse("04/04/2014");
//
//        Date searchStartDate1 = SDF.parse("01/04/2014");
//        Date searchEndDate1 = SDF.parse("04/04/2014");
//        Date searchStartDate2 = SDF.parse("03/04/2014");
//        Date searchEndDate2 = SDF.parse("04/04/2014");
//
//        Room room1 = rm.getRoom("1");
//        Room room2 = rm.getRoom("2");
//        Guest guest1 = new Guest();
//        Guest guest2 = new Guest();
//
//        rm.bookRoom(room1, guest1, bookingStartDate1, bookingEndDate1);
//        rm.bookRoom(room2, guest2, bookingStartDate2, bookingEndDate2);
//
//        SearchParameters parameters = new SearchParameters();
//        parameters.setBookingStartDate(searchStartDate1);
//        parameters.setBookingEndDate(searchEndDate1);
//
//        Map<String, Room> result = rm.findBookings(parameters);
//        assertEquals(2, result.size());
//
//        parameters = new SearchParameters();
//        parameters.setBookingStartDate(searchStartDate2);
//        parameters.setBookingEndDate(searchEndDate2);
//
//        result = rm.findBookings(parameters);
//        assertEquals(1, result.size());
//
//    }
//
//    @Test
//    public void testFindBookingsForSpecificGuest() throws ParseException {
//        Date bookingStartDate1 = SDF.parse("01/04/2014");
//        Date bookingEndDate1 = SDF.parse("03/04/2014");
//        Date bookingStartDate2 = SDF.parse("02/04/2014");
//        Date bookingEndDate2 = SDF.parse("04/04/2014");
//
//
//        Room room1 = rm.getRoom("1");
//        Room room2 = rm.getRoom("2");
//        Guest guest1 = new Guest("Frank Thiel");
//        Guest guest2 = new Guest("Karl-Friedrich Boerne");
//
//        rm.bookRoom(room1, guest1, bookingStartDate1, bookingEndDate1);
//        rm.bookRoom(room2, guest2, bookingStartDate2, bookingEndDate2);
//
//        SearchParameters parameters = new SearchParameters();
//        parameters.setGuestName("Frank Thiel");
//
//        Map<String, Room> result = rm.findBookings(parameters);
//        assertEquals(1, result.size());
//        assertEquals("Frank Thiel", result.get("1").getGuest(bookingStartDate1));
//
//
//    }
//
//    @Test
//    public void testFindBookingsForSpecificRoom() throws ParseException {
//        Date bookingStartDate1 = SDF.parse("01/04/2014");
//        Date bookingEndDate1 = SDF.parse("03/04/2014");
//        Date bookingStartDate2 = SDF.parse("02/04/2014");
//        Date bookingEndDate2 = SDF.parse("04/04/2014");
//
//
//        Room room1 = rm.getRoom("1");
//        Room room2 = rm.getRoom("2");
//        Guest guest1 = new Guest("Frank Thiel");
//        Guest guest2 = new Guest("Karl-Friedrich Boerne");
//
//        rm.bookRoom(room1, guest1, bookingStartDate1, bookingEndDate1);
//        rm.bookRoom(room2, guest2, bookingStartDate2, bookingEndDate2);
//
//        SearchParameters parameters = new SearchParameters();
//        parameters.setRoomNumber("2");
//
//        Map<String, Room> result = rm.findBookings(parameters);
//        assertEquals(1, result.size());
//        assertEquals("2", result.get("2").getRoomNumber());
//    }
//
//    @Test
//    public void testFindRoomsForCategory() {
//
//
//        SearchParameters parameters = new SearchParameters();
//        parameters.setRoomCategory(Category.SINGLE_EXECUTIVE); //2
//
//        Map<String, Room> result = rm.findRooms(parameters);
//        assertEquals(1, result.size());
//
//        parameters = new SearchParameters();
//        parameters.setRoomCategory(Category.DOUBLE_STANDARD); //3 und 6
//
//        result = rm.findRooms(parameters);
//        assertEquals(2, result.size());
//
//    }
//
//    @Test
//    public void testFindRoomsForSpecificDirection() {
//
//        SearchParameters parameters = new SearchParameters();
//        parameters.setRoomViewDirection(Direction.EAST); // 4
//
//        Map<String, Room> result = rm.findRooms(parameters);
//        assertEquals(1, result.size());
//
//        parameters = new SearchParameters();
//        parameters.setRoomViewDirection(Direction.SOUTH); // 2 und 6
//
//        result = rm.findRooms(parameters);
//        assertEquals(2, result.size());
//
//    }
//
//    @Test
//    public void testFindRoomsWithCombinedSearchParameters()  {
//
//        SearchParameters parameters = new SearchParameters();
//        parameters.setRoomCategory(Category.DOUBLE_STANDARD); // 3 und 6
//        parameters.setRoomViewDirection(Direction.SOUTHEAST); // 3 und 5
//
//        Map<String, Room> result = rm.findRooms(parameters);
//        assertEquals(1, result.size());
//        assertEquals("3", result.get("3").getRoomNumber());
//
//    }
//
//    @Test
//    public void testFindBookingsWithCombinedSearchParametersAndPossibleResult() throws ParseException {
//
//        Date bookingStartDate1 = SDF.parse("01/04/2014");
//        Date bookingEndDate1 = SDF.parse("03/04/2014");
//        Date bookingStartDate2 = SDF.parse("02/04/2014");
//        Date bookingEndDate2 = SDF.parse("04/04/2014");
//
//
//        Room room1 = rm.getRoom("1");
//        Room room2 = rm.getRoom("2");
//        Guest guest1 = new Guest("Frank Thiel");
//        Guest guest2 = new Guest("Karl-Friedrich Boerne");
//
//        rm.bookRoom(room1, guest1, bookingStartDate1, bookingEndDate1);
//        rm.bookRoom(room2, guest2, bookingStartDate2, bookingEndDate2);
//
//        SearchParameters parameters = new SearchParameters();
//        parameters.setRoomNumber("2");
//        parameters.setGuestName("Karl-Friedrich Boerne");
//        parameters.setRoomCategory(Category.SINGLE_EXECUTIVE);
//        parameters.setRoomViewDirection(Direction.SOUTH);
//
//
//        Map<String, Room> result = rm.findBookings(parameters);
//        assertEquals(1, result.size());
//        assertEquals("2", result.get("2").getRoomNumber());
//    }
//
//    @Test
//    public void testFindBookingsWithCombinedSearchParametersAndImpossibleResult() throws ParseException {
//
//        Date bookingStartDate1 = SDF.parse("01/04/2014");
//        Date bookingEndDate1 = SDF.parse("03/04/2014");
//        Date bookingStartDate2 = SDF.parse("02/04/2014");
//        Date bookingEndDate2 = SDF.parse("04/04/2014");
//
//
//        Room room1 = rm.getRoom("1");
//        Room room2 = rm.getRoom("2");
//        Guest guest1 = new Guest("Frank Thiel");
//        Guest guest2 = new Guest("Karl-Friedrich Boerne");
//
//        rm.bookRoom(room1, guest1, bookingStartDate1, bookingEndDate1);
//        rm.bookRoom(room2, guest2, bookingStartDate2, bookingEndDate2);
//
//        SearchParameters parameters = new SearchParameters();
//        parameters.setGuestName("Frank Thiel");
//        parameters.setRoomCategory(Category.SINGLE_EXECUTIVE);
//        parameters.setRoomViewDirection(Direction.WEST);
//
//        Map<String, Room> result = rm.findBookings(parameters);
//        assertEquals(0, result.size());
//
//    }


}
