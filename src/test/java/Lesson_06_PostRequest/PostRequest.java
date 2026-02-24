package Lesson_06_PostRequest;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PostRequest {

	public static void main(String[] args) {

		RestAssured.baseURI = "https://api.restful-api.dev";

		//String response = 
				given().contentType("application/json").body(
				"{\r\n" + "   \"name\": \"Apple Iphone 33\",\r\n" + "   \"data\": {\r\n" + "      \"year\": 2025,\r\n"
						+ "      \"price\": 2100.23,\r\n" + "      \"CPU model\": \"Intel Core 11\",\r\n"
						+ "      \"Hard disk size\": \"2 TB\"\r\n" + "   }\r\n" + "}")
				.when().post("/objects")
				.then().log().all()
				.statusCode(200).body("name", equalTo("Apple Iphone 33"));
	}

}
