package controller;

import static io.restassured.RestAssured.given;

import constant.ApiConstants;
import defaultrequest.DefaultRequest;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import model.Student;

public class StudentController extends DefaultRequest {
//  public final static String URL = "http://localhost:8080";

  public Response getAllStudent(){
    Response response = service()
        .queryParam("page", 2)
        .get(ApiConstants.GET_ALL_STUDENT);

    response.getBody().prettyPrint();

    return response;
  }

  public Response getSingleStudent(Integer id){
    Response responseGetSingle = service()
        .pathParam("id", id)
        .get(ApiConstants.GET_SINGLE_STUDENT);

    responseGetSingle.getBody().prettyPrint();
    return responseGetSingle;
  }

  public Response addStudent(Student studentRequest){
    Response response = service()
        .body(studentRequest)
        .post(ApiConstants.ADD_SINGLE_STUDENT);

    response.getBody().prettyPrint();

    return response;
  }

  public Response updateStudent(Student studentRequest, Integer id) {
    Response responseUpdate = service()
        .body(studentRequest)
        .pathParam("id", id)
        .put(ApiConstants.UPDATE_SINGLE_STUDENT);

    responseUpdate.getBody().prettyPrint();

    return responseUpdate;
  }

  public Response deleteStudent(Integer id){
    Response responseDelete = service()
        .pathParam("id", id)
        .delete(ApiConstants.DELETE_SINGLE_STUDENT);

    responseDelete.getBody().prettyPrint();

    return responseDelete;
  }
}
