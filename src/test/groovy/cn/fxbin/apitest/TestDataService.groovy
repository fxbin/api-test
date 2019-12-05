package cn.fxbin.apitest

import cn.fxbin.groovy.FileService
import cn.fxbin.groovy.Secret

/**
 * TestDataService
 *
 * @author fxbin
 * @version v1.0
 * @since 2019/12/4 20:41
 */
class TestDataService {

    FileService fileService

    TestDataService() {
        fileService = new FileService()
    }

    def getUserFileData() {
        def userData = fileService.getCsvFileContent("./src/test/resources/data/user.csv", ",")   //读取csv文件内容，“，”作为分割符
        userData
    }

    def getUserDataByRole(roleName) {
        getUserFileData().find{ it -> it.roleName == roleName }    //通过find方法按RoleName查找对应的用户名、密码信息
    }

    def getPasswordByUserName(userName) {
        // 这个方法是通过用户名称获取解密后的用户密码
        Secret.decrypt( "apiTestStudy",(String)getUserFileData().find{ it -> it.username == userName}.password)   //Secret中都是静态方法，所以可以直接类名.方法名进行调用
    }
}
