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

参考 [官方文档](https://docs.spring.io/spring-security/reference/servlet/authentication/passwords/in-memory.html)
| [中文文档](https://springdoc.cn/spring-security/servlet/authentication/passwords/in-memory.html)

`User.withDefaultPasswordEncoder()` 已被标记弃用，不推荐在生产环境中使用！

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

### 配置基于数据库的身份校验

参考 [官方文档](https://docs.spring.io/spring-security/reference/servlet/authentication/passwords/user-details-service.html)
| [中文文档](https://springdoc.cn/spring-security/servlet/authentication/passwords/user-details-service.html)

只要实现 `UserDetailsManager` 接口即可：

```kotlin
package zone.yue.core

import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.crypto.factory.PasswordEncoderFactories
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.provisioning.UserDetailsManager
import org.springframework.stereotype.Service
import zone.yue.core.user.UserEntity
import zone.yue.core.user.UserRepository
import java.util.*

@Service
class AccountService(val userRepository: UserRepository) : UserDetailsManager {
    val passwordEncoder: PasswordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder()

    fun signup(username: String, password: String) {
        if (userExists(username)) return

        val user: UserDetails = User
            .withUsername(username)
            .password(passwordEncoder.encode(password))
            .build()

        createUser(user)
    }

    override fun loadUserByUsername(username: String): UserDetails {
        val user = userRepository.findByUsername(username)
        return User.withUsername(user.username).password(user.password).build()
    }

    override fun createUser(user: UserDetails) {
        userRepository.save(UserEntity(UUID.randomUUID(), user.username, user.password))
    }

    override fun updateUser(user: UserDetails?) {
        TODO("Not yet implemented")
    }

    override fun deleteUser(username: String) {
        val user = userRepository.findByUsername(username)
        userRepository.delete(user)
    }

    override fun changePassword(oldPassword: String?, newPassword: String?) {
        TODO("Not yet implemented")
    }

    override fun userExists(username: String): Boolean {
        return userRepository.existsByUsername(username)
    }
}
```
