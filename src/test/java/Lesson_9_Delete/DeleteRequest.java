package Lesson_9_Delete;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class DeleteRequest {

	public static void main(String[] args) {
		RestAssured.baseURI= "https://api.restful-api.dev";

	/*	given().contentType("application/json")
		.body("{\r\n"
				+ "   \"name\": \"Apple MacBook Pro 16\",\r\n"
				+ "   \"data\": {\r\n"
				+ "      \"year\": 2019,\r\n"
				+ "      \"price\": 1849.99,\r\n"
				+ "      \"CPU model\": \"Intel Core i9\",\r\n"
				+ "      \"Hard disk size\": \"1 TB\"\r\n"
				+ "   }\r\n"
				+ "}\r\n"
				+ "").when().post("/objects")
		.then().log().all().statusCode(200); */
		
		given()
		.when().delete("/objects/ff8081819782e69e019b7ad535ef2bd0")
		.then().log().all().statusCode(200);
		
		
	}

}
