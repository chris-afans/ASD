package edu.miu.cs.cs489.lab11;

import edu.miu.cs.cs489.lab11.controller.PatientController;
import edu.miu.cs.cs489.lab11.model.Patient;
import edu.miu.cs.cs489.lab11.service.PatientService;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpHeaders;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class PatientControllerTest {

    @Mock
    private PatientService patientService;

    @InjectMocks
    private PatientController patientController;

    private static final String URL = "http://localhost:8080/adsweb/api/v1/patient/list";
    private CloseableHttpClient httpClient;
    private CloseableHttpResponse httpResponse;

    @Before
    public final void setUp() {
        httpClient = HttpClientBuilder.create().build();
    }

    @Test
    public void testPatientList() throws IOException {
        httpClient = HttpClients.custom().build();
        final HttpGet request = new HttpGet(URL);
        httpResponse = httpClient.execute(request);
        assertEquals(httpResponse.getStatusLine()
                .getStatusCode(), 200);

    }
}
