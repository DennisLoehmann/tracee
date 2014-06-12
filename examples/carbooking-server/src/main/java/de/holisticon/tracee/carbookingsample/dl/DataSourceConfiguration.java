package de.holisticon.tracee.carbookingsample.dl;

import javax.inject.Inject;

/**
 * Created by dennis on 06.03.14.
 */
public class DataSourceConfiguration {

    private static DataSource ds = null;

    public static DataSource getDataSource() {
        if (ds == null) {
            ds = new CarBookingDummyObjectDataSource();
        }
        return ds;
    }

}
