# Maven

:::info
Maven 是一个项目管理工具，可以对 Java 项目进行构建、依赖管理。

[官方网站](https://maven.apache.org/)
| [阿里巴巴开源镜像站](https://developer.aliyun.com/mirror/maven)
| [菜鸟教程](https://www.runoob.com/maven/maven-tutorial.html)
:::

## 安装

参考官方网站：
[下载](https://maven.apache.org/download.cgi)
| [安装](https://maven.apache.org/install.html)

----------

也可以使用 [Chocolatey](https://community.chocolatey.org/packages/maven)，安装：

```sh
choco install maven -y
```

安装位置：`C:\ProgramData\chocolatey\lib\maven\apache-maven-3.9.4`

----------

如果使用 IDEA 会自带一套 Maven，配置可以直接写在 `~/.m2/settings.xml` 里（没有就新建一个）。

## 配置

配置文件位于 Maven 安装目录中的 `conf/setting.xml` 文件中。


> 可以使用以下命令查询 Maven 安装位置；
> - PowerShell: `Get-Command mvn | Select-Object Source`
> - Bash: `which git` 或 `where git`
> - CMD:  `where mvn`

以下是一个配置阿里云 Maven 镜像的配置：

```xml title="setting.xml"
<?xml version="1.0" encoding="UTF-8"?>
<settings xmlns="http://maven.apache.org/SETTINGS/1.2.0"
          xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
          xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.2.0 https://maven.apache.org/xsd/settings-1.2.0.xsd">
  <mirrors>
    <mirror>
      <id>maven-default-http-blocker</id>
      <mirrorOf>external:http:*</mirrorOf>
      <name>Pseudo repository to mirror external repositories initially using HTTP.</name>
      <url>http://0.0.0.0/</url>
      <blocked>true</blocked>
    </mirror>
    <mirror>
      <id>aliyunmaven</id>
      <mirrorOf>*</mirrorOf>
      <name>阿里云公共仓库</name>
      <url>https://maven.aliyun.com/repository/public</url>
    </mirror>
  </mirrors>
</settings>
```
