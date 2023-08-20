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

[也可以使用 Chocolatey 安装](/docs/开发/工具/Chocolatey/#安装-git)

[也可以使用 winget 安装](https://winstall.app/apps/Git.Git)

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
