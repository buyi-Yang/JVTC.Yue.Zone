# GraalVM

:::info
高性能！云原生！多语言！

[官网](https://www.graalvm.org/)
| [官方文档](https://www.graalvm.org/latest/docs/)
:::

## 安装

### 参考官网

参考：[Install GraalVM](https://www.graalvm.org/latest/docs/getting-started/#install-graalvm)

### 通过 Chocolate

> 参考 [Chocolatey Software | GraalVM Latest Stable Java Version](https://community.chocolatey.org/packages/graalvm)

```ps
choco install graalvm
```

### 常见问题

如果之前安装了 Java 的话需要将环境变量上移盖过 Java。

### 验证安装

```ps
PS C:\Users\Yue_plus> java -version
openjdk version "17.0.6" 2023-01-17
OpenJDK Runtime Environment GraalVM CE 22.3.1 (build 17.0.6+10-jvmci-22.3-b13)
OpenJDK 64-Bit Server VM GraalVM CE 22.3.1 (build 17.0.6+10-jvmci-22.3-b13, mixed mode, sharing)
```

### 安装完毕后可使用 `gu` 命令

:::tip
在 Windows PowerShell 中使用 `gu.cmd` 命令。
:::


<details>
<summary><code>gu --help</code></summary>

```text
PS C:\Users\Yue_plus> gu.cmd --help
GraalVM Component Updater v2.0.0

Usage:
        gu info [-cClLnprstuvVJ] <param>        print info about a specific component (from a file, a URL or a catalog)
        gu available [-aClvVJ] <expr>           list components available in a catalog
        gu install [-0CcDfiLMnosruvyxY] <param> install a component package
        gu list [-clvJ] <expression>            list installed components, or components from a catalog
        gu remove [-0DfMxv] <id>                uninstall a component
        gu upgrade [-cCnLsuxSd] [<ver>] [<cmp>] upgrade to a recent GraalVM or edition
        gu rebuild-images                       rebuild native executables. Use -h for detailed usage

Common options:
  -A, --auto-yes              respond YES or ACCEPT to all questions.
  -c, --catalog               treat parameters as component IDs from a catalog of GraalVM components. This is the default.
  -C, --custom-catalog <url>  use user-supplied catalog at URL.
  -e, --debug                 debugging. Prints stacktraces, ...
  -E, --no-catalog-errors     do not stop if at least one catalog is working.
  -h, --help                  print help.
  -L, --local-file, --file    treat parameters as local filenames of packaged components.
  -N, --non-interactive       noninteractive mode. Fail when input is required.
  --show-version              print version information and continue.
  -u, --url                   interpret parameters as URLs of packaged components.
  -v, --verbose               be verbose. Print versions and dependency information.
  --version                   print version.

Additonal options:
        --email <address>         email address that confirms acceptance of GDS license.
                                  can only be used with some commands.
        --config <path>           path to configuration file
        --show-ee-token           print current download token

Use
        gu <command> -h
to get specific help.

Runtime options:
  --native                                     Run using the native launcher with limited access to Java libraries
                                               (default).
  --jvm                                        Run on the Java Virtual Machine with access to Java libraries.
  --vm.[option]                                Pass options to the host VM. To see available options, use '--help:vm'.
  --log.file=<String>                          Redirect guest languages logging into a given file.
  --log.[logger].level=<String>                Set language log level to OFF, SEVERE, WARNING, INFO, CONFIG, FINE,
                                               FINER, FINEST or ALL.
  --help                                       Print this help message.
  --help:vm                                    Print options for the host VM.

See http://www.graalvm.org for more information.
[WARNING] Unable to create a system terminal, creating a dumb terminal (enable debug logging for more information)
```

</details>

## 原生镜像

> 参考 [Native Image - GraalVM Reference Manuals](https://www.graalvm.org/latest/reference-manual/native-image/)

安装原生镜像支持：

```ps
gu install native-image
```
