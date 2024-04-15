# DataStore

:::tip
Jetpack DataStore 是一种数据存储解决方案，允许您使用协议缓冲区存储键值对或类型化对象。DataStore 使用 Kotlin 协程和 Flow 以异步、一致的事务方式存储数据。

[官方文档](https://developer.android.google.cn/topic/libraries/architecture/datastore?hl=zh-cn)
:::

## 添加依赖

### Preferences DataStore

```kotlin title="app\build.gradle.kts"
dependencies {
    // implementation("androidx.datastore:datastore-preferences:1.0.0")
    implementation(libs.androidx.datastore.preferences)
}
```

```toml title="gradle\libs.versions.toml"
[version]
datastoreVersion = "1.0.0"


[libraries]
androidx-datastore-preferences = { module = "androidx.datastore:datastore-preferences", version.ref = "datastoreVersion" }
```

## 使用 Preferences DataStore 存储键值对

### 创建 Preferences DataStore

```kotlin
import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore

val Context.dateStore: DataStore<Preferences> by preferencesDataStore("text")
```

<!--
### 从 Preferences DataStore 读取内容

```kotlin
import androidx.compose.material3.Button
import androidx.compose.ui.platform.LocalContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

val context = LocalContext.current

Button(onClick = {
    CoroutineScope(Dispatchers.IO).launch {
        val ys = YS.read(context)
        readText = ys.text
        readHasBackgroundColor = ys.hasBackgroundColor
                    }
                }) { Text("读取") }
```
-->