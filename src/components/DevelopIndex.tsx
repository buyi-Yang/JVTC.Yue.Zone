import React from "react";
import IconCardButton from "@site/src/components/IconCradButton";

// 方便复制：{icon: "", title: "", text: "", href: ""},
type DevelopIndexItems = { icon: string, title: string, text: string, href: string }

function DevelopIndex(items: Array<DevelopIndexItems>) {
    return <div className="row">{
        items.map(item => <IconCardButton {...item} />)
    }</div>
}

/** 语言 */
export function DevelopLanguageIndex() {
    return DevelopIndex([
        {icon: "dart.svg", title: "Dart", text: "为全平台构建快速应用的客户端优化", href: "/docs/开发/语言/Dart/"},
        {icon: "java.svg", title: "Java", text: "跨平台、面向对象、泛型编程", href: "/docs/开发/语言/Java/"},
        {icon: "python.svg", title: "Python", text: "解释型、高级通用编程语言", href: "/docs/开发/语言/Python/"},
        {icon: "ruby.svg", title: "Ruby", text: "开源的动态编程语言，注重简洁和效率", href: "/docs/开发/语言/Ruby/"},
        {icon: "rust.svg", title: "Rust", text: "通用、编译型、安全、并发、实用", href: "/docs/开发/语言/Rust/"},
    ])
}

/** 工具 */
export function DevelopToolIndex() {
    return DevelopIndex([
        {
            icon: "anaconda.svg",
            title: "Anaconda",
            text: "用于计算科学、数据科学、机器学习、大数据处理和预测分析的 Python 和 R 语言发行版本 ",
            href: "/docs/开发/工具/Anaconda/",
        },
        {
            icon: "chocolatey.svg",
            title: "Chocolatey",
            text: "Windows 现代软件自动化的包管理器",
            href: "/docs/开发/工具/Chocolatey/",
        },
        {icon: "winget.svg", title: "winget", text: "Windows 自带的包管理器", href: "/docs/开发/工具/winget/"},
        {
            icon: "gradle.svg",
            title: "Gradle",
            text: "从移动应用到微服务，从小型初创公司到大型企业，Gradle 可帮助团队更快地构建、自动化和交付更好的软件。",
            href: "/docs/开发/工具/Gradle/",
        },
        {icon: "graal-vm.svg", title: "GraalVM", text: "高性能！云原生！多语言！", href: "/docs/开发/工具/GraalVM/"},
        {icon: "apache.svg", title: "Maven", text: "Java软件项目管理及自动构建工具", href: "/docs/开发/工具/Maven/"},
        {icon: "OpenCV.png", title: "OpenCV", text: "跨平台的计算机视觉库", href: "/docs/开发/工具/OpenCV/"},
        {icon: "SSL.svg", title: "OpenSSL", text: "功能丰富且自包含的开源安全工具箱", href: "/docs/开发/工具/OpenSSL/"},
        {
            icon: "正则表达式.svg",
            title: "正则表达式",
            text: "构成搜索模式的字符串序列",
            href: "/docs/开发/工具/正则表达式/"
        },
    ])
}

/** 环境 */
export function DevelopEnvironIndex() {
    return DevelopIndex([
        {icon: "apache2.svg", title: "Apache2", text: "HTTP、Web 服务器", href: "/docs/开发/环境/Apache/httpd"},
        {
            icon: "Docker.svg",
            title: "Docker",
            text: "为相关程序提供操作系统层的虚拟化，比虚拟机更便捷高效",
            href: "/docs/开发/环境/Docker/"
        },
        {
            icon: "InfluxDB.svg",
            title: "InfluxDB",
            text: "用于存储和分析时间序列数据的开源数据库",
            href: "/docs/开发/环境/InfluxDB/"
        },
        {
            icon: "PostgreSQL.svg",
            title: "PostgreSQL",
            text: "世界上最先进的开源关系型数据库",
            href: "/docs/开发/环境/PostgreSQL/"
        },
    ])
}

/** 框架 */
export function DevelopFrameworkIndex() {
    return DevelopIndex([
        {icon: "spring.svg", title: "Spring", text: "互联网软件开发全家桶", href: "/docs/开发/框架/Spring/Boot/"},
        {
            icon: "flutter.svg",
            title: "Flutter",
            text: "只要一套代码库，即可构建、测试和发布适用于移动、Web、桌面和嵌入式平台的精美应用",
            href: "/docs/开发/框架/Flutter/",
        },
        {
            icon: "rocket.svg",
            title: "Rocket",
            text: "使用 Rust 编写快、安全不牺牲灵活性、可用性或类型安全性的 Web 应用程序",
            href: "/docs/开发/框架/Rocket/",
        }
    ])
}

/** 软件 */
export function DevelopSoftwareIndex() {
    return DevelopIndex([
        //TODO:
    ])
}

/** 硬件 */
export function DevelopHardwareIndex() {
    return DevelopIndex([
        {icon: "cw32.png", title: "CW32", text: "武汉芯源半导体", href: "/docs/开发/硬件/CW32/"}
    ])
}

/** 游戏 */
export function DevelopGameIndex() {
    return DevelopIndex([
        {
            icon: "minecraft.webp",
            title: "Minecraft",
            text: "不是网易游戏代理的我的世界",
            href: "/docs/开发/游戏/Minecraft/"
        },
        {icon: "unity.svg", title: "Unity", text: "行业领先的实时 3D 开发平台", href: "/docs/开发/游戏/Unity/"},
    ])
}