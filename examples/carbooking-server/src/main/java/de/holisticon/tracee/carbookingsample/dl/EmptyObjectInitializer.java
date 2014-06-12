package de.holisticon.tracee.carbookingsample.dl;

import de.holisticon.tracee.carbookingsample.service.ServiceObjects.BookableVehicle;
import de.holisticon.tracee.carbookingsample.service.ServiceObjects.IssuedVehicle;
import de.holisticon.tracee.carbookingsample.service.ServiceObjects.UserData;

import javax.inject.Named;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by dennis on 13.03.14.
 */
@Named("dummyObjectDataSource")
@Empty
public class EmptyObjectInitializer implements ObjectInitializer {


    @Override
    public Map<Long, BookableVehicle> initBookableVehicles() {
        return new HashMap<Long, BookableVehicle>();
    }

    @Override
    public Map<Long, IssuedVehicle> initIssuedVehicles() {
        return new HashMap<Long, IssuedVehicle>();
    }

    @Override
    public Map<Long, UserData> initUserData() {
        return new HashMap<Long, UserData>();
    }
}
