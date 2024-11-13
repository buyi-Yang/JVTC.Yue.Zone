# Kotlin

:::info
Kotlin 是一门现代但已成熟的编程语言，旨在让开发人员更幸福快乐。
它简洁、安全、可与 Java 及其他语言互操作，并提供了多种方式在多个平台间复用代码，以实现高效编程。

[官方网站](https://kotlinlang.org/docs/getting-started.html)
| [中文文档](https://book.kotlincn.net/text/getting-started.html)
:::

## Android Jetpack

> Jetpack 是一个由多个库组成的套件，可帮助开发者遵循最佳做法、减少样板代码并编写可在各种 Android 版本和设备中一致运行的代码，让开发者可将精力集中于真正重要的编码工作。

### Compose

- [Jetpack Compose 使用入门  |  Android Developers](https://developer.android.google.cn/develop/ui/compose/documentation?hl=zh-cn)
- [Compose 工具  |  Android Developers](https://developer.android.google.cn/develop/ui/compose/tooling?hl=zh-cn)

## Ktor 服务端开发

> 参考：[官方网站](https://ktor.io/)

使用 **[Ktor Project Generator](https://start.ktor.io/)** 创建新项目。

### Exposed

> Exposed 是一个 Kotlin SQL 数据库库，它有两种风格：轻量级ORM（使用 DAO）和类型安全 SQL（使用 DSL）。
> 参考：[官方文档](https://jetbrains.github.io/Exposed/home.html)

## 多平台开发

> 参考：[开始使用 Kotlin 多平台开发 - Kotlin 文档](https://kotlinlang.org/docs/multiplatform-get-started.html)
> | [官方网站](https://www.jetbrains.com/zh-cn/kotlin-multiplatform/)

使用 **[Kotlin Multiplatform Wizard](https://kmp.jetbrains.com/)** 创建新项目。

### Compose Multiplatform

> 为 Android、iOS、桌面和 Web 开发令人惊叹的共享 UI。
> 参考：[官方网站](https://www.jetbrains.com/zh-cn/lp/compose-multiplatform/)

### 使用 Material3

修改 `composeApp\build.gradle.kts` 文件：

```diff
  kotlin {
      sourceSets {
          commonMain.dependencies {
-             implementation(compose.material)
+             implementation(compose.material3)
+             implementation(compose.material3AdaptiveNavigationSuite)
          }
      }
  }
```

### 组件预览 `@Preview`
