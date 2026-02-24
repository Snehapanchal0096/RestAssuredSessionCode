package Lesson_21_JsonScema;

import io.restassured.RestAssured;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class SchemaValidation {

	public static void main(String[] args) {
		
		RestAssured.baseURI = "https://api.restful-api.dev";
		
		given()
		.when().get("/objects/7")
		.then()
		.statusCode(200)
		.body(matchesJsonSchemaInClasspath("productSchema.json"))
		.log().all();
	}

}
