import static io.restassured.RestAssured.given;

import com.github.javafaker.Faker;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class ApiJavaAutomationTest {

  public final static String URL = "http://localhost:8080";

  //  faker untuk generate random data
  public Faker faker = new Faker();

  public String generateRandomName() {
    return faker.name().fullName();
  }

  public String generateRandomPassportNumber() {
    return faker.numerify("#########");
  }

  @Test
  public void getListStudents() {
    Response response = given().log().all().baseUri(URL)
        .contentType(ContentType.JSON).accept(ContentType.JSON)
        .queryParam("page", 2)
        .get("/students");

    response.getBody().prettyPrint();

    int statusCode = response.getStatusCode();
    Assert.assertEquals(200, statusCode);
    System.out.println("The response status is " + statusCode);
  }


  @Test
  public void getSingleStudent() {
    Response responseGetAll = given().log().all().baseUri(URL)
        .contentType(ContentType.JSON).accept(ContentType.JSON)
        .queryParam("page", 2)
        .get("/students");

    responseGetAll.getBody().prettyPrint();

    Response responseGetSingle = given().log().all().baseUri(URL)
        .contentType(ContentType.JSON).accept(ContentType.JSON)
        .pathParam("id", responseGetAll.path("id[0]"))
        .get("/students/{id}");

    responseGetSingle.getBody().prettyPrint();

    int statusCode = responseGetSingle.getStatusCode();
    Assert.assertEquals(200, statusCode);
    System.out.println("The response status is " + statusCode);
  }


  @Test
  public void addStudent() {

    String requestBody = "{\n"
        + "    \"name\": \"" + generateRandomName() + "\",\n"
        + "    \"passportNumber\": \"" + generateRandomPassportNumber() + "\"\n"
        + "}";

    Response response = given().log().all().baseUri(URL)
        .contentType(ContentType.JSON).accept(ContentType.JSON)
        .body(requestBody)
        .post("/students");

    response.getBody().prettyPrint();

    int statusCode = response.getStatusCode();
    Assert.assertEquals(200, statusCode);
    System.out.println("The response status is " + statusCode);
  }


  @Test
  public void updateStudent() {
    Response responseGetAll = given().log().all().baseUri(URL)
        .contentType(ContentType.JSON).accept(ContentType.JSON)
        .queryParam("page", 2)
        .get("/students");

    responseGetAll.getBody().prettyPrint();

    String requestBody = "{\n"
        + "    \"name\": \"" + generateRandomName() + "\",\n"
        + "    \"passportNumber\": \"" + generateRandomPassportNumber() + "\"\n"
        + "}";

    Response responseUpdate = given().log().all().baseUri(URL)
        .contentType(ContentType.JSON).accept(ContentType.JSON)
        .body(requestBody)
        .pathParam("id", responseGetAll.path("id[0]"))
        .put("/students/{id}");

    responseUpdate.getBody().prettyPrint();

    int statusCode = responseUpdate.getStatusCode();
    Assert.assertEquals(200, statusCode);
    System.out.println("The responseAdd status is " + statusCode);
  }


  @Test
  public void deleteStudent() {

    Response responseGet = given().log().all().baseUri(URL)
        .contentType(ContentType.JSON).accept(ContentType.JSON)
        .queryParam("page", 2)
        .get("/students");

    responseGet.getBody().prettyPrint();

    Response responseDelete = given().log().all().baseUri(URL)
        .contentType(ContentType.JSON).accept(ContentType.JSON)
        .pathParam("id", responseGet.path("id[0]"))
        .delete("/students/{id}");

    int statusCode = responseDelete.getStatusCode();
    Assert.assertEquals(200, statusCode);
    System.out.println("The response status is " + statusCode);
  }

}
