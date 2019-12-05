package cn.fxbin.apitest

import org.junit.Test

/**
 * XmlDataService
 *
 * @author fxbin* @version v1.0* @since 2019/12/4 20:26
 */
class XmlDataService {

    XmlSlurper xmlSlurper
    XmlClient xmlClient

    XmlDataService() {
        xmlSlurper = new XmlSlurper()
        xmlClient = new XmlClient()
    }

    @Test()
    void getMatchLevel() {
        def result = xmlSlurper.parseText(xmlClient.getXmlData())   //将string类型的respone body通过xmlSlurper转换为数据对象
        println result.View.Result.MatchLevel.text()      //打印数据对象中的MatchLevel值
    }

}
