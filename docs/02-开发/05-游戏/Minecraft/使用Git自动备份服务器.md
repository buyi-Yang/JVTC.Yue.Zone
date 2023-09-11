# 使用 Git 自动备份服务器

## 各 Git 托管平台限制

:::tip
GitHub YYDS!
:::

### GitHub

单次推送限制 2GB，单文件限制 100MB。仓库容量无限制。
参考 [关于 GitHub 上的大文件 - GitHub 文档](https://docs.github.com/zh/repositories/working-with-files/managing-large-files/about-large-files-on-github?platform=windows)

### Gitee

单仓库大小上限为 500M 单文件最大 50M；
用户名下以及所创建的组织下面的所有仓库容量为 5G；
参考 [Gitee 使用配额说明 | Gitee 产品文档](https://help.gitee.com/base/account/Gitee%E4%BD%BF%E7%94%A8%E9%85%8D%E9%A2%9D%E8%AF%B4%E6%98%8E/)

### Coding

代码仓库总容量 10 GB；
参考 [产品定价 | CODING - 一站式软件研发管理平台](https://coding.net/pricing.html)

## 忽略文件

```text title=".gitignore"
.fabric/
libraries/
logs/
version/
crash-reports/
*.log
*.data_old
*.lock
```

## 计划任务

```diff title="/etc/crontab"
  # 每六小时备份一次
+ 0 */6 * * * yueplus /home/yueplus/backup-minecraft-server.sh
```

```bash title="/home/yueplus/backup-minecraft-server.sh"
#!/bin/bash
cd /home/yueplus/mc1.20.1
git add *
git commit -m "Backup $(date)"
git push GitHub master
```