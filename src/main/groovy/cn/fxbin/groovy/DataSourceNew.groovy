package cn.fxbin.groovy

import groovy.sql.Sql

/**
 * DataSourceNew
 *
 * @author fxbin
 * @version v1.0
 * @since 2019/12/4 17:25
 */
class DataSourceNew {

    Sql sql
    FileService fileService
    def configs

    DataSourceNew() {
        fileService = new FileService()
        configs = fileService.getConfigs('./src/test/resources/data/app.yml')
    }

    Sql getSql() {
        if (!sql) {
            def mysqlDB = [
                    driver  : 'com.mysql.cj.jdbc.Driver',
                    url     : configs.dev.db.url,
                    user    : configs.dev.db.user,
                    password: configs.dev.db.password
            ]
            sql = Sql.newInstance(mysqlDB.url, mysqlDB.user, mysqlDB.password, mysqlDB.driver)
        }
        sql
    }

}
