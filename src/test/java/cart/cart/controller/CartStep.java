package cart.cart.controller;

import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.springframework.http.MediaType;

import java.util.HashMap;
import java.util.Map;

public final class CartStep {

    public static ExtractableResponse<Response> 장바구니_추가_API_요청(String email, String password, long productId) {
        Map<String, String> params = new HashMap<>();
        params.put("productId", String.valueOf(productId));

        return RestAssured
                .given().log().all()
                .auth()
                .preemptive()
                .basic(email, password)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .body(params)
                .when().post("/carts")
                .then().log().all()
                .extract();
    }

    public static ExtractableResponse<Response> 장바구니_조회_API_요청(String email, String password, long productId) {
        return RestAssured
                .given().log().all()
                .auth()
                .preemptive()
                .basic(email, password)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .when().get("/carts")
                .then().log().all()
                .extract();
    }
}
