# Hilla

:::info
Hilla 是一个用于 Java 的全栈 Web 框架。
它可以通过将 Spring Boot 后端与 React 前端相结合来帮助您更快地构建更好的业务应用程序。
此外，它还具有 40 多个 UI 组件，你可以将其用于更专业的应用程序。

[官方网站](https://hilla.dev/)
:::

## 快速上手

### 系统环境

除了常用的设备和工具外，只需要两件基本的东西：

- [Node.js](https://nodejs.org/) 18.0 或更高版本。
- [JDK](https://adoptium.net/zh-CN/) 17 或更高版本。

### 创建项目

#### 使用官方项目生成器

前往 https://start.vaadin.com/ 创建项目。

#### 使用 Spring initializr

前往 https://start.spring.io/ 或使用 IDEA 创建 Spring 项目。
创建项目时注意：

- Project（项目类型）：Gradle - Kotlin
- Language（项目语言）：Kotlin
- Project Metadata：按需自定。
- Dependencies（项目依赖）：
  + [Spring Boot DevTools](https://springdoc.cn/spring-boot/using.html#using.devtools)
  + Spring Configuration Processor
  + **Hilla**
  + ...以及其他你需要的依赖项；

> 选用 Hilla 时通常无需依赖 Spring Web；
> 也无需依赖 Spring Reactive Web（[Vaadin Flow](https://vaadin.com/docs/latest/guide/quick-start) 了解一下？

#### 使用 Hilla CLI

> 使用 Hilla CLI 创建的项目默认使用 [Maven] 构建，如果想使用 [Gradle] 构建，请直接使用 Spring initializr 创建项目

在终端执行以下命令，使用 Hilla CLI 创建新项目：

```sh
npx @hilla/cli init my-hilla-app
```

默认会创建 [React] 应用，如果想使用 [Lit] 的话，需要加上 `--lit` 选项：

```sh
npx @hilla/cli init --lit my-hilla-app
```

也可以加上 `--auth` 选项来创建具有基本 [安全配置](https://hilla.dev/docs/lit/guides/security/configuring) 的项目：

```sh
npx @hilla/cli init --lit --auth hilla-with-auth
```

##### Hilla CLI 帮助

```text {1}
$ npx @hilla/cli init -h
用法: hilla-init [options] <projectName>

选项：
  --empty            创建一个没有菜单和一个空视图的项目
  --react            UI 使用 React（默认）
  --lit              UI 使用 Lit
  --latest           使用最新的主要版本（默认）
  --pre              使用最新的预发布版本（如果可用）
  --next             使用下一个主要版本的预发布版本（如果可用）
  --auth             向应用程序添加身份验证支持
  --push             向应用程序添加推送支持/响应端点
  --git              初始化项目的 Git 仓库并提交初始文件
  --preset <preset>  使用碰巧知道存在的给定预设
  --server <server>  仅用于内部测试
  -h, --help         显示命令帮助
```

### 项目结构

<table style={{ width: "100%", textAlign: "left" }}>
    <tr><th>目录</th><th>说明</th></tr>
    <tr>
        <td><code>frontend/</code></td>
        <td>客户端源代码目录</td>
    </tr>
    <tr>
        <td>&nbsp;&nbsp;&nbsp;&nbsp;<code>index.html</code>
        </td><td>HTML 模板</td>
    </tr>
    <tr>
        <td>&nbsp;&nbsp;&nbsp;&nbsp;<code>index.ts</code></td>
        <td>前端入口点，包含使用 <a href="https://hilla.dev/docs/react/guides/routing">Hilla Router</a> 的客户端路由设置</td>
    </tr>
    <tr>
        <td>&nbsp;&nbsp;&nbsp;&nbsp;<code>main-layout.ts</code></td>
        <td>主布局 Web 组件，包含导航菜单，使用 <a href="https://vaadin.com/docs/latest/ds/components/app-layout">应用布局</a></td>
    </tr>
    <tr>
        <td>&nbsp;&nbsp;&nbsp;&nbsp;<code>views/</code></td>
        <td>UI 视图和 Web 组件（TypeScript）</td>
    </tr>
    <tr>
        <td>&nbsp;&nbsp;&nbsp;&nbsp;<code>themes/</code></td>
        <td>自定义 CSS 样式</td>
    </tr>
    <tr>
        <td><code>src/main/java/&lt;groupId&gt;/</code></td>
        <td>服务器端源代码目录，包含服务端 Java 视图</td>
    </tr>
    <tr>
        <td>&nbsp;&nbsp;&nbsp;&nbsp;<code>Application.java</code></td>
        <td>服务端入口</td>
    </tr>
</table>

## 安全

### 使用 Spring Security 进行身份验证

> 参考：[Authentication with Spring Security | Security | Guides | React | Hilla Docs](https://hilla.dev/docs/react/guides/security/spring-login)

```kotlin title="SecurityConfig.kt"
import com.vaadin.flow.spring.security.VaadinWebSecurity
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
// highlight-next-line
import org.springframework.security.config.annotation.web.invoke
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.core.userdetails.User
import org.springframework.security.provisioning.InMemoryUserDetailsManager
import org.springframework.security.provisioning.UserDetailsManager

@EnableWebSecurity
@Configuration
class SecurityConfig : VaadinWebSecurity() {
    override fun configure(http: HttpSecurity) {
        // 允许 Hilla 内部请求的默认安全策略
        super.configure(http)

        http {
            formLogin { }
        }
    }

    @Bean
    fun userDetailsManager(): UserDetailsManager {
        // 基于内存的身份校验；请勿在生产环境使用
        return InMemoryUserDetailsManager(
            User.withUsername("user").password("{noop}user").roles("USER").build(),
            User.withUsername("admin").password("{noop}admin").roles("ADMIN", "USER").build(),
        )
    }
}
```

[Gradle]: /docs/开发/工具/Gradle/
[Maven]: /docs/开发/工具/Maven/
[Kotlin]: /docs/开发/语言/Kotlin/
[SpringBoot]: /docs/开发/框架/Spring/Boot/
[React]: /docs/开发/框架/React/
[Lit]: /docs/开发/框架/Lit/
