package de.holisticon.tracee.carbookingsample.cl;

import de.holisticon.tracee.carbookingsample.bl.DataService;
import de.holisticon.tracee.carbookingsample.dl.DataSource;
import de.holisticon.tracee.carbookingsample.service.ServiceObjects.BookableVehicle;
import de.holisticon.tracee.carbookingsample.service.ServiceObjects.IssuedVehicle;
import de.holisticon.tracee.carbookingsample.service.ServiceObjects.UserData;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;
import java.util.Map;

/**
 * Created by dennis on 26.03.14.
 */

@Named("carBookingRestService")
@Default
@ApplicationScoped
public class BookingRestService implements DataService {

    @Context
    UriInfo uriInfo;
    @Context
    Request request;
    String id;
    public BookingRestService(UriInfo uriInfo, Request request, String id) {
        this.uriInfo = uriInfo;
        this.request = request;
        this.id = id;
    }

    private @Inject
    DataSource ds;

    //Application integration
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Override
    public Map<Long, BookableVehicle> findBookableVehicles(Map parameter) {
        return ds.findBookableVehicles(parameter);
    }

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Override
    public Map<Long, IssuedVehicle> findIssuedVehicles(Map parameter) {
        return ds.findIssuedVehicles(parameter);
    }

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Override
    public UserData loadUserData(Long id) {
        return ds.loadUserData(id);
    }

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
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
