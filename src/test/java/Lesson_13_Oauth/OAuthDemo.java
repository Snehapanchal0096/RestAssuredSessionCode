package Lesson_13_Oauth;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class OAuthDemo {

	public static void main(String[] args) {
		String clientId = "";
		String ClientSecret = "";
		
		
		RestAssured.baseURI = "https://api-m.sandbox.paypal.com";
		String responseString = given()
		.auth().preemptive().basic(clientId, ClientSecret)
		.param("grant_type", "client_credentials")
		.when().post("/v1/oauth2/token")
		.then().statusCode(200).log().all().extract().asString();
		
		JsonPath jpath = new JsonPath(responseString);
		String accessToken = jpath.getString("access_token");
		String TokenType = jpath.getString("token_type");
		
		System.out.println(accessToken);
		System.out.println(TokenType);
		
		//API for Invoice List
		given()
		.contentType("application/json")
		.header("Authorization", TokenType+" "+accessToken)
		.when().get("v1/invoicing/invoices")
		.then().statusCode(200).log().all();

		
	}

}
