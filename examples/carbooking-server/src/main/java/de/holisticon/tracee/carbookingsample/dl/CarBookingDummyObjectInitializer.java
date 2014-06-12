package de.holisticon.tracee.carbookingsample.dl;

import de.holisticon.tracee.carbookingsample.service.ServiceObjects.BookableVehicle;
import de.holisticon.tracee.carbookingsample.service.ServiceObjects.IssuedVehicle;
import de.holisticon.tracee.carbookingsample.service.ServiceObjects.UserData;

import javax.enterprise.inject.Default;
import javax.inject.Named;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dennis on 06.03.14.
 */
@Dummy
@Default
@Named
public class CarBookingDummyObjectInitializer implements ObjectInitializer {



    /*
  * Generate some in-memory example data to play with. In a real application
  * we could be using SQLContainer, JPAContainer or some other to persist the
  * data.
  */
    public Map<Long, BookableVehicle> initBookableVehicles() {

        Map<Long, BookableVehicle> bookableVehicles = new HashMap();

        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

        Map returnMap = new HashMap();

		/* Create dummy data by randomly combining first and last names */
        List<Object[]> vehicleTypes = new ArrayList();
        vehicleTypes.add(new Object[]{1L, "City", "Smart Fortwo", "Silber", "HH-XY 123", "21.02.2014", "22.02.2014", "Holisticon HQ", "0", false});
        vehicleTypes.add(new Object[]{2L, "Klein", "VW Polo", "Blau", "HH-XX 234", "21.02.2014", "22.02.2014", "Holisticon HQ", "0", false});
        vehicleTypes.add(new Object[]{3L, "Kompakt", "VW Golf", "Schwarz", "HH-HQ 345", "21.02.2014", "22.02.2014", "Holisticon HQ", "0", false});
        vehicleTypes.add(new Object[]{4L, "Kompakt", "Ford Focus", "Weiß", "HH-MM 456", "21.02.2014", "22.02.2014", "Holisticon HQ", "0", false});
        vehicleTypes.add(new Object[]{5L, "Mittelklasse", "Audi A4", "Braun", "HH-AA 444", "21.02.2014", "22.02.2014", "Holisticon HQ", "0", false});
        vehicleTypes.add(new Object[]{6L, "Transporter", "Mercedes Sprinter", "Weiß", "HH-YY 678", "21.02.2014", "22.02.2014", "Holisticon HQ", "0", false});

        for (Object[] vehicleString : vehicleTypes) {

            Long vehicleId = (Long) vehicleString[0];
            int i= 1;
            BookableVehicle v = new BookableVehicle();
            v.setVehicleCategory((String)vehicleString[1]);
            v.setVehicleType((String)vehicleString[2]);
            v.setVehicleColour((String)vehicleString[3]);
            v.setLicenseNumber((String)vehicleString[4]);
            try {
                v.setAvailableFrom((String)vehicleString[5]);
                v.setAvailableTil((String)vehicleString[6]);
            } catch (Exception e) {
                e.printStackTrace();
            }
            v.setParkingLot((String)vehicleString[7]);
            v.setDistanceFromUser((String)vehicleString[8]);
            v.setBooked((Boolean)vehicleString[9]);
            bookableVehicles.put(vehicleId, v);

        }

        return bookableVehicles;

    }

    public Map<Long, IssuedVehicle> initIssuedVehicles() {

        Map<Long, IssuedVehicle> issuedVehicles = new HashMap();
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

		/* Create dummy data by randomly combining first and last names */
        List<Object[]> vehicleTypes = new ArrayList();
            vehicleTypes.add(new Object[]{1L, "BK-123", "Dennis Löhmann / DLO", "Holisticon HQ", "Bremen", "21.02.2014", "22.02.2014", "21.02.2014", "22.02.2014", "Kompakt", "VW Golf", "Schwarz", "HH-HQ 345", "0", "10000"});

        for (Object[] vehicleString : vehicleTypes) {


            Long vehicleId = (Long) vehicleString[0];
            int i= 1;
            IssuedVehicle v = new IssuedVehicle();
            v.setId(vehicleId);
            v.setBookingNumber((String) vehicleString[1]);
            v.setUser((String) vehicleString[2]);
            v.setParkingLot((String) vehicleString[3]);
            v.setDestination((String) vehicleString[4]);
            try {
            v.setBookedFrom((String) vehicleString[5]);
            v.setBookedTo((String) vehicleString[6]);
            v.setLentFrom((String) vehicleString[7]);
            v.setLentTo((String) vehicleString[8]);
            } catch (Exception e) {
               e.printStackTrace();
            }
            v.setVehicleCategory((String) vehicleString[9]);
            v.setVehicleType((String) vehicleString[10]);
            v.setVehicleColour((String) vehicleString[11]);
            v.setVehicleLicenseNumber((String) vehicleString[12]);
            v.setVehicleFuelUp((String) vehicleString[13]);
            v.setVehicleMileage((String) vehicleString[14]);
            issuedVehicles.put(vehicleId, v);

        }
        return issuedVehicles;

    }


    public Map<Long, UserData> initUserData() {
        Map<Long, de.holisticon.tracee.carbookingsample.service.ServiceObjects.UserData> usersData = new HashMap();
        List<Object[]> users = new ArrayList();
        users.add(new Object[]{1L, "Dennis Löhmann", "DLO", "Holisticon HQ"});
        users.add(new Object[]{2L, "User 2", "u2", "Holisticon HQ"});
        users.add(new Object[]{3L, "User 3", "u3", "Holisticon HQ"});

        for (Object[] userString : users) {
            Long id = (Long) userString[0];
            UserData u = new UserData();
            u.setId(id);
            u.setName((String) userString[1]);
            u.setNameAbbr((String) userString[2]);
            u.setLocationName((String) userString[3]);
            usersData.put(id, u);
        }
        return usersData;
    }

}
