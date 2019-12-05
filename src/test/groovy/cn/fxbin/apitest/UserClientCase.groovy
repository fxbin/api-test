package cn.fxbin.apitest

import cn.fxbin.groovy.FileService
import org.junit.Assert
import spock.lang.Specification


/**
 * UserClientCase
 *
 * @author fxbin
 * @version v1.0
 * @since 2019/12/4 17:38
 */
class UserClientCase extends Specification {

    FileService fileService
    UserClient userClient
    def setup() {
        fileService = new FileService()
        userClient = new UserClient()
    }
    def "should add user successfully"() {
        given: "no given"

        when: "call the add user api"
        // 创建addUser.json文件，将前面列出的request body内容放到该文件中。
        def file = fileService.createFile("./src/test/resources/data/addUser.json")  //获取文件对象

        then: "get the correct response"
        Assert.assertEquals(userClient.addUserWithFile(file), "add user successfully")
        //将文件对象传入userClient.addUserWithFile()中，这里可以开启.log().all()查看接口是否返回正确的response body。
    }

}
