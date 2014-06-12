package de.holisticon.tracee.carbookingsample.bl;

import de.holisticon.tracee.carbookingsample.service.ServiceObjects.UserData;
import de.holisticon.tracee.carbookingsample.service.ServiceObjects.BookableVehicle;
import de.holisticon.tracee.carbookingsample.service.ServiceObjects.IssuedVehicle;

import java.util.Map;


/**
 * Created by dennis on 13.03.14.
 */
public interface DataService {

    Map<Long, BookableVehicle> findBookableVehicles(Map parameter);
    Map<Long, IssuedVehicle> findIssuedVehicles(Map parameter);
    UserData loadUserData(Long id);
    Map<Long, UserData> findUserData(Map parameters);



}
