# GraalVM

:::info
高性能！云原生！多语言！

[官网](https://www.graalvm.org/)
| [官方文档](https://www.graalvm.org/latest/docs/)
:::

## 安装 GraalVM

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

### 安装原生镜像支持

> 参考 [Native Image - GraalVM Reference Manuals](https://www.graalvm.org/latest/reference-manual/native-image/)

原生镜像支持可以使用 [GraalVM 更新工具](https://www.graalvm.org/latest/reference-manual/graalvm-updater/) 添加到 GraalVM。

运行此命令安装原生镜像支持：

```ps
gu install native-image
```

`native-image` 工具将被安装到 `$JAVA_HOME/bin` 目录。

<details>
<summary><code>native-image --help</code></summary>

```text
PS C:\Users\Yue_plus> native-image.cmd --help

GraalVM Native Image (https://www.graalvm.org/native-image/)

This tool can ahead-of-time compile Java code to native executables.

Usage: native-image [options] class [imagename] [options]
           (to build an image for a class)
   or  native-image [options] -jar jarfile [imagename] [options]
           (to build an image for a jar file)
   or  native-image [options] -m <module>[/<mainclass>] [options]
       native-image [options] --module <module>[/<mainclass>] [options]
           (to build an image for a module)

where options include:

    @argument files       one or more argument files containing options
    -cp <class search path of directories and zip/jar files>
    -classpath <class search path of directories and zip/jar files>
    --class-path <class search path of directories and zip/jar files>
                          A ; separated list of directories, JAR archives,
                          and ZIP archives to search for class files.
    -p <module path>
    --module-path <module path>...
                          A ; separated list of directories, each directory
                          is a directory of modules.
    --add-modules <module name>[,<module name>...]
                          root modules to resolve in addition to the initial module.
                          <module name> can also be ALL-DEFAULT, ALL-SYSTEM,
                          ALL-MODULE-PATH.
    -D<name>=<value>      set a system property
    -J<flag>              pass <flag> directly to the JVM running the image generator
    -O<level>             0 - no optimizations, 1 - basic optimizations (default),
                          b - quick build mode for development.
    --diagnostics-mode    enable diagnostics output: class initialization, substitutions, etc.
    --enable-preview      allow classes to depend on preview features of this release
    --verbose             enable verbose output
    --version             print product version and exit
    --help                print this help message
    --help-extra          print help on non-standard options

    --auto-fallback       build stand-alone image if possible
    --configure-reflection-metadata
                          enable runtime instantiation of reflection objects for non-invoked
                          methods.
    --enable-all-security-services
                          add all security service classes to the generated image.
    --enable-http         enable http support in the generated image
    --enable-https        enable https support in the generated image
    --enable-monitoring   enable monitoring features that allow the VM to be inspected at
                          run time. Comma-separated list can contain 'heapdump', 'jfr',
                          'jvmstat', or 'all' (defaults to 'all' if no argument is
                          provided). For example: `--enable-monitoring=heapdump,jvmstat`.
    --enable-url-protocols
                          list of comma separated URL protocols to enable.
    --features            a comma-separated list of fully qualified Feature implementation
                          classes
    --force-fallback      force building of fallback image
    --gc=<value>          select native-image garbage collector implementation. Allowed
                          options for <value>:
                          'epsilon': Epsilon garbage collector
                          'serial': Serial garbage collector (default)
    --initialize-at-build-time
                          a comma-separated list of packages and classes (and implicitly all
                          of their superclasses) that are initialized during image
                          generation. An empty string designates all packages.
    --initialize-at-run-time
                          a comma-separated list of packages and classes (and implicitly all
                          of their subclasses) that must be initialized at runtime and not
                          during image building. An empty string is currently not
                          supported.
    --install-exit-handlers
                          provide java.lang.Terminator exit handlers
    --libc                selects the libc implementation to use. Available implementations:
                          glibc, musl, bionic
    --link-at-build-time  require types to be fully defined at image build-time. If used
                          without args, all classes in scope of the option are required to
                          be fully defined.
    --link-at-build-time-paths
                          require all types in given class or module-path entries to be
                          fully defined at image build-time.
    --list-cpu-features   show CPU features specific to the target platform and exit.
    --list-modules        list observable modules and exit.
    --native-compiler-options
                          provide custom C compiler option used for query code compilation.
    --native-compiler-path
                          provide custom path to C compiler used for query code compilation
                          and linking.
    --native-image-info   show native-toolchain information and image-build settings
    --no-fallback         build stand-alone image or report failure
    --report-unsupported-elements-at-runtime
                          report usage of unsupported methods and fields at run time when
                          they are accessed the first time, instead of as an error during
                          image building
    --shared              build shared library
    --silent              silence build output
    --static              build statically linked executable (requires static libc and zlib)
    --target              selects native-image compilation target (in <OS>-<architecture>
                          format). Defaults to host's OS-architecture pair.
    --trace-class-initialization
                          comma-separated list of fully-qualified class names that class
                          initialization is traced for.
    --trace-object-instantiation
                          comma-separated list of fully-qualified class names that object
                          instantiation is traced for.
    -da                   also -da[:[packagename]...|:classname] or
                          -disableassertions[:[packagename]...|:classname]. Disable
                          assertions with specified granularity.
    -dsa                  also -disablesystemassertions. Disables assertions in all system
                          classes.
    -ea                   also -ea[:[packagename]...|:classname] or
                          -enableassertions[:[packagename]...|:classname]. Enable
                          assertions with specified granularity.
    -esa                  also -enablesystemassertions. Enables assertions in all system
                          classes.
    -g                    generate debugging information
    -o                    name of the output file to be generated

Available macro-options are:
    --language:nfi
    --language:regex
    --language:icu4j
    --tool:coverage
    --tool:insight
    --tool:dap
    --tool:chromeinspector
    --tool:insightheap
    --tool:lsp
    --tool:profiler
```

</details>

### Windows 系统先决条件

> 要在 Windows 上使用原生映像，需要安装 Visual Studio 和 Microsoft Visual c++ (MSVC)。
> 有两种安装选项:
> 
> * 使用 Windows SDK 安装 Visual Studio 构建工具
> * 使用 Windows SDK 安装 Visual Studio
> 
> 可以使用 Visual Studio 2017 version 15.9 或更高版本。
> “原生镜像”构建器只有在从 **X64 原生工具命令提示符** 中运行时才能工作。
> 启动 X64 原生工具命令提示符的命令根据是否只安装了 Visual Studio 构建工具或是否安装了完整的 Visual Studio 2019 而有所不同。

↑↑↑说人话：
- [下载 Visual Studio](https://visualstudio.microsoft.com/downloads/)
- 安装时选择 **使用 C++ 的桌面开发**，可选项里勾选 **Windows 10/11 SDK**
- 添加环境变量（版本更新会导致路径改变）：
  `C:\Program Files\Microsoft Visual Studio\2022\Community\VC\Tools\MSVC\14.35.32215\bin\Hostx64\x64`
