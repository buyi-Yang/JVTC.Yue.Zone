# Tomcat

:::info
Tomcat 是由 Apache 软件基金会下属的 Jakarta 项目开发的一个 Servlet 容器，按照 Sun Microsystems 提供的技术规范开发出来，Tomcat 8 实现了对 Servlet 3.1 和 JavaServer Page 2.3（JSP）的支持，并提供了作为 Web 服务器的一些特有功能，如 Tomcat 管理和控制平台、安全域管理和 Tomcat 附加组件等。

[官方网站](https://tomcat.apache.org/)
:::

## 安装

### Chocolatey

[Chocolatey Software | Apache Tomcat](https://community.chocolatey.org/packages/Tomcat)

```text
Extracting 64-bit C:\ProgramData\chocolatey\lib\Tomcat\tools\apache-tomcat-9.0.78-windows-x64.zip to C:\ProgramData\chocolatey\lib\Tomcat\tools...
C:\ProgramData\chocolatey\lib\Tomcat\tools
C:\ProgramData\Tomcat9
Installing the service 'Tomcat9' ...
Using CATALINA_HOME:    "C:\ProgramData\chocolatey\lib\Tomcat\tools\apache-tomcat-9.0.78"
Using CATALINA_BASE:    "C:\ProgramData\Tomcat9"
Using JAVA_HOME:        "C:\Program Files\OpenJDK\jdk-20.0.2"
Using JRE_HOME:         "C:\Program Files\OpenJDK\jdk-20.0.2"
Using JVM:              "C:\Program Files\OpenJDK\jdk-20.0.2\bin\server\jvm.dll"
```

### Docker

- [tomcat - Official Image | Docker Hub](https://hub.docker.com/_/tomcat)
- [Docker 安装 Tomcat | 菜鸟教程](https://www.runoob.com/docker/docker-install-tomcat.html)

```sh
docker run -it --rm -p 8888:8080 tomcat:9.0
```

http://localhost:8888/

### 压缩包

#### 确保已经配置了 Java 环境

```sh
java -version
```

如果没有输出版本信息请参考 [安装 OpenJDK](https://net.note.yue.zone/coding/Java/#%E9%85%8D%E7%BD%AE%E7%8E%AF%E5%A2%83%E5%8F%98%E9%87%8F)

Tomcat 需要对应 Java 版本，参考：[Apache Tomcat® - Which Version Do I Want?](https://tomcat.apache.org/whichversion.html)

#### 环境变量

1. 添加 `CATALINA_HOME` 变量，值为 Tomcat 所在位置
2. 修改 `Path` 变量，添加 `%CATALINA_HOME%\bin`

## 配置

### 用户

修改 `%CATALINA_HOME%\conf\tomcat-users.xml` 文件，在 `tomcat-users` 内添加用户：

```xml
<user username="admin" password="123123" roles="manager-gui"/>
```

访问管理页面：http://localhost:8888/manager/html

### 日志编码

使用 Windows CMD（命令提示符）启动时会中文输出会乱码，因为 CMD 默认使用 GBK 编码。
修改 `%CATALINA_HOME%\conf\logging.properties` 文件，将所有的 `UTF-8` 改为 `GBK` 即可。

## 启动

```cmd
%CATALINA_HOME%/bin/startup.bat
```

http://localhost:8888/