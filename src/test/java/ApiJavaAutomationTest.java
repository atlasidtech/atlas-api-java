import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class ApiJavaAutomationTest {
    final static String url = "http://dummy.restapiexample.com";

    /*
        Hallo ini adalah initial state terkait java rest assured kita.
        Coba run class ini, dan pastikan program berjalan dan menghasilkan
        output "The response status is 200".
        Segera kontak tim Atlas jika menemui kendala!

        Nantikan berbagai latihan dan problem set di kelas nanti!
     */

    @Test
    public void percobaanPertama(){
        Response response = given().baseUri(url).basePath("/api/v1").contentType(ContentType.JSON)
                .get("/employees");

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
        System.out.println("The response status is " +statusCode);
    }
}
