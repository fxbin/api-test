package cn.fxbin.apitest

import spock.lang.Specification
import static io.restassured.RestAssured.given

class UserDemo extends Specification {

    def "should call mock api successfully"() {     //spock框架（BDD框架）语法，所有case都是def开头，def后面是该case的描述信息
        given: "no given"                           //spock框架语法，given-when-then三段式写法，given/when/then后是描述信息
        when: "call mock api"
        given().baseUri("http://localhost:9090").log().all()    //这里输入接口的baseUri
                .when()
                .get("api/getUserDetails")          //输入接口的地址
                .then()
                .assertThat().statusCode(200)      //这里校验调用接口后返回的状态码是200，如果不是200，调用会失败
        then: "no then"
    }

    def "should add user successfully"() {
        given: "no given"
        def body = "{\"name\": {\"mainName\": \"zhangshang\",\"alias\": \"zhangshangalias\"},\"age\":123}"
        when: "call get user by name api"
        given().log().all().log().all()
                .baseUri("http://localhost:9090")
                .auth().preemptive().basic("root", "root123")  //接口调用时，对basicAuth的的设置
                .header("Content-Type", "application/json")   //mock的接口header中定义了Content-Type，所以接口调用是设置header值
                .cookie("session", "123456")                 //mock的接口中定义了名称为“session”的cookie，所以接口调用时设置该cookie
                .body(body)                                 //这里body是采用传入Body Sring方式，后续课程会详细讲解如何管理接口测试的request body
                .when()
                .post("/api/addUser")
                .then()
                .log().all()
                .assertThat().statusCode(200)
        then: "no then"
    }
}
