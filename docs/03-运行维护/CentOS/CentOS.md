# CentOS

:::info
CentOS 项目是一个由社区驱动的免费软件，提供了丰富的基础平台，供开源社区使用。

[CentOS Linux](https://www.centos.org/centos-linux/)
| [CentOS Stream](https://www.centos.org/centos-stream/)
:::

## 最小安装（manimal）后的网络配置

由于最小安装默认没有安装 `net-tools` 包，所以也没有 `ifconfig` 命令；
可以使用 `ip addr` 来查看当前 IP；

使用 `vi` 编辑 `/etc/sysconfig/network-scripts/ifcfg-ens33` 文件，将 `ONBOOT=no` 改为 `ONBOOT=yes`：

```conf {15} title="/etc/sysconfig/network-scripts/ifcfg-ens33"
TYPE=Ethernet
PROXY_METHOD=none
BROWSER_ONLY=no
BOOTPROTO=dhcp
DEFROUTE=yes
IPV4_FAILURE_FATAL=no
IPV6INIT=yes
IPV6_AUTOCONF=yes
IPV6_DEFROUTE=yes
IPV6_FAILURE_FATAL=no
IPV6_ADDR_GEN_MODE=stable-privacy
NAME=ens33
UUID=ef1316c7-eaaa-446c-ad9a-e42e8a451675
DEVICE=ens33
ONBOOT=yes
```

:::tip
如果使用桥接模式链接虚拟机，必须在虚拟网络编辑器中手动指定桥接网卡，选择默认自动选择的网卡可能找不到 DHCP 服务器导致无法获取 IP！
:::

## 配置光盘为软件源

虚拟机先添加 **DVD/CD-ROM 驱动器** 并选择对应系统的完整 ISO 镜像文件。
例如 `CentOS-7-x86_64-DVD-2009.iso`，这个文件有 4.38GB。里面包含了大量配套软件包。

然后，可以查看系统中的光盘：

```text
[root@localhost yum.repos.d]# ls -l /dev/cdrom
lrwxrwxrwx. 1 root root 3 Sep 27 01:25 /dev/cdrom -> sr0
```

创建挂载点目录：

```sh
mkdir /mnt/iso
```

挂载光盘：

```sh
mount /dev/cdrom /mnt/iso/
```

编辑软件源：

01. 禁用网络源
    
    ```sh
    mv /etc/yum.repos.d/CentOS-Base.repo /etc/yum.repos.d/CentOS-Base.repo.bak
    ```

02. 使用 DVD 源；

    修改 `/etc/yum.repos.d/CentOS-Media.repo` 文件：
    
    - 将 `baseurl=` 的值改为之前创建的挂载点目录 `file:///mnt/iso/`
    - 将 `enabled=0` 改为 `enabled=1`

    ```repo title="/etc/yum.repos.d/CentOS-Media.repo"
    # CentOS-Media.repo
    #
    #  This repo can be used with mounted DVD media, verify the mount point for
    #  CentOS-7.  You can use this repo and yum to install items directly off the
    #  DVD ISO that we release.
    #
    # To use this repo, put in your DVD and use it with the other repos too:
    #  yum --enablerepo=c7-media [command]
    #
    # or for ONLY the media repo, do this:
    #
    #  yum --disablerepo=\* --enablerepo=c7-media [command]

    [c7-media]
    name=CentOS-$releasever - Media
    # highlight-next-line
    baseurl=file:///mnt/iso/
    gpgcheck=1
    # highlight-next-line
    enabled=1
    gpgkey=file:///etc/pki/rpm-gpg/RPM-GPG-KEY-CentOS-7
    ```

03. 更新软件源：

    ```sh
    yum update
    ```
