package Lesson_25_JsonObjectNestedJson;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

import org.json.JSONObject;

import com.github.javafaker.Faker;

public class JsonObjectNestedJsonDemo {

	public static void main(String[] args) {
		JSONObject product = new JSONObject();
		JSONObject data = new JSONObject();
		Faker fake = new Faker();
		product.put("name", "Dell Aura");
		product.put("data", data);
		data.put("year", fake.number().digits(4));
		data.put("price", 230.33);
		data.put("CPU Model", "i55");
		data.put("Hard Disk Size", "55 TB");
		
	
		RestAssured.baseURI = "https://api.restful-api.dev";
		given()
		.header("Content-Type", "application/json")
		.body(product.toString()) //can't pass direct object
		.when().post("/objects")
		.then().statusCode(200)
		.log().all();
		
	}

}
