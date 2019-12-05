package cn.fxbin.apitest

/**
 * AddXmlDataBody
 *
 * @author fxbin
 * @version v1.0
 * @since 2019/12/4 20:17
 */
class AddXmlDataBody {

    def bookName
    def price
    def author
    XmlTemplateService xmlTemplateService

    AddXmlDataBody() {
        xmlTemplateService = new XmlTemplateService()
    }

    def setBookName(bookName) {
        this.bookName = bookName
        this
    }
    def setPrice(price){
        this.price=price
        this
    }

    def setAuthor(author){
        this.author=author
        this
    }

    def getAddXmlDataBody() {
        xmlTemplateService.getAddXmlDataBody(this)
    }

}
