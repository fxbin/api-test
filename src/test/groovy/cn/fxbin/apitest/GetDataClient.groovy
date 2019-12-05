package cn.fxbin.apitest

import cn.fxbin.groovy.ConfigParser
import org.junit.Test

import static io.restassured.RestAssured.given

/**
 * GetDataClient
 *
 * @author fxbin* @version v1.0* @since 2019/12/4 20:32
 */
class GetDataClient {

    ConfigParser configParser
    def configs

    TestDataService testDataService
    def users

    GetDataClient() {
        configParser = new ConfigParser()
        testDataService = new TestDataService()
        configs = configParser.getGlobalConfig()       //获取yaml文件配置信息
        users = testDataService.getUserDataByRole("ForGetDataApi")   //按照角色名称“ForGetDataApi”获取用户信息
    }

    void getData() {
        def res = given().baseUri((String) configs.mockServerUrl)     //调用接口时，接口的baseUri来自yaml文件
                .auth().preemptive().basic("api", "api")
                .when()
                .get("/api/getData")
                .then().assertThat().statusCode(200)
                .extract().response().getBody().asString()
        println res
    }

    @Test()                         //使用junit的@Test注解调用上面编写的getData方法
    void callGetData() {
        getData()
    }

    void getDataWithCsvUser() {
        def res = given().baseUri((String) configs.mockServerUrl)
                .auth().preemptive().basic(users.username, users.password)  //接口调用时使用的用户名称和密码是从csv文件中获取的
        .when()
                .get("/api/getData")
                .then().assertThat().statusCode(200)
                .extract().response().getBody().asString()
        println res
    }

    @Test()
    void callGetDataWithCsvUser() {
        getDataWithCsvUser() //编写测试脚本验证上面的接口调用是否正确
    }

    void getDataWithEncryptPassword() {
        def res = given().baseUri((String) configs.mockServerUrl)
                .auth().preemptive().basic(users.username, testDataService.getPasswordByUserName(users.username))   //这里调用userTestData.getPasswordByUserName解密
                .when()
                .get("/api/getData")
                .then().assertThat().statusCode(200)
                .extract().response().getBody().asString()
        println res
    }
    @Test()
    void callGetDataWithEncryptPassword() {
        getDataWithEncryptPassword()  //编写测试脚本验证上面的接口调用是否正确
    }
}
