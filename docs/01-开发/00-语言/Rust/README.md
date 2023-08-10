# Rust

:::info
一门赋予每个人构建可靠且高效软件能力的语言。

[官网](https://www.rust-lang.org/zh-CN/)
| [《Rust 程序设计语言》](https://kaisery.github.io/trpl-zh-cn/)
| [《通过例子学 Rust》](https://rustwiki.org/zh-CN/rust-by-example/)
:::

## 安装

参考：[官方网站](https://www.rust-lang.org/zh-CN/tools/install)

----------

也可以使用 [Chocolatey] 安装：

```sh
# GUN ABI
choco install rust

# Visual Studio ABI
choco install rust-ms
```

使用 [Chocolatey] 时的默认安装位置 `C:\ProgramData\chocolatey\lib\rust\tools`

----------

安装完成后包含以下工具：

`cargo.exe`
| `rustc.exe`
| `rustdoc.exe`
| `cargo-credential-1password.exe`
| `cargo-credential-wincred.exe`
| `rust-analyzer-proc-macro-srv.exe`

## 框架

- [Rocket](../../03-框架/Rocket/README.md)
- [Tokio](https://tokio.rs/)

[Chocolatey]: ../../01-工具/Chocolatey/README.md