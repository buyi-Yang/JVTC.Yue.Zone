---
title: Security
---

# Spring Security

:::info
Spring Security 是一个框架，提供认证（authentication）、授权（authorization）和保护，以抵御常见的攻击。它对保护命令式和响应式应用程序有一流的支持，是保护基于Spring的应用程序的事实标准。

[官方文档](https://docs.spring.io/spring-security/reference/index.html)
| [中文文档](https://springdoc.cn/spring-security/)
:::

## 教程

- [Spring Security 教程 已完结（IDEA 2023最新版）4K蓝光画质 基于Spring6的全新重制版本 起立到起飞](https://www.bilibili.com/video/BV1fV411M7aS/)
- [SpringSecurity框架教程-Spring Security+JWT实现项目级前端分离认证授权-B站最通俗易懂的Spring Security课程](https://www.bilibili.com/video/BV1mm4y1X7Hc/)

## 配置文件

```yaml title="src/main/resources/application.yaml"
  security:
    user:
      name: yueplus
      password: yueplus
```

## 配置类

- [`WebSecurityConfigurerAdapter` 在 Spring Security 5.7.0-M2 中已弃用！](https://spring.io/blog/2022/02/21/spring-security-without-the-websecurityconfigureradapter)
- [Servlet 应用 Kotlin 配置 :: Spring Security Reference](https://springdoc.cn/spring-security/servlet/configuration/kotlin.html)

### 配置允许访问特定路径

```kotlin
package zone.yue.core

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.WebSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer

@Configuration
@EnableWebSecurity
class SecurityConfiguration {
    @Bean
    fun webSecurityCustomizer(): WebSecurityCustomizer? {
        return WebSecurityCustomizer {
            web: WebSecurity -> web.ignoring().requestMatchers("/signup")
        }
    }
}
```

### 配置基于内存的身份校验

```kotlin
package zone.yue.core

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.factory.PasswordEncoderFactories
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.provisioning.InMemoryUserDetailsManager

@Configuration
@EnableWebSecurity
class SecurityConfiguration {    
    @Bean
    fun userDetailsService(): UserDetailsService {
        val encoder: PasswordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder()

        val test: UserDetails = User
            .withUsername("Yue_test")
            .password(encoder.encode("Yue_test"))
            .roles("USER")
            .build()

        val admin: UserDetails = User
            .withUsername("admin")
            .password(encoder.encode("admin"))
            .roles("ADMIN")
            .build()

        return InMemoryUserDetailsManager(test, admin)
    }
}
```