package Lesson_19_ResponseSpec;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class ResponseSpecDemo {

	public static void main(String[] args) {
		RestAssured.baseURI = "https://jobs.postmanetwork.com";

		// List All Jobs
		given().when().get("/jobs")
		.then().statusCode(200).statusLine("HTTP/1.1 200 OK")
		.contentType("application/json")
				.log().all();

		// List Jobs from Canada country
		given().queryParam("country", "CA")
		.when().get("/jobs")
		.then().statusCode(200).statusLine("HTTP/1.1 200 OK")
				.contentType("application/json").log().all();
	}

}
