package cn.fxbin.apitest

import cn.fxbin.groovy.FileService
import org.junit.Assert
import spock.lang.Specification

/**
 * TemplateCase
 *
 * @author fxbin* @version v1.0* @since 2019/12/4 17:59
 */
class TemplateCase extends Specification {

    UserClient userClient

    def setup() {
        userClient = new UserClient()
    }

    def "should add user with only inputting main contact successfully"() {
        given: "generate request body"
        def body = new AddUserBody()
                .addMainContact(city, street, phone)
                .generateBody()
        when: "call add user api"
        def response = userClient.addUserWithString(body)
        then: "should get correct response"
        Assert.assertEquals("assert add user api response correct", response, "add user successfully")
        where:
        city      | street          | phone
        "chengdu" | "qingyi-street" | 11223344556
        "xx" | "cc-street" | 11223344556
    }

    def "should add user with inputting main and backup contact successfully"() {
        given: "generate request body"
        def body = new AddUserBody()
                .addMainContact(mainCity, mainStreet, mainPhone)              //添加mianContact信息
                .addBackupContact(backupCity, backupStreet, backupPhone)      //添加BackupContact信息
                .generateBody()
        when: "call add user api"
        def response = userClient.addUserWithString(body)
        then: "should get correct response"
        Assert.assertEquals("assert add user api response correct", response, "add user successfully")
        where:
        mainCity  | mainStreet   | mainPhone   | backupCity | backupStreet | backupPhone
        "chengdu" | "one-street" | 11223344556 | "beijing"  | "two-street" | 00112233445
    }

    def "should add user with inputting contacts and background successfully"() {
        given: "generate request body"
        def body = new AddUserBody()
                .addMainContact(mainCity, mainStreet, mainPhone)           //添加mianContact信息
                .addBackupContact(backupCity, backupStreet, backupPhone)   //添加BackupContact信息
                .addBackGround(degree, school, date)                       //添加BackGround信息
                .generateBody()
        when: "call add user api"
        def response = userClient.addUserWithString(body)
        then: "should get correct response"
        Assert.assertEquals("assert add user api response correct", response, "add user successfully")
        where:
        mainCity  | mainStreet   | mainPhone   | backupCity | backupStreet | backupPhone | degree   | school    | date
        "chengdu" | "one-street" | 11223344556 | "beijing"  | "two-street" | 00112233445 | "doctor" | "qinghua" | "2019-07"
    }

}
