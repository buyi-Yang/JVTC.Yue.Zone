# Spring Framework要点

::: info

1. 控制反转（IOC）：IOC是一个技术思想，核心就是将new对象的操作交由IOC容器去帮助我们完成，包括创建实例化对象并管理它，我们需要使用哪个对象，去IOC容器获取即可。

2. 面向切面编程（AOP）：AOP模块为面向切面编程提供了丰富的支持。这个模块是Spring应用系统中开发切面的基础，与DI一样，AOP可以帮助应用对象解耦。

3. Spring的核心结构：Spring是一个层级清晰，职责分明、且依赖关系非常轻量的框架，主要包括几个模块：数据处理模块、WEB模块、面向切面编程AOP模块、Spring核心容器Core Container模块和TEST模块。

4. Spring IOC应用：Spring IOC基础包括beans.xml定义需要实例化对象的类的全限定名以及其各个类之间的依赖关系描述，BeanFactory是IOC容器，通过反射技术来实例化对象并维护对象之间的依赖关系。

5. 声明式事务：Spring Framework提供了声明式事务的支持，通过配置就可以完成对事务的管理，无需编程。

6. 集成优秀框架：Spring内部提供了对各种优秀框架（Struts2、Hibernate、MyBatis）的直接支持。

7. 降低Java EE API使用难度：对JAVA EE开发中一些API（JDBC、JavaMail、远程调用）都提供了封装。

:::

```text
Spring 框架的基础操作要点主要包括以下几个方面：

1. 理解 Spring 的核心机制：Spring 的核心功能有两个：
    - Spring 容器作为超级大工厂，负责创建、管理所有的 Java 对象，这些 Java 对象被称为 Bean。
    - Spring 容器管理容器中 Bean 之间的依赖关系，Spring 使用一种被称为 "依赖注入" 的方式来管理 Bean 之间的依赖关系。

2. 管理 Bean：程序主要是通过 Spring 容器来访问容器中的 Bean。

3. 依赖注入：使用依赖注入，不仅可以为 Bean 注入普通的属性值，还可以注入其他 Bean 的引用。

4. 设值注入和构造注入：设值注入是指 IoC 容器通过成员变量的 setter 方法来注入被依赖对象。利用构造器来设置依赖关系的方式，被称为构造注入。

5. Spring 容器中的 Bean：对于开发者来说，开发者使用 Spring 框架主要是做两件事：开发 Bean；配置 Bean。

6. Spring Boot 的使用：Spring Boot 是 Spring 的一个子项目，目的是简化新 Spring 应用的初始搭建以及开发过程。
```

