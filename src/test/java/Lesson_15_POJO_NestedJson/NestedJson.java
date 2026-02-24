package Lesson_15_POJO_NestedJson;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import org.hamcrest.Matchers.*;

public class NestedJson {

	public static void main(String[] args) {
		
		Product product = new Product();
		product.setName("Dell Sky11");
		
		Data data =  new Data();
		data.setYear(2015);
		data.setPrice(23000);
		data.setCPUmodel("I10");
		data.setHarddisksize("5 TB");
		
		product.setData(data);
		
		RestAssured.baseURI = "https://api.restful-api.dev";
		
	String response =	given().contentType("application/json")
		.body(product)
		.when().post("/objects")
		.then().statusCode(200)
		.log().all().extract().response().asString();
	
	System.out.println("Response : "+ response);
		
		
		
	}

}
