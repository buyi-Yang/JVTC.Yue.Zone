# HTTP 服务器

| [官网](https://httpd.apache.org/)
| [Apache HTTP 服务器 2.4 文档](https://httpd.apache.org/docs/2.4/)
|

## 安装

参考 [](https://httpd.apache.org/docs/2.4/en/install.html)

### Fedora/CentOS/Red Hat Enterprise Linux

```shell
sudo yum install httpd
sudo systemctl enable httpd
sudo systemctl start httpd
```

### Ubuntu/Debian

```shell
sudo apt install apache2
sudo service apache2 start
```