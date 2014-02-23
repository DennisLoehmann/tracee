package de.holisticon.util.tracee.servlet;

import de.holisticon.util.tracee.*;
import de.holisticon.util.tracee.transport.HttpJsonHeaderTransport;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

import static org.hamcrest.Matchers.hasEntry;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


/**
 * @author Daniel Wegener (Holisticon AG)
 */
public class TraceeFilterTest {

    private final SimpleTraceeBackend backend = SimpleTraceeBackend.createNonLoggingAllPermittingBackend();
    private final TraceeFilter unit = new TraceeFilter();
    private final FilterChain filterChain = Mockito.mock(FilterChain.class);
    private final HttpServletRequest httpServletRequest = Mockito.mock(HttpServletRequest.class);
    private final HttpServletResponse httpServletResponse = Mockito.mock(HttpServletResponse.class);
	private final TraceeLoggerFactory traceeLoggerFactory = Mockito.mock(TraceeLoggerFactory.class);
	private final HttpJsonHeaderTransport transport =  new HttpJsonHeaderTransport(traceeLoggerFactory);

    @Before
    public void setUp() throws ServletException {
		unit.backend = backend;
		unit.httpJsonHeaderSerialization = transport;
    }

    @Test
    public void testDoFilterRespondsWithRequestId() throws Exception {
		when(httpServletRequest.getHeaders(TraceeConstants.HTTP_HEADER_NAME)).thenReturn(Utilities.toEnumeration(Arrays.asList()));
        unit.doFilter(httpServletRequest,httpServletResponse, filterChain);
		verify(filterChain).doFilter(any(ServletRequest.class), any(ServletResponse.class));
		verify(httpServletResponse).setHeader(eq(TraceeConstants.HTTP_HEADER_NAME),
                contains("\"" + TraceeConstants.REQUEST_ID_KEY + "\":\""));
    }

	@Test
	public void testAcceptIncomingRequestId() throws Exception {
		when(httpServletRequest.getHeaders(TraceeConstants.HTTP_HEADER_NAME)).thenReturn(Utilities.toEnumeration(
				Arrays.asList("{ \""+TraceeConstants.REQUEST_ID_KEY+"\":\"123\"}")));

		unit.doFilter(httpServletRequest, httpServletResponse, filterChain);

		assertThat(backend.getValuesBeforeLastClear(), hasEntry(TraceeConstants.REQUEST_ID_KEY, "123"));

		verify(httpServletResponse).setHeader(eq(TraceeConstants.HTTP_HEADER_NAME),
				contains("\"" + TraceeConstants.REQUEST_ID_KEY + "\":\""));
	}




}
