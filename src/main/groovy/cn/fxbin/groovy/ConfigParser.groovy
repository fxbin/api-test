package cn.fxbin.groovy

/**
 * ConfigParser
 *
 * @author fxbin
 * @version v1.0
 * @since 2019/12/4 20:31
 */
class ConfigParser {

    FileService fileService

    ConfigParser() {
        fileService = new FileService()
    }

    def getConfigs(String configFilePath) {
        def configs = fileService.getConfigs(configFilePath)       //传入yaml文件的路径，然后获取整个yaml文件的内容
        def sysEnv = System.getenv("ACTIVE_ENV")               //读取名称为“ACTIVE_ENV”的环境变量
        def active = sysEnv ? sysEnv : configs.active          //如果环境变量存在，则读取环境变量的值，如果环境变量不存在，则读取yaml文件中active值
        configs.putAll(configs.get(active))
        //通过active值获取对应环境的配置信息，例如如果active的值是“dev“，那么自动化脚本在运行时就会获取dev下面配置的db连接信息和mockServerUrl
        configs
    }

    def getGlobalConfig() {
        def configs
        configs = getConfigs("./src/test/resources/data/app.yml")
        configs
    }
}
