package defaultrequest;

import static io.restassured.RestAssured.given;

import configuration.DataConfiguration;
import constant.ApiConstants;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class DefaultRequest {

  public RequestSpecification service(){
//    return given().log().all().baseUri(ApiConstants.URL)
//        .contentType(ContentType.JSON).accept(ContentType.JSON);
    DataConfiguration dataConfiguration = new DataConfiguration();

    return given().log().all()
        .baseUri(dataConfiguration.getData("url"))
        .contentType(ContentType.JSON).accept(ContentType.JSON);
  }
}
