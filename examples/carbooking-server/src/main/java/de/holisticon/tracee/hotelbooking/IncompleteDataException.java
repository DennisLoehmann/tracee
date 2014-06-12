package de.holisticon.tracee.hotelbooking;

/**
 * Created by dennis on 16.04.14.
 */
public class IncompleteDataException extends RuntimeException {

    public IncompleteDataException(String message ) {
        super(message);
    }
}
