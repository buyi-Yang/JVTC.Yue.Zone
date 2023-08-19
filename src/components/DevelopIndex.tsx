import React from "react";
import IconCardButton from "@site/src/components/IconCradButton";

export function DevelopLanguageIndex() {
    return <div className="row">{
        [
            {icon: "dart.svg", title: "Dart", text: "为全平台构建快速应用的客户端优化", href: "/docs/开发/语言/Dart/"},
            {icon: "java.svg", title: "Java", text: "跨平台、面向对象、泛型编程", href: "/docs/开发/语言/Java/"},
            {icon: "python.svg", title: "Python", text: "解释型、高级通用编程语言", href: "/docs/开发/语言/Python/"},
            {icon: "ruby.svg", title: "Ruby", text: "开源的动态编程语言，注重简洁和效率", href: "/docs/开发/语言/Ruby/"},
            {icon: "rust.svg", title: "Rust", text: "通用、编译型、安全、并发、实用", href: "/docs/开发/语言/Rust/"},
        ].map(item => <IconCardButton {...item} />)
    }</div>
}

export function DevelopToolIndex() {
    return <div className="row">{
        [
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
            {icon: "正则表达式.svg", title: "正则表达式", text: "构成搜索模式的字符串序列", href: "/docs/开发/工具/正则表达式/"},
        ].map(item => <IconCardButton {...item} />)
    }</div>
}

export function DevelopFrameworkIndex() {
    return <div className="row">{
        [
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
        ].map(item => <IconCardButton {...item} />)
    }</div>
}
