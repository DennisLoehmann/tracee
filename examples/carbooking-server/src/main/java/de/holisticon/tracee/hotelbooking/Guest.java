package de.holisticon.tracee.hotelbooking;

/**
 * Created by dennis on 26.03.14.
 */
public class Guest {

    private String name;

    public Guest() {
    }

    public Guest(String guestName) {
        setName(guestName);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
