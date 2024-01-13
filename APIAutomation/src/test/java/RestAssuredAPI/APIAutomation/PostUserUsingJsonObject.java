package RestAssuredAPI.APIAutomation;

import org.testng.annotations.Test;
import org.json.simple.JSONObject;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostUserUsingJsonObject {

    int id;

	@Test
    void createUserUsingJson()
	{
        JSONObject data = new JSONObject();

        data.put("name", "scott");
        data.put("location", "Bagalkot");
        data.put("phone", "123456");

        String[] courseArr = {"c", "python"};
        data.put("courses", courseArr);

        id = given()
            .contentType("application/json")
            .body(data)
        .when()
            .post("https://reqres.in/api/users")
        .then()
            .log().all() // Log the response details
            .statusCode(201)
          // Correct assertion for the name
            .extract().jsonPath().getInt("id");
    }

    @Test
    void deleteUser() {
        given()
          .pathParam("id", id)
       .when()
          .delete("https://reqres.in/api/users/{id}")
       .then()
          .statusCode(204)
                .log().all();
    }
}
