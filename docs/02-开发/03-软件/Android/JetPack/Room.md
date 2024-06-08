# Room

:::info
处理大量结构化数据的应用可极大地受益于在本地保留这些数据。最常见的使用场景是缓存相关的数据，这样一来，当设备无法访问网络时，用户仍然可以在离线状态下浏览该内容。

Room 持久性库在 SQLite 上提供了一个抽象层，以便在充分利用 SQLite 的强大功能的同时，能够流畅地访问数据库。具体来说，Room 具有以下优势：

- 提供针对 SQL 查询的编译时验证。
- 提供方便注解，可最大限度减少重复和容易出错的样板代码。
- 简化了数据库迁移路径。
- 出于这些方面的考虑，强烈建议您使用 Room，而不是直接使用 SQLite API。

[官方文档](https://developer.android.google.cn/training/data-storage/room?hl=zh-cn)
:::

## 依赖

> 相关参考文档：
> - [使用 Room 将数据保存到本地数据库 | Android Developers](https://developer.android.google.cn/training/data-storage/room?hl=zh-cn#kts)
> - [使用 Room 持久保留数据 | Codelab](https://developer.android.google.cn/codelabs/basic-android-kotlin-training-persisting-data-room?hl=zh-cn)
> - [从 kapt 迁移到 KSP | Android Studio | Android Developers](https://developer.android.google.cn/build/migrate-to-ksp?hl=zh-cn)
> - [Kotlin Symbol Processing API | Kotlin Documentation](https://kotlinlang.org/docs/ksp-overview.html)

```toml title="libs.versions.toml"
[versions]
kotlin = "2.0.0"
composeBom = "2024.05.00"
roomRuntime = "2.6.1"
googleDevtoolsKsp = "2.0.0-1.0.22"

[libraries]
androidx-room-compiler = { module = "androidx.room:room-compiler", version.ref = "roomRuntime" }
androidx-room-runtime = { module = "androidx.room:room-runtime", version.ref = "roomRuntime" }

[plugins]
compose-compiler = { id = "org.jetbrains.kotlin.plugin.compose", version.ref = "kotlin" }
google-devtools-ksp = { id = "com.google.devtools.ksp", version.ref = "googleDevtoolsKsp"}
```

```kotlin title="build.gradle.kts"
plugins {
    alias(libs.plugins.google.devtools.ksp) apply false
}
```

```kotlin title="/app/build.gradle.kts"
plugins {
    alias(libs.plugins.google.devtools.ksp)
}

dependencies {
    implementation(libs.androidx.room.runtime)
    annotationProcessor(libs.androidx.room.compiler)
    ksp(libs.androidx.room.compiler)
}
```
