package cn.fxbin.apitest

import groovy.json.JsonSlurper
import org.junit.Assert
import spock.lang.Specification
import static io.restassured.RestAssured.given

class BookCase extends Specification {

    //测试场景：期望调用接口获取到名字为"三国演绎的书籍"且判断价格是否等于20

    JsonSlurper jsonSlurper = new JsonSlurper()
    //接口返回的是json字符串，jsonSlurper作用是将json字符串转换为 Groovy  的集合对象

    def "should book's price correct"() {
        given: ""
        when: "get books response"
        def response = given().baseUri("http://localhost:9090").log().all()
                .when()
                .get("/api/getAllBooks")
                .then().log().all()
                .assertThat()
                .statusCode(200)
                .extract().response().getBody().asString()
        then: "book's price is correct"

        def bookPrice = jsonSlurper.parseText(response).books.find{ it -> it.name == bookName }.price    //通过将字符串的response转换为数据集，然后调用 Groovy  自带的find方法，轻松找到名称为“三国演绎”的书籍价格
        Assert.assertEquals("bookPrice: ${bookPrice} is not correct", bookPrice, price)   //校验书籍的价格是否等于期望的价格，如果校验失败，会打印填写的错误信息
        where:
        bookName | price
        "三国演绎"| 29
    }

}
