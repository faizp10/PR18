package tests;

import org.apache.http.HttpResponse;
import org.junit.Assert;
import org.junit.Test;
import utils.ApiClient;

import java.io.IOException;

public class TestCases {

    @Test
    public void testPositiveCase() throws IOException {
        HttpResponse response = ApiClient.get("http://example.com/api/endpoint");
        int statusCode = response.getStatusLine().getStatusCode();
        Assert.assertEquals(200, statusCode);
    }

    @Test
    public void testNegativeCase() throws IOException {
        HttpResponse response = ApiClient.get("http://example.com/api/invalid-endpoint");
        int statusCode = response.getStatusLine().getStatusCode();
        Assert.assertNotEquals(200, statusCode);
    }

    @Test
    public void testBoundaryCase() throws IOException {
        HttpResponse response = ApiClient.get("http://example.com/api/boundary-endpoint");
        int statusCode = response.getStatusLine().getStatusCode();
        // Assert boundary conditions
    }
}
