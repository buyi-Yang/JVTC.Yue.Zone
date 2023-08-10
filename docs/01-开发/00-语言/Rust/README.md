# Rust

:::info
一门赋予每个人构建可靠且高效软件能力的语言。

[官网](https://www.rust-lang.org/zh-CN/)
| [《Rust 程序设计语言》](https://kaisery.github.io/trpl-zh-cn/)
| [《通过例子学 Rust》](https://rustwiki.org/zh-CN/rust-by-example/)
| [菜鸟教程](https://www.runoob.com/rust/rust-tutorial.html)
| [Rust 中文社区](https://rustcc.cn/)
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

使用 [Chocolatey] 时的默认安装位置 `C:\ProgramData\chocolatey\lib\rust(-ms)\tools`

----------

安装完成后包含以下工具：

`cargo.exe`
| `rustc.exe`
| `rustdoc.exe`
| `cargo-credential-1password.exe`
| `cargo-credential-wincred.exe`
| `rust-analyzer-proc-macro-srv.exe`

## `cargo`

Cargo 是 Rust 的构建系统和包管理器。
Rust 开发者常用 Cargo 来管理 Rust 工程和获取工程所依赖的库。

### 文档/教程

- [Cargo 手册 中文版](https://rustwiki.org/zh-CN/cargo/getting-started/installation.html)
  | [The Cargo Book](https://doc.rust-lang.org/cargo/index.html)
- [Cargo 教程 | 菜鸟教程](https://www.runoob.com/rust/cargo-tutorial.html)

## 框架

- [Rocket](../../03-框架/Rocket/README.md)
- [Tokio](https://tokio.rs/)

## 语言特性

### 属性 - `#[]`

`#[]` 是属性（Attribute）的语法。
属性是应用于模块、箱（crate）或项（item）的元数据。
这些元数据可以用于：

- 有条件地编译代码
- 设置箱的名称、版本和类型（二进制或库）
- 禁用 lint（警告）
- 启用编译器功能（宏、全局导入等）
- 链接到外部库
- 标记函数为单元测试
- 标记函数将成为基准测试的一部分

当属性应用于整个箱时，它们的语法是 `#![crate_attribute]`，当它们应用于模块或项时，语法是 `#[item_attribute]`（注意缺少感叹号 !）。
属性可以带有不同语法的参数：

```rust
# [attribute = "value"]
# [attribute (key = "value")]
# [attribute (value)]
```

属性可以有多个值，并且也可以分成多行：

```rust
# [attribute (value, value2)]
# [attribute (value, value2, value3, value4, value5)]
```

参考：

- [属性 - 通过例子学 Rust 中文版](https://rustwiki.org/zh-CN/rust-by-example/attribute.html)
  | [Attributes - Rust By Example](https://doc.rust-lang.org/rust-by-example/attribute.html)
- [Attributes - The Rust Reference](https://doc.rust-lang.org/reference/attributes.html)
- [【Rust每周一知】 Attribute 属性 - Rust 中文社区](https://rustcc.cn/article?id=3d356fbf-4091-41c6-a66b-10cd72fd0e7a)

[Chocolatey]: ../../01-工具/Chocolatey/README.md
