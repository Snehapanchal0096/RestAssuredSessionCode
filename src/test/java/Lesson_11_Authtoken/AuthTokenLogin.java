package Lesson_11_Authtoken;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.hamcrest.*;

public class AuthTokenLogin {

	public static void main(String[] args) {
		//			us - testclarus12@gmail.com , ps-Admin@1234 , API Key - 8a55f9475fee0c8f5270bc7e123dfbd8
//https://api.openweathermap.org/data/2.5/weather?q={city name}&appid={API key}


		RestAssured.baseURI = "https://api.openweathermap.org";
		
		given().queryParam("q", "Ahmedabad")
		.queryParam("appid", "8a55f9475fee0c8f5270bc7e123dfbd8")
		.when().get("/data/2.5/weather")
		.then().statusCode(200).log().all();
			

		
	}

}
