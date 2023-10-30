# Docker

前往 [NetNote](https://net.note.yue.zone/coding/Docker/)

[官网](https://www.docker.com/)
| [文档](https://docs.docker.com/)
| [菜鸟教程](https://www.runoob.com/docker/docker-tutorial.html)
| [编程宝库](http://www.codebaoku.com/docker/docker-index.html)
| [Docker Hub](https://hub.docker.com/)

## 镜像站

- [Docker ToolBox镜像 - 阿里巴巴开源镜像站](https://developer.aliyun.com/mirror/docker-toolbox)
- [Docker CE 镜像 - 阿里巴巴开源镜像站](https://developer.aliyun.com/mirror/docker-ce)
- [Docker CE 软件仓库镜像使用帮助 | 清华大学开源软件镜像站](https://mirrors.tuna.tsinghua.edu.cn/help/docker-ce/)
- [Docker Hub 镜像源 - 掘金](https://juejin.cn/post/7165806699461378085)

修改 `daemon.json` 文件即可配置镜像仓库：

```json title="daemon.json"
{
    "registry-mirrors": [
        "https://dockerproxy.com",
        "https://hub-mirror.c.163.com",
        "https://mirror.baidubce.com",
        "https://ccr.ccs.tencentyun.com"
    ]
}
```

UbuntuServer: `/etc/docker/daemon.json`

## 容器（Containers）

### 配置容器随 Docker 启动

参考：[Start containers automatically | Docker Documentation](https://docs.docker.com/config/containers/start-containers-automatically/)

```ps
docker run --restart=always <containerName>
docker update --restart=always <containerName>
```

| 选项 | 说明 |
| --- | --- |
| `no` | 不自动重启容器。（默认） |
| `on-failure[:max-retries]` | 如果容器因错误而退出，则重新启动容器，该错误显示为非零退出代码。可以使用 `:max-retries` 选项限制 Docker 守护进程尝试重新启动容器的次数。 |
| `always` | 容器一旦停止，一定会重新启动它。如果是手动停止，那么只有当 Docker 守护进程重启或容器本身手动重启时才会重启。 |
| `unless-stopped` | 与 `always` 类似，除了当容器被停止（手动或其他方式）时，即使在 Docker 守护进程重新启动之后，它也不会重新启动。 |

## 开发环境（Dev Environments）

- [Overview of Dev Environments | Docker Docs](https://docs.docker.com/desktop/dev-environments/)
- [Docker Compose overview | Docker Docs](https://docs.docker.com/compose/)

## 扩展（Extensions）

### 访问容器

使用 `host.docker.internal` 域名访问容器。

## 常见问题

### Docker Desktop 一直卡在 `String Docker Engine...`

```text
Starting the Docker Engine...
Docker Engine is the underlying technology that runs containers
```

重启 Windows 系统仍然无法解决。

#### 解决方法

参考：[Docker永远在“docker desktop starting .”Settings 一直在转圈 - Popeye-lxw - 博客园](https://www.cnblogs.com/liuxw/p/17310264.html)

实在不行卸掉 Docker 重装。
