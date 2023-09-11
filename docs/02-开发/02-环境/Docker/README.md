# Docker

前往 [NetNote](https://net.note.yue.zone/coding/Docker/)

[官网](https://www.docker.com/)
| [文档](https://docs.docker.com/)
| [Docker Hub](https://hub.docker.com/)

## 配置容器随 Docker 启动

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

## 扩展（Extensions）访问容器

使用 `host.docker.internal` 域名访问容器。
