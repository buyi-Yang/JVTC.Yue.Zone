# Minecraft

前往 [NetNote](https://net.note.yue.zone/game/minecraft.html)

## WiKi 

- [Java 版世界格式](https://minecraft.fandom.com/zh/wiki/Java%E7%89%88%E4%B8%96%E7%95%8C%E6%A0%BC%E5%BC%8F)
- [生物头颅](https://minecraft.fandom.com/zh/wiki/%E7%94%9F%E7%89%A9%E5%A4%B4%E9%A2%85#%E7%94%9F%E6%88%90)
  + 获取玩家头颅：`/give @s minecraft:player_head{SkullOwner:"<玩家名>"}`

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
