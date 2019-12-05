package cn.fxbin.apitest

import static io.restassured.RestAssured.given

/**
 * UserClient
 *
 * @author fxbin
 * @version v1.0
 * @since 2019/12/4 17:37
 */
class UserClient {

    def addUserWithFile(File file) {

        def res = given().baseUri("http://localhost:9090").log().all()
                .when()
                .body(file)
                .header("Content-Type", "application/json; charset=UTF-8")
                //body参数中传入File对象
                .post("/api/addUserDetails")
                .then().assertThat().statusCode(200)
                .extract().response().getBody().asString()     //获取接口的response body
        res
    }

    def addUserWithString(String body) {
        def res = given().baseUri("http://localhost:9090").log().all()
                .when()
                .body(body)//body参数中传入接口的request body字符串
                .header("Content-Type", "application/json; charset=UTF-8")
                .post("/api/addUserDetails")
                .then().assertThat().statusCode(200)
                .extract().response().getBody().asString()  //获取接口的response body
        res
    }
}
