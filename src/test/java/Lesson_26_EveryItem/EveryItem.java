package Lesson_26_EveryItem;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class EveryItem {

	public static void main(String[] args) {
		RestAssured.baseURI = "https://jobs.postmanatwork.com";
		given()
		.queryParam("country", "US")
		.when().get("/jobs")
		.then().log().all().body("country", everyItem(equalTo("US")));
		
		
	}

}
