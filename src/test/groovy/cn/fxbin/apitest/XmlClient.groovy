package cn.fxbin.apitest

import static io.restassured.RestAssured.given

/**
 * XmlClient
 *
 * @author fxbin
 * @version v1.0
 * @since 2019/12/4 20:18
 */
class XmlClient {

    def getXmlData() {
        def res = given().baseUri("http://localhost:9090")
                .when()
                .get("/api/getXmlData")
                .then().assertThat().statusCode(200)
                .extract().response().getBody().asString()    //获取接口的response body
        res
    }


    def addXmlData(reqBody,expectCode=200) {

        def res = given().baseUri("http://localhost:9090")
                .header("Content-Type", "application/xml;charset=utf-8")     //设置接口的content-type为“application/xml”
                .body(reqBody)
                .when()
                .post("/api/addXmlData/xml")
                .then().assertThat().statusCode(expectCode)
                .extract().response().getBody().asString()        //获取response body
        res
    }

}
