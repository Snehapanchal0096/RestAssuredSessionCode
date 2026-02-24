package Lesson_24_FakerLibrary;

import static io.restassured.RestAssured.given;

import org.json.JSONObject;

import com.github.javafaker.Faker;

import io.restassured.RestAssured;

public class FakerLibrary {

	public static void main(String[] args) {
		Faker faker = new Faker();
		UserData us = new UserData();
		us.setName(faker.name().fullName());
		us.setGender("male");
		us.setEmail(faker.internet().emailAddress());
		us.setStatus("active");
		
		RestAssured.baseURI = "https://gorest.co.in";
		
		String response	= given()
			.contentType("application/json")
			.header("Authorization", "Bearer 8af20b2964cd45f048ef53597434f4ec543cea594989d05d236a08b08824edaf")
			.body(us)
			.when().post("/public/v2/users")
			.then().statusCode(201)
			.log().all().extract().response().asString();
	}
	
	/*
	 * faker.name().fullName()
faker.internet().emailAddress()
faker.name().username()
faker.phoneNumber().cellPhone()
faker.address().city()
faker.number().randomDigit()
faker.internet().password()
	 */

}
