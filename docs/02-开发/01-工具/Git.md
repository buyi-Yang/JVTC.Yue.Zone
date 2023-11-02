# Git

:::info
Git 是一个免费的开源分布式版本控制系统，旨在以快速和高效的方式处理从小型到超大型项目的所有内容。

Git 易于学习，占用空间很小，性能快如闪电。
它超越了像 Subversion、CVS、Perforce 和 ClearCase 这样的配置管理工具，具有廉价的本地分支、方便的暂存区和多个工作流等特性。

[官方网站](https://git-scm.com/)
| [《Pro Git 中文版》](https://git-scm.com/book/zh/v2/%E8%B5%B7%E6%AD%A5-%E5%85%B3%E4%BA%8E%E7%89%88%E6%9C%AC%E6%8E%A7%E5%88%B6)
| [菜鸟教程](https://www.runoob.com/git/git-tutorial.html)
| [在 BiliBili 上搜索视频教程](https://search.bilibili.com/all?keyword=git)
:::

## 安装

### Windows

[点击下载 Windows 最新版的 Git 安装包](https://git-scm.com/download/win)
| [也可以使用 Chocolatey 安装](/docs/开发/工具/Chocolatey/#安装-git)
| [也可以使用 winget 安装](https://winstall.app/apps/Git.Git)

### TortoiseGit

TortoiseGit 提供了显示文件状态的叠加图标、强大的 Git 上下文菜单以及更多！
[官方网站](https://tortoisegit.org/)

## GitBash 配置代理

```sh
## 注意端口号---------------------------------------
# http                                          ↓↓↓↓
git config --global http.proxy http://127.0.0.1:1080
git config --global https.proxy https://127.0.0.1:1080

# socks5
git config --global http.proxy 'socks5://127.0.0.1:1080'
git config --global https.proxy 'socks5://127.0.0.1:1080'

# 重置代理
git config --global --unset http.proxy
git config --global --unset https.proxy

```

## 基本操作

参考：[Git 基本操作 - 菜鸟教程](https://www.runoob.com/git/git-basic-operations.html)

```sh 
# 初始化仓库
git init

# 克隆项目
git clone

# 添加至暂存区
git add

# 查看仓库状态
git status

# 比较暂存区和工作区
git diff

# 提交暂存区到本地仓库
git commit

# 回退版本
git reset

# 删除文件
git rm

# 移动或重命名文件
git mv

# 分支切换
git checkout

# 更清晰地切换分支 git 2.23后
git switch 

# 恢复或撤销文件 git 2.23后
git restore 

# 查看历史提交记录
git log

# 列表形式查看指定文件修改记录
git blame <文件路径>

# 远程仓库操作
git remote

# 从远程获取代码库
git fetch

# 下载远程代码并合并
git pull

# 上传远程代码并合并
git push
```

