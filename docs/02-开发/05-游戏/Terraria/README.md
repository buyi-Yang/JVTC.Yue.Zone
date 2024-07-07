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

#### 允许开启撒旦军队事件

[撒旦军队（旧日军团）- 官方中文 Terraria Wiki](https://terraria.wiki.gg/zh/wiki/%E6%92%92%E6%97%A6%E5%86%9B%E9%98%9F)

```text
/group addperm default tshock.npc.startdd2
```

## tModLoader

tModLoader（TML）是泰拉瑞亚游戏的开源、社区驱动的修改和扩展，使制作和玩模组成为可能。
TML 通过泰拉瑞亚社区创建的新内容扩展您的泰拉瑞亚冒险！
TML 允许玩家创建和玩泰拉瑞亚模组，其设计方式使您可以单独或与朋友一起玩，使用一个模组或多个模组：选择随心所欲地玩！

但是，如果您想一起玩，则要求您的所有朋友也安装 TML；
原版用户无法与 TML 用户一起玩。
TML 与 TShock 并不兼容。

[官方网站](https://www.tmodloader.net/)
| [在 Steam 上获取 tModLoader](https://store.steampowered.com/app/1281930/tModLoader/)
| [GitHub](https://github.com/tModLoader/tModLoader)
| [WiKi](https://github.com/tModLoader/tModLoader/wiki)

地图用户默认保存在 `~/.local/share/Terraria/tModLoader/` 目录下。