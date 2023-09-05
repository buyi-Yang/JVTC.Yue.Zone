# HTTP 服务器

| [官网](https://httpd.apache.org/)
| [Apache HTTP 服务器 2.4 文档](https://httpd.apache.org/docs/2.4/)
|

## 安装

参考 [Compiling and Installing - Apache HTTP Server Version 2.4](https://httpd.apache.org/docs/2.4/en/install.html)

### Fedora / CentOS / Red Hat Enterprise Linux

```shell
sudo yum install httpd
sudo systemctl enable httpd
sudo systemctl start httpd
```

### Ubuntu / Debian

```shell
sudo apt install apache2
sudo service apache2 start
```

## 常用指令

参考 [Directive Quick Reference - Apache HTTP Server Version 2.4](https://httpd.apache.org/docs/2.4/en/mod/quickreference.html)

### `apache2`

别名：`apache2ctl` | `apachectl`

<details>
<summary><code>apache2 -h</code></summary>

```text
$ apache2 -h
Usage: apache2 [-D name] [-d directory] [-f file]
               [-C "directive"] [-c "directive"]
               [-k start|restart|graceful|graceful-stop|stop]
               [-v] [-V] [-h] [-l] [-L] [-t] [-T] [-S] [-X]
Options:
  -D name            : 定义在 <IfDefine name> 指令中使用的名称
  -d directory       : 指定初始 ServerRoot 备用
  -f file            : 指定 ServerConfigFile 备用
  -C "directive"     : 在读取配置文件前的处理指令
  -c "directive"     : 在读取配置文件后的处理指令
  -e level           : 显示启动错误级别（参考 LogLevel）
  -E file            : 将启动错误保存到文件
  -v                 : 显示版本号
  -V                 : 显示编译设置
  -h                 : 列出可用的命令行选项（本页）
  -l                 : 列出已编译的模块
  -L                 : 列出可用的配置指令
  -t -D DUMP_VHOSTS  : 显示已解析的虚拟主机设置
  -t -D DUMP_RUN_CFG : 显示解析的运行设置
  -S                 : -t -D DUMP_VHOSTS -D DUMP_RUN_CFG 简写
  -t -D DUMP_MODULES : 显示所有已加载的模块
  -M                 : -t -D DUMP_MODULES 简写
  -t -D DUMP_INCLUDES: 显示所有已包含的配置文件
  -t                 : 对配置文件进行语法检查
  -T                 : 在没有 DocumentRoot(s) 检查的情况下启动
  -X                 : 调试模式（单 Worker，不拆分）
```

</details>

### `a2`

+ `dis` - 禁用
| `en` - 启用
  + `conf` - 配置
  | `mod` - 模块
  | `site` - 站点
  | `query` - 查询

```text
a2disconf  a2dismod   a2dissite  a2enconf   a2enmod    a2ensite   a2query
```

<details>
<summary><code>a2query -h</code></summary>

```text{1}
$ a2query -h
Usage: /usr/sbin/a2query -q -m [MODULE] -s [SITE] -c [CONF] -a -v -M -d -h
-q              抑制任何输出。用于从脚本调用
-m [MODULE]     检查模块 MODULE 是否启用，如果没有参数则列出所有启用的模块
-s [SITE]       检查站点 SITE 是否启用，如果没有参数则列出所有站点
-c [CONF]       检查配置 CONF 是否启用，如果没有参数则列出所有配置
-a              返回当前的 Apache 2 模块魔法版本
-v              返回当前的 Apache 2 版本
-M              返回启用的 Apache 2 MPM
-d              返回 Apache 2 模块目录
-h              显示此帮助
```

</details>

## 配置：一台主机多个站点

## 配置：SSL 证书（HTTPS）

参考：

- [在Apache服务器上安装SSL证书 - 阿里云帮助中心](https://help.aliyun.com/document_detail/98727.html)
- [在Ubuntu系统Apache 2部署SSL证书 - 阿里云帮助中心](https://help.aliyun.com/document_detail/102450.html?spm=a2c4g.11186623.0.0.2bd26079VlvY73)

启用 SSL 模块：

```shell
sudo a2enmod ssl
```

编辑 `/etc/apache2/sites-available/default-ssl.conf` 文件，第 33、34、43 行，修改为证书保存位置：

```diff
  28                 #   A self-signed (snakeoil) certificate can be created by installing
  29                 #   the ssl-cert package. See
  30                 #   /usr/share/doc/apache2/README.Debian.gz for more info.
  31                 #   If both key and certificate are stored in the same file, only the
  32                 #   SSLCertificateFile directive is needed.
+ 33                 SSLCertificateFile      /etc/apache2/ssl/public.crt
+ 34                 SSLCertificateKeyFile   /etc/apache2/ssl/private.key
  35
  36                 #   Server Certificate Chain:
  37                 #   Point SSLCertificateChainFile at a file containing the
  38                 #   concatenation of PEM encoded CA certificates which form the
  39                 #   certificate chain for the server certificate. Alternatively
  40                 #   the referenced file can be the same as SSLCertificateFile
  41                 #   when the CA certificates are directly appended to the server
  42                 #   certificate for convinience.
+ 43                 SSLCertificateChainFile /etc/apache2/ssl/ca.crt
```



