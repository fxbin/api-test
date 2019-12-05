package cn.fxbin.apitest

import io.restassured.module.jsv.JsonSchemaValidator

import static io.restassured.RestAssured.given
import static org.hamcrest.Matchers.*


/**
 * ResumeClient
 *
 * @author fxbin
 * @version v1.0
 * @since 2019/12/4 19:07
 */
class ResumeClient {

    def getResumeDetails(){
        def res = given().baseUri("http://localhost:9090")
                .when()
                .get("/api/getResume")
                .then().assertThat().statusCode(200)
                .extract().response().getBody().asString()       //获取接口的response body
        res
    }

    void getResumeDetails2() {
        given().baseUri("http://localhost:9090")
                .when().log().all()
                .get("/api/getResume")
                .then().body("name", equalTo("TOM"))
//                .body("name").equals("TOM")    //校验response中名称是否是TOM
    }

    def getResumeDetails3() {
        given().baseUri("http://localhost:9090")
                .when()
                .get("/api/getResume")
                .then().assertThat().statusCode(200)
                .extract()
                .response().path("contacts.phone")   // 返回reponse中的所有phone信息
    }

    def getResumeDetailHeader() {
        given().baseUri("http://localhost:9090")
                .when()
                .get("/api/getResume")
                .then().assertThat().statusCode(200)
                .extract()
                .response().getHeader("content-type")   //获取header中content-type值
    }

    def getResumeSchemaValidate(filePath) {
        given().baseUri("http://localhost:9090").log().all()
                .when()
                .get("/api/getResume")
                .then().assertThat()
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath((String) filePath))    //在调用接口时通过matchsJsonSchemaInClassPath校验接口的response schema
    }

    def getResume2() {
        def payLoad=  given().baseUri("http://localhost:9090")
                .when()
                .get("/api/getResume2")
                .then().assertThat().statusCode(200)
                .extract()
                .response()
                .path("payLoad")            //返回接口response中payLoad的值
        payLoad
    }


}
