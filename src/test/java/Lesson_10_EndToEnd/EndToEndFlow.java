package Lesson_10_EndToEnd;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.hamcrest.*;

import groovyjarjarantlr4.v4.runtime.misc.EqualityComparator;

public class EndToEndFlow {

	public static void main(String[] args) {
		
		//Create Product  - post
		RestAssured.baseURI = "https://api.restful-api.dev";
		
		String createProductResponse= given().contentType("application/json")
		.body("{\r\n"
				+ "   \"name\": \"Apple MacBook Pro 19\",\r\n"
				+ "   \"data\": {\r\n"
				+ "      \"year\": 2026,\r\n"
				+ "      \"price\": 1849.99,\r\n"
				+ "      \"CPU model\": \"Intel Core i9\",\r\n"
				+ "      \"Hard disk size\": \"1 TB\"\r\n"
				+ "   }\r\n"
				+ "}")
		.when().post("/objects")
		.then().statusCode(200).log().all().extract().response().asString();
		
		//Extract product ID
		
		JsonPath js = new JsonPath(createProductResponse);
		String Prod_id = js.getString("id");
		
		//validation of Product by its ID using Get
		
		given().when().get("objects/"+Prod_id+"")
		.then().statusCode(200)
		.body("id", equalTo(Prod_id)).log().all();
		
		//update request using PUT request
		given().contentType("Application/json")
		.body("{\r\n"
				+ "   \"name\": \"Apple MacBook Pro 16\",\r\n"
				+ "   \"data\": {\r\n"
				+ "      \"year\": 2019,\r\n"
				+ "      \"price\": 2049.99,\r\n"
				+ "      \"CPU model\": \"Intel Core i9\",\r\n"
				+ "      \"Hard disk size\": \"1 TB\",\r\n"
				+ "      \"color\": \"silver\"\r\n"
				+ "   }\r\n"
				+ "}")
		.when().put("objects/"+Prod_id+"").then().statusCode(200)
		.body("name", equalTo("Apple MacBook Pro 16")).log().all();	
	
		//Delete product using Delete Method
		given().when().delete("objects/"+Prod_id+"")
		.then().statusCode(200).log().all()
		.body("message", equalTo("Object with id = "+Prod_id+" has been deleted."));
	
		//Confirm Product deletion
		given().when().get("objects/"+Prod_id+"")
		.then().statusCode(404).log().all()
		.body("error", equalTo("Oject with id="+Prod_id+" was not found."));

	
	}

}
