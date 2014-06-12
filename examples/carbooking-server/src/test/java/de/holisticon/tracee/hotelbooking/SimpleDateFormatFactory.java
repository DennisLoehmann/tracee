package de.holisticon.tracee.hotelbooking;

import java.text.SimpleDateFormat;

/**
 * Created by dennis on 17.04.14.
 */
public class SimpleDateFormatFactory {

    public static final SimpleDateFormat EN_US_SHORTDATE = new SimpleDateFormat("dd/MM/yyyy");
    public static final SimpleDateFormat DE_DE_SHORTDATE = new SimpleDateFormat("dd.MM.yyyy");

    public static final SimpleDateFormat EN_US_SHORTDATETIME = new SimpleDateFormat("dd/MM/yyyy hh:mm");
    public static final SimpleDateFormat DE_DE_SHORTDATETIME = new SimpleDateFormat("dd.MM.yyyy hh:mm");

}
