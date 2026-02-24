package Lesson_04_ValidateResponse;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class ValidateResponse {

	public static void main(String[] args) {
		RestAssured.baseURI = "https://api.restful-api.dev";

		given()
		.when().get("/objects/7")
		.then().log().all().statusCode(200)
		.statusLine("HTTP/1.1 200 OK")
		.body("id", equalTo("7"))
		.body("data.year", equalTo(2019))
		.header("Content-Type", equalTo("application/json"))
		.time(lessThan(1000L));

	}

}
