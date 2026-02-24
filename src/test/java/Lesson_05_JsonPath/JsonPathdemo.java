package Lesson_05_JsonPath;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.List;

public class JsonPathdemo {

	public static void main(String[] args) {
		RestAssured.baseURI = "https://api.restful-api.dev";

		String response = given()
		.when().get("/objects")
		.then().extract().response().asString();
		
		JsonPath jpath = new JsonPath(response);
		System.out.println(jpath.getString("name[0]"));
		System.out.println(jpath.getString("data.color[2]"));
	
		List<String> namelist = jpath.getList("name");
		System.out.println(namelist);
		
		System.out.println(jpath.getFloat("data[3].price"));
		
	}

}
