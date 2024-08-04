# Unturned

:::info
《未转变者（Unturned）》是一款第一人称沙盒生存游戏，该游戏融合了 [Minecraft](../Minecraft/README.md) 的方块画面特色以及dayz的游戏特色，玩家将扮演幸存者，躲避丧尸以及其他玩家的攻击，建造防御工程，寻找食物和水，获取更多的武器和弹药应对丧尸和玩家的攻击。

[官方文档](https://docs.smartlydressedgames.com/en/stable/)
[在 Steam 上免费开玩！](https://store.steampowered.com/app/304930/Unturned/)
:::

## 在 Ubuntu 上配置服务器

> 参考： https://unturned.wiki.gg/wiki/Linux_dedicated_server#Installing_SteamCMD

### 安装 SteamCMD

要安装 SteamCMD，必须启用 multiverse 仓库和 x86 包。

```sh
sudo add-apt-repository multiverse; sudo dpkg --add-architecture i386; sudo apt update
sudo apt install steamcmd
```

### 运行 SteamCMD

```sh
steamcmd
```

### SteamCMD

[官方文档](https://developer.valvesoftware.com/wiki/SteamCMD#LinuxSteamCMD)

#### 配置应用安装目录

```text
Steam> force_install_dir <path>
```

#### 匿名登入

```text
Steam> login anonymous
```

#### 使用 Steam 帐户

某些服务器会要求使用 Steam 帐户登录。

:::warning
出于安全原因，建议为专用服务器创建一个新的 Steam 帐户。

用户在任何时候只能登录一次（包括 grapical 客户端和 SteamCMD 登录）。
:::

```sh
Steam> login <username>
```

接下来，输入密码。
如果用户帐户上激活了 Steam 令牌，请检查电子邮件以获取 Steam 令牌访问代码并输入该代码。
只有在首次登录时（以及当您删除 SteamCMD 存储登录信息的文件）时才需要这样做。

#### 下载服务器

```text
Steam> app_update 1110390
```

下载完成后使用 `quit` 命令退出。

下载的文件保存在 `~/Steam/steamapps/common/U3DS/`：

```text
Steam/steamapps/common/U3DS
├── BattlEye
├── Bundles
├── Content
├── CuratedMapIcons
├── EconInfo.json
├── ExampleServer.sh
├── Extras
├── install.vdf
├── Licenses.txt
├── linux64
├── LoadingScreens
├── Localization
├── Logs
├── Maps
├── Modules
├── Sandbox
├── ServerHelper.sh
├── Servers/<ServerName>
│   ├── Bundles
│   ├── Config.json
│   ├── Level
│   │   ├── PEI
│   │   └── Russia
│   ├── Maps
│   ├── Players
│   │   └── 76561198312824570_0
│   ├── Server
│   │   ├── Adminlist.dat
│   │   ├── Blacklist.dat
│   │   ├── Commands.dat
│   │   └── Whitelist.dat
│   ├── Workshop
│   │   ├── Content
│   │   ├── Maps
│   │   └── Steam
│   └── WorkshopDownloadConfig.json
├── Status.json
├── steam_appid.txt
├── steamclient.so
├── StreamerNames.json
├── UnityPlayer.so
├── Unturned_Headless_Data
└── Unturned_Headless.x86_64
```

### 配置 GSLT

> GSLT 是 Game Server Login Token 的缩写，译为：[游戏服务器登录令牌](https://docs.smartlydressedgames.com/en/stable/servers/game-server-login-tokens.html)

前往 [Steam 游戏服务器帐户管理](https://steamcommunity.com/dev/managegameservers) 创建一个新的游戏服务器帐户。

基础游戏的 App ID 填：`304930`

点击创建按钮后可以看到表格，复制 **登录令牌** 粘贴到服务器 `~/Steam/steamapps/common/U3DS/Servers/<服务器名>/Config.json` 文件中：

```json {8} title="~/Steam/steamapps/common/U3DS/Servers/<服务器名>/Config.json"
{
  "Browser": {
    "Icon": "",
    "Thumbnail": "",
    "Desc_Hint": "",
    "Desc_Full": "",
    "Desc_Server_List": "",
    "Login_Token": "<此处填入登入令牌>",
    "BookmarkHost": "",
    "Monetization": "Unspecified",
    "Links": null
  },

  // 后面省略……
}
```

### 使用创意工坊内容

修改 `~/Steam/steamapps/common/U3DS/Servers/<服务器名>/WorkshopDownloadConfig.json` 文件中的 `File_IDs`：

```json {2} title="~/Steam/steamapps/common/U3DS/Servers/<服务器名>/WorkshopDownloadConfig.json"
{
  "File_IDs": [],
  "Ignore_Children_File_IDs": [],
  "Query_Cache_Max_Age_Seconds": 600,
  "Max_Query_Retries": 2,
  "Use_Cached_Downloads": true,
  "Should_Monitor_Updates": true,
  "Shutdown_Update_Detected_Timer": 600,
  "Shutdown_Update_Detected_Message": "Workshop file update detected, shutdown in: {0}",
  "Shutdown_Kick_Message": "Shutdown for Workshop file update."
}
```

`File_IDs` 为创意工坊的 ID，打开相应的创意工坊页面，看 URL：

```text
https://steamcommunity.com/sharedfiles/filedetails/?id=3263565146
                                                       ----------
                                                       ↑ 这串数字就是 ID
```

### 修改服务器配置

修改 `~/Steam/steamapps/common/U3DS/Servers/<服务器名>/Server/Commands.dat` 文件即可，可修改项目参考：

- [Unturned Linux 开服](https://www.bilibili.com/read/cv11951379/)
- [Configuring your Unturned Server (commands.dat)](https://nodecraft.com/support/games/unturned/configuring-your-unturned-server-commands-dat#h-configuring-your-unturned-server-c7d0d)