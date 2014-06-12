package de.holisticon.tracee.carbookingsample.model;

/**
 * Created by dennis on 06.03.14.
 */
public class UserData {

    String name;
    String abbreviation;
    Location location;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
