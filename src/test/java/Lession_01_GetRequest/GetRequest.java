package Lession_01_GetRequest;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

public class GetRequest {

	public static void main(String[] args) {

		RestAssured.baseURI = "https://jobs.postmanatwork.com";

		// given - input, when - action, then - response
		given()
		.when().get("/jobs") // Semicolon removed here
		.then().log().all().statusCode(200);
	}
}
