package cn.fxbin.apitest

import org.apache.velocity.VelocityContext
import org.apache.velocity.app.VelocityEngine

/**
 * XmlTemplateService
 *
 * @author fxbin
 * @version v1.0
 * @since 2019/12/4 20:16
 */
class XmlTemplateService {

    VelocityEngine velocityEngine = new VelocityEngine()
    VelocityContext velocityContext = new VelocityContext()
    StringWriter stringWriter = new StringWriter()

    def getAddXmlDataBody(addXmlData) {
        velocityContext.put("addXmlData", addXmlData)

//        D:\Project\Github\ApiTest\src\test\resources\template\addXmlData.vm
        velocityEngine.getTemplate("./src/test/resources/template/addXmlData.vm").merge(velocityContext, stringWriter)   //这里写入自己创建的vm文件地址
        stringWriter.toString()
    }

}
