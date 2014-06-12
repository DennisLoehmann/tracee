package de.holisticon.tracee.carbookingsample.test;

import de.holisticon.tracee.carbookingsample.bl.DataService;
import org.cdisource.beancontainer.BeanContainer;
import org.cdisource.beancontainer.BeanContainerManager;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by dennis on 20.03.14.
 */
public class TestDummyDataSources {

    static BeanContainer beanContainer =  BeanContainerManager.getInstance();


    @Test
    public void testBookableVehiclesDatasourceReturnsNotNull() {
        Map searchParams = new HashMap();

        DataService ds = (DataService) beanContainer
                .getBeanByName("carBookingDataService");

        //AutomatedTellerMachine atm = beanContainer.getBeanByType(AutomatedTellerMachine.class);

        assertNotNull(ds.findBookableVehicles(searchParams));
    }

    @Test
    public void testIssuedVehiclesDatasourceReturnsNotNull() {
        Map searchParams = new HashMap();

        DataService ds = (DataService) beanContainer
                .getBeanByName("carBookingDataService");

        //AutomatedTellerMachine atm = beanContainer.getBeanByType(AutomatedTellerMachine.class);

        assertNotNull(ds.findIssuedVehicles(searchParams));
    }

    @Test
    public void testUserDataDatasourceReturnsNotNull() {
        Map searchParams = new HashMap();

        DataService ds = (DataService) beanContainer
                .getBeanByName("carBookingDataService");

        //AutomatedTellerMachine atm = beanContainer.getBeanByType(AutomatedTellerMachine.class);
        Map userData = ds.findUserData(searchParams);
        System.out.println(userData);
        assertNotNull(ds.findUserData(searchParams));
    }

}
