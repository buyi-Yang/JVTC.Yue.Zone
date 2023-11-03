# 使用 Docker 一键部署

参考：[一键 Docker 部署 - WeBASE 文档](https://webasedoc.readthedocs.io/zh-cn/latest/docs/WeBASE-Install/docker_install.html)
| [Docker](../../02-环境/Docker/README.md)

**本案例使用 Ubuntu 22.04 LTS**

## 准备系统环境

### 安装相关依赖

```sh
sudo apt install openssl curl wget git dos2unix zip openjdk-11-jre -y
```

### 安装 Dockers

```sh
sudo apt install docker docker-compose -y
```

配置 Docker 镜像，修改 `/etc/docker/daemon.json` 文件（没有则新建）：

```json title="/etc/docker/daemon.json"
{
    "registry-mirrors": [
        "https://dockerproxy.com",
        "https://hub-mirror.c.163.com",
        "https://mirror.baidubce.com",
        "https://ccr.ccs.tencentyun.com"
    ]
}
```

重新加载配置文件，重启docker服务：

```sh
sudo systemctl daemon-reload
sudo systemctl restart docker.service
```

### 安装 Python

```sh
sudo apt install python3 python3-pip -y
sudo pip3 install PyMySQL
```

## 开始部署

### 拉取部署脚本

```sh
# 获取部署安装包：
wget https://osp-1257653870.cos.ap-guangzhou.myqcloud.com/WeBASE/releases/download/v1.5.5/webase-deploy.zip

# 解压安装包：
unzip webase-deploy.zip

# 进入目录：
cd webase-deploy
```

### 拉取 Docker 镜像

```sh
sudo docker pull mysql
sudo docker pull fiscoorg/fiscobcos
sudo docker pull webasepro/webase-front
sudo docker pull webasepro/webase-node-mgr
sudo docker pull webasepro/webase-sign
sudo docker pull webasepro/webase-web
```

### Docker 启动 MySQL 容器

参考：[mysql - Official Image | Docker Hub](https://hub.docker.com/_/mysql)

```sh
sudo docker run -it --name webase-mysql -p 23306:3306 -e MYSQL_ROOT_PASSWORD=123456 -d mysql:latest --restart=always
```

### 一键部署

```sh
# 部署并启动所有服务
python3 deploy.py installDockerAll

# 停止一键部署的所有服务
python3 deploy.py stopDockerAll

# 启动一键部署的所有服务
python3 deploy.py startDockerAll
```

#### 节点的启停

```sh
# 启动所有 FISCO-BCOS 节点
python3 deploy.py startNode

# 停止所有 FISCO-BCOS 节点
python3 deploy.py stopNode
```

#### WeBASE服务的启停

```sh
# 启动所有 WeBASE 服务
python3 deploy.py dockerStart

# 停止所有 WeBASE 服务
python3 deploy.py dockerStop
```

## 访问 WeBASE

浏览器访问 <https://localhost:5000/>；
默认账号：`admin`；
默认密码：`Abcd1234`；
首次登入强制修改密码；
