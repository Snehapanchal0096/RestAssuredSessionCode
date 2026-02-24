package Lesson_07_PatchRequest;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class PutRequest {

	public static void main(String[] args) {

		RestAssured.baseURI = "https://api.restful-api.dev";
		
		given().contentType("application/json").body("{\r\n"
				+ "   \"name\": \"Apple Iphone 313\",\r\n"
				+ "   \"data\": {\r\n"
				+ "      \"year\": 2025,\r\n"
				+ "      \"price\": 2049.99,\r\n"
				+ "      \"CPU model\": \"Intel Core 11\",\r\n"
				+ "      \"Hard disk size\": \"1 TB\",\r\n"
				+ "      \"color\": \"silver\"\r\n"
				+ "   }\r\n"
				+ "}")
		.when().put("/objects/ff8081819782e69e019b79afd368298f")
		.then().log().all().statusCode(200);
	}

}
