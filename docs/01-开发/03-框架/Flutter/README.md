# Flutter

:::info
Flutter 为软件开发行业带来了革新：只要一套代码库，即可构建、测试和发布适用于移动、Web、桌面和嵌入式平台的精美应用。

[官方文档](https://docs.flutter.dev/get-started/install)
| [中文文档](https://flutter.cn/docs/get-started/install)
| [《Flutter实战·第二版》](https://book.flutterchina.club/)
| [Flame Engine](https://flame-engine.org/)
| [Dart 官方文档](https://dart.dev/guides)
| [Dart 中文文档](https://dart.cn/guides)
:::

## 使用 Chocolatey 安装

使用 **管理员身份运行** 以下命令：

```powershell
choco install flutter -y
git config --global --add safe.directory C:\tools\flutter\

# 重开一下终端再执行

flutter doctor
flutter upgrade
```

## 配置静态分析

`analysis_options.yaml` 文件是用来配置 Dart 代码的静态分析器的，它可以检查错误、警告和提示。
分析器发现的问题会在 [支持 Dart 的 IDE](https://dart.dev/tools#ides-and-editors) 的界面中显示。
也可以通过在命令行中执行 `flutter analyze` 来调用分析器。

在 `linter.rules` 中，可以自定义应用于此项目的提示规则，以禁用上面包含的 `package:flutter_lints/flutter.yaml` 中的规则或启用其他规则。
所有可用提示及其文档的列表发布在 [Linter rules | Dart](https://dart.dev/tools/linter-rules)。

除了在 `analysis_options.yaml` 文件中为整个项目禁用提示规则外，还可以使用
`// ignore: name_of_lint` 和 `// ignore_for_file: name_of_lint`
语法在产生提示的代码行或文件中忽略单个提示规则。

```yaml title="analysis_options.yaml"
# 下面这一行激活了一组为 Flutter 应用、包和插件设计的推荐提示，旨在鼓励良好的编码实践。
include: package:flutter_lints/flutter.yaml

linter:
  rules:
    # 避免在生产代码中调用 `print()`。
    avoid_prin: true

    # 只对包含单引号的字符串使用双引号。
    prefer_single_quotes: true
```

有关 `analysis_options.yaml` 的更多信息，请参阅：
[官方文档](https://dart.dev/tools/analysis)
| [中文文档](https://dart.cn/guides/language/analysis-options)

在项目根目录下执行 `dart fix --apply` 可以自动查找并修复问题。

## 修改 Windows 窗口标题

```cpp title="windows/runner/main.cpp"
#include <flutter/dart_project.h>
#include <flutter/flutter_view_controller.h>
#include <windows.h>

#include "flutter_window.h"
#include "utils.h"

int APIENTRY wWinMain(_In_ HINSTANCE instance, _In_opt_ HINSTANCE prev,
                      _In_ wchar_t *command_line, _In_ int show_command) {
  // Attach to console when present (e.g., 'flutter run') or create a
  // new console when running with a debugger.
  if (!::AttachConsole(ATTACH_PARENT_PROCESS) && ::IsDebuggerPresent()) {
    CreateAndAttachConsole();
  }

  // Initialize COM, so that it is available for use in the library and/or
  // plugins.
  ::CoInitializeEx(nullptr, COINIT_APARTMENTTHREADED);

  flutter::DartProject project(L"data");

  std::vector<std::string> command_line_arguments =
      GetCommandLineArguments();

  project.set_dart_entrypoint_arguments(std::move(command_line_arguments));

  FlutterWindow window(project);
  Win32Window::Point origin(10, 10);
  Win32Window::Size size(1280, 720);
  // highlight-next-line
  if (!window.Create(L"Windows Title", origin, size)) {
    return EXIT_FAILURE;
  }
  window.SetQuitOnClose(true);

  ::MSG msg;
  while (::GetMessage(&msg, nullptr, 0, 0)) {
    ::TranslateMessage(&msg);
    ::DispatchMessage(&msg);
  }

  ::CoUninitialize();
  return EXIT_SUCCESS;
}

```
