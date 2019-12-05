package cn.fxbin.apitest

import spock.lang.Specification
import static io.restassured.RestAssured.given

class BookDemo extends Specification {

    def "should get book details by book name successfully" () {
        given: "no given"
        when: "call get user by name api"
        given().baseUri("http://localhost:9090/").log().all()
                .when()
                .pathParam("bookName",bookName)
                .get("api/getBook/{bookName}")
                .then()
                .assertThat().statusCode(200)
        then: "no then"
        where:                            //固定写法，where：后面跟测试用例需要的测试数据
        bookName|placeHolder             //固定写法，多个参数之间用“|”隔开，且至少要有一个“|”，所以如果只有一个输入参数“|”后面可以写个placeHolder
//        "TOM"|""
//        "Dave"|""
        "tom"|""
        "dave"|""
    }

    def "should call get book by name and price api successfully"() {
        given: "no given"
        when: "call mock api api"
        given().baseUri("http://localhost:9090").log().all()
                .queryParam("name","sanguo")         //设置接口的查询参数
                .queryParam("price",18)              //设置接口的查询参数
                .when()
                .get("api/getBookByPathPatter/test")
                .then()
                .assertThat().statusCode(200)
        then: "no then"
    }



}
