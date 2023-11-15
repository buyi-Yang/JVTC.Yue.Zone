# DHCP

## `isc-dhcp-server`

:::info
动态主机配置协议（DHCP - Dynamic Host Configuration Protocol）

DHCP 通常被用于局域网环境，主要作用是集中的管理、分配 IP 地址，使客户端动态的获得 IP 地址、Gateway 地址、DNS 服务器地址等信息，
并能够提升地址的使用率。
简单来说，DHCP 就是一个不需要账号密码登录的、自动给内网机器分配 IP 地址等信息的协议。

**注意：** 此软件包在 `12.04 LTS` 之前的版本中 称为 `dhcp3-server`。

[isc-dhcp-server - Community Help Wiki](https://help.ubuntu.com/community/isc-dhcp-server)
:::

### 安装

```shell
sudo apt install isc-dhcp-server -y
```

### 配置

#### `/etc/dhcp3/dhcpd.conf`

`dhcpd` 服务的配置文件。

```conf title="/etc/dhcp3/dhcpd.conf"
# A slightly different configuration for an internal subnet.
subnet 192.168.33.0 netmask 255.255.255.0 {
   range 192.168.33.100 192.168.33.200;                       # 开放的地址池
   option domain-name-servers 114.114.114.114, 8.8.8.8;       # DNS 服务器
   #option domain-name "internal.example.org";                # 域名
   option routers 192.168.33.1;                               # 网关地址
   option broadcast-address 192.168.33.255;                   # 广播地址
   default-lease-time 600;                                    # 默认租期，单位：秒
   max-lease-time 7200;                                       # 最大租期
}
```

#### `/etc/default/isc-dhcp-server`

该文件用于指定 `dhcpd` 服务应侦听的接口。
默认情况下监听 `eth0`。

```conf title="/etc/default/isc-dhcp-server"
# Defaults for isc-dhcp-server (sourced by /etc/init.d/isc-dhcp-server)

# Path to dhcpd's config file (default: /etc/dhcp/dhcpd.conf).
#DHCPDv4_CONF=/etc/dhcp/dhcpd.conf
#DHCPDv6_CONF=/etc/dhcp/dhcpd6.conf

# Path to dhcpd's PID file (default: /var/run/dhcpd.pid).
#DHCPDv4_PID=/var/run/dhcpd.pid
#DHCPDv6_PID=/var/run/dhcpd6.pid

# Additional options to start dhcpd with.
#       Don't use options -cf or -pf here; use DHCPD_CONF/ DHCPD_PID instead
#OPTIONS=""

# On what interfaces should the DHCP server (dhcpd) serve DHCP requests?
#       Separate multiple interfaces with spaces, e.g. "eth0 eth1".
INTERFACESv4=""     # 此处添加需要提供DHCP服务的网卡名
INTERFACESv6=""
```


