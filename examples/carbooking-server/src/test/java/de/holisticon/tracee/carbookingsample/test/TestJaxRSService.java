package de.holisticon.tracee.carbookingsample.test;

import de.holisticon.tracee.carbookingsample.cl.BookingRestService;
import org.cdisource.beancontainer.BeanContainer;
import org.cdisource.beancontainer.BeanContainerManager;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertNotNull;

/**
 * Created by dennis on 26.03.14.
 */
public class TestJaxRSService {

    static BeanContainer beanContainer =  BeanContainerManager.getInstance();

    @Before
    public void setUp() {
    }

    @Test
    public void testServiceProviderGetsBookableVehicles() {

            Map searchParams = new HashMap();

            BookingRestService br = (BookingRestService) beanContainer
                    .getBeanByName("carBookingRestService");

            //AutomatedTellerMachine atm = beanContainer.getBeanByType(AutomatedTellerMachine.class);

            assertNotNull(br.findBookableVehicles(searchParams));
    }

}
