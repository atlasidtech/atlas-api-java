import static io.restassured.RestAssured.*;

public class EmployeeTest {
    final static String url = "http://dummy.restapiexample.com";

    /*
        Hallo ini adalah initial state terkait java rest assured kita.
        Coba run class ini, dan pastikan program berjalan dan menghasilkan
        output "The response status is 200"

        Nantikan berbagai latihan dan problem set di kelas nanti!
     */

    public static void main(String args[]){
        checkConnection();
    }

    public static void checkConnection(){
        int statusCode =
                given()
                        .baseUri(url)
                        .basePath("/api/v1")
                .when()
                        .get("/employees")
                        .getStatusCode();
        System.out.println("The response status is "+statusCode);
    }
}
