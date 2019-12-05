package cn.fxbin.apitest

import org.junit.Assert
import spock.lang.Specification

/**
 * AddXmlDataCase
 *
 * @author fxbin
 * @version v1.0
 * @since 2019/12/4 20:18
 */
class AddXmlDataCase extends Specification {

    XmlTemplateService xmlTemplateService
    XmlClient xmlClient

    def setup() {
        xmlTemplateService = new XmlTemplateService()
        xmlClient = new XmlClient()
    }

    def "should add xml data successfully"() {
        given: "generate add xml data api request body"
        def reqBody = new AddXmlDataBody()
                .setBookName("bookName-shanguo")
                .setPrice(20)
                .setAuthor("luoguanzhong")
                .getAddXmlDataBody()

        when: "call add xml data api"
        def res = xmlClient.addXmlData(reqBody)
        then: "should get correct response"
        Assert.assertEquals(res, "add xml data successfully")     //校验接口返回的response body是否正确
    }

    def "should add xml data with invalid bookName failed"() {
        given: "generate add xml data api request body"
        def reqBody = new AddXmlDataBody()
                .setBookName("shanguo")       //mock接口的时候要求request body中bookName字段必须包含“bookName”字符串，这里设置的书名不正确，调用接口应该会失败
                .setPrice(20)
                .setAuthor("luoguanzhong")
                .getAddXmlDataBody()

        when: "call add xml data api"
        xmlClient.addXmlData(reqBody, 404)   //校验接口返回404状态码
        then: "no then"
    }

}
