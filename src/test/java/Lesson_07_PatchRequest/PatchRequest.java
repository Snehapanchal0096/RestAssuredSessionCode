package Lesson_07_PatchRequest;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class PatchRequest {

	public static void main(String[] args) {
		RestAssured.baseURI= "https://api.restful-api.dev";
	/*	
		given().contentType("application/json")
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
		
		//patch -  request
		
		given().contentType("application/json")
		.body("{\r\n"
				+ "   \"name\": \"Apple MacBook Pro 16 (Updated Name)\"\r\n"
				+ "}").when().patch ("/objects/ff8081819782e69e019b7acd2b682bcb")
		.then().log().all().statusCode(200);
	}

}
