# Minecraft

前往 [NetNote](https://net.note.yue.zone/game/minecraft.html)

## 配置为系统服务

创建 `/etc/systemd/system/minecraft-server.service` 文件：

```toml
[Unit]
Description=Minecraft服务器
After=ssh.service
StartLimitBurst=5
StartLimitIntervalSec=0

[Service]
Type=simple
Restart=always
RestartSec=10
User=yueplus
ExecStart=/home/yueplus/mc1.20.1/start.sh

[Install]
WantedBy=multi-user.target
```

```sh
# 重新加载系统服务
sudo systemctl daemon-reload

# 设置开机启动
sudo systemctl start minecraft-server.service

# 启动服务
sudo systemctl start minecraft-server.service

# 查看服务状态
sudo systemctl status minecraft-server.service
```
