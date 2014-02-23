package de.holisticon.util.tracee.outbound.httpclient;

import de.holisticon.util.tracee.SimpleTraceeBackend;
import de.holisticon.util.tracee.Tracee;
import de.holisticon.util.tracee.TraceeBackend;
import de.holisticon.util.tracee.TraceeConstants;
import org.apache.http.HttpRequest;
import org.apache.http.message.BasicHttpRequest;
import org.apache.http.protocol.HttpContext;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.mock;

/**
 * @author Daniel Wegener (Holisticon AG)
 */
public class TraceeHttpRequestInterceptorTest {

	final SimpleTraceeBackend backend = SimpleTraceeBackend.createNonLoggingAllPermittingBackend();
	final TraceeHttpRequestInterceptor unit = new TraceeHttpRequestInterceptor(backend);

    @Test
    public void testProcess() throws Exception {
        final HttpRequest httpRequest = new BasicHttpRequest("GET", "http://localhost/pew");

        backend.put("foo", "bar");

        unit.process(httpRequest, mock(HttpContext.class));

        assertThat("HttpRequest has Tracee Header", httpRequest.containsHeader(TraceeConstants.HTTP_HEADER_NAME), equalTo(true));
        assertThat(httpRequest.getFirstHeader(TraceeConstants.HTTP_HEADER_NAME).getValue(), equalTo("{\"foo\":\"bar\"}"));
    }


}
