package Lession_02_queryParam;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

public class GetRequestQueryParam {

	public static void main(String[] args) {
		RestAssured.baseURI = "https://jobs.postmanatwork.com";
		
		given().queryParams("location", "San Francisco", "country", "US")
		.when().get("/jobs")
		.then().log().all().statusCode(200);
	}

}
