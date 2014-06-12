package de.holisticon.tracee.hotelbooking;

/**
 * Created by dennis on 16.04.14.
 */
public class RoomFactory {

    public static Room createRoom(String roomNumber, Category category, int squareMeters, Direction direction) {
        return new Room(roomNumber, category, squareMeters, direction);
    }
}
