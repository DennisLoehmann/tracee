package io.tracee.contextlogger.data.subdata.tracee;

import io.tracee.contextlogger.api.TraceeContextLogProvider;
import io.tracee.contextlogger.api.TraceeContextLogProviderMethod;
import io.tracee.contextlogger.api.WrappedContextData;
import io.tracee.contextlogger.data.Order;
import io.tracee.contextlogger.data.subdata.aspectj.AspectjProceedingJoinPointContextProvider;
import io.tracee.contextlogger.data.wrapper.WatchdogDataWrapper;
import io.tracee.contextlogger.profile.ProfilePropertyNames;

/**
 * Watchdog context data provider.
 * Created by Tobias Gindler, holisticon AG on 17.03.14.
 */
@SuppressWarnings("unused")
@TraceeContextLogProvider(displayName = "watchdog", order = Order.WATCHDOG)
public final class WatchdogContextProvider implements WrappedContextData<WatchdogDataWrapper> {

    private WatchdogDataWrapper watchdogDataWrapper;

    public WatchdogContextProvider() {
    }

    @SuppressWarnings("unused")
    public WatchdogContextProvider(final WatchdogDataWrapper watchdogDataWrapper) {
        this.watchdogDataWrapper = watchdogDataWrapper;
    }

    @Override
    public void setContextData(Object instance) throws ClassCastException {
        this.watchdogDataWrapper = (WatchdogDataWrapper) instance;
    }

    @Override
    public Class<WatchdogDataWrapper> getWrappedType() {
        return WatchdogDataWrapper.class;
    }

    @SuppressWarnings("unused")
    @TraceeContextLogProviderMethod(
            displayName = "id",
            propertyName = ProfilePropertyNames.WATCHDOG_ID,
            order = 10)
    public String getId() {
        if (watchdogDataWrapper != null) {
            return watchdogDataWrapper.getAnnotatedId();
        }
        return null;
    }

    @SuppressWarnings("unused")
    @TraceeContextLogProviderMethod(
            displayName = "aspectj.proceedingJoinPoint",
            propertyName = ProfilePropertyNames.WATCHDOG_ASPECTJ_CONTEXT,
            order = 20)
    public AspectjProceedingJoinPointContextProvider getProceedingJoinPoint() {
        if (watchdogDataWrapper != null && watchdogDataWrapper.getProceedingJoinPoint() != null) {
            return AspectjProceedingJoinPointContextProvider.wrap(watchdogDataWrapper.getProceedingJoinPoint());
        }
        return null;
    }

}
