import static io.restassured.RestAssured.given;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class ApiJavaAutomationTest {

    public final static String URL = "https://reqres.in/";

    @Test
    public void getListUsers() {
        Response response = given().log().all().baseUri(URL).basePath("/api")
            .contentType(ContentType.JSON).accept(ContentType.JSON)
            .queryParam("page", 2)
            .get("/users");

        response.getBody().prettyPrint();

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
        Assert.assertEquals(response.path("page"), new Integer(2));
        System.out.println("The response status is " + statusCode);
    }


    @Test
    public void getSingleUser() {
        Response response = given().log().all().baseUri(URL).basePath("/api")
            .contentType(ContentType.JSON).accept(ContentType.JSON)
            .pathParam("userId", 2)
            .get("/users/{userId}");

        response.getBody().prettyPrint();

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
        System.out.println("The response status is " + statusCode);
    }


    @Test
    public void createUser() {

        String requestBody = "{\n"
            + "    \"name\": \"Tri Abror\",\n"
            + "    \"job\": \"SEIT\"\n"
            + "}";

        Response response = given().log().all().baseUri(URL).basePath("/api")
            .contentType(ContentType.JSON).accept(ContentType.JSON)
            .body(requestBody)
            .post("/users");

        response.getBody().prettyPrint();

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 201);
        System.out.println("The response status is " + statusCode);
    }


    @Test
    public void updateUser() {

        String requestBodyAdd = "{\n"
            + "    \"name\": \"Tri Abror\",\n"
            + "    \"job\": \"SEIT\"\n"
            + "}";

        String requestBodyUpdate = "{\n"
            + "    \"name\": \"Hendri\",\n"
            + "    \"job\": \"SEIT\"\n"
            + "}";

        Response responseAdd = given().log().all().baseUri(URL).basePath("/api")
            .contentType(ContentType.JSON).accept(ContentType.JSON)
            .body(requestBodyAdd)
            .post("/users");

        responseAdd.getBody().prettyPrint();

        Response responseUpdate = given().log().all().baseUri(URL).basePath("/api")
            .contentType(ContentType.JSON).accept(ContentType.JSON)
            .body(requestBodyUpdate)
            .pathParam("userId", responseAdd.path("id"))
            .put("/users/{userId}");

        responseUpdate.getBody().prettyPrint();

        int statusCode = responseUpdate.getStatusCode();
        Assert.assertEquals(statusCode, 200);
        System.out.println("The responseAdd status is " + statusCode);
    }


    @Test
    public void deleteeUser() {

        String requestBody = "{\n"
            + "    \"name\": \"Tri Abror\",\n"
            + "    \"job\": \"SEIT\"\n"
            + "}";

        Response responseAdd = given().log().all().baseUri(URL).basePath("/api")
            .contentType(ContentType.JSON).accept(ContentType.JSON)
            .body(requestBody)
            .post("/users");

        responseAdd.getBody().prettyPrint();

        Response responseDelete = given().log().all().baseUri(URL).basePath("/api")
            .contentType(ContentType.JSON).accept(ContentType.JSON)
            .pathParam("userId", responseAdd.path("id"))
            .delete("/users/{userId}");

        int statusCode = responseDelete.getStatusCode();
        Assert.assertEquals(statusCode, 204);
        System.out.println("The response status is " + statusCode);
    }

}
