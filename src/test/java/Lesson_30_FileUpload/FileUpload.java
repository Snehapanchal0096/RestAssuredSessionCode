package Lesson_30_FileUpload;

import java.io.File;

import javax.mail.Multipart;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

public class FileUpload {

	public static void main(String[] args) {

		File file = new File("E:\\eclipse_backUP\\Automation_Java\\RestAssureSession\\fileUploadData\\playwrightQA.pdf");
		
		given()
		.baseUri("https://example.com")
		.multiPart("file", file)
		.when()
		.post("/uploadFile")
		.then().statusCode(200);
	}

}
