package de.holisticon.tracee.hotelbooking;

/**
 * Created by dennis on 31.03.14.
 */
public class IllegalCancelRoomException extends RuntimeException {

    public IllegalCancelRoomException(String message) {
        super(message);
    }

}
