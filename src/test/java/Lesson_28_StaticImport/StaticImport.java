package Lesson_28_StaticImport;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import static org.hamcrest.Matchers.*;

public class StaticImport {

	public static void main(String[] args) {
		RestAssured.baseURI = "https://jobs.postmanatwork.com/";
		given().queryParam("country", "US")
		.when().get("/jobs")
		.then().statusCode(200)
		.body("country[0]", equalTo("US"))
		.log().all();
	}

	//Industry standard -- short, clean, and easy to maintain
	//improve Readability
}
