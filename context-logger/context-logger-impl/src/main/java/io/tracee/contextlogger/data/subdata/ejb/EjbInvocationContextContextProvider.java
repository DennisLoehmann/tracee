package io.tracee.contextlogger.data.subdata.ejb;

import io.tracee.contextlogger.api.TraceeContextLogProvider;
import io.tracee.contextlogger.api.TraceeContextLogProviderMethod;
import io.tracee.contextlogger.api.WrappedContextData;
import io.tracee.contextlogger.data.Order;
import io.tracee.contextlogger.data.subdata.NameStringValuePair;
import io.tracee.contextlogger.profile.ProfilePropertyNames;
import io.tracee.contextlogger.utility.RecursiveReflectionToStringStyle;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.interceptor.InvocationContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Context provider for ProceedingJoinPoint.
 * Created by Tobias Gindler, holisticon AG on 20.03.14.
 */
@TraceeContextLogProvider(displayName = "invocationContext", order = Order.EJB)
public class EjbInvocationContextContextProvider implements WrappedContextData<InvocationContext> {

    private InvocationContext invocationContext;

    public EjbInvocationContextContextProvider() {
    }

    public EjbInvocationContextContextProvider(final InvocationContext invocationContext) {
        this.invocationContext = invocationContext;
    }

    public final void setContextData(Object instance) throws ClassCastException {
        this.invocationContext = (InvocationContext) instance;
    }

    public final Class<InvocationContext> getWrappedType() {
        return InvocationContext.class;
    }

    @TraceeContextLogProviderMethod(displayName = "methodName", propertyName = ProfilePropertyNames.EJB_INVOCATION_CONTEXT_METHOD_NAME, order = 10)
    public final String getMethodName() {
        return this.invocationContext != null && this.invocationContext.getMethod() != null ? this.invocationContext.getMethod().getName() : null;
    }

    @TraceeContextLogProviderMethod(displayName = "parameters", propertyName = ProfilePropertyNames.EJB_INVOCATION_CONTEXT_PARAMETERS, order = 20)
    public final List<String> getParameters() {

        List<String> result = new ArrayList<String>();

        if (this.invocationContext != null) {
            for (Object parameter : invocationContext.getParameters()) {

                result.add(parameter != null ? parameter.toString() : null);

            }
        }

        return result.size() > 0 ? result : null;
    }

    @TraceeContextLogProviderMethod(displayName = "deserialized.targetInstance", propertyName = ProfilePropertyNames.EJB_INVOCATION_CONTEXT_TARGET_INSTANCE,
			order = 30)
    public final String getTargetInstance() {
        String result = null;
        if (this.invocationContext != null) {
            Object targetInstance = this.invocationContext.getTarget();
            if (targetInstance != null) {
                result = ReflectionToStringBuilder.reflectionToString(targetInstance, new RecursiveReflectionToStringStyle());
            } else {
                result = null;
            }
        }

        return result;
    }

    @TraceeContextLogProviderMethod(displayName = "deserialized.contextData", propertyName = ProfilePropertyNames.EJB_INVOCATION_CONTEXT_DATA, order = 40)
    public final List<NameStringValuePair> getContextData() {

        List<NameStringValuePair> result = new ArrayList<NameStringValuePair>();

        if (this.invocationContext != null) {

            for (Map.Entry<String, Object> entry : this.invocationContext.getContextData().entrySet()) {

                String key = entry.getKey();
                Object value = entry.getValue();

                final String deSerializedValue;
                if (value != null) {
                    deSerializedValue = ReflectionToStringBuilder.reflectionToString(value, new RecursiveReflectionToStringStyle());
                } else {
                    deSerializedValue = null;
                }

                result.add(new NameStringValuePair(key, deSerializedValue));


            }

        }

        return result.size() > 0 ? result : null;

    }

}
