# PowerShell

:::info
<img src="/icons/PowerShell.svg" style={{height: "6rem", float: "left", paddingRight: 12}} />

PowerShell 是一种跨平台的任务自动化解决方案，由命令行 shell、脚本语言和配置管理框架组成。
PowerShell 在 Windows、Linux 和 macOS 上运行。

[官方文档](https://learn.microsoft.com/zh-cn/powershell/)
:::

## 安装

[在 Windows 上安装 PowerShell 7](https://learn.microsoft.com/zh-cn/powershell/scripting/install/installing-powershell-on-windows?view=powershell-7.3)

### 位置

- PowerShell 1（系统自带）: `C:\Windows\System32\WindowsPowerShell\v1.0\powershell.exe`
- PowerShell 7：`C:\Program Files\PowerShell\7\pwsh.exe`

## 常见问题

### Windows PowerShell 无法加载文件，因为在此系统上禁止运行脚本。

```text
cnpm : 无法加载文件 C:\Users\Yue_plus\AppData\Roaming\npm\cnpm.ps1，因为在此系统上禁止运脚本。
有关详细信息，请参阅 https:/go.microsoft.com/fwlink/?LinkID=135170 中的 about_Execution_Policies。
所在位置 行:1 字符: 1
+ cnpm install
+ ~~~~
    + CategoryInfo          : SecurityError: (:) []，PSSecurityException
    + FullyQualifiedErrorId : UnauthorizedAccess
```

![](https://net.note.yue.zone/assets/PS_error-09638296.png)

参阅 <https://go.microsoft.com/fwlink/?LinkID=135170>

#### 解决方法

以 **管理员身份** 在 PowerShell 中运行以下指令：

```ps
set-ExecutionPolicy RemoteSigned
```