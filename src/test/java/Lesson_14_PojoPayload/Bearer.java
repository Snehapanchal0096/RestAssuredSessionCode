package Lesson_14_PojoPayload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class Bearer {
	
	public static void main(String[] args) {
		UserData us = new UserData();
		us.setName("Meet2");
		us.setEmail("meet2@gmail.com");
		us.setGender("male");
		us.setStatus("active");
		
		RestAssured.baseURI = "https://gorest.co.in";
		
	String response	= given().contentType("application/json")
		.header("Authorization", "Bearer 8af20b2964cd45f048ef53597434f4ec543cea594989d05d236a08b08824edaf")
		.body(us)
		.when().post("/public/v2/users")
		.then().statusCode(201)
		.log().all().extract().response().asString();
		
		JsonPath js = new JsonPath(response);
		String id = js.getString("id");
		System.out.println("ID : -"+id);
		
		/*{
    "id": 8316387,
    "name": "Tenaliasa Ramakrishna",
    "email": "tenali23.ramakrishna@15ce.com",
    "gender": "male",
    "status": "active"
}
ID : -8316387*/
	}

}
