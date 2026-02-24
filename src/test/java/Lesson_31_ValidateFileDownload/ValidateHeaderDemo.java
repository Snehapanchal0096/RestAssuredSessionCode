package Lesson_31_ValidateFileDownload;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.nio.file.Paths;

import org.apache.http.util.Asserts;
import org.hamcrest.text.MatchesPattern;

import com.google.common.io.Files;

import io.restassured.response.Response;

public class ValidateHeaderDemo {

	public static void main(String[] args) {
		
		  Response response = given().when().get("/download/invoice/101");
		   
		  Assert.assertEquals(response.getStatusCode(), 200);
		  
		  //Validate content-type 
		  Assert.assertEquals(response.getHeaders("Content-Type", "application/pdf"));
		  
		  //validate Content-Disposition
		  Assert.assertTrue(response.getHeader("Content-Disposition"), "attachement");
		  
		  //validate File Not Empty
		  //take the complete response body and convert it into raw binary format(array of bytes )
		  byt[] fileBytes = response.asByteArray();
		  Assert.asserttrue(fileBytes.length>0);
		  
		  //Save the File & validate 
		  //It will be saved in your current working directory
		  //Root of the prohect
		  Files.write(Paths.get("invoce101.pdf"), fileBytes);

		
	}

}
