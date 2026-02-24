package Lesson_16_PojoPayloadJsonArray;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.List;


public class JsonArrayPayload {
	
	public static void main(String[] args) {
		UserData us = new UserData();
		us.setName("MeetDesai2");
		us.setEmail("meetD2@gmail.com");
		us.setGender("male");
		us.setStatus("active");
		
		UserData us1 = new UserData();
		us1.setName("Seema2");
		us1.setEmail("Seema2@demo.com");
		us1.setGender("male");
		us1.setStatus("active");
		
		UserData us2 = new UserData();
		us2.setName("komalgupta");
		us2.setEmail("kgupta@demo.com");
		us2.setGender("male");
		us2.setStatus("inactive");
		
		List<UserData> userList =  new ArrayList<UserData>();
		userList.add(us);
		userList.add(us1);
		userList.add(us2);
		
		for(UserData ud :userList) {
		
			RestAssured.baseURI = "https://gorest.co.in";
			
			String response	= given().contentType("application/json")
				.header("Authorization", "Bearer 8af20b2964cd45f048ef53597434f4ec543cea594989d05d236a08b08824edaf")
				.body(ud)
				.when().post("/public/v2/users")
				.then().statusCode(201)
				.log().all().extract().response().asString();
				
				JsonPath js = new JsonPath(response);
				String id = js.getString("id");
				System.out.println("ID : -"+id);
				
		}
		
		
	}

}


/*{
"id": 8316387,
"name": "Tenaliasa Ramakrishna",
"email": "tenali23.ramakrishna@15ce.com",
"gender": "male",
"status": "active"
}
ID : -8316387*/
