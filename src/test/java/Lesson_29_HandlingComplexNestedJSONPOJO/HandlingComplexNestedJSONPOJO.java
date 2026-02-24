package Lesson_29_HandlingComplexNestedJSONPOJO;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;

public class HandlingComplexNestedJSONPOJO {

	public static void main(String[] args) {
		
		RestAssured.baseURI = "api.example.com";
		APIResponse response = given()
		.when()
		.get("users/101")
		.then()
		.statusCode(200)
		.extract().as(APIResponse.class);
		
		response.getStatus();
		response.getUserdata().getAddress().getCity();
	
		
	}

}
