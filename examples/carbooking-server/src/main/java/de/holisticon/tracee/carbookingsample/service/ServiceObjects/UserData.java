package de.holisticon.tracee.carbookingsample.service.ServiceObjects;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by dennis on 10.03.14.
 */
@XmlRootElement
public class UserData {

    private Long id;
    private String name;
    private String nameAbbr;
    private String locationName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameAbbr() {
        return nameAbbr;
    }

    public void setNameAbbr(String nameAbbr) {
        this.nameAbbr = nameAbbr;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getNameAndAbbreviation() {
        return name + " / " + nameAbbr;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
