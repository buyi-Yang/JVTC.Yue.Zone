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

```toml title="/etc/systemd/resolved.conf"
[Resolve]
DNS=114.114.114.114 4.2.2.1
```

修改后需要重启服务：`sudo systemctl restart systemd-resolved`
