# 蓝桥杯

* [官方网站](https://dasai.lanqiao.cn/)
* [刷题](https://github.com/Yue-plus/Solution.JVTC.Yue.Zone/tree/main/src/main/java/zone/yue/jvtc/solution/LanQiao)

## 比赛环境

* 使用 [jdk-8u261-windows-x64](https://www.oracle.com/cn/java/technologies/downloads/#java8-windows)
* 使用 [eclipse-java-2020-06-R-win32-x86_64](/blog/2022/10/13/setupEclipse/README)
* 提供 API 文档（英文）

## 文档

* [“蓝桥杯”比赛系统 选手文档.pdf](http://upload.lanqiao.cn/file/20180207/1517983232418142.pdf)
* [第九届蓝桥杯大赛竞赛大纲（软件类）.pdf](http://upload.lanqiao.cn/file/20180207/1517983424205832.pdf)

## 注意事项

* 主类名必须是 `Main`
* 不能使用 `package` 语句

## Java 版本差异

由于蓝桥杯 **还在** 使用 Java 8，以下介绍一些刷题时很好用但 Java 8 中还不存在的特性。

<details>
<summary>各版本新特性概览</summary>

* [Java 9 新特性概览 | JavaGuide(Java面试+学习指南)](https://javaguide.cn/java/new-features/java9.html)
* [Java 10 新特性概览 | JavaGuide(Java面试+学习指南)](https://javaguide.cn/java/new-features/java10.html)
* [Java 11 新特性概览 | JavaGuide(Java面试+学习指南)](https://javaguide.cn/java/new-features/java11.html)
* [Java 12~13 新特性概览 | JavaGuide(Java面试+学习指南)](https://javaguide.cn/java/new-features/java12-13.html)
* [Java 14 新特性概览 | JavaGuide(Java面试+学习指南)](https://javaguide.cn/java/new-features/java14.html)
* [Java 15 新特性概览 | JavaGuide(Java面试+学习指南)](https://javaguide.cn/java/new-features/java15.html)
* [Java 16 新特性概览 | JavaGuide(Java面试+学习指南)](https://javaguide.cn/java/new-features/java16.html)
* [Java 17 新特性概览 | JavaGuide(Java面试+学习指南)](https://javaguide.cn/java/new-features/java17.html)
* [Java 18 新特性概览 | JavaGuide(Java面试+学习指南)](https://javaguide.cn/java/new-features/java18.html)
* [Java 19 新特性概览 | JavaGuide(Java面试+学习指南)](https://javaguide.cn/java/new-features/java19.html)

</details>

### 不支持局部变量类型推断（`var`）

这是 Java10 的新特性。
可参考：[Java 10 新特性之局部变量类型推断 - 知乎](https://zhuanlan.zhihu.com/p/34911982)

### 不支持 `record`

可参考：[无涯教程- Java 14 – Record类型介绍 - 知乎](https://zhuanlan.zhihu.com/p/372678867)

### 不支持一些 `String` 方法

Java11 增加了一系列的字符串处理方法：

```java
//判断字符串是否为空
" ".isBlank();             //true
//去除字符串首尾空格
" Java ".strip();          // "Java"
//去除字符串首部空格
" Java ".stripLeading();   // "Java "
//去除字符串尾部空格
" Java ".stripTrailing();  // " Java"
//重复字符串多少次
"Java".repeat(3);          // "JavaJavaJava"
//返回由行终止符分隔的字符串集合。
"A\nB\nC".lines().count(); // 3
"A\nB\nC".lines().collect(Collectors.toList());
```

### 不支持 Lambda `switch`

传统的 switch 语法存在容易漏写 break 的问题，而且从代码整洁性层面来看，多个 break 本质也是一种重复。

Java12 增强了 switch 表达式，使用类似 lambda 语法条件匹配成功后的执行块，不需要多写 break 。

```java
switch (day) {
    case MONDAY, FRIDAY, SUNDAY -> System.out.println(6);
    case TUESDAY                -> System.out.println(7);
    case THURSDAY, SATURDAY     -> System.out.println(8);
    case WEDNESDAY              -> System.out.println(9);
}
```

Java14 正式支持了此特性。

### 不支持文本块

文本块解决了 Java 定义多行字符串时只能通过换行转义或者换行连接符来变通支持的问题，引入 **三重双引号** 来定义多行文本。

Java 13 支持两个 `"""` 符号中间的任何内容都会被解释为字符串的一部分，包括换行符。

未支持文本块之前的 Json 写法：

```java
String json ="{\n" +
              "   \"name\":\"mkyong\",\n" +
              "   \"age\":38\n" +
              "}\n";
```

支持文本块之后的 Json 写法：

```java
 String json = """
                {
                    "name":"mkyong",
                    "age":38
                }
                """;
```

未支持文本块之前的 SQL 写法：

```sql
String query = "SELECT `EMP_ID`, `LAST_NAME` FROM `EMPLOYEE_TB`\n" +
               "WHERE `CITY` = 'INDIANAPOLIS'\n" +
               "ORDER BY `EMP_ID`, `LAST_NAME`;\n";
```

支持文本块之后的 SQL 写法：

```sql
String query = """
               SELECT `EMP_ID`, `LAST_NAME` FROM `EMPLOYEE_TB`
               WHERE `CITY` = 'INDIANAPOLIS'
               ORDER BY `EMP_ID`, `LAST_NAME`;
               """;
```

另外，`String` 类新增加了 3 个新的方法来操作文本块：

- `formatted(Object... args)` ：它类似于 `String` 的`format()`方法。添加它是为了支持文本块的格式设置。
- `stripIndent()` ：用于去除文本块中每一行开头和结尾的空格。
- `translateEscapes()` ：转义序列如 _“\\\t”_ 转换为 _“\t”_

由于文本块是一项预览功能，可以在未来版本中删除，因此这些新方法被标记为弃用。

```java
@Deprecated(forRemoval=true, since="13")
public String stripIndent() {
}
@Deprecated(forRemoval=true, since="13")
public String formatted(Object... args) {

}
@Deprecated(forRemoval=true, since="13")
public String translateEscapes() {
}
```

Java15 正式支持了此特性。
