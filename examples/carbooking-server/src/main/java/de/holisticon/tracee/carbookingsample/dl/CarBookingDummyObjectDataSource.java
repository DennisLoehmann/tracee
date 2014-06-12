package de.holisticon.tracee.carbookingsample.dl;

import de.holisticon.tracee.carbookingsample.service.ServiceObjects.BookableVehicle;
import de.holisticon.tracee.carbookingsample.service.ServiceObjects.IssuedVehicle;
import de.holisticon.tracee.carbookingsample.service.ServiceObjects.UserData;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by dennis on 06.03.14.
 */
//@Dummy
//@Named
//@Default
public class CarBookingDummyObjectDataSource implements DataSource {

    Map<Long, BookableVehicle> bookableVehicles = null;
    Map<Long, IssuedVehicle> issuedVehicles = null;
    Map<Long, UserData> usersData = null;

    private @Inject
    ObjectInitializer initializer;

    @Override
    public Map<Long, BookableVehicle> findBookableVehicles(Map parameter) {
        bookableVehicles = initializer.initBookableVehicles();
        return bookableVehicles;
    }

    @Override
    public Map<Long, IssuedVehicle> findIssuedVehicles(Map parameter) {
        issuedVehicles = initializer.initIssuedVehicles();
        return issuedVehicles;
    }

    @Override
    public UserData loadUserData(Long userId) {
        return findUserData(new HashMap()).get(userId);
    }

    @Override
    public Map<Long, UserData> findUserData(Map parameters) {
        usersData = initializer.initUserData();
        return usersData;
    }

    public Map<Long, BookableVehicle> getBookableVehicles(Map parameters) {
        Map result = getBookableVehicles(new HashMap());
//        for (Map.Entry paramEntry : (Set<Map.Entry>)parameters.entrySet()) {
//            Map tempResult = new HashMap();
//            if (VehicleBookingSearchFields.SEARCH_FROM.equals(paramEntry.getKey())) {
//              for (Map.Entry resultEntry : (Set<Map.Entry>) result.entrySet()) {
//
//                  if (((BookableVehicle)resultEntry.getValue()) != null && (((BookableVehicle)resultEntry.getValue()).getBookedFrom().after(paramEntry.getValue())) ) {
//                      tempResult.put(resultEntry.getKey(), resultEntry.getValue());
//                  }
//                  // result = intersection(tempResult)
//              }
//
//            }
//            switch (paramEntry.getKey()) {
//                case "VehicleBookingSearchFields.SEARCH_FROM"  : break;
//            }
//        }
//        VehicleBookingSearchFields.SEARCH_FROM = "Von";
//            public static final String SEARCH_TO = "Bis";
//            public static final String SEARCH_START = "Start";
//            public static final String SEARCH_DESTINATION = "Ziel";
//            public static final String SEARCH_DISTANCE = "Entfernung";
//            public static final String SEARCH_CATEGORY
//    }
        return result;
    }


    public Map<Long, IssuedVehicle> getIssuedVehicles() {
        return issuedVehicles;
    }

    public Map<Long, UserData> getUsersData() {
        return usersData;
    }

    public void setUsersData(Map<Long, UserData> usersData) {
        this.usersData = usersData;
    }
}
