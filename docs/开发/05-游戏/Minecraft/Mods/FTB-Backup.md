# FTB Backup

不停服自动备份存档。

## FTB Backup

- [FTB Backups (Forge) - Minecraft Mods - CurseForge](https://www.curseforge.com/minecraft/mc-mods/ftb-backups-forge)
- [FTBTeam/FTB-Backups - GitHub](https://github.com/FTBTeam/FTB-Backups)
- [FTB Backups - Wiki](https://feedthebeast.notion.site/FTB-Backups-feda2cb8517141be93c144220cffa370)

## FTB Backup 2

适用于 Minecraft 1.18 及更高版本。

- [FTB Backups 2 - Minecraft Mods - CurseForge](https://www.curseforge.com/minecraft/mc-mods/ftb-backups-2)
- [CreeperHost/FTB-Backups-2 - GitHub](https://github.com/CreeperHost/FTB-Backups-2)

### 配置文件

配置文件在 `config/ftbbackups2.json` 中：

```json
{
	// 启用自动备份
	"enabled": true,
	// `/backup` 命令权限等级
	"command_permission_level": 0,
	// 仅向服务器 op 发送备份状态
	"notify_op_only": true,
	// 不发送备份状态
	"do_not_notify": false,
    /* 备份保留模式。有效模式：MAX_BACKUPS、TIERED
    注意：TIERED 模式是一项实验性功能，请自行决定是否使用
    */
    "retention_mode": "MAX_BACKUPS",

    // 适用于 retention_mode:MAX_BACKUPS，设置要保留的备份数量上限
    "max_backups": 5,

    // 适用于 retention_mode:TIERED，将保留最新的 x 个备份
    "keep_latest": 5,

    // 适用于 retention_mode:TIERED，设置要保留的每小时备份数量
    "keep_hourly": 1,

    // 适用于 retention_mode:TIERED，设置要保留的每天备份数量
    "keep_daily": 1,

    // 适用于 retention_mode:TIERED，设置要保留的每周备份数量
    "keep_weekly": 1,

    // 适用于 retention_mode:TIERED，设置要保留的每月备份数量
    "keep_monthly": 1,

    /* 使用 Quartz Java 库的 cron 实现
       详细信息请参考以下链接：
       (http://www.cronmaker.com)
    */
    // "backup_cron": "0 */30 * * * ?",     // 每 30 分钟备份一次；
    "backup_cron": "0 0 0/6 1/1 * ? *",     // 每 6 小时备份一次；

    // 使用指令进行手动备份的时间间隔
    "manual_backups_time": 0,

    // 仅在上一次备份后有玩家在线时运行备份
    "only_if_players_been_online": true,

    // 要包含在备份中的额外目录
    "additional_directories": [],

    /* 要包含在备份中的额外文件和目录
       可以指定文件名、相对于服务器目录的路径或通配符文件路径
       示例：
       (所有文件路径均相对于服务器根目录)
       fileName.txt                  匹配所有名为 "fileName.txt" 的文件
       folder/file.txt               精确的文件路径
       folder/                       此文件夹下的所有内容
       path/starts/with*             匹配路径开头为 path/ 的所有文件
       *path/ends/with.txt           匹配路径结尾为 path.txt 的所有文件
       *path/contains*               匹配路径中包含 path 的所有文件
    */
    "additional_files": [],

    // 在备份消息中显示文件大小
    "display_file_size": true,

    // 备份的存储位置
    "backup_location": ".",

    // 指定备份格式。有效选项为 ZIP 和 DIRECTORY
    "backup_format": "ZIP",

    // 最少剩余的可用磁盘空间（以MB为单位）。如果创建备份会导致剩余空间少于这个值，则备份操作将中止。
    "minimum_free_space": 0,

    // 如果上一次备份由于空间不足失败，则删除最旧的备份以释放空间
    "free_space_if_needed": false,

    /* 指定要排除的文件或目录
       可以指定文件名、相对于服务器目录的路径或通配符文件路径
       示例：
       (所有文件路径均相对于服务器根目录)
       fileName.txt                  匹配所有名为 "fileName.txt" 的文件
       folder/file.txt               精确的文件路径
       folder/                       此文件夹下的所有内容
       path/starts/with*             匹配路径开头为 path/ 的所有文件
       *path/ends/with.txt           匹配路径结尾为 path.txt 的所有文件
       *path/contains*               匹配路径中包含 path 的所有文件
    */
    "excluded": []
}
```
