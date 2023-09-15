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

<http://localhost:8888/>

### 环境变量

1. 添加 `CATALINA_HOME` 变量，值为 Tomcat 所在位置
2. 修改 `Path` 变量，添加 `%CATALINA_HOME%\bin`
