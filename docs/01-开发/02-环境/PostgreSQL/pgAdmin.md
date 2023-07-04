# pgAdmin

:::info
pgAdmin 是世界上最先进的开源数据库 PostgreSQL 的最流行和功能丰富的开源管理和开发平台。


[pgAdmin](https://www.pgadmin.org/)
:::

## Ubuntu 安装 pgAdmin

```shell
#
# 安装仓库
#

# 安装仓库的公钥（如果之前没有安装）:
sudo curl https://www.pgadmin.org/static/packages_pgadmin_org.pub | sudo apt-key add

# 创建仓库配置文件：
sudo sh -c 'echo "deb https://ftp.postgresql.org/pub/pgadmin/pgadmin4/apt/$(lsb_release -cs) pgadmin4 main" > /etc/apt/sources.list.d/pgadmin4.list && apt update'

#
# 安装 pgAdmin
#

# 安装桌面与 Web 模式：
sudo apt install pgadmin4

# 仅安装桌面模式：
sudo apt install pgadmin4-desktop

# 仅安装 Web 模式： 
sudo apt install pgadmin4-web 

# 如果安装了 `pgadmin4-web` 的话需要配置 Web 服务：
sudo /usr/pgadmin4/bin/setup-web.sh
```

> 参考 [pgAdmin 4 (APT) Download](https://www.pgadmin.org/download/pgadmin-4-apt/)

## 配置 pgAdmin4-web

```bash {1,8-10}
ubuntu@VM-0-5-ubuntu:~$ sudo /usr/pgadmin4/bin/setup-web.sh
Setting up pgAdmin 4 in web mode on a Debian based platform...
Creating configuration database...
NOTE: Configuring authentication for SERVER mode.

Enter the email address and password to use for the initial pgAdmin user account:

Email address: Yue_plus@foxmail.com
Password:
Retype password:
pgAdmin 4 - Application Initialisation
======================================

Creating storage and log directories...
We can now configure the Apache Web server for you. This involves enabling the wsgi module and configuring the pgAdmin 4 application to mount at /pgadmin4. Do you wish to continue (y/n)? y
The Apache web server is running and must be restarted for the pgAdmin 4 installation to complete. Continue (y/n)? y
Apache successfully restarted. You can now start using pgAdmin 4 in web mode at http://127.0.0.1/pgadmin4
```