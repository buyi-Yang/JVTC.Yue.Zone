# MariaDB & MySQL

:::info
MariaDB 数据库管理系统是 MySQL 的一个分支，主要由开源社区在维护，采用 GPL 授权许可。
MariaDB 的目的是全兼容 MySQL，包括 API 与命令行，使之能轻松成为 MySQL 的代替品。

MySQL 是最流行的关系型数据库管理系统，在 WEB 应用方面 MySQL 是最好的
RDBMS（Relational Database Management System：关系数据库管理系统）
应用软件之一。

- [MariaDB 官网](https://mariadb.org/)
  | [编程宝库](http://www.codebaoku.com/mariadb/mariadb-index.html)

- [MySQL 官网](https://www.mysql.com/cn/)
  | [中文文档](https://www.mysqlzh.com/)
  | [编程宝库](http://www.codebaoku.com/mysql/mysql-index.html)
  | [菜鸟教程](https://www.runoob.com/mysql/mysql-tutorial.html)
:::

> 前往 [NetNote](https://net.note.yue.zone/coding/MariaDB/)
> | [CentOS](https://net.note.yue.zone/serve/CentOS/MariaDB/)

## CLI 自动补全

### `mysql-client`

#### 临时开启

```sh
sudo mysql -u root -p --auto-rehash
```

#### 长期开启

Ubuntu Server 系统，先修改 `/etc/mysql/mysql.conf.d/mysql.cnf` 文件：

```diff title="/etc/mysql/mysql.conf.d/mysql.cnf"
  [mysql]
+ auto-rehash
```

重启 MySQL 服务

```sh
sudo systemctl restart mysql.service
```

### mycli

**[mycli 官方网站](https://www.mycli.net/)**

```sh
sudo apt install mycli -y
```

## 用户与权限管理

参考易百教程：[MySQL管理](https://www.yiibai.com/mysql/administration.html)
| [MySQL授予权限（Grant语句）](https://www.yiibai.com/mysql/grant.html)

### 刷新权限

```sql
FLUSH PRIVILEGES;
```
### 创建用户

```sql
CREATE USER 'username'@'localhost' IDENTIFIED BY '!@#$Password1234';
```

### 查看所有用户

```sql
SELECT user, host FROM mysql.user;
```

### 删除用户

```sql
DROP USER username;
```

### 数据库授权

```sql
GRANT ALL PRIVILEGES ON mydata.* TO 'username'@'localhost';
```

## 常见问题

### ERROR 1819

```text
ERROR 1819 (HY000): Your password does not satisfy the current policy requirements
```

密码强度无法满足当前的政策要求。

