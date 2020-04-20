import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.Test;

public class test {
    public test() {
    }

    @Test
    public void user() {
        RestAssured.given().when().post("https://petstore.swagger.io/v2/user/createWithList", new Object[0]);
        RestAssured.
                given().
                when().
                get("https://petstore.swagger.io/v2/user/Skubidu", new Object[0]);
        RestAssured.
                given().
                put("https://petstore.swagger.io/v2/user/Skubidu", new Object[0]);
        ((ValidatableResponse)((ValidatableResponse)((Response)RestAssured.
                given().delete("https://petstore.swagger.io/v2/user/Skubidu", new Object[0])).
                then()).assertThat()).
                statusCode(404);
    }
}