package cn.fxbin.groovy

import org.junit.Test

class BasicGrammerTest {

    def add(a, b, c = 1) {    //方法的参数可以不指定数据类型，参数可以指定默认值，例如C的默认值是1
        a + b + c         //无retrun关键字，代码结尾处无需添加；
    }

    @Test
    void testAdd() {
        println add(2, 2)   //因为c有默认值，所有调用add方法的时候，可以不传入第三个变量值
        def c = add 1, 1, 3   //调用方法时，方法的（）可以取消掉
        println c
    }


    /**
     * 使用了 Groovy 提供的 Gstring，双引号中添加${变量}，可自动进行变量解析，"""中支持换行符解析
     */
    @Test
    void testGstring() {
        def c = 100
        println "this c value is ${c}"      //“”支持变量解析
        int[] array = [1, 2, 3]
        array.each() { it ->
            println """the array value is ${it}\n """
        }
    }

    /**
     *  Groovy 中任何对象都可转换为布尔值
     */
    @Test
    void testIf() {
        def c = 0
        int[] myArray = []
        def myString = ""
        if (!c) {  //0转换为布尔值
            println "c is 0"
        }
        if (!myArray) {   //空数组转换为布尔值
            println "myArray is 空值数组"
        }
        if (!myString) {  //空字符串转换为布尔值
            println "myString is 空值字符串"
        }
    }

    /**
     *  Groovy 中对象值比较使用 ==，对象引用比较使用 is
     */
    @Test
    void testEqual() {
        def a = [1,2,3]
        def b = [1,2,3]
        def c = a
        if (a == b) {     //值比较
            println "a's value equal to b"
        }
        if (a.is(b)) {
            println "a is b"
        } else {
            println "a is not b"
        }
        if (a.is(c)) {
            println "a is c"
        }
    }

}
