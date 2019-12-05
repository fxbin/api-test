
GitChat <接口自动化测试实战> 专栏学习

| 框架或语言 | 优势 |
| - | - |
| REST Assured | 采用 REST Assured 完成接口调用简单易上手； Github 上 Star 数已达到4096 |
| Groovy | 使用 Groovy 语言让数据库增删改查，各类文件（ JSON 、TXT、 CSV 、yaml）的读取变得极其简单 |
| Spock	Groovy | 语言自带的 BDD 框架，让自动化 case 更加清晰，易于阅读 |
| Velocity | 采用模板引擎工具，让接口的 Request Body 维护成本降到最低 |


## WireMock

[http://wiremock.org/docs/](http://wiremock.org/docs/)

### 模拟 GET 请求接口

* 如果模拟的接口无查询参数，那么使用 urlPattern 即可。
* 如果模拟的接口有查询参数，但对查询参数的名字和个数无任何限制，那么使用 urlPathPattern 即可。
* 如果模拟的接口有查询参数，且对查询参数的名称和值都有限制，那么需要在 mapping 文件中添加 queryParameters 进行控制。

### 模拟 JSON 格式接口

[http://wiremock.org/docs/verifying/](http://wiremock.org/docs/verifying/)

### 模拟 XML 格式接口

* 如果对接口的 Body 体内容有严格要求（字段名称，字段值都有限制）那么可以采用equalToXml方式定义 Request Body 。
* 如果只对接口 Body 体局部字段值有控制，那么可以采用matchesXpath的方式进行定义。
* 如果对 Request Body 无任何要求，那么不配置bodyPatterns，只需把 Header 中content-Type设置为application/xml 即可。

## Rest Assured 

[Rest Assured官网](http://rest-assured.io/)

针对接口调用的调试，REST Assured 提供了很简单的调试方式，
* given()后面加入.log().all()即可打印 Request 的详细信息
* then()后面加入.log().all()即可打印 Response 的详细信息

[rest-assured/wiki](https://github.com/rest-assured/rest-assured/wiki/Usage)

## Spock 

[Spock官网](http://spockframework.org/)

Spock是一个BDD框架，每一个case以def开头，
* def这里可以添加该case所覆盖的业务场景描述信息，
* case内容上支持given-when-then三段式。
* 为了使用spock框架所有测试Class都需要继承Specification

## Groovy 基础知识

### Groovy 语法

* 1、代码结尾处无需使用";"
* 2、可以不用显示定义数据类型，所有数据类型都可以用 def 定义
* 3、方法返回值前无需添加 return 关键字，如果方法不用 void 修饰，方法内的最后一行返回值即函数的返回值
* 4、可以指定方法中参数默认值，方法中的参数可以不指定数据类型
* 5、所有方法默认都是 public，无需添加 public 关键字
* 6、方法的()可以取消
* 7、Gstring：字符串中支持变量解析和换行处理
* 8、任何对象都可以被强制转换为布尔值，任何为 null、void 的对象，等同于 0 或空值都会解析为 false，反之则为 true
* 9、Groovy 中的“ == ”是 Java 中的 equal，如果需要判断两个对象值是否相等使用“==”

### Groovy 闭包

> Groovy 官方对闭包的定义是“闭包是一个匿名代码块，可接受参数，返回值并可分配给变量”，
闭包使用{},{clouserParameter->statement}，clouserParameter指闭包接受的参数，
多个参数用逗号隔开，statement指闭包中的代码。

### Groovy 集合处理

cn.fxbin.groovy.CollectionTest

### Groovy 操作数据库

cn.fxbin.groovy.DataSource
cn.fxbin.groovy.DataSourceNew
cn.fxbin.groovy.ConstantSql
cn.fxbin.groovy.DataRepository

### Groovy 文件操作

cn.fxbin.groovy.FileService

### Groovy 脚本文件

cn.fxbin.apitest.*

## Schema 文件定义详解

* properties 中 type 总共包含六种类型（integer、string、number、object、array、boolean），number 和 integer 的区别是 integer 只可以匹配整数类型
* type 为 number 的数据，可以通过 maxinum，minimum 指定数据取值范围
* type 为 string 的数据，可以通过 maxLength，minLength 指定字符串长度范围，通过pattern正则表达式定义该field值
* type为array的数据，可以通过 minItems,maxItems 指定数组长度，uniqueItems是个布尔值，true表示数组值之间不可重复
* type为object的数据，可以通过 maxProperties，minProperties 指定该object 包含的属性个数范围，required 中指定 object 的哪些属性是必须的，properties 里面指定每个属性的类型，长度范围等 根据上面的规则，我们重新定义 getResume 这个接口的 Response Schema，假设接口的 response 中每个字段有如下规则
* name feild：type 是 string，假设长度范围是1-100的字符，必须是大写字母
* age feild：type 是 number，假设长度范围是20-50
* birthPlace field：type 是 object，包含四个属性country，city，state，street都是必填项
* contacts filed：type 是 array，假设数组长度范围是 1-3，每个 item 又是个object，object 中的 phone，address 都是必填字段 按照上面的假设，定义的 schema 如下，大家在定义 schema 的时候可以参考到getResume 的 Response Body 一起看