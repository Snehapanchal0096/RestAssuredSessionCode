package Lesson_27_RegexDyanamicValidation;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.hamcrest.text.MatchesPattern;

import Lesson_26_EveryItem.EveryItem;

public class RegexValidationDemo {

	public static void main(String[] args) {

		RestAssured.baseURI = "https://jobs.postmanatwork.com/";
		
		given().queryParam("country", "US")
		.when().get("/jobs")
		.then().log().all()
		.statusCode(200)
		.body("id", everyItem(matchesPattern("[A-Za-z0-9-_]{21}")))
		.body("url", everyItem(matchesPattern("https://www.postman.com/company/careers/[a-z-]+\\d{10}")))
		.body("created_at", everyItem(matchesPattern("\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}\\.\\d{3}Z")));	}

}
