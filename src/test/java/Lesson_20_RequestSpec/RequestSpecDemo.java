package Lesson_20_RequestSpec;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.apache.http.client.methods.RequestBuilder;


public class RequestSpecDemo {

	public static void main(String[] args) {
		
		RequestSpecBuilder requestbuilder = new RequestSpecBuilder();
		requestbuilder
		.setBaseUri("https://jobs.postmanatwork.com")
		.setBasePath("/jobs")
		.setContentType("application/json");
		
	 RequestSpecification requestspec = requestbuilder.build();
		
	 //list of all jobs	 
	 given()
	 .spec(requestspec)
	 .when().get()
	 .then().statusCode(200).log().all();
	 
	 //list of jobs from Canada
	 System.out.println("--------------------------------");
	 given()
	 .spec(requestspec)
	 .queryParam("country", "CA")
	 .when().get()
	 .then().statusCode(200).log().all();
	 
	}

}
