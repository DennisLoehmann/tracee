package de.holisticon.tracee.carbookingsample.dl;

import javax.inject.Qualifier;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;


/**
 * Created by dennis on 20.03.14.
 */
@Qualifier
@Retention(RUNTIME) @Target({TYPE, METHOD, FIELD, PARAMETER})
public @interface Empty {
}