---
title: JPA
---

# Spring Data JPA

:::info
Spring Data JPA 为 Jakarta Persistence API (JPA) 提供了存储库支持。
它简化了需要访问 JPA 数据源的应用程序的开发。

[官方文档](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/)
| [中文文档](https://springdoc.cn/spring-data-jpa/)
:::

## 教程

- [Accessing JPA Data with REST - Spring Guides](https://spring.io/guides/gs/accessing-data-rest/)

## 配置文件

```yaml title="src/main/resources/application.yaml"
spring:
  jpa:
    database: postgresql
    generate-ddl: true
    hibernate.ddl-auto: validate
```

## 实体（Entity）

- [Spring Data JPA @Entity详解 - 掘金](https://juejin.cn/post/7143048935739752484)

## 储存库（Repository）

- [4.1. 核心概念 - Spring Data JPA 中文文档](https://springdoc.cn/spring-data-jpa/#repositories.core-concepts)