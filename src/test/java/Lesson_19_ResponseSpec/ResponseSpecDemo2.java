package Lesson_19_ResponseSpec;

import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class ResponseSpecDemo2 {

	public static void main(String[] args) {
		
		//Create Object of ResponseSpecBuilder
		ResponseSpecBuilder responseBuilder = new ResponseSpecBuilder();
		responseBuilder
		.expectStatusCode(200)
		.expectStatusLine("HTTP/1.1 200 OK")
		.expectContentType("application/json");
		
		ResponseSpecification responseSpec  =responseBuilder.build();
		
		RestAssured.baseURI = "https://jobs.postmanatwork.com";

		// List All Jobs
		given().when().get("/jobs")
		.then().spec(responseSpec)
		.log().all();

		// List Jobs from Canada country
		given().queryParam("country", "CA")
		.when().get("/jobs")
		.then().spec(responseSpec)
		.log().all();
	}

}
