package Lesson_03_pathParam;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

public class GetRequest_pathParam {

	public static void main(String[] args) {
		RestAssured.baseURI = "https://jobs.postmanatwork.com";
		
		given().pathParam("id", "WlExAIzPKApzbdq2ZDbnR")
		.when().get("/jobs/{id}")
		.then().log().all().statusCode(200);
	}

}
