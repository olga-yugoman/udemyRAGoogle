package api.utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.Method;
import io.restassured.response.Response;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;

public class NetworkCore {

    protected Response response;
    protected RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
    protected JSONObject responseBody;

    public void sentRequestAndGetResponse(Method method, int code) {
        response = given().spec(requestSpecBuilder.build())
                .log().uri()
                .log().parameters()
                .when()
                .request(method);

        response.then().assertThat().statusCode(code);
    }
}
