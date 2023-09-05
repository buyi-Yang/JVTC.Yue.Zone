---
title: Data
---

# Spring Data

:::info
Spring Data Commons 项目将 Spring 的核心概念应用于使用许多关系型和非关系型数据存储的解决方案的开发。

[官方文档](https://docs.spring.io/spring-data/commons/docs/current/reference/html/)
| [中文文档](https://springdoc.cn/spring-data/)
:::

## 配置文件

```yaml title="src/main/resources/application.yaml"
spring:
  datasource:
    username: postgres
    password: postgres
    url: jdbc:postgresql://localhost:5432/postgres
    driver-class-name: org.postgresql.Driver
```

## 对 Kotlin 的支持

参考：[官方文档](https://docs.spring.io/spring-data/commons/docs/current/reference/html/#mapping.kotlin)
| [中文文档](https://springdoc.cn/spring-data/#mapping.kotlin)
