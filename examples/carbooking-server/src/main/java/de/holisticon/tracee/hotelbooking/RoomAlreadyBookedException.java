package de.holisticon.tracee.hotelbooking;

/**
 * Created by dennis on 31.03.14.
 */
public class RoomAlreadyBookedException extends RuntimeException {

    public RoomAlreadyBookedException(String message) {
        super(message);
    }

}
