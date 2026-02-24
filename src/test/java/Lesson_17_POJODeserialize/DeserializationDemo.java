package Lesson_17_POJODeserialize;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import org.hamcrest.Matchers.*;


public class DeserializationDemo {

	public static void main(String[] args) {
		RestAssured.baseURI = "https://jobs.postmanatwork.com";
	
		JobData[] joblist = given().contentType("Application/json")
		.when().get("/jobs")
		.then().statusCode(200).log().all()
		.extract().as(JobData[].class);
		
		System.out.println("total record : "+joblist.length);
		System.out.println(joblist[23].getId());
	
	}

}
