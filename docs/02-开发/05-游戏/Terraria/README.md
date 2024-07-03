# Terraria

:::info
《泰拉瑞亚》是冒险之地！是神秘之地！是可让你塑造、捍卫、享受的大地。在《泰拉瑞亚》，你有无穷选择。
手指发痒的动作游戏迷？建筑大师？收藏家？探险家？每个人都能找到自己想要的。

从建造基本的藏身之处开始，接着挖掘矿石及其他资源。
探索并制作超过 500 种各式魔法、远程、近战、和召唤武器，以及盔甲，借助它们与数百种不同的敌怪战斗。
很快，你将直面十多个巨大的 Boss。还可以去钓鱼、骑上坐骑、找寻漂浮岛、为 NPC 建造房屋，有很多很多事情可以做。

[官方网站](https://www.terraria.org/)
| [WiKi](https://terraria.wiki.gg/zh/wiki/Terraria_Wiki)
:::

## TShock

TShock 是为泰拉瑞亚服务器和社区开发的一个工具箱。
这个工具箱拥有反作弊、服务端存档、用户组、权限、物品禁止、大量指令和无限的可能性。
它是独一无二的。

[GitHub](https://github.com/Pryaxis/TShock)
| [使用文档](https://ikebukuro.tshock.co/#/)

### 服务器启动脚本

```sh
./TShock.Installer \
        --port 7777 \
        -maxplayers 20 \
        -world /home/yueplus/TShock-5.2/world/神奇小镇.wld \
        --worldselectpath /home/yueplus/TShock-5.2/world \
        -worldname 神奇小镇 \
        -autocreate 3 \
        -motd Yoooooooooooooooo\! \
        -secure 1 \
        -difficulty 2 \
        -lang zh_CN
```

### 配置强制开荒

```json {3} title="tshock/sscconfig.json"
{
  "Settings": {
    "Enabled": true,
    "ServerSideCharacterSave": 5,
    "LogonDiscardThreshold": 250,
    "StartingHealth": 100,
    "StartingMana": 20,
    "StartingInventory": [
      {
        "netID": -15,
        "prefix": 0,
        "stack": 1
      },
      {
        "netID": -13,
        "prefix": 0,
        "stack": 1
      },
      {
        "netID": -16,
        "prefix": 0,
        "stack": 1
      }
    ],
    "WarnPlayersAboutBypassPermission": true
  }
}
```

### 配置出生点保护

```json {3,4} title="tshock/config.json"
{
  "Settings": {
    "SpawnProtection": false,
    "SpawnProtectionRadius": 10,
  }
}
```

### 配置方块可破坏阈值

原本是 60，太低了导致连续仍炸弹无法破坏方块

```json {3} title="tshock/config.json"
{
  "Settings": {
    "TileKillThreshold": 300,
  }
}
```

### 配置玩家权限

[查看所有可编辑权限](https://ikebukuro.tshock.co/#/permission-descriptions)

#### 允许修改 NPC 房间

```text
/group addperm default tshock.world.movenpc
```

#### 允许开启入侵事件

哥布林、雪人军团

```text
/group addperm default tshock.npc.startinvasion
```
