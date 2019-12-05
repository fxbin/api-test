package cn.fxbin.apitest

import io.restassured.module.jsv.JsonSchemaValidator
import org.junit.Assert
import spock.lang.Specification


/**
 * ResumeCase
 *
 * @author fxbin
 * @version v1.0
 * @since 2019/12/4 19:08
 */
class ResumeCase extends Specification{

    ResumeClient resumeClient
    ResumeService resumeService

    def setup() {
        resumeClient = new ResumeClient()
        resumeService = new ResumeService()
    }

    def "get person from different country"() {
        given: "no given"
        when: "call the get resume api"
        def res = resumeClient.getResumeDetails()
        then: "println  out the person name from different country"
        println resumeService.getPersonByCountry(res, country)
        where:
        country | placeHolder
        "China" | ""
        "USA" | ""
    }

    def "call the api"() {
        given: "no given"
        when: "call the get resume api"
        resumeClient.getResumeSchemaValidate(filePath)    //编写case调用上面的getResumeSchemaValidate方法
        then: "no then"
        where:
        filePath|placeHolder
        "cn/fxbin/schema/getResumeSchema.json"|""        //这里请输入自己存放的shema文件地址
    }

    def "validate schema of getResume2 api"() {
        given: "no given"
        when: "call the get resume2 api"
        def payLoad= resumeClient.getResume2()        //获取接口中payLoad的值
        then: "check the schema"
        Assert.assertThat(payLoad, JsonSchemaValidator.matchesJsonSchemaInClasspath(filePath))    //assertThat中使用matchesJsonSchemaInClasspath校验payLoad的值是否与getResumeSchema2中定义的schema一致
        where:
        filePath|placeHolder
        "cn/fxbin/schema/getResumeSchema-v2.json"|""
    }






}
