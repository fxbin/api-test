package cn.fxbin.groovy

import groovy.sql.Sql

/**
 * DataSource 负责数据库的连接
 *
 * @author fxbin
 * @version v1.0
 * @since 2019/12/4 16:04
 */
class DataSource {

    Sql sql

    Sql getSql() {
        if (!sql) {
            def mysqlDB = [
                    driver  : 'com.mysql.cj.jdbc.Driver',
                    url     : 'jdbc:mysql://127.0.0.1:3306/test?zeroDateTimeBehavior=convertToNull&useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai',
                    user    : 'root',          //这里写入安装mysql是设置的用户名
                    password: '123456'     //这里写入安装mysql时设置的密码
            ]
            sql = Sql.newInstance(mysqlDB.url, mysqlDB.user, mysqlDB.password, mysqlDB.driver)
            // 连接mysql数据库固定写法
        }
        sql
    }

}
