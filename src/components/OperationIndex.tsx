import React from "react";
import Index from "@site/src/components/Index";

export function LinuxIndex() {
    return Index([
        {icon: "Debian.png", title: "Debian↗", text: "通用操作系统", href: "https://www.debian.org/index.zh-cn.html"},
        {icon: "Ubuntu.svg", title: "Ubuntu", text: "企业开源与 Linux", href: "/docs/运行维护/Ubuntu/"},
        {icon: "CentOS.svg", title: "CentOS", text: "RedHat 社区企业操作系统", href: "/docs/运行维护/CentOS/"},
    ])
}
