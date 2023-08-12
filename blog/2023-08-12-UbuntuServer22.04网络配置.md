# Ubuntu Server 22.04 网络配置

<!--truncate-->

## DNS 服务器

### 查看 DNS 状态

```sh
# highlight-next-line
$ resolvectl status
Global
         Protocols: -LLMNR -mDNS -DNSOverTLS DNSSEC=no/unsupported
  resolv.conf mode: stub
Current DNS Server: 8.8.8.8
       DNS Servers: 8.8.8.8 114.114.114.114

Link 2 (eth0)
    Current Scopes: DNS
         Protocols: +DefaultRoute +LLMNR -mDNS -DNSOverTLS DNSSEC=no/unsupported
Current DNS Server: 1.1.1.1
       DNS Servers: 114.114.114.114 1.1.1.1

Link 3 (eth1)
Current Scopes: none
     Protocols: -DefaultRoute +LLMNR -mDNS -DNSOverTLS DNSSEC=no/unsupported
```

### 临时修改

```toml title="/etc/resolv.conf"
nameserver 8.8.8.8
nameserver 114.114.114.114
```

### 长期有效

```yaml title="/etc/netplan/01-network-manager-all.yaml"
network:
  version: 2
  renderer: networkd
  ethernets:
    enp0s3:
      dhcp4: no
      addresses: [192.168.157.140/24]
      gateway4: 192.168.157.140
      nameservers:
        addresses: [8.8.8.8,8.8.4.4]
```