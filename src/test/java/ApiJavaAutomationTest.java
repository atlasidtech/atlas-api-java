import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import com.github.javafaker.Faker;
import configuration.DataConfiguration;
import controller.StudentController;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import model.Student;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class ApiJavaAutomationTest {

  String test = "THIS IS THE LATEST VERSION";

  public final static String URL = "http://localhost:8080";

  //  faker untuk generate random data
  public Faker faker = new Faker();

  public String generateRandomName() {
    return faker.name().fullName();
  }

  public String generateRandomPassportNumber() {
    return faker.numerify("#########");
  }

  StudentController studentController = new StudentController();

  @Test
  public void getListStudents() {
    Response response = studentController.getAllStudent();

    int statusCode = response.getStatusCode();
    Assert.assertEquals(200, statusCode);
    System.out.println("The response status is " + statusCode);
  }

  @Test
  public void getSingleStudent() {
    Response responseGetAll = studentController.getAllStudent();

    Response responseGetSingle = studentController
        .getSingleStudent(responseGetAll.path("id[0]"));

    int statusCode = responseGetSingle.getStatusCode();
    Assert.assertEquals(200, statusCode);
    System.out.println("The response status is " + statusCode);

    Assert.assertThat(responseGetSingle.getBody().asString(),
        matchesJsonSchemaInClasspath("schemas/get-single-student.json"));

    
  }

  @Test
  public void addStudent() {
    //serialization
    Student studentRequest = new Student();

    DataConfiguration dataConfiguration = new DataConfiguration();

    studentRequest.setName(dataConfiguration.getData("name"));
    studentRequest.setPassportNumber(dataConfiguration.getData("passport"));

    Response response = studentController.addStudent(studentRequest);

    int statusCode = response.getStatusCode();
    Assert.assertEquals(200, statusCode);
    System.out.println("The response status is " + statusCode);

    //Deserialization
    Student studentResponse = response.getBody().as(Student.class);
    System.out.println("id: " + studentResponse.getId());
    System.out.println("name: " + studentResponse.getName());
    System.out.println("passport: " + studentResponse.getPassportNumber());
  }

  @Test
  public void updateStudent() {
    Response responseGetAll = studentController.getAllStudent();

    Student requestBody = new Student();
    requestBody.setName(generateRandomName());
    requestBody.setPassportNumber(generateRandomPassportNumber());

    Response responseUpdate = studentController
        .updateStudent(requestBody, responseGetAll.path("id[0]"));

    int statusCode = responseUpdate.getStatusCode();
    Assert.assertEquals(200, statusCode);
    System.out.println("The responseAdd status is " + statusCode);

    studentController.getAllStudent();
  }

  @Test
  public void deleteStudent() {
    Response responseGet = studentController.getAllStudent();

    Response responseDelete = studentController
        .deleteStudent(responseGet.path("id[0]"));

    int statusCode = responseDelete.getStatusCode();
    Assert.assertEquals(200, statusCode);
    System.out.println("The response status is " + statusCode);
  }

}
