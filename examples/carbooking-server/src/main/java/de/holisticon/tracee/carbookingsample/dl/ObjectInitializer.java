package de.holisticon.tracee.carbookingsample.dl;

import de.holisticon.tracee.carbookingsample.service.ServiceObjects.BookableVehicle;
import de.holisticon.tracee.carbookingsample.service.ServiceObjects.IssuedVehicle;
import de.holisticon.tracee.carbookingsample.service.ServiceObjects.UserData;

import java.util.Map;

/**
 * Created by dennis on 13.03.14.
 */
public interface ObjectInitializer {

    public Map<Long, BookableVehicle> initBookableVehicles();

    public Map<Long, IssuedVehicle> initIssuedVehicles();

    public Map<Long, UserData> initUserData();

}
