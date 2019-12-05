package cn.fxbin.apitest
/**
 * AddUserBody
 *
 * @author fxbin
 * @version v1.0
 * @since 2019/12/4 17:56
 */
class AddUserBody {

    def mainContact=[:]
    def ifAddMainContact
    def backupContact=[:]
    def ifAddBackupContact
    def backGround=[:]
    def ifAddBackGround
    def otherInfo
    def ifAddOtherInfo
    UserClient userClient

    AddUserBody() {
        userClient = new UserClient()
    }

    def addMainContact(city, street, phone) {
        this.ifAddMainContact = true
        this.mainContact.city = city
        this.mainContact.street = street
        this.mainContact.phone = phone
        this
    }

    def addBackupContact(city, street, phone) {
        this.ifAddBackupContact = true
        this.backupContact.city = city
        this.backupContact.street = street
        this.backupContact.phone = phone
        this
    }

    def addBackGround(degree, school, date) {
        this.ifAddBackGround = true
        this.backGround.degree = degree
        this.backGround.school = school
        this.backGround.date = date
        this
    }

    def addOtherInfo(otherInfo) {
        this.ifAddOtherInfo = true
        this.otherInfo = otherInfo
        this
    }

    def generateBody() {
        new TemplateService().getAddUserRequestBody(this)  //this表示AddUserBody对象本身，将this传递给templateService，那么该对象中设置的所有值就可以用在模版文件中了
    }
}
