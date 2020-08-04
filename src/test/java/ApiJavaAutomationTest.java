import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;

public class ApiJavaAutomationTest {
    final static String firstUrl = "http://dummy.restapiexample.com";
    final static String secondUrl = "https://reqres.in";

    /*
        Hallo ini adalah initial state terkait java rest assured kita.
        Coba run class ini, dan pastikan program berjalan dan menghasilkan
        output "The response status is 200".
        Segera kontak tim Atlas jika menemui kendala!

        Nantikan berbagai latihan dan problem set di kelas nanti!
     */

    @Test
    public void firstTrial(){
        Response response = given().baseUri(firstUrl).basePath("/api/v1").contentType(ContentType.JSON)
                .get("/employees");

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
        System.out.println("The response status is " +statusCode);
    }

    @Test
    public void getResponseBody(){

    }

    @Test
    public void getFirstEmployeeName(){

    }

    @Test
    public void tryQueryParameters(){

    }

    @Test
    public void tryPathParameters(){

    }

    @Test
    public void tryVerifyEmployee(){

    }

    @Test
    public void postCreateUser(){

    }

    @Test
    public void updateUser(){

    }

    @Test
    public void deleteEmployee(){

    }
}
