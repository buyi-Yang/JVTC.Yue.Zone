---
title: JPA
---

# Spring Data JPA

:::info
Spring Data JPA 为 Jakarta Persistence API (JPA) 提供了存储库支持。
它简化了需要访问 JPA 数据源的应用程序的开发。

[官方文档](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/)
| [中文文档](https://springdoc.cn/spring-data-jpa/)
| [Hibernate](https://hibernate.org/)
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

```kotlin title="src/main/kotlin/zone/yue/core/user/UserLastLoginInfoEntity.kt"
package zone.yue.core.user

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.hibernate.proxy.HibernateProxy
import java.net.InetAddress
import java.time.LocalDateTime
import java.util.*

@Entity
@Table(name = "user_last_login_info")
data class UserLastLoginInfoEntity(
    @Id val uuid: UUID,
    private val lastLoginDateTime: LocalDateTime,
    private val lastLoginIp: InetAddress,
    private val lastLoginUserAgent: String,
) {
    constructor() : this(
        UUID.fromString("00000000-0000-0000-0000-000000000000"),
        LocalDateTime.MIN,
        InetAddress.getLoopbackAddress(),
        "",
    )

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null) return false

        val oEffectiveClass =
            if (other is HibernateProxy) other.hibernateLazyInitializer.persistentClass else other.javaClass
        if (javaClass != oEffectiveClass) return false

        other as UserLastLoginInfoEntity

        return uuid == other.uuid
    }

    override fun hashCode(): Int = javaClass.hashCode()

    override fun toString(): String {
        return this::class.simpleName +
                "(uuid = $uuid , " +
                "lastLoginDateTime = $lastLoginDateTime , " +
                "lastLoginIp = $lastLoginIp , " +
                "lastLoginUserAgent = $lastLoginUserAgent )"
    }
}
```

## 储存库（Repository）

- [4.1. 核心概念 - Spring Data JPA 中文文档](https://springdoc.cn/spring-data-jpa/#repositories.core-concepts)
