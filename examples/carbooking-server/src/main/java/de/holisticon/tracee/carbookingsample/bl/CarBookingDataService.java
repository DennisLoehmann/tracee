package de.holisticon.tracee.carbookingsample.bl;

import de.holisticon.tracee.carbookingsample.dl.DataSource;
import de.holisticon.tracee.carbookingsample.service.ServiceObjects.UserData;
import de.holisticon.tracee.carbookingsample.service.ServiceObjects.BookableVehicle;
import de.holisticon.tracee.carbookingsample.service.ServiceObjects.IssuedVehicle;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Map;

/**
 * Created by dennis on 13.03.14.
 */
@Named("carBookingDataService")
@Default
@ApplicationScoped
public class CarBookingDataService implements DataService {

    private @Inject DataSource ds;

    @Override
    public Map<Long, BookableVehicle> findBookableVehicles(Map parameter) {
        return ds.findBookableVehicles(parameter);
    }

    @Override
    public Map<Long, IssuedVehicle> findIssuedVehicles(Map parameter) {
        return ds.findIssuedVehicles(parameter);
    }

    @Override
    public UserData loadUserData(Long id) {
        return ds.loadUserData(id);
    }

    @Override
    public Map<Long, UserData> findUserData(Map parameters) {
        return ds.findUserData(parameters);
    }

    public DataSource getDs() {
        return ds;
    }

    @Inject
    public void setDs(DataSource ds) {
        this.ds = ds;
    }
}
