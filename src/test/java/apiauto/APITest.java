package apiauto;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class APITest {

   @Test
    public void getUserTestPositive(){
        RestAssured.given().when().get("https://reqres.in/api/users/4")
                .then()
                .log().all();
    }
    @Test
    public void createNewUserTestPositive(){
        RestAssured.baseURI = "https://reqres.in/";
        String name = "Faiz";
        String job = "QA_Engineer";
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", name);
        jsonObject.put("job", job);
        given().log().all()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .body(jsonObject.toString())
                .post("api/users")
                .then()
                .assertThat().statusCode(201)
                .assertThat().body("name", Matchers.equalTo(name))
                .assertThat().body("job", Matchers.equalTo(job))
                .assertThat().body("$", Matchers.hasKey("id"))
                .assertThat().body("$", Matchers.hasKey("createdAt"));
   }

   @Test
   public void getUserTestNegative(){
       RestAssured.given().when().get("https://reqres.in/api/users/5a")
               .then()
               .log().all();
   }
   @Test
   public void createNewUserTestNegative(){
        RestAssured.baseURI = "https://reqres.in/";
        String name = " 12345 ";
        String job = "QA_Engineer";
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", name);
        jsonObject.put("job", job);
        given().log().all()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .body(jsonObject.toString())
                .post("api/users")
                .then()
                .assertThat().statusCode(201)
                .assertThat().body("name", Matchers.equalTo(name))
                .assertThat().body("job", Matchers.equalTo(job))
                .assertThat().body("$", Matchers.hasKey("id"))
                .assertThat().body("$", Matchers.hasKey("createdAt"));
    }
    @Test
    public void testMaxUserList(){
       RestAssured.baseURI = "https://reqres.in/";
       given().when().get("https://reqres.in/api/users?page=3")
               .then()
               .log().all();
    }
}

