package cn.fxbin.groovy

/**
 * ConstantSql 存放 SQL 常量
 *
 * @author fxbin
 * @version v1.0
 * @since 2019/12/4 16:07
 */
class ConstantSql {

    static final getUserInfo="select * from user"
    static final getAddressInfoByUserName ="select a.username, a.age, b.address from user a,address b where a.id=b.userId and a.username=?"
    static final addUser = "insert into user (username,age,create_date) values (?,?,'2019-10-11:11:12:13')"
    static final getUser="select * from user where username = ?"
    static final updateAge="update user set age=? where username=?"    //sql查询语句固定写法，需要传递参数的地方用？

}
