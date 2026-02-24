package Lesson_22_JSONObjectClass;

import static io.restassured.RestAssured.given;

import org.json.JSONObject;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class JSONObjectClass {

	public static void main(String[] args) {
		JSONObject jb = new JSONObject();
		jb.put("name", "sneha");
		jb.put("gender", "male");
		jb.put("email", "testqa@test.com");
		jb.put("status","active");
		
		RestAssured.baseURI = "https://gorest.co.in";
		
		String response	= given()
			.contentType("application/json")
			.header("Authorization", "Bearer 8af20b2964cd45f048ef53597434f4ec543cea594989d05d236a08b08824edaf")
			.body(jb.toString())
			.when().post("/public/v2/users")
			.then().statusCode(201)
			.log().all().extract().response().asString();
			
	}

}
